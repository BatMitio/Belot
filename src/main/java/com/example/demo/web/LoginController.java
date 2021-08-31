package com.example.demo.web;

import com.example.demo.dtos.implementations.AuthBodyDTO;
import com.example.demo.dtos.implementations.PlayerDTO;
import com.example.demo.dtos.implementations.UsernameAvailabilityDTO;
import com.example.demo.entities.Response;
import com.example.demo.entities.Player;
import com.example.demo.services.interfaces.PlayerService;
import com.example.demo.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/login")
    public Response login(@RequestBody AuthBodyDTO body){
        Player player = playerService.login(body.username, body.password);
        if(player != null){
            return new Response("Login successful!", new PlayerDTO(player));
        }
        return new Response("Invalid credentials!", null);
    }
}
