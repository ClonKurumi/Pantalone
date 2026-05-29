package com.arcanearena.battle.log;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "battle_logs")
public class BattleLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attackerName;

    private String targetName;

    private String spellName;

    private int damage;

    private LocalDateTime createdAt;

    public BattleLog() {
    }

    public BattleLog(
            String attackerName,
            String targetName,
            String spellName,
            int damage
    ) {
        this.attackerName = attackerName;
        this.targetName = targetName;
        this.spellName = spellName;
        this.damage = damage;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getAttackerName() {
        return attackerName;
    }

    public String getTargetName() {
        return targetName;
    }

    public String getSpellName() {
        return spellName;
    }

    public int getDamage() {
        return damage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
