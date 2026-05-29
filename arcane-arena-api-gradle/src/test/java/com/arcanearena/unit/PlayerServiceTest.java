package com.arcanearena.unit;

import com.arcanearena.dto.CreatePlayerRequest;
import com.arcanearena.dto.PlayerResponse;
import com.arcanearena.player.Player;
import com.arcanearena.player.PlayerRepository;
import com.arcanearena.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePlayer() {
        CreatePlayerRequest request = new CreatePlayerRequest();
        request.setUsername("Mage");
        request.setMageClass("Fire Mage");
        request.setLevel(1);
        request.setMana(100);
        request.setHealth(100);

        Player savedPlayer = new Player("Mage", "Fire Mage", 1, 100, 100);
        savedPlayer.setId(1L);

        when(playerRepository.save(any(Player.class))).thenReturn(savedPlayer);

        PlayerResponse response = playerService.createPlayer(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Mage", response.getUsername());
        verify(playerRepository, times(1)).save(any(Player.class));
    }

    @Test
    void testGetAllPlayers() {
        Player p1 = new Player("Mage1", "Fire", 1, 100, 100);
        p1.setId(1L);
        Player p2 = new Player("Mage2", "Ice", 2, 80, 90);
        p2.setId(2L);

        when(playerRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<PlayerResponse> responses = playerService.getAllPlayers();

        assertEquals(2, responses.size());
        assertEquals("Mage1", responses.get(0).getUsername());
        assertEquals("Mage2", responses.get(1).getUsername());
    }
}
