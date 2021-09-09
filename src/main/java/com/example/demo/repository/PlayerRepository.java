package com.example.demo.repository;

import com.example.demo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player getByUsername(String username);

    boolean existsByUsername(String username);


}
