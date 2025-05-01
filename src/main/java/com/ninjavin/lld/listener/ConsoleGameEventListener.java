package com.ninjavin.lld.listener;

import com.ninjavin.lld.enums.GameStatus;
import com.ninjavin.lld.models.Move;

public class ConsoleGameEventListener implements GameEventListener {
    public void onMoveMade(Move move) {
        System.out.println("Move made from : " + move.getStartCell().getLabel() + " to " + move.getEndCell().getLabel());
    }

    public void onGameStateChanged(GameStatus status) {
        System.out.println("Game state changed to : " + status);
    }
}
