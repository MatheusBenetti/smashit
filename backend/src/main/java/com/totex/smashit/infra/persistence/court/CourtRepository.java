package com.totex.smashit.infra.persistence.court;

import com.totex.smashit.core.entities.court.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourtRepository extends JpaRepository<CourtEntity, Long> {
    Optional<Court> findByNameIgnoreCase(String name);
}
