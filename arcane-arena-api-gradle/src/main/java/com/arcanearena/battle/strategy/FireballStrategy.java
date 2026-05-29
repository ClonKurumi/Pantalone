package com.arcanearena.battle.strategy;

import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.battle.log.BattleLogRepository;
import com.arcanearena.player.Player;
import org.springframework.stereotype.Component;

@Component
public class FireballStrategy extends AbstractSpellStrategy {

    public FireballStrategy(
            BattleLogRepository battleLogRepository
    ) {
        super(battleLogRepository);
    }

    @Override
    public BattleResponseDTO cast(
            Player attacker,
            Player target
    ) {

        int damage = 30;
        int manaCost = 20;

        consumeMana(attacker, manaCost);

        applyDamage(target, damage);

        logBattle(
                attacker,
                target,
                "Fireball",
                damage
        );

        return new BattleResponseDTO(
                "Fireball dealt 30 damage",
                attacker.getMana(),
                target.getHealth()
        );
    }
}
