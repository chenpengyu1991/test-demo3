define(function(){
	function load(){
		$(function(){
			//分页绑定函数
			pageUtil.bind("info_records",search);
			search(1);
			$("#form_search").onEnter(search, 1);
			$("#serviceInfoSearchBut").click(function() {
				search(1);
			});
			$("#add").click(function() {
				add();
			});
			$("#servicefInfoSearchSpanId").click(function(){
				toggle(this,'serviceInfoSearchTableId');
			});
			$("#infoType").change(getchild);
		});
	};
	
	function getchild(callback){
		var selectValue=$("#infoType").val();
    	$.getJsonByUrl({
			url : contextPath + "/lhserviceInfo/infoTypeChildren",
			param : {
				id : selectValue,
			},
			callback : function(model) {
				var detailType=$("#detailType");
				if(model.success){
					var infoTypeChildren=model.infoTypeChildren;
						detailType.empty();
						detailType.append("<option value=''>请选择类别</option>");
					if(null!=infoTypeChildren&&infoTypeChildren.length>0){
						for(var i=0;i<infoTypeChildren.length;i++){
							detailType.append("<option value='"+infoTypeChildren[i].id+"'>"+infoTypeChildren[i].name+"</option>");
						}
					}
				}else{
					detailType.empty();
					detailType.append("<option value=''>请选择类别</option>");
				}
			}
		});
	}
    	
	function search(indexPage){
		var createBegin = new Date($("#beginTime").val());
		var createEnd = new Date($("#endTime").val());

		if(!checkDate(createBegin,createEnd,"创建")){
			return;
		}
		
		var searchObj = {
				url :"/lhserviceInfo/list",
				insertDiv : "info_records",
				param : {
					indexPage : indexPage
				},
				callback : function(){
					/*为info_records中a的添加click事件*/
	            	initLinkClick('loadInfoService',loadInfoService, {id:"data-recordId"});
	            	initLinkClick('modifyInfoService',modifyInfoService, {id:"data-recordId"});
	            	initLinkClick('publish',publish, {id:"data-recordId"});
					initLinkClick('unpublish',unpublish, {id:"data-recordId"});
	            	initLinkClick('deleteInfoService',deleteInfoService, {id:"data-recordId"});
				}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	
	function add(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/lhserviceInfo/edit",
				insertDiv : "operationDiv",
				param : {
					operatorType : "3"
				}
		};
		$.loadHtmlByUrl(option);
		$("#operationDiv").show();
	};
	
	function loadInfoService(id){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/lhserviceInfo/edit",
				insertDiv : "operationDiv",
				param : {
					id : id,
					operatorType : "1"
				}
		};
		$.loadHtmlByUrl(option);
		$("#operationDiv").show();
	}
	
	function modifyInfoService(id){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/lhserviceInfo/edit",
				insertDiv : "operationDiv",
				param : {
					id : id,
					operatorType : "2"
				}
		};
		$.loadHtmlByUrl(option);
		$("#operationDiv").show();
	}
	
	function publish(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认该记录通过审核？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/lhserviceInfo/status",
					param : {
						id : id,
						operation : "publish"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("审核成功！", {icon:0,title:'提示'}, function(index2) {
								search($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("审核失败！", {icon:0,title:'提示'}, function(index2) {
							search($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function unpublish(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认撤销该记录？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/lhserviceInfo/status",
					param : {
						id : id,
						operation : "unpublish"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("撤销成功！", {icon:0,title:'提示'}, function(index2) {
								search($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("撤销失败！", {icon:0,title:'提示'}, function(index2) {
							search($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function deleteInfoService(id){
		if (id) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('删除服务信息，确认删除？', {icon:2, title:'确认提示'}, function(index){
					var deleteDetail = {
							url : "/lhserviceInfo/delete",
							param : {
								id : id,
							},
							callback : function(data) {
								if (data == "1") {
									layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
										search($("#currentPage").val());
										layer.close(index2);
									});
									return;
								}
								layer.alert("删除失败！", {icon:0,title:'提示'}, function(index2) {
									search($("#currentPage").val());
									layer.close(index2);
								});
							}
						};
						$.getJsonByUrl(deleteDetail);
					layer.close(index);
				});
			});
		}
	}
	
	 function checkDate(startDate,endDate,desp){
			if(startDate && endDate && new Date(startDate) > new Date(endDate)){
				layui.use('layer', function() {
					var layer = layui.layer;
					layer.alert(desp + "开始时间不能大于" + desp + "结束时间！", {icon:0,title:'提示'});
				});
				return false;
			}
			return true;
		}
	 
	return{
		load : load,
		search : search
	};
});