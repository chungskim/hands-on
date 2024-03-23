package springhandson.handson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springhandson.handson.domain.Member;
import springhandson.handson.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    // 생성자 방법 (recommend)
    private MemberService memberService;
    @Autowired // spring bean 에 등록 되어 있는 객체를 넣어준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    // 필드 주입 방법
//    @Autowired private MemberService memberService;

//    // 세터 주입 방법
//    private MemberService memberService;
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @GetMapping(value="/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
