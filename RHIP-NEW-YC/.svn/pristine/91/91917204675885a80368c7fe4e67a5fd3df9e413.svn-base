define(['../infoType/search'],function(infoTypeSearch){
	function load(){
		$(function(){
			//分页绑定函数
			pageUtil.bind("subInfoType_records",search);
			search(1);
			$("#form_subSearch").onEnter(search, 1);
			$("#subSearchBtn").click(function() {
				search(1);
			});
			$("#subInfoTypeReturn").click(function(){
				returnSearch();
			});
			$("#subInfoTypeAdd").click(function(){
				add();
			});
			$("#subInfoTypeSearchSpanId").click(function(){
				toggle(this,'subInfoTypeSearchTable');
			});
		});
	}
	
	function search(indexPage){
		var url = contextPath + "/lhinfoType/subLists";
		var searchObj = {
			url : url ,
			insertDiv : "subInfoType_records",
			param : {
				indexPage : indexPage,
				parentCode : $("#parentCode").val(),
			},
            callback : function() {
            	/*为interaction_records中a的添加click事件*/
            	initLinkClick('modifySubInfoType',modifySubInfoType, {id:"data-recordId"});
            	initLinkClick('deleteSubInfoType',deleteSubInfoType, {id:"data-recordId"});
            }
		};
		$("#form_subSearch").submitFormLoadHtml(searchObj);
	}
	
	function add(){
		var subInfoType = {
				url : "/lhinfoType/add",
				id : "addDialog",
				height : 200,
				weight : 30,
				width : "50%",
				param : {
					parentCode : $("#parentCode").val(),
				},
				title : "新增服务信息名称"
			};
			$.dialog(subInfoType);
	}
	
	function modifySubInfoType(id){
			var infoTypeDetails = {
				url : "/lhinfoType/modify",
				id : "addDialog",
				height : 200,
				weight : 30,
				width : "50%",
				param : {
					id : id,
					parentCode : $("#parentCode").val()
				},
				title : "修改服务信息类别"
			};
			$.dialog(infoTypeDetails);
	}
	
	
	
	function deleteSubInfoType(id){
		if (id) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('删除服务信息，确认删除？', {icon:2, title:'确认提示'}, function(index){
					var deleteDetail = {
						url : "/lhinfoType/delete",
						param : {
							id : id
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
	
	function returnSearch(){
		if(contentChanged){
			msgUtil.backConfirm(function(){
				returnfunction();
			});
		} else {
			returnfunction();
		}
	}
	
    function returnfunction(){
        $("#subInfoType_search").empty();
        $("#section").show();
        infoTypeSearch.search($("#currentPage").val());
    }	
    
	return{
		load : load,
		search : search
	};
});