package com.example.demo;

import com.example.demo.utils.CodeUitl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckController {

    @RequestMapping("/check")
    @ResponseBody
    public String check(HttpServletRequest request){

        if(CodeUitl.checkVerifyCode(request)){
            return "hello world ";
        }
        return "code verfiy failed.";
    }
}
