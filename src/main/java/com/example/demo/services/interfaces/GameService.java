package com.example.demo.services.interfaces;

import com.example.demo.entities.Game;
import com.example.demo.entities.Player;

public interface GameService {
    Game join(Long gameId, Player player);

    Game create();

    Game getGame(Long id);
}
