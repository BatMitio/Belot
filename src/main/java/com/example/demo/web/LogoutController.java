package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @GetMapping("/logout")
    public void logout(@RequestHeader("X-Authorization") String token){

    }
}
