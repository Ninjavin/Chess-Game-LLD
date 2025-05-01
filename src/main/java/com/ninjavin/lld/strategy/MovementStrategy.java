package com.ninjavin.lld.strategy;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.models.Board;
import com.ninjavin.lld.models.Cell;

public interface MovementStrategy {
    boolean canMove(Board board, Cell startCell, Cell endCell, Color color);
}
