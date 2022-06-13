package example.techcourse0613.controller;

import example.techcourse0613.dto.PostCreateDto;
import example.techcourse0613.dto.PostFindDto;
import example.techcourse0613.dto.PostUpdateDto;
import example.techcourse0613.dto.ResultDto;
import example.techcourse0613.entity.Member;
import example.techcourse0613.entity.Post;
import example.techcourse0613.service.MemberService;
import example.techcourse0613.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final MemberService memberService;

//    @GetMapping("/posts")
//    public List<PostDto> findPostList(){
//        List<Post> posts = postService.findAllPost();
//        List<PostDto> result = posts.stream()
//                .map(o -> new PostDto(o))
//    }

    @PostMapping("/post")
    public PostCreateDto createPost(@RequestBody @Valid PostCreateDto postCreateDto){

        Post post = new Post();
        Member findMember = memberService.findOneMember(postCreateDto.getMemberId());

        // request로 들어온 애들을 다 세팅해줌
        post.setMember(findMember);
        post.setTitle(postCreateDto.getTitle());
        post.setContext(postCreateDto.getContext());

        // postSave
        postService.savePost(post);

        return new PostCreateDto(post);
    }

    @GetMapping("/posts")
    public ResultDto findAllPost(){
        List<Post> findPosts = postService.findAllPost();

        List<PostFindDto> collect = findPosts.stream()
                .map(m -> new PostFindDto(m.getId(), m.getMember().getId(), m.getTitle(), m.getContext()))
                .collect(Collectors.toList());

        return new ResultDto(collect);
    }

    //post id로 게시글 수정
    @PutMapping("/post/{postId}")
    public PostUpdateDto updatePost(@PathVariable("postId") Long id, @RequestBody @Valid PostUpdateDto request){
        postService.updatePost(id, request.getTitle(), request.getContext());
        System.out.println("id = " + id);
        Post findPost = postService.fineOnePost(id);
        System.out.println("findPost = " + findPost);
        return new PostUpdateDto(findPost.getTitle(), findPost.getContext());
    }

    // @DeleteMapping("/post/{postId}")
}
