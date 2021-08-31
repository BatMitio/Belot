package com.example.demo.web;

import com.example.demo.dtos.AuthBodyDTO;
import com.example.demo.dtos.PlayerDTO;
import com.example.demo.dtos.UsernameAvailabilityDTO;
import com.example.demo.entities.Response;
import com.example.demo.entities.Player;
import com.example.demo.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private PlayersRepository playersRepo;

    @PostMapping("/login")
    public Response login(@RequestBody AuthBodyDTO body){
        Player player = playersRepo.login(body.username, body.password);
        if(player != null){
            return new Response("Login successful!", new PlayerDTO(player));
        }
        return new Response("Invalid credentials!", null);
    }

    @PostMapping("/username_available")
    public Response usernameAvailable(@RequestBody UsernameAvailabilityDTO body){
        String username = body.username;
        if(playersRepo.usernameAvailable(username)){
            return new Response("Username available!", null);
        }
        return new Response("Username not available!", null);
    }
}
