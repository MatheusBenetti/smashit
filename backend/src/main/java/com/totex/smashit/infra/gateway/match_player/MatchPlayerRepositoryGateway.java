package com.totex.smashit.infra.gateway.match_player;

import com.totex.smashit.core.entities.match_player.MatchPlayer;
import com.totex.smashit.core.gateway.match_player.MatchPlayerGateway;
import com.totex.smashit.infra.mapper.match_player.MatchPlayerEntityMapper;
import com.totex.smashit.infra.persistence.match_player.MatchPlayerEntity;
import com.totex.smashit.infra.persistence.match_player.MatchPlayerRepository;
import org.springframework.stereotype.Component;

@Component
public class MatchPlayerRepositoryGateway implements MatchPlayerGateway {

    private final MatchPlayerEntityMapper matchPlayerEntityMapper;
    private final MatchPlayerRepository matchPlayerRepository;

    public MatchPlayerRepositoryGateway(MatchPlayerEntityMapper matchPlayerEntityMapper, MatchPlayerRepository matchPlayerRepository) {
        this.matchPlayerEntityMapper = matchPlayerEntityMapper;
        this.matchPlayerRepository = matchPlayerRepository;
    }

    @Override
    public MatchPlayer createMatchPlayer(MatchPlayer matchPlayer) {
        MatchPlayerEntity entity = matchPlayerEntityMapper.toEntity(matchPlayer);
        MatchPlayerEntity newMatchPlayer = matchPlayerRepository.save(entity);
        return matchPlayerEntityMapper.toDomain(newMatchPlayer);
    }
}
