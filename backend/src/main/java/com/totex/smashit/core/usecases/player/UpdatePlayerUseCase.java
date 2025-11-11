package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;

public interface UpdatePlayerUseCase {

    public Player execute(Long id, Player player);
}
