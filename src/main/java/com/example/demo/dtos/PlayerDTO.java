package com.example.demo.dtos;

import com.example.demo.entities.Card;
import com.example.demo.entities.Player;

import java.util.List;

public class PlayerDTO implements DTO {
    public String username;
    public String token;
    public List<Card> cards;

    public PlayerDTO() {
    }

    public PlayerDTO(Player player) {
        this.username = player.getUsername();
        this.token = player.getToken().toString();
        this.cards = player.getCards();
    }

    public PlayerDTO(String username, String token, List<Card> cards) {
        this.username = username;
        this.token = token;
        this.cards = cards;
    }
}
