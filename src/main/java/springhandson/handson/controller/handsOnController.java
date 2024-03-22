package springhandson.handson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class handsOnController {
    @GetMapping("main") // url + /main 주소로 들어오면 해당 메소드로 호출
    public String mainpage(Model model){
        model.addAttribute("data", "This is main page");
        return "main"; // templates/main 파일을 찾아서 실행
    }
}
