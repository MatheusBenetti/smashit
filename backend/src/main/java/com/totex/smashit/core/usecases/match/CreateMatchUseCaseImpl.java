package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.gateway.match.MatchGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateMatchUseCaseImpl implements CreateMatchUseCase {

    private static final Logger log = LoggerFactory.getLogger(CreateMatchUseCaseImpl.class);

    private final MatchGateway matchGateway;

    public CreateMatchUseCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public Match execute(Match match) {
        log.info("Creating a tennis match: {}", match);
        try {
            Match created = matchGateway.createMatch(match);
            log.info("Match {} created. Date: {}, Hour: {}", match.id(), match.date(), match.hour());
            return created;
        } catch (Exception e) {
            log.error("Error occurred while creating a match: {}", e.getMessage());
            throw e;
        }
    }
}
