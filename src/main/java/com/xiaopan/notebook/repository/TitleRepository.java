package com.xiaopan.notebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.xiaopan.notebook.domain.Title;

public interface TitleRepository extends CrudRepository<Title, Long> {
	
	
}
