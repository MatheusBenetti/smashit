package com.totex.smashit.infra.mapper.match_player;

import com.totex.smashit.core.entities.match_player.MatchPlayer;
import com.totex.smashit.infra.mapper.match.MatchEntityMapper;
import com.totex.smashit.infra.mapper.player.PlayerEntityMapper;
import com.totex.smashit.infra.persistence.match_player.MatchPlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class MatchPlayerEntityMapper {

    private final MatchEntityMapper matchEntityMapper;
    private final PlayerEntityMapper playerEntityMapper;

    public MatchPlayerEntityMapper(MatchEntityMapper matchEntityMapper, PlayerEntityMapper playerEntityMapper) {
        this.matchEntityMapper = matchEntityMapper;
        this.playerEntityMapper = playerEntityMapper;
    }

    public MatchPlayerEntity toEntity(MatchPlayer matchPlayer) {
        return new MatchPlayerEntity(
                matchPlayer.id(),
                matchEntityMapper.toEntity(matchPlayer.match()),
                playerEntityMapper.toEntity(matchPlayer.player()),
                matchPlayer.playerRole()
        );
    }

    public MatchPlayer toDomain(MatchPlayerEntity matchPlayer) {
        return new MatchPlayer(
                matchPlayer.getId(),
                matchEntityMapper.toDomain(matchPlayer.getMatch()),
                playerEntityMapper.toDomain(matchPlayer.getPlayer()),
                matchPlayer.getRole()
        );
    }
}
