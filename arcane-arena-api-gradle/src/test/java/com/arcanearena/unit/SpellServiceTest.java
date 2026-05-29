package com.arcanearena.unit;

import com.arcanearena.player.Player;
import com.arcanearena.player.PlayerRepository;
import com.arcanearena.spell.Spell;
import com.arcanearena.spell.SpellRepository;
import com.arcanearena.spell.dto.SpellRequestDTO;
import com.arcanearena.spell.dto.SpellResponseDTO;
import com.arcanearena.spell.service.SpellService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SpellServiceTest {

    @Mock
    private SpellRepository spellRepository;

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private SpellService spellService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSpellSuccess() {
        SpellRequestDTO dto = new SpellRequestDTO();
        dto.setName("Fireball");
        dto.setSchool("Fire");
        dto.setManaCost(20);
        dto.setDamage(30);
        dto.setPlayerId(1L);

        Player player = new Player();
        player.setId(1L);

        Spell savedSpell = new Spell();
        savedSpell.setId(5L);
        savedSpell.setName("Fireball");
        savedSpell.setSchool("Fire");
        savedSpell.setManaCost(20);
        savedSpell.setDamage(30);
        savedSpell.setPlayer(player);

        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));
        when(spellRepository.save(any(Spell.class))).thenReturn(savedSpell);

        SpellResponseDTO response = spellService.create(dto);

        assertNotNull(response);
        assertEquals(5L, response.getId());
        assertEquals("Fireball", response.getName());
    }

    @Test
    void testCreateSpellPlayerNotFound() {
        SpellRequestDTO dto = new SpellRequestDTO();
        dto.setPlayerId(1L);

        when(playerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> spellService.create(dto));
    }

    @Test
    void testGetAllSpells() {
        Spell s1 = new Spell("Fireball");
        Spell s2 = new Spell("Frostbolt");

        when(spellRepository.findAll()).thenReturn(Arrays.asList(s1, s2));

        List<Spell> spells = spellService.getAll();

        assertEquals(2, spells.size());
    }
}
