package com.totex.smashit.infra.presentation.match;

import com.totex.smashit.core.entities.match.Match;
import com.totex.smashit.core.usecases.match.CreateMatchUseCase;
import com.totex.smashit.core.usecases.match.FindMatchUseCase;
import com.totex.smashit.infra.dto.MatchDto;
import com.totex.smashit.infra.mapper.match.MatchMapper;
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
public class MatchController {

    private static final Logger log = LoggerFactory.getLogger(MatchController.class);

    private final CreateMatchUseCase createMatchUseCase;
    private final FindMatchUseCase findMatchUseCase;
    private final MatchMapper matchMapper;

    public MatchController(CreateMatchUseCase createMatchUseCase,
                           FindMatchUseCase findMatchUseCase,
                           MatchMapper matchMapper) {
        this.createMatchUseCase = createMatchUseCase;
        this.findMatchUseCase = findMatchUseCase;
        this.matchMapper = matchMapper;
    }

    @PostMapping("create-match")
    public ResponseEntity<Map<String, Object>> createMatch(@RequestBody MatchDto matchDto) {
        log.info("Creating tennis match: {}", matchDto);
        try {
            Match newMatch = createMatchUseCase.execute(matchMapper.toDomain(matchDto));
            Map<String, Object> response = new HashMap<>();

            response.put("Message: ", "Match created successfully!");
            response.put("Match data: ", matchMapper.toDto(newMatch));
            log.info("Match created successfully: {}", newMatch.id());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error occurred while creating match: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("find-matches")
    public List<MatchDto> findGames() {
        return findMatchUseCase.execute().stream().map(matchMapper::toDto).collect(Collectors.toList());
    }
}
