package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;

public interface UpdateCourtUseCase {

    public Court execute(Long id, Court court);
}
