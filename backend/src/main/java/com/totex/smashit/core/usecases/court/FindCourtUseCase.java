package com.totex.smashit.core.usecases.court;

import com.totex.smashit.core.entities.court.Court;

import java.util.List;

public interface FindCourtUseCase {

    public List<Court> execute();
}
