package com.example.demo.dtos.implementations;

import com.example.demo.dtos.interfaces.DTO;
import com.example.demo.entities.Player;

public class ForeignPlayerDTO implements DTO {
    public String username;
    public int cardsCount;

    public ForeignPlayerDTO(Player player) {
        this.username = player.getUsername();
        this.cardsCount = player.getCards().size();
    }
}
