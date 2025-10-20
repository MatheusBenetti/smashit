package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.gateway.court.CourtGateway;

import java.util.List;

public class FindCourtUseCaseImpl implements FindCourtUseCase {

    private final CourtGateway courtGateway;

    public FindCourtUseCaseImpl(CourtGateway courtGateway) {
        this.courtGateway = courtGateway;
    }

    @Override
    public List<Court> execute() {
        return courtGateway.findCourts();
    }
}
