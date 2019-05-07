package com.example.demo.controller;


import com.example.demo.async.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/", method = RequestMethod.GET)
public class BaseController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("index")
    public Integer getNum() throws ExecutionException, InterruptedException {
        System.out.println("BaseController" +  Thread.currentThread().getName());
        return asyncService.doBiz().get();
    }

}
