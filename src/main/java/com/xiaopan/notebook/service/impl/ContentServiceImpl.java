package com.xiaopan.notebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaopan.notebook.domain.Content;
import com.xiaopan.notebook.repository.ContentRepository;
import com.xiaopan.notebook.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	ContentRepository contentRepository;
	
	@Override
	public Content queryByTitleId(Long titleId) {
		return contentRepository.findByTitleId(titleId);
	}

}
