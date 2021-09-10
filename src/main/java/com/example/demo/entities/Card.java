package com.example.demo.entities;

import javax.persistence.*;

@Entity
public class Card extends BaseEntity {
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
