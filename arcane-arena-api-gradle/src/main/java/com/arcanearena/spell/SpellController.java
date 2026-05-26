package com.arcanearena.spell;

import com.arcanearena.spell.dto.SpellRequestDTO;
import com.arcanearena.spell.dto.SpellResponseDTO;
import com.arcanearena.spell.service.SpellService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
public class SpellController {

    private final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @PostMapping
    public SpellResponseDTO create(@RequestBody SpellRequestDTO dto) {
        return spellService.create(dto);
    }

    @GetMapping
    public List<Spell> getAll() {
        return spellService.getAll();
    }
}
