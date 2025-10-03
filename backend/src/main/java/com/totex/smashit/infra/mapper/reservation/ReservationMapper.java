package com.totex.smashit.infra.mapper.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.infra.dto.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public ReservationDto toDto(Reservation reservation) {
        return new ReservationDto(
                reservation.id(),
                reservation.court(),
                reservation.reservedBy(),
                reservation.date(),
                reservation.startTime(),
                reservation.endTime(),
                reservation.reservationStatus()
        );
    }

    public Reservation toDomain(ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.id(),
                reservationDto.court(),
                reservationDto.reservedBy(),
                reservationDto.date(),
                reservationDto.startTime(),
                reservationDto.endTime(),
                reservationDto.reservationStatus()
        );
    }
}
