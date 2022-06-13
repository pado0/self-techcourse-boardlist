package example.techcourse0613.controller;

import example.techcourse0613.dto.CreateMemberRequest;
import example.techcourse0613.dto.CreateMemberResponse;
import example.techcourse0613.dto.FindAllMembersResponse;
import example.techcourse0613.dto.ResultDto;
import example.techcourse0613.entity.Member;
import example.techcourse0613.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 가입
    @PostMapping("/member")
    public CreateMemberResponse createMember(@RequestBody @Valid CreateMemberRequest request){

        Member member = new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    // member 조회 Dto 만들기
    @GetMapping("/members")
    public ResultDto fineAllMember(){
        List<Member> findMembers = memberService.findAllMember();

        List<FindAllMembersResponse> collect = findMembers.stream()
                .map(m -> new FindAllMembersResponse(m.getName()))
                .collect(Collectors.toList());

        return new ResultDto(collect);

    }

}
