package com.totex.smashit.infra.presentation.court;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.usecases.court.CreateCourtUseCase;
import com.totex.smashit.core.usecases.court.FindCourtUseCase;
import com.totex.smashit.core.usecases.court.UpdateCourtUseCase;
import com.totex.smashit.infra.dto.court.CourtDto;
import com.totex.smashit.infra.dto.court.UpdateCourtRequest;
import com.totex.smashit.infra.mapper.court.CourtMapper;
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
public class CourtController {

    private static final Logger log = LoggerFactory.getLogger(CourtController.class);

    private final CreateCourtUseCase createCourtUseCase;
    private final FindCourtUseCase findCourtUseCase;
    private final UpdateCourtUseCase updateCourtUseCase;
    private final CourtMapper courtMapper;

    public CourtController(CreateCourtUseCase createCourtUseCase,
                           FindCourtUseCase findCourtUseCase,
                           UpdateCourtUseCase updateCourtUseCase,
                           CourtMapper courtMapper) {
        this.createCourtUseCase = createCourtUseCase;
        this.findCourtUseCase = findCourtUseCase;
        this.updateCourtUseCase = updateCourtUseCase;
        this.courtMapper = courtMapper;
    }

    @PostMapping("create-court")
    public ResponseEntity<Map<String, Object>> createCourt(@RequestBody CourtDto courtDto) {
        log.info("Creating court: {}", courtDto);
        try {
            Court newCourt = createCourtUseCase.execute(courtMapper.toDomain(courtDto));
            Map<String, Object> response = new HashMap<>();

            response.put("Message: ", "Court created successfully!");
            response.put("Court data: ", courtMapper.toDto(newCourt));
            log.info("Court created successfully: {}", newCourt.id());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error while creating court", e);;
            throw e;
        }
    }

    @GetMapping("find-courts")
    public List<CourtDto> findCourts() {
        return findCourtUseCase.execute().stream().map(courtMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping("update-court/{id}")
    public ResponseEntity<Map<String, Object>> updateCourt(@PathVariable Long id, @RequestBody UpdateCourtRequest updateCourtRequest) {
        log.info("Received request to update court with ID: {}", id);
        try {
            Court updatedCourt = updateCourtUseCase.execute(id, courtMapper.entityToDomain(updateCourtRequest));

            Map<String, Object> response = new HashMap<>();
            response.put("Message: ", "Court updated successfully!");
            response.put("Court: ", courtMapper.toDto(updatedCourt));

            log.info("Court with ID {} updated successfully", id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error updating court with ID: {}. Error: {}", id, e.getMessage());
            throw e;
        }
    }
}
