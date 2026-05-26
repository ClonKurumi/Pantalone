package com.arcanearena.battle.dto;

public class BattleResponseDTO {

    private String message;
    private Integer remainingMana;
    private Integer targetHealth;

    public BattleResponseDTO(
            String message,
            Integer remainingMana,
            Integer targetHealth
    ) {
        this.message = message;
        this.remainingMana = remainingMana;
        this.targetHealth = targetHealth;
    }

    public String getMessage() {
        return message;
    }

    public Integer getRemainingMana() {
        return remainingMana;
    }

    public Integer getTargetHealth() {
        return targetHealth;
    }
}
