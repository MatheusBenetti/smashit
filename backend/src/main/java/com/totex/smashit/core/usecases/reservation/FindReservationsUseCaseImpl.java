package com.totex.smashit.core.usecases.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.core.gateway.reservation.ReservationGateway;

import java.util.List;

public class FindReservationsUseCaseImpl implements FindReservationsUseCase {

    private final ReservationGateway reservationGateway;

    public FindReservationsUseCaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public List<Reservation> execute() {
        return reservationGateway.findReservations();
    }
}
