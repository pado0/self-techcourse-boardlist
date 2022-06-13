package example.techcourse0613.dto;

import example.techcourse0613.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostUpdateDto {
    private String title;
    private String context;

    public PostUpdateDto() {
    }

    public PostUpdateDto(Post post) {
        title = post.getTitle();
        context = post.getContext();
    }
}
