package com.totex.smashit.infra.persistence.match_player;

import com.totex.smashit.core.enums.PlayerRole;
import com.totex.smashit.infra.persistence.match.MatchEntity;
import com.totex.smashit.infra.persistence.player.PlayerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "match_players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchPlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private MatchEntity match;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerEntity player;

    @Enumerated(EnumType.STRING)
    private PlayerRole role;
}
