package com.totex.smashit.infra.presentation.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.usecases.court.CreateCourtUseCase;
import com.totex.smashit.infra.dto.CourtDto;
import com.totex.smashit.infra.mapper.court.CourtMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class CourtController {

    private final CreateCourtUseCase createCourtUseCase;
    private final CourtMapper courtMapper;

    public CourtController(CreateCourtUseCase createCourtUseCase, CourtMapper courtMapper) {
        this.createCourtUseCase = createCourtUseCase;
        this.courtMapper = courtMapper;
    }

    public ResponseEntity<Map<String, Object>> createCourt(CourtDto courtDto) {
        Court newCourt = createCourtUseCase.execute(courtMapper.toDomain(courtDto));
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "Court created successfully!");
        response.put("Court data: ", courtMapper.toDto(newCourt));
        return ResponseEntity.ok(response);
    }
}
