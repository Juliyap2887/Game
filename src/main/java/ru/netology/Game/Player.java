package ru.netology.Game;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    protected int id;
    @Setter
    protected String playerName;
    @Setter
    protected int strength;

    public Player(int id, String playerName, int strength) {
        this.id = id;
        this.playerName = playerName;
        this.strength = strength;
    }

}
