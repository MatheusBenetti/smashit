package com.totex.smashit.infra.mapper.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.infra.dto.match.MatchDto;
import com.totex.smashit.infra.dto.match.UpdateMatchRequest;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public MatchDto toDto(Match match) {
        return new MatchDto(match.id(), match.date(), match.hour(), match.courtId(), match.players(), match.matchStatus(), match.matchType());
    }

    public Match toDomain(MatchDto matchDto) {
        return new Match(matchDto.id(), matchDto.date(), matchDto.hour(), matchDto.courtId(), matchDto.players(), matchDto.matchStatus(), matchDto.matchType());
    }

    public Match updateToDomain(UpdateMatchRequest updateMatchRequest) {
        return new Match(
                null,
                updateMatchRequest.date(),
                updateMatchRequest.hour(),
                null,
                null,
                updateMatchRequest.matchStatus(),
                updateMatchRequest.matchType()
        );
    }
}
