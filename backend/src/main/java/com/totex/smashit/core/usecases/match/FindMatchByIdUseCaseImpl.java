package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.gateway.match.MatchGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindMatchByIdUseCaseImpl implements FindMatchByIdUseCase {

    private static final Logger log = LoggerFactory.getLogger(FindMatchByIdUseCaseImpl.class);

    private final MatchGateway matchGateway;

    public FindMatchByIdUseCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public Match execute(Long id) {
        log.info("Finding match with ID: {}", id);
        try {
            Match found = matchGateway.findByMatchId(id);
            log.info("Match found: {}", found);
            return found;
        } catch (Exception e) {
            log.error("Error while trying to find match. Error: {}", e.getMessage());
            throw e;
        }
    }
}
