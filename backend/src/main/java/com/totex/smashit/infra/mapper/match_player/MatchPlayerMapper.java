package com.totex.smashit.infra.mapper.match_player;

import com.totex.smashit.core.entities.match_player.MatchPlayer;
import com.totex.smashit.infra.dto.MatchPlayerDto;
import org.springframework.stereotype.Component;

@Component
public class MatchPlayerMapper {

    public MatchPlayerDto toDto(MatchPlayer matchPlayer) {
        return new MatchPlayerDto(matchPlayer.id(), matchPlayer.match(), matchPlayer.player(), matchPlayer.playerRole());
    }

    public MatchPlayer toDomain(MatchPlayerDto matchPlayerDto) {
        return new MatchPlayer(matchPlayerDto.id(), matchPlayerDto.match(), matchPlayerDto.player(), matchPlayerDto.playerRole());
    }
}
