package example.techcourse0613.repository;

import example.techcourse0613.entity.FileInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FileInfoRepository {

    private final EntityManager em;

    public void save(FileInfo fileInfo){
        em.persist(fileInfo);
    }

    public FileInfo findFileInfoById(Long id) {
        return em.find(FileInfo.class, id);
    }
}
