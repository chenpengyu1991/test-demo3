var roleSearch = (function() {

    $(function(){
    	pageUtil.bind("listDiv",searchRole);
		searchRole(1);
		enterEven('searchRole','roleQueryForm','1');
		$("#roleButtonId").on("click", function(e){
			searchRole(1);
		});
		
		$("#roleSpanId").on("click", function(){
			toggle(this,'roleSearch');
		});
    });

var saveFlag = "${saveFlag}";
	
	function searchRole(indexPage) {
		var url = "/role/list";
		if(saveFlag != "1"){
			$("#msgError").hide();
			$("#msgOK").hide();
		}else{
			saveFlag = "0";
		}
		var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : { indexPage : indexPage}
			 };
		$("#roleQueryForm").formPost(searchObj);
	}

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
			//goTop();
		},"html","menuIds=" + menuIds);
		
	}

	
})();

