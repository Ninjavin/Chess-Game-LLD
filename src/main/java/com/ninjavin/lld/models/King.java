package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.strategy.KingMovementStrategy;
import com.ninjavin.lld.strategy.MovementStrategy;

public class King extends Piece {
    private MovementStrategy movementStrategy;
    public King(Color color) {
        super(color, new KingMovementStrategy());
    }
    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        return movementStrategy.canMove(board, start, end, this.getColor());
    }
    @Override
    public void move(Board board, Cell start, Cell end) {

    }
    @Override
    public String pieceName() {
        return "K";
    }
}
