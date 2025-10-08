package com.totex.smashit.infra.presentation.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.usecases.match.CreateMatchUseCase;
import com.totex.smashit.infra.dto.MatchDto;
import com.totex.smashit.infra.mapper.match.MatchMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class MatchController {

    private final CreateMatchUseCase createMatchUseCase;
    private final MatchMapper matchMapper;

    public MatchController(CreateMatchUseCase createMatchUseCase, MatchMapper matchMapper) {
        this.createMatchUseCase = createMatchUseCase;
        this.matchMapper = matchMapper;
    }

    @PostMapping("create-match")
    public ResponseEntity<Map<String, Object>> createMatch(@RequestBody MatchDto matchDto) {
        Match newMatch = createMatchUseCase.execute(matchMapper.toDomain(matchDto));
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "Match created successfully!");
        response.put("Match data: ", matchMapper.toDto(newMatch));
        return ResponseEntity.ok(response);
    }
}
