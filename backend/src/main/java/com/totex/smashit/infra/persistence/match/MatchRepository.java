package com.totex.smashit.infra.persistence.match;

import com.totex.smashit.core.enums.CourtType;
import com.totex.smashit.core.enums.MatchStatus;
import com.totex.smashit.core.enums.PlayerLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    boolean existsByMatchStatus(MatchStatus matchStatus);

    List<MatchEntity> findByMatchStatus(MatchStatus matchStatus);

    List<MatchEntity> findByPlayerLevel(PlayerLevel playerLevel);

    List<MatchEntity> findByCourtSurface(CourtType courtType);
}
