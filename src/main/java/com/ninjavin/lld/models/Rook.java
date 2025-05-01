package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.strategy.RookMovementStrategy;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, new RookMovementStrategy());
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
        return "R";
    }
}
