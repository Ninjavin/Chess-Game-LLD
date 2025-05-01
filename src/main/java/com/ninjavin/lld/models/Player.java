package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;

public class Player {
    private String name;
    private Color color;
    public boolean isWhiteSide() {
        return (this.color == Color.WHITE);
    }
    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
