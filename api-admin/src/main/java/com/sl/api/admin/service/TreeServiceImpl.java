package com.sl.api.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sl.api.admin.entity.Tree;
import com.sl.api.admin.model.TreeDTO;
import com.sl.api.admin.repository.TreeRepository;

@Service
public class TreeServiceImpl implements AppService {

	private static final Logger logger = LogManager.getLogger(TreeServiceImpl.class);

	private com.sl.api.admin.repository.TreeRepository treeRepository;
	
	public TreeServiceImpl(TreeRepository treeRepository) {
		this.treeRepository = treeRepository;
	}
	
	@Override
	public TreeDTO save(TreeDTO dto) {
		Tree tree = new Tree(dto);
		logger.info("save={}", dto);
		var sec = new TreeDTO(treeRepository.save(tree)); 
		return sec;
	}

	@Override
	public List<TreeDTO> findAll() {
		List<TreeDTO> dtos = new ArrayList<>();
		List<Tree> trees = treeRepository.findAll();
		for (Tree tree : trees) {
			TreeDTO dto = new TreeDTO(tree);
			dtos.add(dto);
		}
		return dtos;
	}

}
