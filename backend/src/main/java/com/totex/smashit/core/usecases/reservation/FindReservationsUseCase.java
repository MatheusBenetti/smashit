package com.totex.smashit.core.usecases.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;

import java.util.List;

public interface FindReservationsUseCase {

    public List<Reservation> execute();
}
