package com.ninjavin.lld.factory;

import com.ninjavin.lld.enums.Color;
import com.ninjavin.lld.models.*;

public abstract class PieceFactory {
    public static Piece createPiece(String pieceType, Color color) {
        if (pieceType.equals("king")) {
            return new King(color);
        } else if (pieceType.equals("queen")) {
            return new Queen(color);
        } else if (pieceType.equals("rook")) {
            return new Rook(color);
        } else if (pieceType.equals("knight")) {
            return new Knight(color);
        } else if (pieceType.equals("bishop")) {
            return new Bishop(color);
        } else if (pieceType.equals("pawn")) {
            return new Pawn(color);
        }
        throw new IllegalArgumentException("Unknown piece type : " + pieceType);
    }
}
