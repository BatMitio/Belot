package com.example.demo.sockets.structures.dtos;

import com.example.demo.entities.Player;
import com.example.demo.sockets.structures.interfaces.Data;

public class ForeignPlayerDTO implements Data {
    public String username;
    public int cardsCount;

    public ForeignPlayerDTO(Player player) {
        this.username = player.getUsername();
        this.cardsCount = player.getCards().size();
    }
}
