package com.totex.smashit.infra.presentation.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.usecases.court.CreateCourtUseCase;
import com.totex.smashit.core.usecases.court.FindCourtUseCase;
import com.totex.smashit.infra.dto.CourtDto;
import com.totex.smashit.infra.mapper.court.CourtMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class CourtController {

    private final CreateCourtUseCase createCourtUseCase;
    private final FindCourtUseCase findCourtUseCase;
    private final CourtMapper courtMapper;

    public CourtController(CreateCourtUseCase createCourtUseCase,
                           FindCourtUseCase findCourtUseCase,
                           CourtMapper courtMapper) {
        this.createCourtUseCase = createCourtUseCase;
        this.findCourtUseCase = findCourtUseCase;
        this.courtMapper = courtMapper;
    }

    @PostMapping("create-court")
    public ResponseEntity<Map<String, Object>> createCourt(CourtDto courtDto) {
        Court newCourt = createCourtUseCase.execute(courtMapper.toDomain(courtDto));
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "Court created successfully!");
        response.put("Court data: ", courtMapper.toDto(newCourt));
        return ResponseEntity.ok(response);
    }

    @GetMapping("find-courts")
    public List<CourtDto> findCourts() {
        return findCourtUseCase.execute().stream().map(courtMapper::toDto).collect(Collectors.toList());
    }
}
