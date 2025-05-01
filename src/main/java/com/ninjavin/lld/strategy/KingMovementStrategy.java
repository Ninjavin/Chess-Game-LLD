package com.ninjavin.lld.strategy;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.models.Board;
import com.ninjavin.lld.models.Cell;

public class KingMovementStrategy implements MovementStrategy {

    public boolean canMove(Board board, Cell startCell, Cell endCell, Color color) {
        return false;
    }
}
