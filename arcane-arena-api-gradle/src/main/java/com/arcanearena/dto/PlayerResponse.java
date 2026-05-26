package com.arcanearena.dto;

public class PlayerResponse {

    private Long id;
    private String username;
    private String mageClass;
    private Integer level;
    private Integer mana;
    private Integer health;

    public PlayerResponse(Long id,
                          String username,
                          String mageClass,
                          Integer level,
                          Integer mana,
                          Integer health) {

        this.id = id;
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
}
