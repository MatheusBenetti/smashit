package com.totex.smashit.infra.mapper.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.infra.dto.player.PlayerDto;
import com.totex.smashit.infra.dto.player.UpdatePlayerRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlayerMapper {

    public PlayerDto toDto(Player player) {
        return new PlayerDto(
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
                player.wins() != null ? player.wins() : 0,
                player.losses() != null ? player.losses() : 0,
                player.winRate() != null ? player.winRate() : 0.0
        );
    }

    public Player toDomain(PlayerDto playerDto) {
        return new Player(
                playerDto.id(),
                playerDto.name(),
                playerDto.username(),
                playerDto.password(),
                playerDto.email(),
                playerDto.phone(),
                playerDto.playerLevel(),
                playerDto.city(),
                playerDto.state(),
                playerDto.country(),
                null,
                null,
                playerDto.wins(),
                playerDto.losses(),
                playerDto.winRate()
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
                LocalDateTime.now(),
                LocalDateTime.now(),
                updatePlayerRequest.wins(),
                updatePlayerRequest.losses(),
                updatePlayerRequest.winRate()
        );
    }
}
