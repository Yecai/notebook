package com.xiaopan.notebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@RequestMapping("/list")
	public String noteList(Model model) {
		model.addAttribute("nav", "todo");
		return "index";
	}
}
