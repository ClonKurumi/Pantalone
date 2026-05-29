CREATE TABLE battle_logs (
    id BIGSERIAL PRIMARY KEY,
    attacker_name VARCHAR(255),
    target_name VARCHAR(255),
    spell_name VARCHAR(255),
    damage INT,
    created_at TIMESTAMP
);
