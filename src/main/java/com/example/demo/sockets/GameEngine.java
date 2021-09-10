package com.example.demo.sockets;

import com.example.demo.services.interfaces.GameService;
import com.example.demo.sockets.structures.dtos.PlayersListDTO;
import com.example.demo.sockets.structures.frames.TeamFrame;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameEngine {
    @Autowired
    private GameService gameService;
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private Gson gson;

    @MessageMapping("/update")
    public void update(){

    }

    public void playerJoined(Long gamePin) {
        TeamFrame frame = new TeamFrame("Player joined!", new PlayersListDTO(gameService.getGame(gamePin).getPlayers()));
        template.convertAndSend("/team/" + gamePin, gson.toJson(frame));
    }
}
