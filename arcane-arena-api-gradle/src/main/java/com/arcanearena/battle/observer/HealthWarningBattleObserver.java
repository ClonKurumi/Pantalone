package com.arcanearena.battle.observer;

import com.arcanearena.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HealthWarningBattleObserver implements BattleObserver {
    private static final Logger logger = LoggerFactory.getLogger(HealthWarningBattleObserver.class);

    @Override
    public void onSpellCast(Player attacker, Player target, String spellName, int damage, int manaCost) {
        if (target.getHealth() < 30) {
            logger.warn("WARNING: Player {} health is critically low ({})!", target.getUsername(), target.getHealth());
        }
    }
}
