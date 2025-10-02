package com.totex.smashit.infra.dto;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.enums.PlayerRole;

public record MatchPlayerDto(
        Long id,
        Match match,
        Player player,
        PlayerRole playerRole
) {}
