package com.example.springbootdemo.controller;


import io.sentry.Sentry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error_sample_controller {


    @RequestMapping("/error_sample")
    public void doSomething() {

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            Sentry.captureException(e);
        }

    }


}
