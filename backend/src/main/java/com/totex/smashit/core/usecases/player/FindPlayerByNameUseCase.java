package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;

public interface FindPlayerByNameUseCase {
    public Player execute(String name);
}
