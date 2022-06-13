package example.techcourse0613.dto;

import example.techcourse0613.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostCreateDto {

    private Long memberId;
    private String title;
    private String context;

    public PostCreateDto(){}
    public PostCreateDto(Post post) {
        memberId = post.getMember().getId();
        title = post.getTitle();
        context = post.getContext();
    }

}
