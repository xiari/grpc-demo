package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        System.out.println("hello ");
        return "welcome";
    }
}
