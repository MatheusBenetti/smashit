package com.totex.smashit.infra.mapper.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.infra.dto.PlayerDto;
import org.springframework.stereotype.Component;

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
}
