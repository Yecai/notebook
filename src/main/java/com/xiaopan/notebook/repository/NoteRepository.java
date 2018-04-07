package com.xiaopan.notebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.xiaopan.notebook.modal.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
	
	
}
