package com.totex.smashit.core.usecases.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.core.gateway.reservation.ReservationGateway;

public class CreateReservationUseCaseImpl implements CreateReservationUseCase {

    private final ReservationGateway reservationGateway;

    public CreateReservationUseCaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Reservation execute(Reservation reservation) {
        return reservationGateway.createReservation(reservation);
    }
}
