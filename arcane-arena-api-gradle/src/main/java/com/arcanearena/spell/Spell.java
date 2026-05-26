package com.arcanearena.spell;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.arcanearena.player.Player;
import jakarta.persistence.*;

@Entity
@Table(name = "spells")
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String school;

    private Integer manaCost;

    private Integer damage;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonBackReference
    private Player player;

    public Spell() {
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

    public Player getPlayer() {
        return player;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPlayer(Player player) {
        this.player = player;
    }
}
