package springhandson.handson.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class handsOnController {
    @GetMapping("main") // url + /main 주소로 들어오면 해당 메소드로 호출
    public String mainpage(Model model){
        model.addAttribute("data", "This is main page");
        return "main"; // templates/main 파일을 찾아서 실행
    }

    @GetMapping("mvc-main") // controller of mvc
    public String mvcMainPage(@RequestParam("name") String name, Model model){ // Model: model of mvc
        // url + ?name='data'
        model.addAttribute("name", name);
        return "mvc-main-template";
    }
}
