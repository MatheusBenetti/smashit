package com.totex.smashit.core.entities.court;

import com.totex.smashit.core.enums.CourtType;

public record Court(
        Long id,
        String name,
        CourtType courtType,
        String address,
        String city,
        String state,
        String club
        // double long
        // double lat
) {}
