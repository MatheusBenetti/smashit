package com.totex.smashit.infra.persistence.match;

import com.totex.smashit.core.entities.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
