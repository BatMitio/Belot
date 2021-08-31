package com.example.demo.services;

import com.example.demo.repository.CardRepository;
import com.example.demo.services.interfaces.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
}
