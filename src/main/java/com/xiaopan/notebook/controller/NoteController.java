package com.xiaopan.notebook.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaopan.notebook.common.AjaxResponse;
import com.xiaopan.notebook.service.ContentService;
import com.xiaopan.notebook.service.TitleService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private TitleService titleService;

	@Autowired
	private ContentService contentService;

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("nav", "note");
		return "index";
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public AjaxResponse tree() {
		return new AjaxResponse(0, "", titleService.queryAllTitles());
	}
	
	@RequestMapping("/{titleId}")
	@ResponseBody
	public AjaxResponse content(@PathVariable(name="titleId", required=true) Long titleId) {
		Map<String, Object> data = new HashMap<>();
		data.put("title", titleService.queryById(titleId));
		data.put("content", contentService.queryByTitleId(titleId));
		return new AjaxResponse(0, "", data);
	}

}
