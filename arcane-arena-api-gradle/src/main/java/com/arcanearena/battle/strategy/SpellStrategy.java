package com.arcanearena.battle.strategy;

import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.player.Player;

public interface SpellStrategy {

    BattleResponseDTO cast(
            Player attacker,
            Player target
    );
}
