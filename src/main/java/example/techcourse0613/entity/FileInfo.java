package example.techcourse0613.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class FileInfo {

    @Id @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    private String fileName;
    private String filePath;
    private Long fileByte;
}
