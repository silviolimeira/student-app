package com.sl.front.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class PlayerController {
	
	private static final Logger logger = LogManager.getLogger(PlayerController.class);

	private RestClient restClient;
	
	public PlayerController(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("http://localhost:8081")
				.build();
	}

	@GetMapping("/")
	public List<String> getPlayers() {
		logger.info("Running {}", Thread.currentThread());
		return restClient
				.get()
				.uri("/players")
				.retrieve()
				.toEntity(List.class).getBody();
	}

}
