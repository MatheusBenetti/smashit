package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.gateway.court.CourtGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateCourtUseCaseImpl implements UpdateCourtUseCase {

    private static final Logger log = LoggerFactory.getLogger(UpdateCourtUseCaseImpl.class);

    private final CourtGateway courtGateway;

    public UpdateCourtUseCaseImpl(CourtGateway courtGateway) {
        this.courtGateway = courtGateway;
    }

    @Override
    public Court execute(Long id, Court court) {
        log.info("Updating court: {}", id);
        try {
            Court updatedCourt = courtGateway.updateCourt(id, court);
            log.info("Court updated successfully: {}", updatedCourt);
            return updatedCourt;
        } catch (Exception e) {
            log.error("Error while updating court ID: {}, error: {}", id, e.getMessage());
            throw e;
        }
    }
}
