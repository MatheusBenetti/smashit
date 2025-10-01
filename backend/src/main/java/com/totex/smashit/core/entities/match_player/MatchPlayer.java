package com.totex.smashit.core.entities.match_player;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.enums.PlayerRole;

public record MatchPlayer(
        Long id,
        Match match,
        Player player,
        PlayerRole playerRole
) {}
