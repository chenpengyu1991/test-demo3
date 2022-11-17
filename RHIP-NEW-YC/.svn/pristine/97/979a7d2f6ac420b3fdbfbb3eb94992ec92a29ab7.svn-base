var treeParent = (function() {
	$(function() {
		var setting = {
				callback : { //回调函数  
					onClick : zTreeOnClick   //单击事件  
					},
				data: {
					simpleData: {enable: true}
				}
			};

		$.getJsonByUrl({
			 url : contextPath+"/mdmOrganization/treeParent",
			 callback:function(data){
				 $.fn.zTree.init($("#treeParent"), setting, data);
				$("#nocheckTrue").bind("click", {nocheck: true}, nocheckNode);
				$("#nocheckFalse").bind("click", {nocheck: false}, nocheckNode);
			 }
		});
	});
	
	function nocheckNode(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nocheck = e.data.nocheck,
		nodes = zTree.getSelectedNodes();
		if (nodes.length == 0) {
			alert("请先选择一个节点");
		}

		for (var i=0, l=nodes.length; i<l; i++) {
			nodes[i].nocheck = nocheck;
			zTree.updateNode(nodes[i]);
		}
	}
	
	function zTreeOnClick(event, treeId, treeNode) {
	   // alert(treeNode.id + ", " + treeNode.name);
		$("#hidden_parentCode").val(treeNode.id);
		$("#label_parentName").html(treeNode.name);
	};
})();
