package com.sl.spring_1.adm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sl.spring_1.adm.jpa.Section;
import com.sl.spring_1.adm.model.SectionDTO;
import com.sl.spring_1.adm.repository.SectionRepository;

@Service
public class SectionServiceImpl implements AppService {

	private static final Logger logger = LogManager.getLogger(SectionServiceImpl.class);

	private SectionRepository sectionRepository;
	
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
