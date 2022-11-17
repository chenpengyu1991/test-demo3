define(function() {
	function load() {
		$(function() {
			//分页绑定函数
			pageUtil.bind("interaction_records",searchInteraction);
			searchInteraction(1);
			$("#form_search").onEnter(searchInteraction, 1);
			$("#interactionSearchBtn").click(function() {
				searchInteraction(1);
			});

	        $("#unitCancle").click(function() {
	            $.removeDialog("popuOrgDialog");
	        });

	        $("#reportcard-list-export-btn").click(function() {
	            exportList();
	        });

	        $("#interactionSearchSpanId").click(function() {
				toggle(this,'interactionSearchTableId');
			});
	        
		});
	}
	
	function searchInteraction(indexPage) {
		var submitDateBegin = new Date($("#beginTime").val());
		var submitDateEnd = new Date($("#endTime").val());
		
		if(!checkDate(submitDateBegin,submitDateEnd,"发布")) {
			return;
		}
		var url = contextPath + "/interaction/list";
		var searchObj = {
			url : url ,
			insertDiv : "interaction_records",
			param : {
				indexPage : indexPage
			},
            callback : function() {
            	/*为interaction_records中a的添加click事件*/
            	initLinkClick('acceptInteraction',acceptInteraction, {id:"data-recordId"});
            	initLinkClick('viewInteraction',viewInteraction, {id:"data-recordId"});
            	initLinkClick('modifyInteraction',modifyInteraction, {id:"data-recordId"});
            	initLinkClick('popuOrgSelect',popuOrgSelect, {id:"data-recordId"});
            	initLinkClick('retreatInteraction',retreatInteraction, {id:"data-recordId"});
            	initLinkClick('deleteInteraction',deleteInteraction, {id:"data-recordId"});
            }
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	
	function exportList() {
        var option={
            url:"/cdm/reportcard/listExcel",
            param:{}
        };
        $("#form_search").exportListExcel(option);
    }
	
	function acceptInteraction(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认接受该记录？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/interaction/status",
					param : {
						id : id,
						operation : "accept"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("接受成功！", {icon:0,title:'提示'}, function(index2) {
								searchInteraction($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("接受失败！", {icon:0,title:'提示'}, function(index2) {
							searchInteraction($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});	
	}
	
	function viewInteraction(id){
		$("#searchDiv").hide();
		var option = {
				url : "/interaction/edit",
				insertDiv : "interactionDiv",
				param :{
					id : id,
					operatorType:'1'
				}
		};
		$.loadHtmlByUrl(option);
		$("#interactionDiv").show();
	}
	
	function modifyInteraction(id){
		$("#searchDiv").hide();
		var option = {
				url : "/interaction/edit",
				insertDiv : "interactionDiv",
				param :{
					id : id,
					operatorType:'2'
				}
		};
		$.loadHtmlByUrl(option);
		$("#interactionDiv").show();
	}
	
	function retreatInteraction(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认退回该记录？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/interaction/status",
					param : {
						id : id,
						operation : "retreat"
					},
					callback : function(data, status) {
						if (data == "1") {
							layer.alert("退回成功！", {icon:0,title:'提示'}, function(index2) {
								searchInteraction($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("退回失败！", {icon:0,title:'提示'}, function(index2) {
							searchInteraction($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function deleteInteraction(id){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('是否彻底删除此项？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/interaction/delete",
					param : {
						id : id
					},
					callback : function(){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
							searchInteraction($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});	
	}
	
	function popuOrgSelect(id) {
	    var popuOrgDialog = {
	            url : "/interaction/unitSearch",
	            height : 200,
				weight : 30,
				width : "50%",
	            title : "转交单位选择" ,
	            id :"popuOrgDialog",
            	param:{
            		id : id
            	}	            
	        };
		$.dialog(popuOrgDialog);		
    };
    
	function checkDate(startDate,endDate,desp){
		if(startDate && endDate && new Date(startDate) > new Date(endDate)){
			layer.alert(desp + "开始时间不能大于" + desp + "结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}

	return{
		load : load,
		searchInteraction : searchInteraction
	};
});
