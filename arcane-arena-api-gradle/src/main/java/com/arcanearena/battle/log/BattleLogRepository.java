package com.arcanearena.battle.log;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleLogRepository
        extends JpaRepository<BattleLog, Long> {
}
