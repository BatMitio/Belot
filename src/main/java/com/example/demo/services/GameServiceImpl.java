package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.entities.Player;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.services.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepo;
    @Autowired
    private PlayerRepository playerRepo;

    @Override
    public Game join(Long gameId, Player player) {
        Game game = gameRepo.getById(gameId);
        if(game != null){
            if(game.getPlayers().size() < 4){
                player.setGame(game);
                playerRepo.saveAndFlush(player);
                return game;
            }
            return null;
        }
        return null;
    }

    @Override
    public Game create() {
        Game game = new Game();
        gameRepo.saveAndFlush(game);
        return game;
    }

    @Override
    public Game getGame(Long id) {
        return gameRepo.getById(id);
    }
}
