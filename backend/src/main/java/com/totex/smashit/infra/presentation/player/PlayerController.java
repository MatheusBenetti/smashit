package com.totex.smashit.infra.presentation.player;

import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.usecases.player.CreatePlayerUseCase;
import com.totex.smashit.core.usecases.player.FindPlayerByIdUseCase;
import com.totex.smashit.core.usecases.player.FindPlayerUseCase;
import com.totex.smashit.core.usecases.player.UpdatePlayerUseCase;
import com.totex.smashit.infra.dto.player.PlayerDto;
import com.totex.smashit.infra.dto.player.UpdatePlayerRequest;
import com.totex.smashit.infra.mapper.player.PlayerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/")
public class PlayerController {

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    private final CreatePlayerUseCase createPlayerUseCase;
    private final FindPlayerUseCase findPlayerUseCase;
    private final FindPlayerByIdUseCase findPlayerByIdUseCase;
    private final UpdatePlayerUseCase updatePlayerUseCase;
    private final PlayerMapper playerMapper;

    public PlayerController(CreatePlayerUseCase createPlayerUseCase,
                            FindPlayerUseCase findPlayerUseCase,
                            FindPlayerByIdUseCase findPlayerByIdUseCase,
                            UpdatePlayerUseCase updatePlayerUseCase,
                            PlayerMapper playerMapper) {
        this.createPlayerUseCase = createPlayerUseCase;
        this.findPlayerUseCase = findPlayerUseCase;
        this.findPlayerByIdUseCase = findPlayerByIdUseCase;
        this.updatePlayerUseCase = updatePlayerUseCase;
        this.playerMapper = playerMapper;
    }

    @PostMapping("create-player")
    public ResponseEntity<Map<String, Object>> createPlayer(@RequestBody PlayerDto playerDto) {
        log.info("Start creating new player: {}", playerDto);
        try {
            Player newPlayer = createPlayerUseCase.execute(playerMapper.toDomain(playerDto));
            Map<String, Object> response = new HashMap<>();

            response.put("Message: ", "Player added successfully!");
            response.put("Player data: ", playerMapper.toDto(newPlayer));
            log.info("Player created successfully: {}", newPlayer.id());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            log.error("Error while creating player", e);
            throw e;
        }
    }

    @GetMapping("find-players")
    public List<PlayerDto> findPlayers() {
        return findPlayerUseCase.execute().stream().map(playerMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("find-player/{id}")
    public ResponseEntity<PlayerDto> findPlayer(@PathVariable Long id) {
        log.info("Received find request to player with ID: {}", id);
        try {
            Player found = findPlayerByIdUseCase.execute(id);
            log.info("Player found: {}", found);
            return ResponseEntity.ok(playerMapper.toDto(found));
        } catch (Exception e) {
            log.error("Error while trying to find player! Error: {}", e.getMessage());
            throw e;
        }
    }

    @PutMapping("update-player/{id}")
    public ResponseEntity<Map<String, Object>> updatePlayer(@PathVariable Long id, @RequestBody UpdatePlayerRequest updatePlayerRequest) {
        log.info("Received request to update player with ID: {}", id);
        try {
            Player updatedPlayer = updatePlayerUseCase.execute(id, playerMapper.updateToDomain(updatePlayerRequest));

            Map<String, Object> response = new HashMap<>();

            response.put("Message: ", "Player updated successfully!");
            response.put("Player: ", playerMapper.toDto(updatedPlayer));

            log.info("Player with ID {} updated successfully", id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error updating player with ID: {}. Error: {}", id, e.getMessage());
            throw e;
        }
    }
}
