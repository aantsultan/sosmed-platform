package id.co.sosmed.front.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "register/view";
    }

    @GetMapping("/login")
    public String login (){
        return "login/view";
    }

}
