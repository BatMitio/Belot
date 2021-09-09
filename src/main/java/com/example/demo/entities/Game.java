package com.example.demo.entities;

import com.example.demo.utils.Contract;
import com.example.demo.utils.Overbid;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Game{
    private Long id;
    private List<Player> players;
    private Set<Card> deck;
    private Set<Card> team1Deck;
    private Set<Card> team2Deck;
    private int playerToCut;
    private int team1currentPoints;
    private int team2currentPoints;
    private int team1totalPoints;
    private int team2totalPoints;
    private Contract currentContract;
    private Overbid currentOverbid;
    private int lastTeamToCall;

    public Game() {
        this.players = new ArrayList<>();
        this.deck = new HashSet<>();
        this.team1Deck = new HashSet<>();
        this.team2Deck = new HashSet<>();
        this.playerToCut = 0;
        this.team1currentPoints = 0;
        this.team2currentPoints = 0;
        this.team1totalPoints = 0;
        this.team2totalPoints = 0;
        this.currentContract = null;
        this.currentOverbid = null;
        this.lastTeamToCall = 0;
    }

    @Id
    @SequenceGenerator(name = "sequence", initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Card> getDeck() {
        return deck;
    }

    public void setDeck(Set<Card> deck) {
        this.deck = deck;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Card> getTeam1Deck() {
        return team1Deck;
    }

    public void setTeam1Deck(Set<Card> team1Deck) {
        this.team1Deck = team1Deck;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Card> getTeam2Deck() {
        return team2Deck;
    }

    public void setTeam2Deck(Set<Card> team2Deck) {
        this.team2Deck = team2Deck;
    }


    public int getPlayerToCut() {
        return playerToCut;
    }

    public void setPlayerToCut(int playerToCut) {
        this.playerToCut = playerToCut;
    }

    public int getTeam1currentPoints() {
        return team1currentPoints;
    }

    public void setTeam1currentPoints(int team1currentPoints) {
        this.team1currentPoints = team1currentPoints;
    }

    public int getTeam2currentPoints() {
        return team2currentPoints;
    }

    public void setTeam2currentPoints(int team2currentPoints) {
        this.team2currentPoints = team2currentPoints;
    }

    public int getTeam1totalPoints() {
        return team1totalPoints;
    }

    public void setTeam1totalPoints(int team1totalPoints) {
        this.team1totalPoints = team1totalPoints;
    }

    public int getTeam2totalPoints() {
        return team2totalPoints;
    }

    public void setTeam2totalPoints(int team2totalPoints) {
        this.team2totalPoints = team2totalPoints;
    }

    public Contract getCurrentContract() {
        return currentContract;
    }

    public void setCurrentContract(Contract currentContract) {
        this.currentContract = currentContract;
    }

    public Overbid getCurrentOverbid() {
        return currentOverbid;
    }

    public void setCurrentOverbid(Overbid currentOverbid) {
        this.currentOverbid = currentOverbid;
    }

    public int getLastTeamToCall() {
        return lastTeamToCall;
    }

    public void setLastTeamToCall(int lastTeamToCall) {
        this.lastTeamToCall = lastTeamToCall;
    }
}
