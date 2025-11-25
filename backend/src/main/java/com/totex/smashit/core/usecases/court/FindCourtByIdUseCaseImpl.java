package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.gateway.court.CourtGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindCourtByIdUseCaseImpl implements FindCourtByIdUseCase {

    private static final Logger log = LoggerFactory.getLogger(FindCourtByIdUseCaseImpl.class);

    private final CourtGateway courtGateway;

    public FindCourtByIdUseCaseImpl(CourtGateway courtGateway) {
        this.courtGateway = courtGateway;
    }

    @Override
    public Court execute(Long id) {
        log.info("Finding court with ID: {}", id);
        try {
            Court found =  courtGateway.findCourtById(id);
            log.info("Court found: {}", found);
            return found;
        } catch (Exception e) {
            log.error("Error while trying to find court. Error: {}", e.getMessage());
            throw e;
        }
    }
}
