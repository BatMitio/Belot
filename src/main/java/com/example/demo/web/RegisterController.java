package com.example.demo.web;

import com.example.demo.dtos.implementations.AuthBodyDTO;
import com.example.demo.dtos.implementations.PlayerDTO;
import com.example.demo.dtos.implementations.UsernameAvailabilityDTO;
import com.example.demo.entities.Player;
import com.example.demo.services.interfaces.PlayerService;
import com.example.demo.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/register")
    private Response register(@RequestBody AuthBodyDTO body) {
        Player player = new Player(body.username, Encoder.encode(body.password));
        if(!playerService.usernameAvailable(body.username)){
            return new Response("Username already exists!", null);
        }
        if(playerService.addPlayer(player) != null){
            return new Response("Registration successful!", new PlayerDTO(player));
        }
        return new Response("Registration not successful!", null);
    }

    @PostMapping("/username_available")
    public Response usernameAvailable(@RequestBody UsernameAvailabilityDTO body){
        String username = body.username;
        if(playerService.usernameAvailable(username)){
            return new Response("Username available!", null);
        }
        return new Response("Username not available!", null);
    }
}
