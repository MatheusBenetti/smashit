package com.totex.smashit.infra.persistence.match_player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchPlayerRepository extends JpaRepository<MatchPlayerEntity, Long> {
}
