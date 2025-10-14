package com.totex.smashit.infra.presentation.match_player;

import com.totex.smashit.core.entities.match_player.MatchPlayer;
import com.totex.smashit.core.usecases.match_player.CreateMatchPlayerUseCase;
import com.totex.smashit.infra.dto.MatchPlayerDto;
import com.totex.smashit.infra.mapper.match_player.MatchPlayerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class MatchPlayerController {

    private final CreateMatchPlayerUseCase createMatchPlayerUseCase;
    private final MatchPlayerMapper matchPlayerMapper;

    public MatchPlayerController(CreateMatchPlayerUseCase createMatchPlayerUseCase, MatchPlayerMapper matchPlayerMapper) {
        this.createMatchPlayerUseCase = createMatchPlayerUseCase;
        this.matchPlayerMapper = matchPlayerMapper;
    }

    @PostMapping("create-match-player")
    public ResponseEntity<Map<String, Object>> createMatchPlayer(@RequestBody MatchPlayerDto matchPlayerDto) {
        MatchPlayer newMatchPlayer = createMatchPlayerUseCase.execute(matchPlayerMapper.toDomain(matchPlayerDto));
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "Match player created successfully!");
        response.put("Match player data: ", matchPlayerMapper.toDto(newMatchPlayer));
        return ResponseEntity.ok(response);
    }
}
