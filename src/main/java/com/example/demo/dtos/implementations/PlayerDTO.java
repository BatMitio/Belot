package com.example.demo.dtos.implementations;

import com.example.demo.dtos.interfaces.DTO;
import com.example.demo.entities.Card;
import com.example.demo.entities.Player;

import java.util.Set;

public class PlayerDTO implements DTO {
    public String username;
    public String token;
    public Set<Card> cards;

    public PlayerDTO() {
    }

    public PlayerDTO(Player player) {
        this.username = player.getUsername();
        this.token = player.getToken().toString();
        this.cards = player.getCards();
    }

    public PlayerDTO(String username, String token, Set<Card> cards) {
        this.username = username;
        this.token = token;
        this.cards = cards;
    }
}
