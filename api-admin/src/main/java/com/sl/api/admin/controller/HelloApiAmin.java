package com.sl.api.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiAmin {

	@GetMapping("/hello")
	public List<String> getPlayers() throws InterruptedException {
		Thread.sleep(2000);
		return List.of("ApiAdmin");
	}


}
