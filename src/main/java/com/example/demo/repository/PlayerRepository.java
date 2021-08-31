package com.example.demo.repository;

import com.example.demo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player getByUsername(String username);

    @Query("SELECT CASE WHEN COUNT(p) = 0 THEN true ELSE false END FROM Player p WHERE p.username = :username")
    boolean usernameAvailable(String username);
}
