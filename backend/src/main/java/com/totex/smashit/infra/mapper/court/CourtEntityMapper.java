package com.totex.smashit.infra.mapper.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.infra.persistence.court.CourtEntity;
import org.springframework.stereotype.Component;

@Component
public class CourtEntityMapper {

    public CourtEntity toEntity(Court court) {

        return new CourtEntity(
                court.id(),
                court.name(),
                court.courtType(),
                court.address(),
                court.city(),
                court.state(),
                court.club()
        );

    }

    public Court toDomain(CourtEntity courtEntity) {
        return new Court(
                courtEntity.getId(),
                courtEntity.getName(),
                courtEntity.getCourtType(),
                courtEntity.getAddress(),
                courtEntity.getCity(),
                courtEntity.getState(),
                courtEntity.getClub()
        );
    }
}
