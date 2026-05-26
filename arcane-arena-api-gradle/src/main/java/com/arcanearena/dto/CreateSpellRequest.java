package com.arcanearena.dto;

import com.arcanearena.enums.SpellSchool;

public class CreateSpellRequest {

    private String name;

    private SpellSchool school;

    private Integer manaCost;

    private Integer damage;

    private Long playerId;

    public String getName() {
        return name;
    }

    public SpellSchool getSchool() {
        return school;
    }

    public Integer getManaCost() {
        return manaCost;
    }

    public Integer getDamage() {
        return damage;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(SpellSchool school) {
        this.school = school;
    }

    public void setManaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}
