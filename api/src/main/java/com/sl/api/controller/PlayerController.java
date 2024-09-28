package com.sl.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

	@GetMapping("/players")
	public List<String> getPlayers() throws InterruptedException {
		Thread.sleep(2000);
		return List.of("Player 1", "Player 2", "Player 3", "Player 4", "Player 5");
	}
	
}
