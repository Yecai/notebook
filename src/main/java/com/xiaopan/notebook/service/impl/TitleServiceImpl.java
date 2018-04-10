package com.xiaopan.notebook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaopan.notebook.common.TreeNode.TreeNodeBuilder;
import com.xiaopan.notebook.domain.Title;
import com.xiaopan.notebook.repository.TitleRepository;
import com.xiaopan.notebook.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
	TitleRepository titleRepository;
	
	@Override
	public List<Map<String, Object>> queryAllTitles() {
		List<Map<String, Object>> titles = new ArrayList<>();
		
		titleRepository.findAll().forEach(title -> {
			Map<String, Object> map = new TreeNodeBuilder().fromTitle(title).buildMap();
			titles.add(map);
		});
		
		Map<String, Object> root = new TreeNodeBuilder().id(0L).pId(-1L).name("notebook").open(true).buildMap();
		titles.add(root);
		return titles;
	}

	@Override
	public Title queryById(Long titleId) {
		return titleRepository.findById(titleId).get();
	}

}
