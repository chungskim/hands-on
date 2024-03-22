package springhandson.handson.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class handsOnController {

    //Need Resource Static or Template

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

    // No Resource Template
    // Use @ResponseBody

    @GetMapping("html-body-main")
    @ResponseBody
    public String apiMainPage(@RequestParam("name") String name ) {
        return name + " main"; // html body 에 데이터 삽입
    }

    @GetMapping("api-main")
    @ResponseBody
    public Main mainApi(@RequestParam("name") String name) {
        Main main = new Main();
        main.setName(name);
        return main; // html body 에 Main 클래스의 field 데이터 삽입 (JSON)
    }
    // class for api model
    static class Main { // Main 클래스 (객체)
        private String name; // Main 클래스의 field 선언

        public String getName() {
            return name;
        }

        public void setName(String name) { // Main 클래스의 메소드 선언
            this.name = name;
        }
    }
}
