package com.totex.smashit.infra.dto.court;

import com.totex.smashit.core.enums.CourtType;

public record UpdateCourtRequest(
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
