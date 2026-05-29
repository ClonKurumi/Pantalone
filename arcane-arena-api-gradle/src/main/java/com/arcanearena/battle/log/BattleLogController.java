package com.arcanearena.battle.log;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/battle-logs")
public class BattleLogController {

    private final BattleLogRepository battleLogRepository;

    public BattleLogController(
            BattleLogRepository battleLogRepository
    ) {
        this.battleLogRepository = battleLogRepository;
    }

    @GetMapping
    public List<BattleLog> getLogs() {
        return battleLogRepository.findAll();
    }
}
