CREATE TABLE players (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    mage_class VARCHAR(255) NOT NULL,
    level INTEGER NOT NULL,
    mana INTEGER NOT NULL
);
