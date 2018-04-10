(function(){
	
	$(document).ready(function(){
		loadSidebarTree();
	});
})();



var loadSidebarTree = function() {
	var setting = {
			view: {
				addHoverDom: zTreeAddHoverDom,
				removeHoverDom: zTreeRemoveHoverDom,
				selectedMulti: false
			},
			data: {
				key: {
					title:"name"
				},
				simpleData: {
					enable: true
				}
			},
			edit: {
				enable: true
			},
			callback: {
				onClick : zTreeOnClick,
				beforeDrop: zTreeBeforeDrop,
				onRemove: zTreeOnRemove,
				onRename: zTreeOnRename
			}
		};
	ajaxGet("/note/tree", {}, function(response){
		if (response.code = '0') {
			var zNodes = response.data;
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}
	}, function(){});
}
var newCount = 1;
function zTreeAddHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
		+ "' title='add node' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_"+treeNode.tId);
	if (btn) btn.bind("click", function(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new note" + (newCount++)});
		return false;
	});
};
function zTreeRemoveHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.tId).unbind().remove();
};

var zTreeBeforeDrop = function(treeId, treeNodes, targetNode, moveType) {
	console.log(treeNodes);
}
var zTreeOnClick = function (event, treeId, treeNode, clickFlag) {
	ajaxGet("/note/" + treeNode.id, {}, function(response){
		if (response.code = '0') {
			var title = response.data.title;
			var content = response.data.content;
			var titleName = null == title? "" : title.name;
			$("#title").html(title.name); 
			var contentValue = null == content? "" : content.contents;

			$("#content").html(contentValue); 
		}
	}, function(){});
}
var zTreeOnRemove = function(event, treeId, treeNode) {
	console.log(event);
	console.log(treeId);
	console.log(treeNode);
}
var zTreeOnRename = function(event, treeId, treeNode, isCancel) {
	console.log(event);
	console.log(treeId);
	console.log(treeNode);
	console.log(isCancel);
}