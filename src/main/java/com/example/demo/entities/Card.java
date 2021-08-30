package com.example.demo.entities;

import com.example.demo.dtos.DTO;

public class Card {
    private String name;

    public Card() {
        this.name = "";
    }

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
