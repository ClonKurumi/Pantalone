package com.arcanearena.spell.service;

import com.arcanearena.player.Player;
import com.arcanearena.player.PlayerRepository;
import com.arcanearena.spell.Spell;
import com.arcanearena.spell.SpellRepository;
import com.arcanearena.spell.dto.SpellRequestDTO;
import com.arcanearena.spell.dto.SpellResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellService {

    private final SpellRepository spellRepository;
    private final PlayerRepository playerRepository;

    public SpellService(
            SpellRepository spellRepository,
            PlayerRepository playerRepository
    ) {
        this.spellRepository = spellRepository;
        this.playerRepository = playerRepository;
    }

    public SpellResponseDTO create(SpellRequestDTO dto) {

        Player player = playerRepository.findById(dto.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Player not found"));

        Spell spell = new Spell();

        spell.setName(dto.getName());
        spell.setSchool(dto.getSchool());
        spell.setManaCost(dto.getManaCost());
        spell.setDamage(dto.getDamage());
        spell.setPlayer(player);

        Spell savedSpell = spellRepository.save(spell);

        return new SpellResponseDTO(
                savedSpell.getId(),
                savedSpell.getName(),
                savedSpell.getSchool(),
                savedSpell.getManaCost(),
                savedSpell.getDamage()
        );
    }

    public List<Spell> getAll() {
        return spellRepository.findAll();
    }
}
