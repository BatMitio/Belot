package com.example.demo.web;

import com.example.demo.dtos.implementations.JoinBodyDTO;
import com.example.demo.entities.Game;
import com.example.demo.entities.Player;
import com.example.demo.entities.Response;
import com.example.demo.services.interfaces.GameService;
import com.example.demo.services.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;

    @PostMapping("/join")
    public Response join(@RequestBody JoinBodyDTO body,
                         @RequestHeader("username") String username,
                         @RequestHeader("X-Authorization") String token){
        Long gameId = Long.parseLong(body.gamePin);
        Player player = playerService.getPlayerByUsernameAndToken(username, token);
        if(player != null){
            Game game = gameService.join(gameId, player);
            if(game != null){
                return new Response("Successfully joined!", null);
            }
            return new Response("No", null);
        }
        return new Response("No", null);
    }
}
