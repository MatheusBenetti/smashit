package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;

import java.util.List;

public interface FindPlayerUseCase {

    public List<Player> execute();
}
