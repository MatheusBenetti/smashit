package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;

public interface FindCourtByIdUseCase {

    public Court execute(Long id);
}
