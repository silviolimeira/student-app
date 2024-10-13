package com.sl.api.admin.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sl.api.admin.entity.Tree;
import com.sl.api.admin.model.TreeDTO;
import com.sl.api.admin.repository.TreeRepository;
import com.sl.api.admin.service.AppService;
import com.sl.api.admin.service.TreeServiceImpl;

@RestController
@RequestMapping("v1/trees")
public class TreeController {

	private static final Logger logger = LogManager.getLogger(TreeController.class);

	private AppService treeService;

	public TreeController(AppService treeService) {
		this.treeService = treeService;
	}

	@GetMapping
	public ResponseEntity<List<TreeDTO>> findAll() {
		return ResponseEntity.ok(treeService.findAll());
	}

	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping
	public ResponseEntity<TreeDTO> create(@RequestBody TreeDTO dto) {
		return ResponseEntity.ok(treeService.save(dto));
	}

}
