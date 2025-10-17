package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.gateway.match.MatchGateway;

import java.util.List;

public class FindMatchUseCaseImpl implements FindMatchUseCase {

    private final MatchGateway matchGateway;

    public FindMatchUseCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public List<Match> execute() {
        return matchGateway.findMatch();
    }
}
