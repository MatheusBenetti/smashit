package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;

import java.util.List;

public class FindPlayerUseCaseImpl implements FindPlayerUseCase {

    private final PlayerGateway playerGateway;

    public FindPlayerUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public List<Player> execute() {
        return playerGateway.findPlayer();
    }
}
