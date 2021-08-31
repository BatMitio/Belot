package com.example.demo.repository;

import com.example.demo.entities.Player;
import com.example.demo.utils.Encoder;

import java.util.HashMap;
import java.util.Map;

public class PlayersRepository {
    private Map<String, Player> players;

    public PlayersRepository() {
        players = new HashMap<>();
    }

    public boolean addPlayer(Player player){
        if(players.containsKey(player.getUsername()))
            return false;
        players.put(player.getUsername(), player);
        return true;
    }

    public Player removePlayer(String username){
        return players.remove(username);
    }

    public Player getPlayer(String username, String token) {
        Player player = this.players.get(username);
        if(player != null){
            if(player.getToken().toString().equals(token)){
                return player;
            }
            return null;
        }
        return null;
    }

    public Player login(String username, String password) {
        Player player = this.players.get(username);
        if(player != null){
            if(Encoder.encode(password).equals(player.getPassword())){
               return player;
            }
            return null;
        }
        return null;
    }

    public boolean usernameAvailable(String username) {
        return !players.containsKey(username);
    }
}
