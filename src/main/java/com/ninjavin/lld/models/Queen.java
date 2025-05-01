package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.strategy.QueenMovementStrategy;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, new QueenMovementStrategy());
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
        return "Q";
    }
}
