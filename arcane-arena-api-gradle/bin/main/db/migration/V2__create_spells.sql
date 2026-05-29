CREATE TABLE spells (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    school VARCHAR(50) NOT NULL,
    mana_cost INTEGER NOT NULL,
    damage INTEGER NOT NULL,

    player_id BIGINT,

    CONSTRAINT fk_spell_player
        FOREIGN KEY(player_id)
        REFERENCES players(id)
);
