package com.sl.api.admin.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.api.admin.model.SectionDTO;
import com.sl.api.admin.service.AppService;
import com.sl.api.admin.service.SectionServiceImpl;

@RestController
public class SectionController {

	private static final Logger logger = LogManager.getLogger(SectionController.class);

	private AppService sectionService;

	public SectionController(AppService sectionService) {
		this.sectionService = sectionService;
	}

	@GetMapping("/sections")
	public List<SectionDTO> findAll() {
		return sectionService.findAll();
	}

}
