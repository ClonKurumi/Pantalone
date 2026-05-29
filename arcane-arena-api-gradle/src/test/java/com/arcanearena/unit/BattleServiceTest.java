package com.arcanearena.unit;

import com.arcanearena.battle.dto.BattleRequestDTO;
import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.battle.log.BattleLogRepository;
import com.arcanearena.battle.service.BattleService;
import com.arcanearena.battle.strategy.FireballStrategy;
import com.arcanearena.battle.strategy.IceBlastStrategy;
import com.arcanearena.battle.strategy.LightningStrategy;
import com.arcanearena.battle.factory.SpellStrategyFactory;
import com.arcanearena.exception.NotEnoughManaException;
import com.arcanearena.model.SpellType;
import com.arcanearena.player.Player;
import com.arcanearena.player.PlayerRepository;
import com.arcanearena.spell.Spell;
import com.arcanearena.spell.SpellRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BattleServiceTest {

    private BattleService battleService;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private SpellRepository spellRepository;

    @Mock
    private BattleLogRepository battleLogRepository;

    private SpellStrategyFactory strategyFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        FireballStrategy fireballStrategy = new FireballStrategy(battleLogRepository);
        IceBlastStrategy iceBlastStrategy = new IceBlastStrategy(battleLogRepository);
        LightningStrategy lightningStrategy = new LightningStrategy(battleLogRepository);
        
        strategyFactory = new SpellStrategyFactory(fireballStrategy, iceBlastStrategy, lightningStrategy);
        
        battleService = new BattleService(playerRepository, spellRepository, strategyFactory);
    }

    @Test
    void testCastSpellFireballSuccess() {
        BattleRequestDTO dto = new BattleRequestDTO();
        dto.setAttackerId(1L);
        dto.setTargetId(2L);
        dto.setSpellId(3L);
        dto.setSpellType(SpellType.FIREBALL);

        Player attacker = new Player("Attacker", "Mage", 1, 100, 100);
        attacker.setId(1L);
        Player target = new Player("Target", "Mage", 1, 100, 100);
        target.setId(2L);

        Spell spell = new Spell("Fireball");
        spell.setId(3L);

        when(playerRepository.findById(1L)).thenReturn(Optional.of(attacker));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(target));
        when(spellRepository.findById(3L)).thenReturn(Optional.of(spell));

        BattleResponseDTO response = battleService.castSpell(dto);

        assertNotNull(response);
        assertEquals(80, response.getRemainingMana()); // 100 - 20 mana cost
        assertEquals(70, response.getTargetHealth());  // 100 - 30 damage
        assertTrue(response.getMessage().contains("Fireball dealt 30 damage"));
    }

    @Test
    void testCastSpellIceBlastSuccess() {
        BattleRequestDTO dto = new BattleRequestDTO();
        dto.setAttackerId(1L);
        dto.setTargetId(2L);
        dto.setSpellId(3L);
        dto.setSpellType(SpellType.ICE_BLAST);

        Player attacker = new Player("Attacker", "Mage", 1, 100, 100);
        attacker.setId(1L);
        Player target = new Player("Target", "Mage", 1, 100, 100);
        target.setId(2L);

        Spell spell = new Spell("Ice Blast");
        spell.setId(3L);

        when(playerRepository.findById(1L)).thenReturn(Optional.of(attacker));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(target));
        when(spellRepository.findById(3L)).thenReturn(Optional.of(spell));

        BattleResponseDTO response = battleService.castSpell(dto);

        assertNotNull(response);
        assertEquals(85, response.getRemainingMana()); // 100 - 15 mana cost
        assertEquals(80, response.getTargetHealth());  // 100 - 20 damage
        assertTrue(response.getMessage().contains("Ice Blast dealt 20 damage and froze target"));
    }

    @Test
    void testCastSpellNotEnoughMana() {
        BattleRequestDTO dto = new BattleRequestDTO();
        dto.setAttackerId(1L);
        dto.setTargetId(2L);
        dto.setSpellId(3L);
        dto.setSpellType(SpellType.LIGHTNING);

        Player attacker = new Player("Attacker", "Mage", 1, 25, 100); // Only 25 mana, lightning costs 35
        attacker.setId(1L);
        Player target = new Player("Target", "Mage", 1, 100, 100);
        target.setId(2L);

        Spell spell = new Spell("Lightning");
        spell.setId(3L);

        when(playerRepository.findById(1L)).thenReturn(Optional.of(attacker));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(target));
        when(spellRepository.findById(3L)).thenReturn(Optional.of(spell));

        assertThrows(NotEnoughManaException.class, () -> battleService.castSpell(dto));
    }
}
