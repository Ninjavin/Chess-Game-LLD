package com.ninjavin.lld.strategy;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.models.Board;
import com.ninjavin.lld.models.Cell;
import com.ninjavin.lld.models.Piece;

public class PawnMovementStrategy implements MovementStrategy {
    public boolean canMove(Board board, Cell startCell, Cell endCell, Color color) {
        int dx = endCell.getX() - startCell.getX();
        int dy = endCell.getY() - startCell.getY();
        Piece destinationPiece = board.getCells()[endCell.getX()][endCell.getY()].getPiece();
        if (color.equals(Color.WHITE)) {
            if (dx == 1 && dy == 0 && destinationPiece==null)
                return true;
            if (startCell.getX()==1 && dx==2 && dy==0 && destinationPiece==null && board.getCells()[startCell.getX()+1][startCell.getY()]==null) {
                return true;
            }
            if (dx == 1 && Math.abs(dy) == 1 && destinationPiece!=null && !destinationPiece.isWhitePiece()) {
                return true;
            }
        } else {
            if (dx == -1 && dy == 0 && destinationPiece == null) return true;

            // Move 2 steps forward from row 6
            if (startCell.getX() == 6 && dx == -2 && dy == 0 &&
                    destinationPiece == null &&
                    board.getCells()[startCell.getX()-1][startCell.getY()] == null) {
                return true;
            }

            // Capture diagonally
            if (dx == -1 && Math.abs(dy) == 1 &&
                    destinationPiece != null && destinationPiece.isWhitePiece()) {
                return true;
            }
        }
        return false;
    }
}
