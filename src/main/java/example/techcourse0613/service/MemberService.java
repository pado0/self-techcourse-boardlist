package example.techcourse0613.service;

import example.techcourse0613.entity.Member;
import example.techcourse0613.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        // todo : 중복 검증 로직 추가
        // 아래 save 동작으로 영속성 컨텍스트 저장
        memberRepository.save(member);
        return member.getId();
    }

    public Member findOneMember(Long id){
        return memberRepository.findMemberById(id);
    }

    public List<Member> findAllMember(){
        return memberRepository.findAllMember();
    }
}
