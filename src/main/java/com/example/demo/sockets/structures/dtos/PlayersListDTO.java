package com.example.demo.sockets.structures.dtos;

import com.example.demo.entities.Player;
import com.example.demo.sockets.structures.interfaces.Data;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersListDTO implements Data {
    public List<ForeignPlayerDTO> players;

    public PlayersListDTO(List<Player> players) {
        this.players = players.stream().map(ForeignPlayerDTO::new).collect(Collectors.toList());
    }
}
