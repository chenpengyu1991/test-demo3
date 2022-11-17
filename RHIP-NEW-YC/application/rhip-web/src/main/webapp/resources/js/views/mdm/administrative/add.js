var villageAdd  = (function() {
	$(function() { 
		 //getVillages();
        //if($("#admininitdivid").parents('div').attr('id')=="tagContent2"){
        //    $("#hiddenBtn").hide();
        //}else{
        //    $("#hiddenBtn").show();
        //}
		
		$("#mergeButton").click(function(e) {
			e.preventDefault();
			saveVillage();
		});
		
		$("#mergeCancelButton").click(function(e) {
			e.preventDefault();
			layer.closeAll();
		});
	});
	
	function popup(itemCode) {
        var selectYear = $("#selectYear").val();
       /* var dialogObj = {
				url : "/administrative/village/add",
	            height : 300,
	            width : 500,
	            title : "添加或修改行政村",
	            id :"villageDialog",
	            param:{ itemCode: itemCode,selectYear:selectYear}
		};
		$.dialog(dialogObj);*/
		
		$.post(contextPath+'/administrative/village/add',
				{
				 itemCode: itemCode,selectYear:selectYear
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'villageDialog',
	        			  area: ['500px', '300px'],
	        			  title:"添加或修改行政村",
	        			  content: ret
	        		  });
	        	});
	}

    function popupView(itemCode) {
        var selectYear = $("#selectYear").val();
       /* var dialogObj = {
            url : "/administrative/village/view",
            height : 300,
            width : 500,
            title : "查看行政村",
            id :"villageDialog",
            param:{ itemCode: itemCode,selectYear:selectYear}
        };
        $.dialog(dialogObj);*/
        
        $.post(contextPath+'/administrative/village/view',
				{
        	   itemCode: itemCode,selectYear:selectYear
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'villageDialog',
	        			  area: ['500px', '300px'],
	        			  title:"查看行政村",
	        			  content: ret
	        		  });
	        	});
    }

	function mergeDialog() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getCheckedNodes(true); //获取被选中的id
		var checkCount = nodes.length;
		var townCode = '';
		var i = 1;
		if(checkCount < 2) {
			layer.alert("请选择至少两个行政单位！", {icon:0,title:'提示'});
			return;
		}
		for(var node in nodes){ 
			townCode = townCode + nodes[node].id;
			if(i< checkCount) {
				townCode = townCode + ',';
			}
			i++;
		 } 
		
		/*var dialogObj = {
				url : "/administrative/initMergeDialog",
                wait : true,
                height : 300,
	            width : 500,
	            title : "合并行政单位",
	            id :"mergeDialog",
	            param:{ townCodes: townCode}
		};
		$.dialog(dialogObj);*/
		
		$.post(contextPath+'/administrative/initMergeDialog',
				{
				townCodes: townCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'mergeDialog',
	        			  area: ['500px', '300px'],
	        			  title:"合并行政单位",
	        			  content: ret
	        		  });
	        	});
	}
	
	function mergeTown() {
		validate = $("#mergeTownForm").easyValidate();
		if (validate.validateForm()) {
			$("#mergeTownForm").submitFormGetJson({
				url : '/administrative/mergeTown',
				wait : true,
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                    layer.alert("保存失败！", {icon:0,title:'提示'});
	                } else if(data.indexOf("exist") > -1) {
	                	 layer.alert("编码已存在，请核实后保存！", {icon:0,title:'提示'});
	                } else {
	                	 layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	                		 layer.closeAll();
	                		 getVillages();
	                		 tree.initTree();
	                	 });
	                }
	            }
			});
		}
	}
	
	function saveVillage() {
		validate = $("#addVillageForm").easyValidate();
		if (validate.validateForm()) {
			$("#addVillageForm").submitFormGetJson({
				url : '/administrative/village/save',
				wait : true,
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                    layer.alert("保存失败！", {icon:0,title:'提示'});
	                } else if(data.indexOf("exist") > -1) {
	                	 layer.alert("编码已存在，请核实后保存！", {icon:0,title:'提示'});
	                } else {
	                	 layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	                		 layer.closeAll();
	                		 getVillages();
	                		 tree.initTree();
	                	 });
	                }
	            }
			});
		}
	}
	
	function updateVillage() {
		validate = $("#addVillageForm").easyValidate();
		if (validate.validateForm()) {
			$("#addVillageForm").submitFormGetJson({
				url : '/administrative/village/update',
				wait : true,
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                    layer.alert("修改失败！", {icon:0,title:'提示'});
	                }else {
	                    layer.alert("修改成功！", {icon:0,title:'提示'}, function() {
	                    	layer.closeAll();
	                    	getVillages();
	                    	tree.initTree();
	                    });
	                }
	            }
			});
		}
	}
	
	function deleteVillage(itemCode) {
			layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					 url : "/administrative/village/delete",
					 callback:function(data){
						 if(data.indexOf('success') > -1) {
							 layer.alert("删除成功！", {icon:0,title:'提示'});
						 } else {
							 layer.alert("删除失败！", {icon:0,title:'提示'}, function() {
								 layer.closeAll();
								 getVillages();
								 tree.initTree();
							 });
						 }
					 },
					 wait : true,
					 param:{ itemCode: itemCode}
				});
				layer.close(index);
			});
	}
	
	function saveRelation() {
		var townCode = $("#townCode").val();
		var villageCode = $("input[name='villageCodes']:checked").val();
		if($.isEmpty(townCode) || $.isEmpty(villageCode)) {
			layer.alert("至少选择一个镇或行政村！", {icon:0,title:'提示'});
			return;
		}
			layer.confirm("你确定要修改吗？", {icon:1, title:'确认提示'}, function(index){
				$("#adminForm").submitFormGetJson({
					url : "/administrative/saveRelation",
					wait : true,
					 callback:function(data){
						 if(data.indexOf('success') > -1) {
							 layer.alert("保存成功！", {icon:0,title:'提示'});
						 } else {
							 layer.alert("保存失败！", {icon:0,title:'提示'});
						 }
					 },
					 param : {
			            	townCode: townCode
			            }
				});
				layer.close(index);
			});
	}
	
	function getVillages() {
		    $.loadHtmlByUrl({
	            url : "/administrative/getVillages",
	            insertDiv :"listDiv",
	            param : {
	            	townCode: $("#townCode").val()
	            }
	        });
		};
		
	function closePopUp(dialogId){
        $.removeDialog (dialogId);
    }
    /**
     * 查看地区详情
     * @param itemCode
     * @param year
     */
    function popupAreaInfo(year) {
        var townCode = $("#townCode").val();
        if($.isEmpty(townCode)){
            layer.alert("请选择地区(镇)！", {icon:0,title:'提示'});
            return;
        }
        /*var dialogObj = {
            url : "/administrative/areaInfo",
            height : 250,
            width : 400,
            title : "查看地区详情",
            id :"areaDialog",
            param:{ townCode: townCode,year:year}
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
    }
	/*function isShow() {
		var newCode = $("#newCode").val();
		if($.isEmpty(newCode)) {
			$("#").show();
		} else
	}*/
	return {
		saveVillage: saveVillage,
        updateVillage: updateVillage,
        deleteVillage: deleteVillage,
        popup: popup,
        popupView:popupView,
        popupAreaInfo:popupAreaInfo,
        closePopUp: closePopUp,
        saveRelation: saveRelation,
        mergeDialog:mergeDialog,
        mergeTown: mergeTown
	};
})();

//快捷键show ctrl+shift+<- =======快捷键hide ctrl+shift+->
$(document).keydown(function(e){
if(e.which == 37&&e.shiftKey&&e.ctrlKey) {
    if($("#admininitdivid").parents('div').attr('id')=="tagContent2") {
        $("#hiddenBtn").hide();
    }else{
        $("#hiddenBtn").show();
    }
}
if(e.which == 39&&e.shiftKey&&e.ctrlKey) {
$("#hiddenBtn").hide();
}
});