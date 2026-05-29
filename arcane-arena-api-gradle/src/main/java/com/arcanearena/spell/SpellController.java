package com.arcanearena.spell;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
public class SpellController {

    private final SpellRepository spellRepository;

    public SpellController(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    @PostMapping
    public Spell createSpell(@RequestBody Spell spell) {
        return spellRepository.save(spell);
    }

    @GetMapping
    public List<Spell> getAllSpells() {
        return spellRepository.findAll();
    }
}
