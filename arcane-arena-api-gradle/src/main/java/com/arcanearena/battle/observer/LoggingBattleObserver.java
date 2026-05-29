package com.arcanearena.battle.observer;

import com.arcanearena.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingBattleObserver implements BattleObserver {
    private static final Logger logger = LoggerFactory.getLogger(LoggingBattleObserver.class);

    @Override
    public void onSpellCast(Player attacker, Player target, String spellName, int damage, int manaCost) {
        logger.info("Player {} cast {} on Player {} dealing {} damage using {} mana.",
                attacker.getUsername(), spellName, target.getUsername(), damage, manaCost);
    }
}
