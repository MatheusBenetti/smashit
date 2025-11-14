package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;

import java.util.List;

public interface UpdateMatchUseCase {

    public Match execute(Long id, Match match, Long courtId, List<Long> playerIds);
}
