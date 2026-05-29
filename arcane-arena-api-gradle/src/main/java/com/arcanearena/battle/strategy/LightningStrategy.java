package com.arcanearena.battle.strategy;

import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.battle.log.BattleLogRepository;
import com.arcanearena.player.Player;
import org.springframework.stereotype.Component;

@Component
public class LightningStrategy extends AbstractSpellStrategy {

    public LightningStrategy(
            BattleLogRepository battleLogRepository
    ) {
        super(battleLogRepository);
    }

    @Override
    public BattleResponseDTO cast(
            Player attacker,
            Player target
    ) {

        int damage = 40;
        int manaCost = 35;

        consumeMana(attacker, manaCost);

        applyDamage(target, damage);

        logBattle(
                attacker,
                target,
                "Lightning",
                damage
        );

        return new BattleResponseDTO(
                "Lightning dealt 40 damage",
                attacker.getMana(),
                target.getHealth()
        );
    }
}
