package com.xiaopan.notebook.service;

import java.util.List;
import java.util.Map;

import com.xiaopan.notebook.domain.Title;

public interface TitleService {

	List<Map<String, Object>> queryAllTitles();

	Title queryById(Long titleId);
	
}
