package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.gateway.court.CourtGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateCourtUseCaseImpl implements UpdateCourtUseCase {

    private static final Logger log = LoggerFactory.getLogger(UpdateCourtUseCaseImpl.class);

    private final CourtGateway courtGateway;

    public UpdateCourtUseCaseImpl(CourtGateway courtGateway) {
        this.courtGateway = courtGateway;
    }
}
