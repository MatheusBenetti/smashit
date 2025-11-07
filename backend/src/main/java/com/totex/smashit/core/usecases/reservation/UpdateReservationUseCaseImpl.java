package com.totex.smashit.core.usecases.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;

import com.totex.smashit.core.gateway.reservation.ReservationGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateReservationUseCaseImpl implements UpdateReservationUseCase {

    private static final Logger log = LoggerFactory.getLogger(UpdateReservationUseCaseImpl.class);

    private final ReservationGateway reservationGateway;

    public UpdateReservationUseCaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Reservation execute(Reservation reservation) {
        log.info("Updating reservation: {}", reservation.id());
        try {
            Reservation updatedReservation = reservationGateway.updateReservation(reservation);
            log.info("Reservation updated successfully: {}", updatedReservation);
            return updatedReservation;
        } catch (Exception e) {
            log.error("Error while updating reservation ID: {}, error: {}", reservation.id(), e.getMessage());
            throw e;
        }
    }
}
