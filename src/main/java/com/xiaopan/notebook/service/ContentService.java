package com.xiaopan.notebook.service;

import com.xiaopan.notebook.domain.Content;

public interface ContentService {

	Content queryByTitleId(Long titleId);
	
}
