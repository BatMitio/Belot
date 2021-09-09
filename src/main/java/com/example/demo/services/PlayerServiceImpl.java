package com.example.demo.services;

import com.example.demo.entities.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.services.interfaces.PlayerService;
import com.example.demo.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public Player login(String username, String password) {
        if(!playerRepository.existsByUsername(username)){
            return null;
        }
        Player player = playerRepository.getByUsername(username);
        String hashedPassword = Encoder.encode(password);
        if(player.getPassword().equals(hashedPassword)){
            return player;
        }
        return null;
    }

    @Override
    public boolean usernameAvailable(String username) {
        return !playerRepository.existsByUsername(username);
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    @Override
    public Player getPlayerByUsernameAndToken(String username, String token) {
        Player player = playerRepository.getByUsername(username);
        if(player != null && player.getToken().equals(token)){
            return player;
        }
        return null;
    }
}
