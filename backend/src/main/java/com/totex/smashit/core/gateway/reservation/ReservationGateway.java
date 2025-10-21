package com.totex.smashit.core.gateway.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;

import java.util.List;

public interface ReservationGateway {

    public Reservation createReservation(Reservation reservation);
    public List<Reservation> findReservations();
}
