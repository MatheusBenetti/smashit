package com.totex.smashit.infra.mapper.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.infra.dto.player.UpdatePlayerRequest;
import com.totex.smashit.infra.persistence.player.PlayerEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlayerEntityMapper {

    public PlayerEntity toEntity(Player player) {
        return new PlayerEntity(
                player.id(),
                player.name(),
                player.username(),
                player.password(),
                player.email(),
                player.phone(),
                player.playerLevel(),
                player.city(),
                player.state(),
                player.country(),
                player.createdAt(),
                player.updatedAt(),
                player.wins() != null ? player.wins() : 0,
                player.losses() != null ? player.losses() : 0,
                player.winRate() != null ? player.winRate() : 0.0
        );
    }

    public Player toDomain(PlayerEntity playerEntity) {
        return new Player(
                playerEntity.getId(),
                playerEntity.getName(),
                playerEntity.getUsername(),
                playerEntity.getPassword(),
                playerEntity.getEmail(),
                playerEntity.getPhone(),
                playerEntity.getPlayerLevel(),
                playerEntity.getCity(),
                playerEntity.getState(),
                playerEntity.getCountry(),
                playerEntity.getCreatedAt(),
                playerEntity.getUpdatedAt(),
                playerEntity.getWins(),
                playerEntity.getLosses(),
                playerEntity.getWinRate()
        );
    }

    public Player updateToDomain(UpdatePlayerRequest updatePlayerRequest) {
        return new Player(
                null,
                updatePlayerRequest.name(),
                updatePlayerRequest.username(),
                null,
                updatePlayerRequest.email(),
                updatePlayerRequest.phone(),
                updatePlayerRequest.playerLevel(),
                updatePlayerRequest.city(),
                updatePlayerRequest.state(),
                updatePlayerRequest.country(),
                null,
                LocalDateTime.now(),
                updatePlayerRequest.wins(),
                updatePlayerRequest.losses(),
                updatePlayerRequest.winRate()
        );
    }
}
