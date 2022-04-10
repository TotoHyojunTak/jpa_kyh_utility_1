package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        // model은 view로 넘겨주는 방법
        model.addAttribute("data", "Jiwon!!");
        return "hello";
        // resources/templates/hello.html 파일을 호출함
        // resources:templates/ +{ViewName} + .html
    }
}
