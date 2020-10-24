package jpabook.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // hello라는 url로 오면 이 컨트롤러가 호출
    public String hello(Model model){ // Model Spring UI에 있는 Model이라는게 어떤 데이터를 컨트롤러에서 실어서 뷰로 넘김
        model.addAttribute("data", "hello!!!");
        return "hello"; // 화면 이름 (templates)
    }
}
