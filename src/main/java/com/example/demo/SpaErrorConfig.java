package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaErrorConfig {
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String error() {
        return "forward:/";
    }
}
