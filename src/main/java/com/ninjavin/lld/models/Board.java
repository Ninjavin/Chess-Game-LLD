package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.factory.PieceFactory;

public class Board {
    private Cell[][] cells = new Cell[8][8];
    private static Board instance;
    public Board() {
        initialize();
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
    private void initialize() {
        cells[0][0] = new Cell(0, 0, PieceFactory.createPiece("rook", Color.WHITE));
        cells[0][1] = new Cell(0, 1, PieceFactory.createPiece("knight", Color.WHITE));
        cells[0][2] = new Cell(0, 2, PieceFactory.createPiece("bishop", Color.WHITE));
        cells[0][3] = new Cell(0, 3, PieceFactory.createPiece("queen", Color.WHITE));
        cells[0][4] = new Cell(0, 4, PieceFactory.createPiece("king", Color.WHITE));
        cells[0][5] = new Cell(0, 5, PieceFactory.createPiece("bishop", Color.WHITE));
        cells[0][6] = new Cell(0, 6, PieceFactory.createPiece("knight", Color.WHITE));
        cells[0][7] = new Cell(0, 7, PieceFactory.createPiece("rook", Color.WHITE));

        for (int i=0 ; i<8 ; i++) {
            cells[1][i] = new Cell(1, i, new Pawn(Color.WHITE));
        }

        cells[7][0] = new Cell(7, 0, new Rook(Color.BLACK));
        cells[7][1] = new Cell(7, 1, new Knight(Color.BLACK));
        cells[7][2] = new Cell(7, 2, new Bishop(Color.BLACK));
        cells[7][3] = new Cell(7, 3, new Queen(Color.BLACK));
        cells[7][4] = new Cell(7, 4, new King(Color.BLACK));
        cells[7][5] = new Cell(7, 5, new Bishop(Color.BLACK));
        cells[7][6] = new Cell(7, 6, new Knight(Color.BLACK));
        cells[7][7] = new Cell(7, 7, new Rook(Color.BLACK));
        for (int i=0 ; i<8 ; i++) {
            cells[6][i] = new Cell(6, i, new Pawn(Color.BLACK));
        }

        for (int i=2 ; i<6 ; i++) {
            for (int j=0 ; j<8 ; j++) {
                cells[i][j] = new Cell(i, j, null);
            }
        }

        System.out.println("Chess board initialized!");
        printChessBoard();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void printChessBoard() {
        System.out.println("    A   B   C   D   E   F   G   H");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + " |");

            for (int j = 0; j < 8; j++) {
                Piece piece = cells[i][j].getPiece();
                String symbol = piece == null ? " " : piece.pieceName();
                System.out.print(" " + symbol + " |");
            }

            System.out.println(" " + (i + 1));
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
        System.out.println("    A   B   C   D   E   F   G   H");
    }
}
