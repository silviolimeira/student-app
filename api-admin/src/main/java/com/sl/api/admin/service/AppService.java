package com.sl.api.admin.service;

import java.util.List;

import com.sl.api.admin.model.TreeDTO;

public interface AppService {

	public TreeDTO save(TreeDTO tree);
	public List<TreeDTO> findAll();
}
