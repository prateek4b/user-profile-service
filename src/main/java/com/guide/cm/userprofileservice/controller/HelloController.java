package com.guide.cm.userprofileservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello";

    }

    @GetMapping("/sayRedirected")
    public String sayHelloRedirected() {
        return "HelloRedirected";

    }

}
