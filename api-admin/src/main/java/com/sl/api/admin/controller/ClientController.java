package com.sl.api.admin.controller;

import com.sl.api.admin.model.ClientDto;
import com.sl.api.admin.model.StatusDTO;
import com.sl.api.admin.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/clients", produces = {"aplication/json"})
@Tag(name = "client")
public class ClientController {

	private static final Logger logger = LogManager.getLogger(ClientController.class);

	private ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@Operation(summary = "List of Clients", method = "GET")
	@GetMapping(produces = "application/json")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of clients.")})
	public ResponseEntity<List<ClientDto>> findAll() {
		return ResponseEntity.ok(clientService.findAll());
	}

	@Operation(summary = "Save Client", method = "POST")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Client register successfully")})
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDto> create(@RequestBody ClientDto dto) {
		return ResponseEntity.ok(clientService.save(dto));
	}

}











