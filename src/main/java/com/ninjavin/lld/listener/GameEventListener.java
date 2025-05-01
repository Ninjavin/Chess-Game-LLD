package com.ninjavin.lld.listener;

import com.ninjavin.lld.enums.GameStatus;
import com.ninjavin.lld.models.Move;

public interface GameEventListener {
    void onMoveMade(Move move);
    void onGameStateChanged(GameStatus status);
}
