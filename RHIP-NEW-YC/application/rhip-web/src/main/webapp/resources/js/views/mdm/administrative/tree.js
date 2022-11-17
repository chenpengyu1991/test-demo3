var tree = (function() {
	$(function() {
		initTree();
	});
	
	function initTree() {
		var loadingImg = "<span><img src='" + contextPath + "/images/AjaxLoader16.gif' style='vertical-align:top;'/></span>";
		var loding =  $(loadingImg);
		$("#treeId").parent().append(loding);
		$("#treeDemo").hide();
		var setting = {
				check: {
					enable: true,
					nocheckInherit: true,
					chkboxType: { "Y": "s", "N": "s" }
				},
				callback : { //回调函数  
					onClick : zTreeOnClick   //单击事件
					},
				data: {
					simpleData: {enable: true}
				}
			};
		$.getJsonByUrl({
			 url : contextPath+"/administrative/getTowns",
			 callback:function(data){
				 //alert(data);
				$.fn.zTree.init($("#treeDemo"), setting, data);
				$("#treeDemo").show();
				$(loding).remove();
				$("#nocheckTrue").bind("click", {nocheck: true}, nocheckNode);
				$("#nocheckFalse").bind("click", {nocheck: false}, nocheckNode);
			 }
		});
	}
	
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
        $("#townCode").val(treeNode.id);
        $.loadHtmlByUrl({
            url : "/administrative/getVillages",
            insertDiv :"listDiv",
            param : {
                townCode: treeNode.id,
                selectYear:$('#selectYear').val()
            }
        });
	};
	return{
		initTree: initTree
	};
})();
