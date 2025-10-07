package com.totex.smashit.infra.gateway.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.core.gateway.reservation.ReservationGateway;
import com.totex.smashit.infra.mapper.reservation.ReservationEntityMapper;
import com.totex.smashit.infra.persistence.reservation.ReservationEntity;
import com.totex.smashit.infra.persistence.reservation.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationRepositoryGateway implements ReservationGateway {

    private final ReservationRepository reservationRepository;
    private final ReservationEntityMapper reservationEntityMapper;

    public ReservationRepositoryGateway(ReservationRepository reservationRepository, ReservationEntityMapper reservationEntityMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationEntityMapper = reservationEntityMapper;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        ReservationEntity entity = reservationEntityMapper.toEntity(reservation);
        ReservationEntity newReservation = reservationRepository.save(entity);
        return reservationEntityMapper.toDomain(newReservation);
    }
}
