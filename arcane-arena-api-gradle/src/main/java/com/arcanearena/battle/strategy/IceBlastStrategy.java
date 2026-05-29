package com.arcanearena.battle.strategy;

import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.battle.log.BattleLogRepository;
import com.arcanearena.player.Player;
import org.springframework.stereotype.Component;

@Component
public class IceBlastStrategy extends AbstractSpellStrategy {

    public IceBlastStrategy(
            BattleLogRepository battleLogRepository
    ) {
        super(battleLogRepository);
    }

    @Override
    public BattleResponseDTO cast(
            Player attacker,
            Player target
    ) {

        int damage = 20;
        int manaCost = 15;

        consumeMana(attacker, manaCost);

        applyDamage(target, damage);

        logBattle(
                attacker,
                target,
                "Ice Blast",
                damage
        );

        return new BattleResponseDTO(
                "Ice Blast dealt 20 damage and froze target",
                attacker.getMana(),
                target.getHealth()
        );
    }
}
