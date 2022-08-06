package com.ming.springsecuritylearn.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloSecurity {
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello Security";
    }

    @RequestMapping("/helloUser")
    @PreAuthorize(value = "hasAnyRole('admin','normal')")
    public String helloUser(){
        return "hello 拥有normal，admin角色的用户";
    }

    @RequestMapping("/helloAdmin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String helloAdmin(){
        return "Hello 拥有admin角色的用户";
    }
}
