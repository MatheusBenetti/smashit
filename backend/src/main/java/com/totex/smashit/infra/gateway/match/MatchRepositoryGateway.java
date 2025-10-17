package com.totex.smashit.infra.gateway.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.gateway.match.MatchGateway;
import com.totex.smashit.infra.mapper.match.MatchEntityMapper;
import com.totex.smashit.infra.persistence.match.MatchEntity;
import com.totex.smashit.infra.persistence.match.MatchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchRepositoryGateway implements MatchGateway {

    private final MatchRepository matchRepository;
    private final MatchEntityMapper matchEntityMapper;

    public MatchRepositoryGateway(MatchRepository matchRepository, MatchEntityMapper matchEntityMapper) {
        this.matchRepository = matchRepository;
        this.matchEntityMapper = matchEntityMapper;
    }

    @Override
    public Match createMatch(Match match) {
        MatchEntity entity = matchEntityMapper.toEntity(match);
        MatchEntity newMatch = matchRepository.save(entity);
        return matchEntityMapper.toDomain(newMatch);
    }

    @Override
    public List<Match> findMatch() {
        return matchRepository.findAll().stream().map(matchEntityMapper::toDomain).toList();
    }
}
