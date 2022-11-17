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
					chkboxType: { "Y": "", "N": "" }
				},
				callback : { //回调函数  
					onClick : zTreeOnClick   //单击事件  
					},
				data: {
					simpleData: {enable: true}
				}
			};

        var tag = $("#tag").val();
        var url = '/mdmOrganization/area/centres';
/*        if("tag1" == tag){
            url = '/mdmOrganization/area/centres'
        }
        if("tag2" == tag){
            url = '/mdmOrganization/area/centresHistory'
        }*/
		$.getJsonByUrl({
			 url : contextPath+url,
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
	   // alert(treeNode.id + ", " + treeNode.name);$("#orgCodes").val()
        var tag = $("#tag").val();
        var url = '/mdmOrganization/area/getVillages';
        /*if("tag1" == tag){
            url = '/mdmOrganization/area/getVillages'
        }
        if("tag2" == tag){
            url = '/mdmOrganization/area/getVillagesHistory'
        }*/
		$("#orgCodes").val(treeNode.id);
		$("#genreCode").val(treeNode.genreCode);
		$("#orgId").val(treeNode.orgId);
	    $.loadHtmlByUrl({
            url : url,
            insertDiv :"listDiv",
            param : {
            	organCode: treeNode.id,
				selectYear:$('#selectYear').val()
            }
        });
	};
	return{
		initTree: initTree
	};
})();
