package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.strategy.MovementStrategy;

public abstract class Piece {
    private Color color;
    private boolean isKilled = false;
    private MovementStrategy movementStrategy;
    public boolean canMove(Board board, Cell start, Cell end) {
        return movementStrategy.canMove(board, start, end, color);
    }
    public abstract void move(Board board, Cell start, Cell end);
    public abstract String pieceName();
    public Piece(Color color, MovementStrategy movementStrategy) {
        this.color = color;
        this.movementStrategy = movementStrategy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhitePiece() {
        return (this.color == Color.WHITE);
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
}
