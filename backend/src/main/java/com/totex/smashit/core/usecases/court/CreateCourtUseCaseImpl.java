package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.gateway.court.CourtGateway;

public class CreateCourtUseCaseImpl implements CreateCourtUseCase {

    private final CourtGateway courtGateway;

    public CreateCourtUseCaseImpl(CourtGateway courtGateway) {
        this.courtGateway = courtGateway;
    }

    @Override
    public Court execute(Court court) {
        return courtGateway.createCourt(court);
    }
}
