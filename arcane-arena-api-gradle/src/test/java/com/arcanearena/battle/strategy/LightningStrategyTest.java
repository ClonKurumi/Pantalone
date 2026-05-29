package com.arcanearena.battle.strategy;

import com.arcanearena.battle.log.BattleLogRepository;
import com.arcanearena.exception.NotEnoughManaException;
import com.arcanearena.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class LightningStrategyTest {

    @Test
    void shouldThrowWhenNotEnoughMana() {

        BattleLogRepository logRepository =
                mock(BattleLogRepository.class);

        LightningStrategy strategy =
                new LightningStrategy(logRepository);

        Player attacker = new Player();
        attacker.setMana(10);

        Player target = new Player();
        target.setHealth(100);

        assertThrows(
                NotEnoughManaException.class,
                () -> strategy.cast(attacker, target)
        );
    }
}
