package com.arcanearena.spell.dto;

public class SpellResponseDTO {

    private Long id;
    private String name;
    private String school;
    private Integer manaCost;
    private Integer damage;

    public SpellResponseDTO() {
    }

    public SpellResponseDTO(
            Long id,
            String name,
            String school,
            Integer manaCost,
            Integer damage
    ) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.manaCost = manaCost;
        this.damage = damage;
    }

    public Long getId() {
        return id;
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
}
