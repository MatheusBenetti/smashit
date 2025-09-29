package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.gateway.match.MatchGateway;

public class CreateMatchUseCaseImpl implements CreateMatchUseCase {

    private final MatchGateway matchGateway;

    public CreateMatchUseCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public Match execute(Match match) {
        return matchGateway.createMatch(match);
    }
}
