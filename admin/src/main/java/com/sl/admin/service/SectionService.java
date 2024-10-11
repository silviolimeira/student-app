package com.sl.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.admin.model.Section;
import com.sl.admin.model.SectionDTO;

@Service
public class SectionService {

	private static final Logger logger = LogManager.getLogger(SectionService.class);

	private RestClient restClient;

	public SectionService(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("http://localhost:8091").build();
	}

	public List<Section> findAll() {
	    var dots = Arrays.asList(restClient.get().uri("/v1/sections").retrieve().body(SectionDTO[].class));
	    return dots.stream().map(d -> new Section(d)).collect(Collectors.toList());
	}

	public void save(Section section) {
        SectionDTO dto = new SectionDTO(section);
		ResponseEntity<Void> response = restClient.post().uri("/v1/sections")
				.contentType(MediaType.APPLICATION_JSON)
				.body(dto)
				.retrieve()
				.toBodilessEntity();
	}
}
