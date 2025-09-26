package com.totex.smashit.infra.persistence.match;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.enums.MatchStatus;
import com.totex.smashit.core.enums.MatchType;
import com.totex.smashit.infra.persistence.court.CourtEntity;
import com.totex.smashit.infra.persistence.player.PlayerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "match")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime hour;

    @ManyToOne
    @JoinColumn(name = "court_id", nullable = false)
    private CourtEntity courtId;

    @ManyToMany
    @JoinTable(
            name = "match_players",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<PlayerEntity> players;

    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;

    @Enumerated(EnumType.STRING)
    private MatchType matchType;
}
