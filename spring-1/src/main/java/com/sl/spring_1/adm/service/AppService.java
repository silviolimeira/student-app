package com.sl.spring_1.adm.service;

import java.util.List;

import com.sl.spring_1.adm.model.SectionDTO;

public interface AppService {

	public void save(SectionDTO section);
	public List<SectionDTO> findAll();
}
