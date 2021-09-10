package com.example.demo.web;

import com.example.demo.services.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    private GameService gameService;

    @GetMapping("/test")
    public Response test(){
        return new Response(String.valueOf(gameService.getGame(100201L).getPlayers().size()), null);
    }
}