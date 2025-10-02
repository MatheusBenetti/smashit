package com.totex.smashit.core.usecases.match_player;

import com.totex.smashit.core.entities.match_player.MatchPlayer;
import com.totex.smashit.core.gateway.match_player.MatchPlayerGateway;

public class CreateMatchPlayerUseCaseImpl implements CreateMatchPlayerUseCase {

    private final MatchPlayerGateway matchPlayerGateway;

    public CreateMatchPlayerUseCaseImpl(MatchPlayerGateway matchPlayerGateway) {
        this.matchPlayerGateway = matchPlayerGateway;
    }

    @Override
    public MatchPlayer execute(MatchPlayer matchPlayer) {
        return matchPlayerGateway.createMatchPlayer(matchPlayer);
    }
}
