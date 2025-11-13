package com.totex.smashit.infra.dto.court;

import com.totex.smashit.core.enums.CourtType;

public record CourtDto(
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
