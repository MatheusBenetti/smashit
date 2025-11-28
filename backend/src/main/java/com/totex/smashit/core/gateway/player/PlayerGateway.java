package com.totex.smashit.core.gateway.player;

import com.totex.smashit.core.entities.player.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerGateway {

    Player createPlayer(Player player);
    List<Player> findPlayer();
    Player updatePlayer(Long id, Player player);
    Player findById(Long id);
    Optional<Player> findByName(String name);
    boolean existsByName(String name);
}
