package com.arcanearena.dto;

public class CreatePlayerRequest {

    private String username;
    private String mageClass;
    private Integer level;
    private Integer mana;
    private Integer health;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMageClass() {
        return mageClass;
    }

    public void setMageClass(String mageClass) {
        this.mageClass = mageClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
