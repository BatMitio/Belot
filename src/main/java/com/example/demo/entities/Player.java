package com.example.demo.entities;

import com.example.demo.dtos.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private String username;
    private String password;
    private UUID token;
    private List<Card> cards;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.token = UUID.randomUUID();
        this.cards = new ArrayList<>();
    }

    public Player(String username, String password, UUID token, List<Card> cards) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.cards = cards;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
