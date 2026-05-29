package com.arcanearena.battle.dto;

import com.arcanearena.model.SpellType;

public class BattleRequestDTO {

    private Long attackerId;
    private Long targetId;
    private Long spellId;
    private SpellType spellType;

    public BattleRequestDTO() {
    }

    public Long getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getSpellId() {
        return spellId;
    }

    public void setSpellId(Long spellId) {
        this.spellId = spellId;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType spellType) {
        this.spellType = spellType;
    }
}
