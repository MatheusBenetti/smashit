package com.totex.smashit.infra.presentation.reservation;

import com.totex.smashit.core.entities.reservation.Reservation;
import com.totex.smashit.core.usecases.reservation.CreateReservationUseCase;
import com.totex.smashit.core.usecases.reservation.FindReservationsUseCase;
import com.totex.smashit.infra.dto.ReservationDto;
import com.totex.smashit.infra.mapper.reservation.ReservationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/")
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    private final CreateReservationUseCase createReservationUseCase;
    private final FindReservationsUseCase findReservationsUseCase;
    private final ReservationMapper reservationMapper;

    public ReservationController(CreateReservationUseCase createReservationUseCase,
                                 FindReservationsUseCase findReservationsUseCase,
                                 ReservationMapper reservationMapper) {
        this.createReservationUseCase = createReservationUseCase;
        this.findReservationsUseCase = findReservationsUseCase;
        this.reservationMapper = reservationMapper;
    }

    @PostMapping("create-reservation")
    public ResponseEntity<Map<String, Object>> createReservation(@RequestBody ReservationDto reservationDto) {
        log.info("Start creating new reservation: {}", reservationDto);
        try {
            Reservation newReservation = createReservationUseCase.execute(reservationMapper.toDomain(reservationDto));
            Map<String, Object> response = new HashMap<>();

            response.put("Message: ", "Reservation created successfully!");
            response.put("Reservation data: ", reservationMapper.toDto(newReservation));
            log.info("Reservation created successfully! {}", newReservation.id());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error while creating match", e);
            throw e;
        }
    }

    @GetMapping("find-reservations")
    public List<ReservationDto> findReservations() {
        return findReservationsUseCase.execute().stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }
}
