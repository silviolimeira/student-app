package com.sl.api.admin.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sl.api.admin.entity.Tree;
import com.sl.api.admin.model.StatusDTO;
import com.sl.api.admin.model.TreeDTO;
import com.sl.api.admin.repository.TreeRepository;
import com.sl.api.admin.service.AppService;
import com.sl.api.admin.service.TreeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "v1/status", produces = {"aplication/json"})
@Tag(name = "status")
public class StatusController {

	private static final Logger logger = LogManager.getLogger(StatusController.class);

	private AppService statusService;

	public StatusController(AppService statusService) {
		this.statusService = statusService;
	}

	@GetMapping(produces = "application/json")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Status register successfully")})
	public ResponseEntity<List<StatusDTO>> findAll() {
		return ResponseEntity.ok(statusService.findAll());
	}

	@Operation(summary = "Save Trees", method = "POST")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Tree register successfully")})
	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusDTO> create(@RequestBody StatusDTO dto) {
		return ResponseEntity.ok(statusService.save(dto));
	}

}











