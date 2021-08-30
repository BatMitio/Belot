package com.example.demo.web;

import com.example.demo.dtos.AuthBodyDTO;
import com.example.demo.dtos.PlayerDTO;
import com.example.demo.entities.Response;
import com.example.demo.entities.Player;
import com.example.demo.repository.PlayersRepository;
import com.example.demo.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private PlayersRepository playersRepo;

    @PostMapping("/register")
    private Response register(@RequestBody AuthBodyDTO body) {
        Player player = new Player(body.username, Encoder.encode(body.password));
        if(playersRepo.addPlayer(player)){
            return new Response("Registration successful!", new PlayerDTO(player));
        }
        return new Response("Username already exists!", null);
    }
}
