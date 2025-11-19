package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindByIdUseCaseImpl implements FindByIdUseCase {

    private static final Logger log = LoggerFactory.getLogger(FindByIdUseCaseImpl.class);

    private final PlayerGateway playerGateway;

    public FindByIdUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player findById(Long id) {
        log.info("Finding player with ID: {}", id);
        try {
            Player found = playerGateway.findById(id);
            log.info("Player found: {}", found);
            return found;
        } catch (Exception e) {
            log.error("Error while trying to find player. Error: {}", e.getMessage());
            throw e;
        }
    }
}
