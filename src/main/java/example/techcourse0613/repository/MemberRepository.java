package example.techcourse0613.repository;

import example.techcourse0613.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findMemberById(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAllMember(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

}
