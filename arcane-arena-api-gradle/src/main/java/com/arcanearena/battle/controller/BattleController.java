package com.arcanearena.battle.controller;

import com.arcanearena.battle.dto.BattleRequestDTO;
import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.battle.service.BattleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/battle")
public class BattleController {

    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/cast")
    public BattleResponseDTO castSpell(
            @RequestBody BattleRequestDTO dto
    ) {
        return battleService.castSpell(dto);
    }
}
