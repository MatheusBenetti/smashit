package com.totex.smashit.infra.gateway.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.gateway.player.PlayerGateway;
import com.totex.smashit.infra.mapper.player.PlayerEntityMapper;
import com.totex.smashit.infra.persistence.player.PlayerEntity;
import com.totex.smashit.infra.persistence.player.PlayerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerRepositoryGateway implements PlayerGateway {

    private final PlayerRepository playerRepository;
    private final PlayerEntityMapper playerEntityMapper;

    public PlayerRepositoryGateway(PlayerRepository playerRepository, PlayerEntityMapper playerEntityMapper) {
        this.playerRepository = playerRepository;
        this.playerEntityMapper = playerEntityMapper;
    }

    @Override
    public Player createPlayer(Player player) {
        PlayerEntity entity = playerEntityMapper.toEntity(player);
        PlayerEntity newPlayer = playerRepository.save(entity);
        return playerEntityMapper.toDomain(newPlayer);
    }

    @Override
    public List<Player> findPlayer() {
        return playerRepository.findAll().stream().map(playerEntityMapper::toDomain).toList();
    }
}
