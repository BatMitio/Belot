package com.example.demo;

import com.example.demo.repository.PlayersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean()
    @Scope("singleton")
    public PlayersRepository getPlayerRepo(){
        return new PlayersRepository();
    }
}
