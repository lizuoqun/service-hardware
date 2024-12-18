package com.modify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author modify
 */
@RestController
public class demoController{

    @GetMapping("/demo")
    public String demo() {
        return "hello world in demo controller test compiler";
    }
}
