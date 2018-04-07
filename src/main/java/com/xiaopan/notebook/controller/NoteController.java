package com.xiaopan.notebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaopan.notebook.modal.Note;
import com.xiaopan.notebook.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@RequestMapping("/list")
	public String noteList(Model model) {
		List<Note> noteList = noteService.queryAllNotes();
		model.addAttribute("noteList", noteList);
		model.addAttribute("nav", "note");
		return "index";
	}
}
