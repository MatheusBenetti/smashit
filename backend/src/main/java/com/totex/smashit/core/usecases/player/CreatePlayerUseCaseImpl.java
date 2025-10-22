package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatePlayerUseCaseImpl implements CreatePlayerUseCase {

    private static final Logger log = LoggerFactory.getLogger(CreatePlayerUseCaseImpl.class);

    private final PlayerGateway playerGateway;

    public CreatePlayerUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player execute(Player player) {
        log.info("Creating player: {}", player);
        try {
            Player created = playerGateway.createPlayer(player);
            log.info("Player {} created successfully!", player.name());
            return created;
        } catch (Exception e) {
            log.error("Error while creating player: {}", e.getMessage());
            throw e;
        }
    }
}
