package com.totex.smashit.core.usecases.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;

public interface UpdateReservationUseCase {

    public Reservation execute(Reservation reservation);
}
