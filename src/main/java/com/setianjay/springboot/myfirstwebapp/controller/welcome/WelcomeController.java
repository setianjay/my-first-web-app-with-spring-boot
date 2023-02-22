package com.setianjay.springboot.myfirstwebapp.controller.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String firstPage() {
        return "user/welcome";
    }
}
