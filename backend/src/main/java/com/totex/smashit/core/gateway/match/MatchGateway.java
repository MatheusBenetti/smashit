package com.totex.smashit.core.gateway.match;

import com.totex.smashit.core.entities.match.Match;

import java.util.List;

public interface MatchGateway {

    Match createMatch(Match match);
    List<Match> findMatch();
}
