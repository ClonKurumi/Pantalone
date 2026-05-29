package com.arcanearena.battle.strategy;

import com.arcanearena.battle.log.BattleLog;
import com.arcanearena.battle.log.BattleLogRepository;
import com.arcanearena.battle.observer.BattleObserver;
import com.arcanearena.exception.NotEnoughManaException;
import com.arcanearena.player.Player;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractSpellStrategy
        implements SpellStrategy {

    protected final BattleLogRepository battleLogRepository;

    @Autowired(required = false)
    protected List<BattleObserver> observers;

    protected AbstractSpellStrategy(
            BattleLogRepository battleLogRepository
    ) {
        this.battleLogRepository = battleLogRepository;
    }

    protected void consumeMana(Player attacker, int manaCost) {

        if (attacker.getMana() < manaCost) {
            throw new NotEnoughManaException("Not enough mana");
        }

        attacker.setMana(attacker.getMana() - manaCost);
    }

    protected void applyDamage(Player target, int damage) {
        target.setHealth(target.getHealth() - damage);
    }

    protected void logBattle(
            Player attacker,
            Player target,
            String spellName,
            int damage
    ) {

        BattleLog log = new BattleLog(
                attacker.getUsername(),
                target.getUsername(),
                spellName,
                damage
        );

        battleLogRepository.save(log);
    }

    protected void notifyObservers(Player attacker, Player target, String spellName, int damage, int manaCost) {
        if (observers != null) {
            observers.forEach(observer -> observer.onSpellCast(attacker, target, spellName, damage, manaCost));
        }
    }
}
