INSERT INTO players (username, mage_class, level, mana, health) VALUES
('Wizard', 'Fire Mage', 1, 100, 100),
('Enemy', 'Ice Mage', 1, 100, 100);

INSERT INTO spells (name, school, mana_cost, damage, player_id) VALUES
('Fireball', 'Fire', 25, 40, 1);
