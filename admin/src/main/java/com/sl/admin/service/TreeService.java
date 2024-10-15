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
import com.sl.admin.model.Tree;
import com.sl.admin.model.TreeDTO;

@Service
public class TreeService {

	private static final Logger logger = LogManager.getLogger(TreeService.class);

	private RestClient restClient;

	public TreeService(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("http://localhost:8091").build();
	}

	public List<Tree> findAll() {
	    var dots = Arrays.asList(restClient.get().uri("/v1/trees").retrieve().body(TreeDTO[].class));
	    return dots.stream().map(d -> new Tree(d)).collect(Collectors.toList());
	}

	public void save(Tree tree) {
        TreeDTO dto = new TreeDTO(tree);
		ResponseEntity<Void> response = restClient.post().uri("/v1/trees")
				.contentType(MediaType.APPLICATION_JSON)
				.body(dto)
				.retrieve()
				.toBodilessEntity();
	}
}
