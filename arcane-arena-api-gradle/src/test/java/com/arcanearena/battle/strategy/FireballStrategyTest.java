package com.arcanearena.battle.strategy;

import com.arcanearena.battle.dto.BattleResponseDTO;
import com.arcanearena.battle.log.BattleLogRepository;
import com.arcanearena.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class FireballStrategyTest {

    @Test
    void shouldCastFireball() {

        BattleLogRepository logRepository =
                mock(BattleLogRepository.class);

        FireballStrategy strategy =
                new FireballStrategy(logRepository);

        Player attacker = new Player();
        attacker.setMana(100);

        Player target = new Player();
        target.setHealth(100);

        BattleResponseDTO response =
                strategy.cast(attacker, target);

        assertEquals(80, attacker.getMana());

        assertEquals(70, target.getHealth());

        assertTrue(
                response.getMessage()
                        .contains("Fireball")
        );
    }
}
