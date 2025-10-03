package com.totex.smashit.infra.persistence.reservation;

import com.totex.smashit.core.enums.ReservationStatus;
import com.totex.smashit.infra.persistence.court.CourtEntity;
import com.totex.smashit.infra.persistence.player.PlayerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "court_id", nullable = false)
    private CourtEntity court;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerEntity reservedBy; // quem fez a reserva

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

}
