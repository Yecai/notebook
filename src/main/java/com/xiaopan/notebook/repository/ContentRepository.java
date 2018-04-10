package com.xiaopan.notebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.xiaopan.notebook.domain.Content;

public interface ContentRepository extends CrudRepository<Content, Long> {
	
	public Content findByTitleId(Long titleId);
}
