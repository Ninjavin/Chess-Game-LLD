package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;

public class Move {
    private Cell startCell;
    private Cell endCell;

    public Move(Cell startCell, Cell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public boolean isValid() {
        Color startPieceColor = startCell.getPiece().getColor();
        Piece endPiece = endCell.getPiece();
        if (endPiece != null) {
            System.out.println("\nEnd piece : " + endPiece.pieceName());
            Color endPieceColor = endPiece.getColor();
            if (startPieceColor == endPieceColor) {
                return false;
            }
        }
        return true;
    }

    public Cell getStartCell() {
        return startCell;
    }

    public void setStartCell(Cell startCell) {
        this.startCell = startCell;
    }

    public Cell getEndCell() {
        return endCell;
    }

    public void setEndCell(Cell endCell) {
        this.endCell = endCell;
    }
}
