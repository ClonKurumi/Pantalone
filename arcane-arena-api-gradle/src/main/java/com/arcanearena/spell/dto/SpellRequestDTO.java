package com.arcanearena.spell.dto;

public class SpellRequestDTO {

    private String name;
    private String school;
    private Integer manaCost;
    private Integer damage;
    private Long playerId;

    public SpellRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
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

    public void setSchool(String school) {
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
