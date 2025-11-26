package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;

public interface FindPlayerByIdUseCase {

    public Player execute(Long id);
}
