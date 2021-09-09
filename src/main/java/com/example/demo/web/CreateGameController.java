package com.example.demo.web;

import com.example.demo.dtos.implementations.CreateResponseDTO;
import com.example.demo.entities.Game;
import com.example.demo.entities.Player;
import com.example.demo.entities.Response;
import com.example.demo.services.interfaces.GameService;
import com.example.demo.services.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateGameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;

    @GetMapping("/create")
    public Response join(@RequestHeader("username") String username,
                         @RequestHeader("X-Authorization") String token){
        Player player = playerService.getPlayerByUsernameAndToken(username, token);
        if(player != null){
            Game game = gameService.create();
            gameService.join(game.getId(), player);
            if(game != null){
                return new Response("Successfully created!", new CreateResponseDTO(game));
            }
            return new Response("No", null);
        }
        return new Response("No", null);
    }
}
