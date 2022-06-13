package example.techcourse0613.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

// 지네릭으로 한번 감싸 data 태그로 내려줄 수 있도. 향후 필요한 필드 추가가능
@Data
@AllArgsConstructor
public class ResultDto<T> {

    // 리턴을 위한 DTO
    private T data;
}
