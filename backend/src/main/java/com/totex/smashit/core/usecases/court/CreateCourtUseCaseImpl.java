package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.gateway.court.CourtGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCourtUseCaseImpl implements CreateCourtUseCase {

    private static final Logger log = LoggerFactory.getLogger(CreateCourtUseCaseImpl.class);

    private final CourtGateway courtGateway;

    public CreateCourtUseCaseImpl(CourtGateway courtGateway) {
        this.courtGateway = courtGateway;
    }

    @Override
    public Court execute(Court court) {
        log.info("Creating court: {}", court);
        try {
            Court created = courtGateway.createCourt(court);
            log.info("Court: {}, Address: {} created successfully!", court.name(), court.address());
            return created;
        } catch (Exception e) {
            log.error("Error while creating court: {}", e.getMessage());
            throw e;
        }
    }
}
