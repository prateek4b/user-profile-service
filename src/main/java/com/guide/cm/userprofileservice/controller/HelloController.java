package com.guide.cm.userprofileservice.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {



    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello";

    }

    @GetMapping("/showRequest")
    public String showRequest(HttpServletRequest httpRequest) {
       return httpRequest.getHeader("gateway")+"-->"+httpRequest.getParameter("gateway");
    }

    @GetMapping("/sayRedirected")
    public String sayHelloRedirected() {
        return "HelloRedirected";

    }


    @GetMapping("/afterTime")
    public String sayAfterTime() {
        return "AfterTime";

    }

    @GetMapping("/time/afterTime")
    public String sayPrefixAfterTime() {
        return "PrefixAfterTime";

    }

    @GetMapping("/redirectThis")
    public String sayRedirectThis() {
        return "redirectThis";

    }

    @GetMapping("/retryer")
    public String retry() {
        System.out.println("Retried");
        return "redirectThis";

    }

}
