package com.totex.smashit.infra.gateway.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.gateway.court.CourtGateway;
import com.totex.smashit.infra.exceptions.ResourceNotFoundException;
import com.totex.smashit.infra.mapper.court.CourtEntityMapper;
import com.totex.smashit.infra.persistence.court.CourtEntity;
import com.totex.smashit.infra.persistence.court.CourtRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Court updateCourt(Long id, Court court) {
        CourtEntity existing = courtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Court not found with id: " + id));

        existing.setName(court.name());
        existing.setCourtType(court.courtType());
        existing.setAddress(court.address());
        existing.setCity(court.city());
        existing.setState(court.state());
        existing.setClub(court.club());

        CourtEntity updated = courtRepository.save(existing);
        return courtEntityMapper.toDomain(updated);
    }

    @Override
    public Court findCourtById(Long id) {
        CourtEntity existing = courtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Court not found with id: " + id));

        return courtEntityMapper.toDomain(existing);
    }

    @Override
    public Optional<Court> findCourtByName(String name) {
        return courtRepository.findByNameIgnoreCase(name);
    }

    @Override
    public boolean existsByName(String name) {
        return courtRepository.findAll().stream().anyMatch(n -> n.getName().equalsIgnoreCase(name));
    }
}
