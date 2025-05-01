package com.ninjavin.lld.models;

public class Cell {
    private int x;
    private int y;
    private String label;
    private Piece piece;
    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.label = assignLabel(x, y);
        this.piece = piece;
    }

    public String getLabel() {
        return label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private String assignLabel(int x, int y) {
        String[] xLabels = {"1","2","3","4","5","6","7","8"};
        String[] yLabels = {"a","b","c","d","e","f","g","h"};
        return xLabels[x] + yLabels[y];
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public static int[] getIndicesFromLabel(String label) {
        String[] xLabels = {"1","2","3","4","5","6","7","8"};
        String[] yLabels = {"a","b","c","d","e","f","g","h"};
        // label = 'e2'
        char fileChar = label.charAt(0); // 'e' -> 'E'
        char rankChar = label.charAt(1); // '2'
        int y = -1, x = -1;
        for (int i=0 ; i<yLabels.length ; i++) {
            if (yLabels[i].equals(String.valueOf(fileChar))) {
                y = i;
                break;
            }
        }
        for (int i=0 ; i<xLabels.length ; i++) {
            if (xLabels[i].equals(String.valueOf(rankChar))) {
                x = i;
                break;
            }
        }

        return new int[]{x, y};
    }
}
