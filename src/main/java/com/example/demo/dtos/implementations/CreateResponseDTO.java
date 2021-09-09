package com.example.demo.dtos.implementations;

import com.example.demo.dtos.interfaces.DTO;
import com.example.demo.entities.Game;

public class CreateResponseDTO implements DTO {
    public String gamePin;

    public CreateResponseDTO(Game game) {
        gamePin = String.valueOf(game.getId());
    }
}
