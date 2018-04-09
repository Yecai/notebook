$(document).ready(function(){
	$("#addNote").bind("click", addNote);
	
	loadSidebarTree();
	
});

var loadSidebarTree = function() {
	var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};
	$.ajax({
		url : "/note/tree",
		cache : false,
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {},
		method : "GET",
		success : function(response) {
			if (response.code = '0') {
				var zNodes = response.data;
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			}
		},
		error : function() {
			
		}
	});
	
}

var addNote = function() {
	alert(1);
}