package com.sl.admin.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.sl.admin.model.SectionDTO;

@Service
public class SectionService {

	private static final Logger logger = LogManager.getLogger(SectionService.class);

	private RestClient restClient;

	public SectionService(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("http://localhost:8091").build();
	}

	public List<com.sl.admin.model.SectionDTO> findAll() {
		return (List<SectionDTO>) restClient.get().uri("/sections").retrieve().toEntity(SectionDTO.class).getBody();
	}

	public SectionDTO save(SectionDTO dto) {
		return restClient.post().uri("/articles").contentType(MediaType.APPLICATION_JSON).body(dto).retrieve()
				.toEntity(SectionDTO.class).getBody();

	}
}
