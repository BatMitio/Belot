package com.example.demo.services.interfaces;

import com.example.demo.entities.Player;

public interface PlayerService {
    Player login(String username, String password);

    boolean usernameAvailable(String username);

    Player addPlayer(Player player);

    Player getPlayerByUsernameAndToken(String username, String token);
}
