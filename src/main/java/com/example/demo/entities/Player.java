package com.example.demo.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Player extends BaseEntity {
    private String username;
    private String password;
    private String token;
    private Set<Card> cards;
    private Game game;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.token = UUID.randomUUID().toString();
        this.cards = new HashSet<>();
    }

    public Player(String username, String password, UUID token, Set<Card> cards) {
        this.username = username;
        this.password = password;
        this.token = token.toString();
        this.cards = cards;
    }

    public Player() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
