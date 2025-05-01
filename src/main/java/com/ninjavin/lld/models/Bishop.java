package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.strategy.BishopMovementStrategy;
import com.ninjavin.lld.strategy.MovementStrategy;

public class Bishop extends Piece {
    private MovementStrategy strategy;
    public Bishop(Color color) {
        super(color, new BishopMovementStrategy());
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
        return "B";
    }
}
