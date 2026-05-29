package com.arcanearena.battle.factory;

import com.arcanearena.battle.strategy.FireballStrategy;
import com.arcanearena.battle.strategy.IceBlastStrategy;
import com.arcanearena.battle.strategy.LightningStrategy;
import com.arcanearena.battle.strategy.SpellStrategy;
import com.arcanearena.model.SpellType;
import org.springframework.stereotype.Component;

@Component
public class SpellStrategyFactory {

    private final FireballStrategy fireballStrategy;
    private final IceBlastStrategy iceBlastStrategy;
    private final LightningStrategy lightningStrategy;

    public SpellStrategyFactory(
            FireballStrategy fireballStrategy,
            IceBlastStrategy iceBlastStrategy,
            LightningStrategy lightningStrategy
    ) {
        this.fireballStrategy = fireballStrategy;
        this.iceBlastStrategy = iceBlastStrategy;
        this.lightningStrategy = lightningStrategy;
    }

    public SpellStrategy getStrategy(
            SpellType spellType
    ) {

        return switch (spellType) {

            case FIREBALL -> fireballStrategy;

            case ICE_BLAST -> iceBlastStrategy;

            case LIGHTNING -> lightningStrategy;
        };
    }
}
