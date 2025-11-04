package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.match.MatchGateway;
import com.totex.smashit.core.usecases.player.UpdatePlayerUseCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateMatchUseCaseImpl implements UpdateMatchUseCase {

    private static final Logger log = LoggerFactory.getLogger(UpdateMatchUseCaseImpl.class);

    private final MatchGateway matchGateway;

    public UpdateMatchUseCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public Match execute(Match match) {
        log.info("Updating match: {}", match);
        try {
            Match updatedMatch = matchGateway.updateMatch(match);
            log.info("Match updated successfully: {}", updatedMatch);
            return updatedMatch;
        } catch (Exception e) {
            log.error("Error while updating match: {}", e.getMessage());
            throw e;
        }
    }
}
