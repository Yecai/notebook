package com.xiaopan.notebook.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			Map<String, Object> map = new HashMap<>();
			map.put("id", title.getId());
			map.put("pId", title.getPid());
			map.put("name", title.getName());
			map.put("open", title.isOpen());
			titles.add(map);
		});
		return titles;
	}

}
