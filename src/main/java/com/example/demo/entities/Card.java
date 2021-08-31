package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card extends BaseEntity {
    private String name;

    public Card() {
        this.name = "";
    }

    public Card(String name) {
        this.name = name;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
