package com.arcanearena.player;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.arcanearena.spell.Spell;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String mageClass;

    private Integer level;

    private Integer mana;

    private Integer health;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<Spell> spells = new ArrayList<>();

    public Player() {
    }

    public Player(String username, String mageClass, Integer level, Integer mana, Integer health) {
        this.username = username;
        this.mageClass = mageClass;
        this.level = level;
        this.mana = mana;
        this.health = health;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMageClass() {
        return mageClass;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getMana() {
        return mana;
    }

    public Integer getHealth() {
        return health;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMageClass(String mageClass) {
        this.mageClass = mageClass;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }
}
