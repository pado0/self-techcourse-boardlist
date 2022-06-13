package example.techcourse0613.service;

import example.techcourse0613.entity.Post;
import example.techcourse0613.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Post fineOnePost(Long id) {
        return postRepository.finePostById(id);
    }

    public List<Post> findAllPost() {
        return postRepository.findAllPost();
    }

    @Transactional
    public void updatePost(Long id, String title, String context) {
        Post post = postRepository.finePostById(id);
        post.setTitle(title);
        post.setContext(context);
    }


}
