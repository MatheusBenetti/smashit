package com.totex.smashit.core.gateway.court;

import com.totex.smashit.core.entities.court.Court;

import java.util.List;
import java.util.Optional;

public interface CourtGateway {

    Court createCourt(Court court);
    List<Court> findCourts();
    Court updateCourt(Long id, Court court);
    Court findCourtById(Long id);
    Optional<Court> findCourtByName(String name);
    boolean existsByName(String name);
}
