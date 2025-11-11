package com.totex.smashit.core.usecases.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdatePlayerUseCaseImpl implements UpdatePlayerUseCase {

    private static final Logger log = LoggerFactory.getLogger(UpdatePlayerUseCaseImpl.class);

    private final PlayerGateway playerGateway;

    public UpdatePlayerUseCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player execute(Long id, Player player) {
        log.info("Updating player: {}", id);
        try {
            Player updatedPlayer = playerGateway.updatePlayer(id, player);
            log.info("Player updated: {}", updatedPlayer);
            return updatedPlayer;
        } catch (Exception e) {
            log.error("Error while updating player: {}! Error message: {}", player.name(), e.getMessage());
            throw e;
        }
    }
}
