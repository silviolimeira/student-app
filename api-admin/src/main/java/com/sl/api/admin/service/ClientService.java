package com.sl.api.admin.service;

import com.sl.api.admin.entity.Client;
import com.sl.api.admin.entity.Status;
import com.sl.api.admin.model.ClientDto;
import com.sl.api.admin.model.StatusDTO;
import com.sl.api.admin.repository.ClientRepository;
import com.sl.api.admin.repository.StatusRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

	private static final Logger logger = LogManager.getLogger(ClientService.class);

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public ClientDto save(ClientDto dto) {
		Client client = new Client(dto);
		logger.info("save={}", dto);
		return new ClientDto(clientRepository.save(client));
	}

	public List<ClientDto> findAll() {
		List<Client> statusList = clientRepository.findAll();
		return statusList.stream().map(c -> new ClientDto(c)).collect(Collectors.toList()); 
	}

}
