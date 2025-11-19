package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;

public class FindByIdUseCaseImpl implements FindByIdUseCase {

    private final PlayerGateway playerGateway;

    public FindByIdUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player findById(Long id) {
        return null;
    }
}
