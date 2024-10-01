package com.sl.api.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sl.api.admin.entity.Section;
import com.sl.api.admin.model.SectionDTO;
import com.sl.api.admin.repository.SectionRepository;

@Service
public class SectionServiceImpl implements AppService {

	private static final Logger logger = LogManager.getLogger(SectionServiceImpl.class);

	private com.sl.api.admin.repository.SectionRepository sectionRepository;
	
	public SectionServiceImpl(SectionRepository sectionRepository) {
		this.sectionRepository = sectionRepository;
	}
	
	@Override
	public void save(SectionDTO dto) {
		Section section = new Section(dto);
		logger.info("save={}", dto);
		sectionRepository.save(section);
	}

	@Override
	public List<SectionDTO> findAll() {
		List<SectionDTO> dtos = new ArrayList<>();
		List<Section> sections = sectionRepository.findAll();
		for (Section section : sections) {
			SectionDTO dto = new SectionDTO(section);
			dtos.add(dto);
		}
		return dtos;
	}

}
