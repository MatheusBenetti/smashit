package com.totex.smashit.core.usecases.match;

import com.totex.smashit.core.entities.match.Match;

public interface FindMatchByIdUseCase {

    public Match execute(Long id);
}
