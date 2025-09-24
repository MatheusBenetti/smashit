package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;

public class CreatePlayerUseCaseImpl implements CreatePlayerUseCase {

    private final PlayerGateway playerGateway;

    public CreatePlayerUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player execute(Player player) {
        return playerGateway.createPlayer(player);
    }
}
