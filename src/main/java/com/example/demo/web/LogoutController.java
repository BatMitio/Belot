package com.example.demo.web;

import com.example.demo.entities.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @GetMapping("/logout")
    public Response logout(@RequestHeader("X-Authorization") String token){
        return new Response("Logout successful!", null);
    }
}
