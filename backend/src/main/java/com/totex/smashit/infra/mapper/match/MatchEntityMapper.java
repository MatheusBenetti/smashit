package com.totex.smashit.infra.mapper.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.infra.mapper.court.CourtEntityMapper;
import com.totex.smashit.infra.mapper.player.PlayerEntityMapper;
import com.totex.smashit.infra.persistence.match.MatchEntity;
import org.springframework.stereotype.Component;

@Component
public class MatchEntityMapper {

    private final CourtEntityMapper courtEntityMapper;
    private final PlayerEntityMapper playerEntityMapper;

    public MatchEntityMapper(CourtEntityMapper courtEntityMapper, PlayerEntityMapper playerEntityMapper) {
        this.courtEntityMapper = courtEntityMapper;
        this.playerEntityMapper = playerEntityMapper;
    }

    public MatchEntity toEntity(Match match) {
        return new MatchEntity(
                match.id(),
                match.date(),
                match.hour(),
                courtEntityMapper.toEntity(match.courtId()),
                match.players().stream().map(playerEntityMapper::toEntity).toList(),
                match.matchStatus(),
                match.matchType()
        );
    }

    public Match toDomain(MatchEntity matchEntity) {
        return new Match(
                matchEntity.getId(),
                matchEntity.getDate(),
                matchEntity.getHour(),
                courtEntityMapper.toDomain(matchEntity.getCourtId()),
                matchEntity.getPlayers().stream().map(playerEntityMapper::toDomain).toList(),
                matchEntity.getMatchStatus(),
                matchEntity.getMatchType()
        );
    }
}
