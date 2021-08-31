package com.example.demo.web;

import com.example.demo.dtos.JoinBodyDTO;
import com.example.demo.dtos.JoinResponseDTO;
import com.example.demo.entities.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {
    @PostMapping("/join")
    public Response join(@RequestBody JoinBodyDTO body,
                         @RequestHeader("username") String username,
                         @RequestHeader("X-Authorization") String token){
        return new Response("No", new JoinResponseDTO());
    }
}
