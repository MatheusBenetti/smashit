package com.totex.smashit.infra.gateway.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.gateway.court.CourtGateway;
import com.totex.smashit.infra.mapper.court.CourtEntityMapper;
import com.totex.smashit.infra.persistence.court.CourtEntity;
import com.totex.smashit.infra.persistence.court.CourtRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourtRepositoryGateway implements CourtGateway {

    private final CourtRepository courtRepository;
    private final CourtEntityMapper courtEntityMapper;

    public CourtRepositoryGateway(CourtRepository courtRepository, CourtEntityMapper courtEntityMapper) {
        this.courtRepository = courtRepository;
        this.courtEntityMapper = courtEntityMapper;
    }

    @Override
    public Court createCourt(Court court) {
        CourtEntity entity = courtEntityMapper.toEntity(court);
        CourtEntity newCourt = courtRepository.save(entity);
        return courtEntityMapper.toDomain(newCourt);
    }

    @Override
    public List<Court> findCourts() {
        return courtRepository.findAll().stream().map(courtEntityMapper::toDomain).toList();
    }
}
