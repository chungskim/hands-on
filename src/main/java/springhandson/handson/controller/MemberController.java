package springhandson.handson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springhandson.handson.service.MemberService;

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

}
