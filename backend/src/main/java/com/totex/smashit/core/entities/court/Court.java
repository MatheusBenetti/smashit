package com.totex.smashit.core.entities.court;

import com.totex.smashit.core.enums.CourtType;

public record Court(
        Long id,
        String name,
        CourtType courtType
) {}
