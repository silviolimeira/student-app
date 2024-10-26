package com.sl.api.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sl.api.admin.entity.Status;
import com.sl.api.admin.model.StatusDTO;
import com.sl.api.admin.repository.StatusRepository;

@Service
public class StatusService implements AppService {

	private static final Logger logger = LogManager.getLogger(StatusService.class);

	private com.sl.api.admin.repository.StatusRepository statusRepository;
	
	public StatusService(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}
	
	@Override
	public <T> T save(T dto) {
		Status status = new Status(dto);
		logger.info("save={}", dto);
		return (T) new StatusDTO(statusRepository.save(status));
	}

	@Override
	public List<StatusDTO> findAll() {
		List<StatusDTO> statusListDTO = new ArrayList<>();
		List<Status> statusList = statusRepository.findAll();
		for (Status status : statusList) {
			StatusDTO dto = new StatusDTO(status);
			statusListDTO.add(dto);
		}
		return statusListDTO;
	}


}
