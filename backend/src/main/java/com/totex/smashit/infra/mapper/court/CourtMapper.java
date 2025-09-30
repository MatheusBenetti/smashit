package com.totex.smashit.infra.mapper.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.infra.dto.CourtDto;
import org.springframework.stereotype.Component;

@Component
public class CourtMapper {

    public CourtDto toDto(Court court) {
        return new CourtDto(
                court.id(),
                court.name(),
                court.courtType(),
                court.address(),
                court.city(),
                court.state(),
                court.club()
        );
    }

    public Court toDomain(CourtDto courtDto) {
        return new Court(
                courtDto.id(),
                courtDto.name(),
                courtDto.courtType(),
                courtDto.address(),
                courtDto.city(),
                courtDto.state(),
                courtDto.club()
        );
    }
}
