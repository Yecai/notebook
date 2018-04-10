package com.xiaopan.notebook.common;

import java.util.HashMap;
import java.util.Map;

import com.xiaopan.notebook.domain.Title;

public class TreeNode {
	private Long id;
	private Long pId;
	private String name;
	private boolean open = false;
	private boolean drag = true;
	private boolean drop = true;
	
	public static class TreeNodeBuilder {
		private Long id;
		private Long pId;
		private String name;
		private Boolean open = false;
		private Boolean drag = true;
		private Boolean drop = true;
		
		public TreeNodeBuilder fromTitle(Title title) {
			this.id = title.getId();
			this.pId = title.getPid();
			this.name = title.getName();
			this.open = title.isOpen();
			return this;
		}
		public TreeNodeBuilder id(Long id) {
			this.id = id;
			return this;
		}
		public TreeNodeBuilder pId(Long pId) {
			this.pId = pId;
			return this;
		}
		public TreeNodeBuilder name(String name) {
			this.name = name;
			return this;
		}
		public TreeNodeBuilder open(Boolean open) {
			this.open = open;
			return this;
		}
		public TreeNodeBuilder drag(Boolean drag) {
			this.drag = drag;
			return this;
		}
		public TreeNodeBuilder drop(Boolean drop) {
			this.drop = drop;
			return this;
		}
		
		public Map<String, Object> buildMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("id", this.id);
			map.put("pId", this.pId);
			map.put("name", this.name);
			map.put("open", this.open);
			map.put("drag", this.drag);
			map.put("drop", this.drop);
			return map;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isDrag() {
		return drag;
	}

	public void setDrag(boolean drag) {
		this.drag = drag;
	}

	public boolean isDrop() {
		return drop;
	}

	public void setDrop(boolean drop) {
		this.drop = drop;
	}

	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", pId=" + pId + ", name=" + name + ", open=" + open + ", drag=" + drag
				+ ", drop=" + drop + "]";
	}
	
	
	
}

