$(document).ready(function() {
			searchTooltip();
			getRoleTree();
		});

/*---------list begin---------*/		
function searchTooltip() {
	elb.searchTooltip("#sName", "请输入角色");
	elb.searchTooltip("#sDescription", "请输入描述");
}

function detail(id) {
	var path = contextPath + "/role/update/" + id;
	window.location.href = path;
}

function goToAdd() {
	var path = contextPath + "/role/add";
	window.location.href = path;
}

function search(pageIndex) {
	var form = document.getElementById('roleFormId');
	form.action = contextPath + "/role/search?pageIndex=" + pageIndex;
	form.submit();
}
/*---------list end---------*/
/*---------add begin---------*/

function getRoleTree() {
	if ($("#tree1").length > 0) {
		$("#tree1").ligerTree({
					data : data,
					checkbox : true,
					nodeWidth : 250
				});
		manager = $("#tree1").ligerGetTreeManager();
		manager.collapseAll();
	}
}

function getChecked() {
	var nodes = manager.getChecked();
	if (nodes == null) {
		return;
	}
	var id = "";
	for (var i = 0; i < nodes.length; i++) {
		id += nodes[i].data.id + "," + nodes[i].data.pid + ",";
	}
	id = id.substring(0, id.lastIndexOf(','));
	return id;
}

function collapseAll() {
	manager.collapseAll();
}

function expandAll() {
	manager.expandAll();
}

function showAccess(id) {
	var path = contextPath + "/role/getRolesAccess/" + id;
	window.location.href = path;
}

function saveRole() {
	var menuIds = getChecked();
	/*
	 * if (menuIds == '') { alert("请选择权限"); return; }
	 */

	var form = document.getElementById('roleFormId');
	form.action = contextPath + "/role/save" + "?menuIds="
			+ menuIds;
	form.submit();
} 
 
/*---------add end---------*/