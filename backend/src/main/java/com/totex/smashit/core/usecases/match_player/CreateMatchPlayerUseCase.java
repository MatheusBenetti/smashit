package com.totex.smashit.core.usecases.match_player;

import com.totex.smashit.core.entities.match_player.MatchPlayer;

public interface CreateMatchPlayerUseCase {

    public MatchPlayer execute(MatchPlayer matchPlayer);
}
