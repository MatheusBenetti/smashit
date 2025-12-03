package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;

import com.totex.smashit.core.gateway.player.PlayerGateway;
import com.totex.smashit.infra.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindPlayerByNameUseCaseImpl implements FindPlayerByNameUseCase {

    private static final Logger log = LoggerFactory.getLogger(FindPlayerByNameUseCaseImpl.class);

    private final PlayerGateway playerGateway;

    public FindPlayerByNameUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player execute(String name) {
        log.info("Finding player with name: {}", name);
        try {
            Player found = playerGateway.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Player with name: " + name + " not found!"));
            log.info("Player found: {}", found);
            return found;
        } catch (Exception e) {
            log.error("Error while finding player by name. Error: {}", e.getMessage());
            throw e;
        }
    }
}
