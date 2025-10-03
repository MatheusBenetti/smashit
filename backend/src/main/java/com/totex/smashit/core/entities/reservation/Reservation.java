package com.totex.smashit.core.entities.reservation;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.enums.ReservationStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record Reservation(
        Long id,
        Court court,
        Player reservedBy,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        ReservationStatus reservationStatus
) {}
