package com.totex.smashit.core.entities.match;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.enums.MatchStatus;
import com.totex.smashit.core.enums.MatchType;

import java.time.LocalDate;
import java.time.LocalTime;

public record Match(
        Long id,
        LocalDate date,
        LocalTime hour,
        Court courtId,
        MatchStatus matchStatus,
        MatchType matchType
) {}
