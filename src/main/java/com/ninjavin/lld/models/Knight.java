package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.strategy.KnightMovementStrategy;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color, new KnightMovementStrategy());
    }
    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        return false;
    }
    @Override
    public void move(Board board, Cell start, Cell end) {

    }
    @Override
    public String pieceName() {
        return "G";
    }
}
