package com.arcanearena.battle.observer;

import com.arcanearena.player.Player;

public interface BattleObserver {
    void onSpellCast(Player attacker, Player target, String spellName, int damage, int manaCost);
}
