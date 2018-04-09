package com.xiaopan.notebook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaopan.notebook.domain.AjaxResponse;
import com.xiaopan.notebook.service.TitleService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private TitleService titleService;

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("nav", "note");
		return "index";
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public AjaxResponse tree() {
//		data.add(getTreeNode("1","0","分类1",true, true));
//		data.add(getTreeNode("11","1","note1",null, null));
//		data.add(getTreeNode("12","1","note2",null, null));
//		data.add(getTreeNode("2","0","分类2",null, true));
//		data.add(getTreeNode("21","2","note3",null, null));
//		data.add(getTreeNode("3","0","分类3",true, true));
		return new AjaxResponse(0, "", titleService.queryAllTitles());
	}

	private Map<String, Object> getTreeNode(String id, String pid, String name, Boolean open, Boolean isParent) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pId", pid);
		map.put("name", name);
		if (null != open) {
			map.put("open", open);
		}
		if (null != isParent) {
			map.put("isParent", isParent);
		}
		return map;
	}
}
