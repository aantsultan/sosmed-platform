package id.co.sosmed.front.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile-setting")
    public String get(){
        return "profile/view";
    }

}
