package com.totex.smashit.infra.presentation.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.usecases.player.CreatePlayerUseCase;
import com.totex.smashit.infra.dto.PlayerDto;
import com.totex.smashit.infra.mapper.player.PlayerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class PlayerController {

    private final CreatePlayerUseCase createPlayerUseCase;
    private final PlayerMapper playerMapper;

    public PlayerController(CreatePlayerUseCase createPlayerUseCase, PlayerMapper playerMapper) {
        this.createPlayerUseCase = createPlayerUseCase;
        this.playerMapper = playerMapper;
    }

    @PostMapping("create-player")
    public ResponseEntity<Map<String, Object>> createPlayer(@RequestBody PlayerDto playerDto) {
        Player newPlayer = createPlayerUseCase.execute(playerMapper.toDomain(playerDto));
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "Player added successfully!");
        response.put("Player data: ", playerMapper.toDto(newPlayer));
        return ResponseEntity.ok(response);
    }
}
