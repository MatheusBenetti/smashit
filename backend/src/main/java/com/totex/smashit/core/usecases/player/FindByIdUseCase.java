package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;

public interface FindByIdUseCase {

    public Player findById(Long id);
}
