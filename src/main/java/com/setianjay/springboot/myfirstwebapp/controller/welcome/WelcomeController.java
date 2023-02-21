package com.setianjay.springboot.myfirstwebapp.controller.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SayHelloController class is a class with the @Controller annotation where the annotated class is a class that will
 * later handle HTTP Requests but for the response is a view or HTML display. Because the firstPage function does not
 * return a view by not indicating the name of the view, we return the result in JSON, XML, or plain text format with
 * the @ResponseBody annotation so that later if the return value is valuable or contains HTML, the return value will
 * be executed automatically by the browser because it is considered HTML code.
 * */
@Controller
public class WelcomeController {

    @GetMapping("/")
    @ResponseBody
    public String firstPage() {
        return "<html>" +
                "<head>" +
                "<title>First Page</title>" +
                "</head>" +
                "<body>" +
                "<h3 align='center'>Welcome on the First Page, I am Hari Setiaji a Fullstack Developer. Good to see you</h3>" +
                "</body>" +
                "</html>";
    }
}
