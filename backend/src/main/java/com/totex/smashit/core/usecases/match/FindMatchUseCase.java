package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;

import java.util.List;

public interface FindMatchUseCase {

    public List<Match> execute();
}
