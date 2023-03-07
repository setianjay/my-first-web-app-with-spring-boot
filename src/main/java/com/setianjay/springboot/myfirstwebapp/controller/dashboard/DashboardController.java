package com.setianjay.springboot.myfirstwebapp.controller.dashboard;

import com.setianjay.springboot.myfirstwebapp.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboardPage(Model model){
        model.addAttribute("username", SessionUtil.getUsername());
        return "user/dashboard";
    }
}
