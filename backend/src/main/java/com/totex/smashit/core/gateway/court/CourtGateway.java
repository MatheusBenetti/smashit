package com.totex.smashit.core.gateway.court;

import com.totex.smashit.core.entities.court.Court;

import java.util.List;

public interface CourtGateway {

    Court createCourt(Court court);
    List<Court> findCourts();
}
