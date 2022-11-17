

function detail(roleId) {
	var path = contextPath + "/role/update/" + roleId;
	window.location.href = path;
}

function goToAdd() {
	var path = contextPath + "/role/add";
	window.location.href = path;
}

/*---------list end---------*/
/*---------add begin---------*/

function getRoleTree() {
	if ($("#tree1").length > 0) {
		$("#tree1").ligerTree({
					data : menuData,
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
	
	$.postRepeat(contextPath + "/role/save", $("#roleFormId").serialize(),  function(data){
		if(data == "1"){
			var path = contextPath + "/role/searchFromUpdate";
			window.location.href = path;
		}else{
			$("#msgOK").hide();
			$("#msgError").show();
			$("#msgError").html(data);
		}
		goTop();
	},"html","menuIds=" + menuIds);
	
}
/*---------add end---------*/