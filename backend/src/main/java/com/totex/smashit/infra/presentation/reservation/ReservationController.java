package com.totex.smashit.infra.presentation.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.core.usecases.reservation.CreateReservationUseCase;
import com.totex.smashit.infra.dto.ReservationDto;
import com.totex.smashit.infra.mapper.reservation.ReservationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class ReservationController {

    private final CreateReservationUseCase createReservationUseCase;
    private final ReservationMapper reservationMapper;

    public ReservationController(CreateReservationUseCase createReservationUseCase, ReservationMapper reservationMapper) {
        this.createReservationUseCase = createReservationUseCase;
        this.reservationMapper = reservationMapper;
    }

    public ResponseEntity<Map<String, Object>> createReservation(@RequestBody ReservationDto reservationDto) {
        Reservation newReservation = createReservationUseCase.execute(reservationMapper.toDomain(reservationDto));
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "Reservation created successfully!");
        response.put("Reservation data: ", reservationMapper.toDto(newReservation));
        return ResponseEntity.ok(response);
    }
}
