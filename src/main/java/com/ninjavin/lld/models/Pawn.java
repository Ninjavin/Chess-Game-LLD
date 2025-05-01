package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.strategy.PawnMovementStrategy;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color, new PawnMovementStrategy());
    }
    public boolean canMove(Board board, Cell start, Cell end) {
        PawnMovementStrategy strategy = (PawnMovementStrategy) this.getMovementStrategy();
        return strategy.canMove(board, start, end, this.getColor());
    }
    @Override
    public void move(Board board, Cell start, Cell end) {

    }
    @Override
    public String pieceName() {
        return "P";
    }
}
