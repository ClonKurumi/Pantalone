package com.arcanearena.battle.service;

import com.arcanearena.battle.dto.BattleRequestDTO;
import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.battle.factory.SpellStrategyFactory;
import com.arcanearena.battle.strategy.SpellStrategy;
import com.arcanearena.exception.ResourceNotFoundException;
import com.arcanearena.player.Player;
import com.arcanearena.player.PlayerRepository;
import com.arcanearena.spell.Spell;
import com.arcanearena.spell.SpellRepository;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    private final PlayerRepository playerRepository;
    private final SpellRepository spellRepository;
    private final SpellStrategyFactory spellStrategyFactory;

    public BattleService(
            PlayerRepository playerRepository,
            SpellRepository spellRepository,
            SpellStrategyFactory spellStrategyFactory
    ) {
        this.playerRepository = playerRepository;
        this.spellRepository = spellRepository;
        this.spellStrategyFactory = spellStrategyFactory;
    }

    public BattleResponseDTO castSpell(
            BattleRequestDTO dto
    ) {

        Player attacker = playerRepository.findById(dto.getAttackerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Attacker not found"
                        ));

        Player target = playerRepository.findById(dto.getTargetId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Target not found"
                        ));

        Spell spell = spellRepository.findById(dto.getSpellId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Spell not found"
                        ));

        SpellStrategy strategy =
                spellStrategyFactory.getStrategy(
                        dto.getSpellType()
                );

        BattleResponseDTO response =
                strategy.cast(attacker, target);

        playerRepository.save(attacker);
        playerRepository.save(target);

        return response;
    }
}
