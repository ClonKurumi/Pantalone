package com.arcanearena.battle.service;

import com.arcanearena.battle.dto.BattleRequestDTO;
import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.player.Player;
import com.arcanearena.player.PlayerRepository;
import com.arcanearena.spell.Spell;
import com.arcanearena.spell.SpellRepository;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    private final PlayerRepository playerRepository;
    private final SpellRepository spellRepository;

    public BattleService(
            PlayerRepository playerRepository,
            SpellRepository spellRepository
    ) {
        this.playerRepository = playerRepository;
        this.spellRepository = spellRepository;
    }

    public BattleResponseDTO castSpell(BattleRequestDTO dto) {

        Player attacker = playerRepository.findById(dto.getAttackerId())
                .orElseThrow(() -> new RuntimeException("Attacker not found"));

        Player target = playerRepository.findById(dto.getTargetId())
                .orElseThrow(() -> new RuntimeException("Target not found"));

        Spell spell = spellRepository.findById(dto.getSpellId())
                .orElseThrow(() -> new RuntimeException("Spell not found"));

        if (attacker.getMana() < spell.getManaCost()) {
            throw new RuntimeException("Not enough mana");
        }

        attacker.setMana(attacker.getMana() - spell.getManaCost());

        target.setHealth(target.getHealth() - spell.getDamage());

        playerRepository.save(attacker);
        playerRepository.save(target);

        return new BattleResponseDTO(
                spell.getName() + " dealt " + spell.getDamage() + " damage",
                attacker.getMana(),
                target.getHealth()
        );
    }
}
