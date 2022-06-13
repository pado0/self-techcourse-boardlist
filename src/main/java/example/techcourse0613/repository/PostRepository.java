package example.techcourse0613.repository;

import example.techcourse0613.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }

    public Post finePostById(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findAllPost(){
        return em.createQuery("select p from Post p", Post.class).getResultList();
    }

}
