package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;

public class UpdatePlayerUseCaseImpl implements UpdatePlayerUseCase {

    private final PlayerGateway playerGateway;

    public UpdatePlayerUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player execute(Player player) {
        return null;
    }
}
