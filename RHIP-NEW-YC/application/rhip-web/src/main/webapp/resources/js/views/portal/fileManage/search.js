define(function() {
	
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDivFile",searchFile);
			searchFile(1);
			$("#fileFormId").onEnter(searchFile, 1);
			$("#fileSearchBut").click(function() {
				searchFile(1);
			});
			
			$("#fileAddButId").click(function(){
				add(0);
			});
			$("#fileSearchSpanId").click(function(){
				toggle(this,'fileSearchTableId');
			});
		});
	}
	
    function searchFile(indexPage) {
		var url = contextPath + "/fileManager/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDivFile",
				 param : {indexPage : indexPage},
				callback: function() {
					/*为listDiv中a的添加click事件*/
					initLinkClick('viewFile',view, {fileId:"data-fileId"});
					initLinkClick('unpublishFile',unpublish, {fileId:"data-fileId"});
					initLinkClick('modifyFile',add, {fileId:"data-fileId"});
					initLinkClick('deleteFile',delFile, {fileId:"data-fileId"});
					initLinkClick('publishFile',publishFile, {fileId:"data-fileId",fileIdStatus:"data-status"});
				}
			 };
		$("#fileFormId").formPost(searchObj);
	
	}
	
    function add(fileId) { 
		$("#top_allFile").hide();
		$.loadHtmlByUrl({
			url : "/fileManager/add",
			insertDiv :"detailDivFile",
            wait : true,
			param : {
				fileId: fileId
			}
		});
		$("#detailDivFile").show();
	};
	function view(fileId) { 
		$("#top_allFile").hide();
		$.loadHtmlByUrl({
			url : "/fileManager/view",
			insertDiv :"detailDivFile",
            wait : true,
			param : {
				fileId: fileId
			}
		});
		$("#detailDivFile").show();
	};
	function publishFile(fileId, fileIdStatus ) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认该记录通过审核？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : contextPath + "/fileManager/publish",
					callback:function(data){
						if (data == "success") {
							searchFile($("#currentPage").val());
							layer.alert("审核成功！", {icon:0,title:'提示'});
						} else if (data == "fail") {
							layer.alert("审核失败！", {icon:0,title:'提示'});
						}else {
							var errors = parseJson(data);
							$("#msgError").html(errors);
							$("#msgOK").hide();
							$("#msgError").show();
						}
					},
					param:{
						fileId: fileId,
						fileIdStatus: fileIdStatus
					}
				});
				layer.close(index);
			});
		});
	}
	
	function unpublish(fileId) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认撤销该记录？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : contextPath + "/fileManager/unpublish",
					param : {
						fileId: fileId,
					},
					callback : function(data) {
						if (data == "success") {
							searchFile($("#currentPage").val());
							layer.alert("撤销成功！", {icon:0,title:'提示'});
						} else if (data == "fail") {
							layer.alert("撤销失败！", {icon:0,title:'提示'});
						}else {
							var errors = parseJson(data);
							$("#msgError").html(errors);
							$("#msgOK").hide();
							$("#msgError").show();
						}
					}
				});
				layer.close(index);
			});
		});
	}

	function delFile(fileId) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('您确认要删除吗?', {icon:2, title:'确认提示'}, function(index){
				deleteDo(fileId);
				layer.close(index);
			});
		});
	}
	
	function deleteDo(fileId){
		$.getJsonByUrl({
	    	url : contextPath + "/fileManager/delete",
            callback:function(data){
    			if (data == "success") {
    				searchFile($("#currentPage").val());
    				layui.use('layer', function() {
    					var layer = layui.layer;
    					layer.alert("删除成功！", {icon:0,title:'提示'});
    				});
    			} else if (data == "fail") {
    				layui.use('layer', function() {
    					var layer = layui.layer;
    					layer.alert("删除失败！", {icon:0,title:'提示'});
    				});
    			}else {
    			    var errors = parseJson(data);
    				$("#msgError").html(errors);
    				$("#msgOK").hide();
    				$("#msgError").show();
    			}
    		},
	    	param:{
	    		fileId:fileId
	    	}
	     });
	}
	function closeFunc(){
		$("#orgCreate").get(0).selectedIndex = 0;
		$("#msgError").hide();
	}
    return{
    	load: load,
    	searchFile: searchFile
    };
});
