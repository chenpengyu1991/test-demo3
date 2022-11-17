var villageAdd  = (function() {
	$(function() { 
		 getVillages();
		 $("#btnMerge").click(mergeDialog);
        //if($("#organinitdivid").parents('div').attr('id')=="tagContent2"){
        //    $("#hiddenBtn").hide();
        //}else{
        //    $("#hiddenBtn").show();
        //}
	});
	
	function mergeDialog() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getCheckedNodes(true); //获取被选中的id
		var checkCount = nodes.length;
		var orgCodes = '';
		var i = 1;
		if(checkCount < 2) {
			layer.alert("请选择至少两个机构进行合并！", {icon:0,title:'提示'});
			return;
		}
		for(var node in nodes){ 
			orgCodes = orgCodes + nodes[node].id;
			if(i< checkCount) {
				orgCodes = orgCodes + ',';
			}
			i++;
		 } 
		
		var dialogParams = {
				id : "mergeDialog",
				url : "/mdmOrganization/initMergeDialog",
                wait : true,
				height : 500,
				width : 800,
				title : "机构合并机构",
				param:{ orgCodes: orgCodes}
		};
		$.dialog(dialogParams);
	}
	
	function saveRelation() {
		var orgCodes = $("#orgCodes").val();
		var villageCode = $("input[name='villageCodes']:checked").val();
		if($.isEmpty(orgCodes)) {
			layer.alert("至少选择一个卫生服务站！", {icon:0,title:'提示'});
			return;
		}
		if($.isEmpty(villageCode)) {
			layer.alert("至少选择一个行政村！", {icon:0,title:'提示'});
			return;
		}
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("你确定要修改吗？", {icon:1, title:'确认提示'}, function(index){
				$("#adminForm").submitFormGetJson({
					url : "/mdmOrganization/area/saveRelation",
	                wait : true,
					 callback:function(data){
						 if(data.indexOf('success') > -1) {
							 layer.alert("保存成功！", {icon:0,title:'提示'});
						 } else {
							 layer.alert("保存失败！", {icon:0,title:'提示'});
						 }
					 },
					 param : {
						 organCode: $("#orgCodes").val()
			            }
				});
				layer.close(index);
			});
		});		
	}
	
	function getVillages() {
        var tag = $("#tag").val();
        var url = '/mdmOrganization/area/getVillages';
/*        if("tag1" == tag){
            url = '/mdmOrganization/area/getVillages'
        }
        if("tag2" == tag){
            url = '/mdmOrganization/area/getVillagesHistory'
        }*/
        $.loadHtmlByUrl({
            url : url,
            insertDiv :"listDiv",
            param : {
                townCode: $("#townCode").val()
            }
        });
		};
		
	function closePopUp(dialogId){
        $.removeDialog (dialogId);
    }
	
	function mergeOrganization() {
		//alert($("select[name='newCode']").find("option:selected").val());
		validate = $("#organizationForm").easyValidate();
		if (validate.validateForm()) {
			$("#organizationForm").submitFormGetJson({
				url : '/mdmOrganization/mergeOrganization',
				wait: true,
				callback : submitCallback
			});
		}
	}
	
	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.result) {
			 getVillages();
        	 tree.initTree();
             closePopUp('mergeDialog');
		}
	}
	/**
	 * 查看地区详情
	 * @param itemCode
	 * @param year
	 */
	function popupAreaInfo(year) {
		var genreCode = $("#genreCode").val();
		var townCode = $("#orgCodes").val();
		if($.isEmpty(townCode) || '1' == townCode){
			layer.alert("请选择机构！", {icon:0,title:'提示'});
			return;
		}
		if($.isEmpty(genreCode)) {
			/*var dialogObj = {
				url: "/administrative/areaInfo",
				height: 250,
				width: 400,
				title: "查看地区详情",
				id: "areaDialog",
				param: {townCode: townCode, year: year}
			};
			$.dialog(dialogObj);*/
			
			$.post(contextPath+'/administrative/areaInfo',
					{
	        	     townCode: townCode,year:year
					},
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'areaDialog',
		        			  area: ['400px', '250px'],
		        			  title:"查看地区详情",
		        			  content: ret
		        		  });
		        	});
		}else{
			var organId = $("#orgId").val();
			/*var dialogParams = {
				id : "d1",
				url : "/mdmOrganization/view",
				param : {
					organId : organId
				},
				height : 360,
				width : 800,
				title : "查看机构"
			};
			$.dialog(dialogParams);*/
			

			$.post(contextPath+'/mdmOrganization/view',
					{
				    organId : organId
					},
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'viewAreaOrganizationDialog',
		        			  area: ['800px', '375px'],
		        			  title:"查看机构",
		        			  content: ret
		        		  });
		        	});
		}
	}
	return {
        saveRelation: saveRelation,
        closePopUp: closePopUp,
        mergeOrganization: mergeOrganization,
		popupAreaInfo:popupAreaInfo
	};
})();

//快捷键show ctrl+shift+<- =======快捷键hide ctrl+shift+->
$(document).keydown(function(e){
if(e.which == 37&&e.shiftKey&&e.ctrlKey) {
    if($("#organinitdivid").parents('div').attr('id')=="tagContent2") {
        $("#hiddenBtn").hide();
    }else {
        $("#hiddenBtn").show();
    }
}
if(e.which == 39&&e.shiftKey&&e.ctrlKey) {
$("#hiddenBtn").hide();
}
});