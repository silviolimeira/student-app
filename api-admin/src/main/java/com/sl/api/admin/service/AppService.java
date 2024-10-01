package com.sl.api.admin.service;

import java.util.List;

import com.sl.api.admin.model.SectionDTO;

public interface AppService {

	public void save(SectionDTO section);
	public List<SectionDTO> findAll();
}
