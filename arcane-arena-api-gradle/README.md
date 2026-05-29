# Arcane Arena API

## Features

### REST API
- **Player System**
- **Spell Casting**
- **Battle System**

### Design Patterns
- **Strategy Pattern**: Different spell behaviors (`FireballStrategy`, `IceBlastStrategy`, `LightningStrategy`).
- **Factory Pattern**: `SpellStrategyFactory` selects the correct strategy at runtime.

### Additional Features
- **Global Exception Handling**
- **Flyway Migrations**
- **PostgreSQL**
- **Battle Logging**
- **Unit Testing**

## Technologies
- Java 21
- Spring Boot 3
- PostgreSQL
- Flyway
- Gradle
- Docker

## OOP Principles
- Abstraction
- Encapsulation
- Polymorphism
- Separation of Concerns

## Endpoints

### Players
- `GET /api/players`
- `POST /api/players`

### Spells
- `GET /api/spells`
- `POST /api/spells`

### Battle
- `POST /api/battle/cast`

### Battle Logs
- `GET /api/battle-logs`

## Run Project
```bash
docker compose up -d
gradle bootRun
```
