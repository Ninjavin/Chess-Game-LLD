package com.ninjavin.lld;

import com.ninjavin.lld.listener.ConsoleGameEventListener;
import com.ninjavin.lld.models.ChessGame;
import com.ninjavin.lld.models.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Vineeta");
        Player player2 = new Player("Ninja");
        ChessGame game = new ChessGame(player1, player2);
        game.setObserver(new ConsoleGameEventListener());
        game.start();
    }
}
