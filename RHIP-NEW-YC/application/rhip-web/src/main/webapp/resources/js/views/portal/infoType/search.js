define(function(){
	function load(){
		$(function(){
			//分页绑定函数
			pageUtil.bind("infoType_records",search);
			search(1);
			$("#form_search").onEnter(search, 1);
			$("#infoTypeSearchBtn").click(function() {
				search(1);
			});
			$("#infoTypeAdd").click(function(){
				add();
			});
			$("#infoTypeSearchSpanId").click(function(){
				toggle(this,'infoTypeSearchTableId');
			});
		});
	}
	
	function search(indexPage){
		var searchObj = {
			url : "/lhinfoType/list",
			insertDiv : "infoType_records",
			param : {
				indexPage : indexPage
			},
            callback : function() {
            	/*为infoType_records中a的添加click事件*/
            	initLinkClick('loadSubInfoType',loadSubInfoType, {id:"data-recordId"});
            	initLinkClick('modifyInfoType',modifyInfoType, {id:"data-recordId"});
            	initLinkClick('deleteInfoType',deleteInfoType, {id:"data-recordId"});
            }
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	
	function loadSubInfoType(id){
		$("#section").hide();
		var option = {
				url : "/lhinfoType/subSearch",
				insertDiv : "subInfoType_search",
				param : {
					id : id,
					parentCode : id
				},
		};
		$.loadHtmlByUrl(option);
		$("#subInfoType_search").show();
	}
	
	function add(){
		var infoTypeDetails = {
				url : "/lhinfoType/add",
				id : "addDialog",
				height : 300,
				weight : 30,
				width : "50%",
				param : {
					operation : "1",
				},
				title : "新增服务信息类别"
			};
			$.dialog(infoTypeDetails);
	}
	
	function modifyInfoType(id){
		if (id) {
			var infoTypeDetails = {
				url : "/lhinfoType/modify",
				id : "addDialog",
				height : 300,
				weight : 30,
				width : "50%",
				param : {
					id : id,
				},
				title : "修改服务信息类别"
			};
			$.dialog(infoTypeDetails);
		}
	}
	
	function deleteInfoType(id){
		if (id) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('删除一级服务信息其下属信息也将被删除，确认删除？', {icon:2, title:'确认提示'}, function(index){
					var deleteDetail = {
						url : "/lhinfoType/delete",
						param : {
							id : id,
							deleteType : "1"
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
	
	return{
		load : load,
		search : search
	};
});