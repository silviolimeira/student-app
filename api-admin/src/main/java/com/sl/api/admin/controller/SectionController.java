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

import com.sl.api.admin.entity.Section;
import com.sl.api.admin.model.SectionDTO;
import com.sl.api.admin.repository.SectionRepository;
import com.sl.api.admin.service.AppService;
import com.sl.api.admin.service.SectionServiceImpl;

@RestController
@RequestMapping("v1/sections")
public class SectionController {

	private static final Logger logger = LogManager.getLogger(SectionController.class);

	private AppService sectionService;

	public SectionController(AppService sectionService) {
		this.sectionService = sectionService;
	}

	@GetMapping
	public ResponseEntity<List<SectionDTO>> findAll() {
		return ResponseEntity.ok(sectionService.findAll());
	}

	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping
	public ResponseEntity<SectionDTO> create(@RequestBody SectionDTO dto) {
		return ResponseEntity.ok(sectionService.save(dto));
	}

}
