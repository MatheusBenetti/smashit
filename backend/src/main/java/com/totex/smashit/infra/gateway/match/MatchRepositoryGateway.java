package com.totex.smashit.infra.gateway.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.gateway.match.MatchGateway;
import com.totex.smashit.infra.exceptions.ResourceNotFoundException;
import com.totex.smashit.infra.mapper.match.MatchEntityMapper;
import com.totex.smashit.infra.persistence.court.CourtEntity;
import com.totex.smashit.infra.persistence.court.CourtRepository;
import com.totex.smashit.infra.persistence.match.MatchEntity;
import com.totex.smashit.infra.persistence.match.MatchRepository;
import com.totex.smashit.infra.persistence.player.PlayerEntity;
import com.totex.smashit.infra.persistence.player.PlayerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchRepositoryGateway implements MatchGateway {

    private final MatchRepository matchRepository;
    private final CourtRepository courtRepository;
    private final PlayerRepository playerRepository;
    private final MatchEntityMapper matchEntityMapper;

    public MatchRepositoryGateway(MatchRepository matchRepository,
                                  CourtRepository courtRepository,
                                  PlayerRepository playerRepository,
                                  MatchEntityMapper matchEntityMapper) {
        this.matchRepository = matchRepository;
        this.courtRepository = courtRepository;
        this.playerRepository = playerRepository;
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

    @Override
    public Match updateMatch(Long id, Match match, Long courtId, List<Long> playerIds) {
        MatchEntity existing = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Court not found with ID: " + id));

        CourtEntity courtEntity = courtRepository.findById(courtId)
                .orElseThrow(() -> new ResourceNotFoundException("Court not found with ID: " + courtId));

        List<PlayerEntity> players = playerRepository.findAllById(playerIds);
        if (players.size() != playerIds.size()) {
            throw new ResourceNotFoundException("One or more players not found");
        }

        existing.setDate(match.date());
        existing.setHour(match.hour());
        existing.setCourtId(courtEntity);
        existing.setPlayers(players);
        existing.setMatchStatus(match.matchStatus());
        existing.setMatchType(match.matchType());

        MatchEntity updated = matchRepository.save(existing);
        return matchEntityMapper.toDomain(updated);
    }

    @Override
    public Match findByMatchId(Long id) {
        MatchEntity existing = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with ID: " + id));

        return matchEntityMapper.toDomain(existing);
    }
}
