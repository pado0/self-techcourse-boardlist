package example.techcourse0613.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    // member 연동
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // memberId를 fk로
    private Member member;

    // 파일정보
    @OneToOne
    @JoinColumn(name = "file_id")
    private FileInfo fileInfo;

    // 게시글 정보
    private String title;
    private String context;

}
