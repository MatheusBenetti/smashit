package com.totex.smashit.infra.persistence.player;

import com.totex.smashit.core.entities.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    Optional<Player> findByNameIgnoreCase(String name);
}
