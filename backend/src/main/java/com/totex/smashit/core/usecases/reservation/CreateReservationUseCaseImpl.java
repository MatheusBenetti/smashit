package com.totex.smashit.core.usecases.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.core.gateway.reservation.ReservationGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateReservationUseCaseImpl implements CreateReservationUseCase {

    private static final Logger log = LoggerFactory.getLogger(CreateReservationUseCaseImpl.class);

    private final ReservationGateway reservationGateway;

    public CreateReservationUseCaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Reservation execute(Reservation reservation) {
        log.info("Creating reservation for player {} on court {}", reservation.reservedBy(), reservation.court());
        try {
            Reservation created = reservationGateway.createReservation(reservation);
            log.info("Reservation {} created successfully", created.id());
            return created;
        } catch (Exception e) {
            log.error("Failed to create reservation for player {}: {}", reservation.reservedBy(), e.getMessage(), e);
            throw e;
        }
    }
}
