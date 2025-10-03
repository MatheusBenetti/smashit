package com.totex.smashit.infra.mapper.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.infra.mapper.court.CourtEntityMapper;
import com.totex.smashit.infra.mapper.player.PlayerEntityMapper;
import com.totex.smashit.infra.persistence.reservation.ReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservationEntityMapper {

    private final CourtEntityMapper courtEntityMapper;
    private final PlayerEntityMapper playerEntityMapper;

    public ReservationEntityMapper(CourtEntityMapper courtEntityMapper, PlayerEntityMapper playerEntityMapper) {
        this.courtEntityMapper = courtEntityMapper;
        this.playerEntityMapper = playerEntityMapper;
    }

    public ReservationEntity toEntity(Reservation reservation) {
        return new ReservationEntity(
                reservation.id(),
                courtEntityMapper.toEntity(reservation.court()),
                playerEntityMapper.toEntity(reservation.reservedBy()),
                reservation.date(),
                reservation.startTime(),
                reservation.endTime(),
                reservation.reservationStatus()
        );
    }

    public Reservation toDomain(ReservationEntity reservationEntity) {
        return new Reservation(
                reservationEntity.getId(),
                courtEntityMapper.toDomain(reservationEntity.getCourt()),
                playerEntityMapper.toDomain(reservationEntity.getReservedBy()),
                reservationEntity.getDate(),
                reservationEntity.getStartTime(),
                reservationEntity.getEndTime(),
                reservationEntity.getStatus()
        );
    }
}
