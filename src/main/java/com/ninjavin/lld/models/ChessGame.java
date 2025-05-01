package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.GameStatus;
import com.ninjavin.lld.listener.GameEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessGame {
    private boolean whiteTurn;
    // player1 is always WHITE, player2 is always BLACK
    private Player player1;
    private Player player2;
    private Board chessBoard;
    private List<Move> gameLog;
    private GameStatus status;
    private GameEventListener listener;
    private Scanner scanner = new Scanner(System.in);
    public ChessGame(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.whiteTurn = true;
        this.chessBoard = new Board();
        this.gameLog = new ArrayList<Move>();
        this.status = GameStatus.ACTIVE;
    }

    public void start() {
        while (this.status == GameStatus.ACTIVE) {
            if (whiteTurn) {
                System.out.println("Player 1 please input your moves like : e2 e4");
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    System.out.println("Invalid format.");
                    continue;
                }
                int[] pos = Cell.getIndicesFromLabel(parts[0]);
                int startX = pos[0], startY = pos[1];
                int[] endPos = Cell.getIndicesFromLabel(parts[1]);
                int endX = endPos[0], endY = endPos[1];
                Cell startCell = chessBoard.getCells()[startX][startY];
                Cell endCell = chessBoard.getCells()[endX][endY];
                makeMove(new Move(startCell, endCell), player1);
            } else {
                System.out.println("Player 2 please input your moves like : e2 e4");
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    System.out.println("Invalid format.");
                    continue;
                }
                int[] pos = Cell.getIndicesFromLabel(parts[0]);
                int startX = pos[0], startY = pos[1];
                int[] endPos = Cell.getIndicesFromLabel(parts[1]);
                int endX = endPos[0], endY = endPos[1];
                Cell startCell = chessBoard.getCells()[startX][startY];
                Cell endCell = chessBoard.getCells()[endX][endY];
                makeMove(new Move(startCell, endCell), player2);
            }
        }
    }

    public void makeMove(Move move, Player player) {
        if (move.isValid()) {
            Piece sourcePiece = move.getStartCell().getPiece();
            if (sourcePiece.canMove(this.chessBoard, move.getStartCell(), move.getEndCell())) {
                Piece destinationPiece = move.getEndCell().getPiece();
                if (destinationPiece != null) {
                    if (destinationPiece instanceof King && whiteTurn) {
                        this.status = GameStatus.WHITEWIN;
                        notifyGameStateChanged(this.status);
                        return ;
                    }
                    if (destinationPiece instanceof King && !whiteTurn) {
                        this.status = GameStatus.BLACKWIN;
                        notifyGameStateChanged(this.status);
                        return ;
                    }
                    destinationPiece.setKilled(true);
                }
                gameLog.add(move);
                move.getEndCell().setPiece(sourcePiece);
                move.getStartCell().setPiece(null);
                notifyMoveMade(move);
                chessBoard.printChessBoard();
                whiteTurn = !whiteTurn;
            }
        }
    }

    public void setObserver(GameEventListener listener) {
        this.listener = listener;
    }

    private void notifyMoveMade(Move move) {
        if (listener != null) {
            listener.onMoveMade(move);
        }
    }
    private void notifyGameStateChanged(GameStatus status) {
        if (listener!=null) {
            listener.onGameStateChanged(status);
        }
    }
}
