package com.xiaopan.notebook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaopan.notebook.modal.Note;
import com.xiaopan.notebook.repository.NoteRepository;
import com.xiaopan.notebook.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	public List<Note> queryAllNotes() {
		List<Note> noteList = new ArrayList<Note>();
		noteRepository.findAll().forEach(note -> {
			noteList.add(note);
		});
		return noteList;
	}
	
}
