package com.totex.smashit.core.entities.match;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.enums.MatchStatus;
import com.totex.smashit.core.enums.MatchType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record Match(
        Long id,
        LocalDate date,
        LocalTime hour,
        Court courtId,
        List<Player> players,
        MatchStatus matchStatus,
        MatchType matchType
) {}
