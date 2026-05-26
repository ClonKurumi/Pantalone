package com.arcanearena.service;

import com.arcanearena.dto.CreatePlayerRequest;
import com.arcanearena.dto.PlayerResponse;
import com.arcanearena.player.Player;
import com.arcanearena.player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerResponse createPlayer(CreatePlayerRequest request) {

        Player player = new Player();

        player.setUsername(request.getUsername());
        player.setMageClass(request.getMageClass());

        player.setLevel(request.getLevel() != null ? request.getLevel() : 1);
        player.setMana(request.getMana() != null ? request.getMana() : 100);
        player.setHealth(request.getHealth() != null ? request.getHealth() : 100);

        Player savedPlayer = playerRepository.save(player);

        return mapToResponse(savedPlayer);
    }

    public List<PlayerResponse> getAllPlayers() {

        return playerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private PlayerResponse mapToResponse(Player player) {

        return new PlayerResponse(
                player.getId(),
                player.getUsername(),
                player.getMageClass(),
                player.getLevel(),
                player.getMana(),
                player.getHealth()
        );
    }
}
