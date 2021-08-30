package com.example.demo.web;

import com.example.demo.dtos.PlayerDTO;
import com.example.demo.entities.Response;
import com.example.demo.entities.Player;
import com.example.demo.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CredentialsController {
    @Autowired
    private PlayersRepository playersRepository;

    @GetMapping("/validate_credentials")
    public Response validateCredentials(@RequestHeader("username") String username,
                                        @RequestHeader("X-Authorization") String token){
        Player player = playersRepository.getPlayer(username, token);
        if(player != null){
            return new Response("Valid credentials!", new PlayerDTO(player));
        }
        return new Response("Invalid credentials!", null);
    }
}
