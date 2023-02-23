package com.setianjay.springboot.myfirstwebapp.controller.login;

import com.setianjay.springboot.myfirstwebapp.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    @Autowired
    private AuthenticationService authService;

    /**
     * handle get request in login url, if user access this url www.example/login, then this function will be executed.
     * */
    @GetMapping("/login")
    public String loginPage(ModelMap model){
        model.addAttribute("errorMessage", model.getOrDefault("errorMessage", ""));
        return "user/login";
    }

    /**
     * handle post request in login url, if in the login url has post request then this function will be executed.
     * */
    @PostMapping("/login")
    public RedirectView loginPost(@RequestParam(value = "username") String username, @RequestParam("password") String password, RedirectAttributes attributes){
        // do authentication, if success redirect to dashboard screen, if fail stay in login page
        if(authService.auth(username, password)){
            attributes.addFlashAttribute("username", username);
            return new RedirectView("/dashboard");
        }

        attributes.addFlashAttribute("errorMessage", "Invalid Credentials! Please try again.");
        return new RedirectView("/login");
    }
}
