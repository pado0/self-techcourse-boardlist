package example.techcourse0613.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostFindDto {

    private Long id;
    private Long memberId;
    private String title;
    private String context;

}
