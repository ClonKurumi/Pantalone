package com.arcanearena.dto;

import com.arcanearena.enums.SpellSchool;

public class SpellResponse {

    private Long id;

    private String name;

    private SpellSchool school;

    private Integer manaCost;

    private Integer damage;

    private String ownerUsername;

    public SpellResponse(Long id,
                         String name,
                         SpellSchool school,
                         Integer manaCost,
                         Integer damage,
                         String ownerUsername) {

        this.id = id;
        this.name = name;
        this.school = school;
        this.manaCost = manaCost;
        this.damage = damage;
        this.ownerUsername = ownerUsername;
    }

    public Long getId() {
        return id;
    }

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

    public String getOwnerUsername() {
        return ownerUsername;
    }
}
