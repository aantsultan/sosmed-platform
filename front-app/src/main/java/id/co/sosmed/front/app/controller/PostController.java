package id.co.sosmed.front.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(){
        return "index";
    }

}
