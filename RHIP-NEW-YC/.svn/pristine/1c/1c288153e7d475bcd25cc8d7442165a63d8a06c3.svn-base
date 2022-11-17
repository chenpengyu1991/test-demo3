var deathMedicineCertificateSearch = (function() {
	
	$(function(){
		$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e){
			e.preventDefault();
			search(1);
		});
		$("#lifeEventAdd").click(function(e){
			e.preventDefault();
			add();
		});
		search(1);
	});
	
    function search(indexPage) {
    	
		var url = "/life/deathMedicineCertificate/search";
		var searchObj = {
			 url : url,
			 insertDiv : "resultDiv",
			 param : {indexPage : indexPage}
		 };
		$("#searchForm").formPost(searchObj);
	}

	function view(id){
		$.post(contextPath+'/life/deathMedicineCertificate/view',
        		{ id:id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'deathMedicineCertificateDialog',
        			  area: ['750px', '550px'],
        			  title:'死亡医学证明',
        			  content: ret
        		  });
        		});
        	});
	}

	function del(id){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("提示：确认删除？", {icon:2, title:'确认提示'}, function(){
				var option = {
						url : contextPath + "/life/deathMedicineCertificate/delete",
						wait: true,
						param : {"id":id},
						callback : function(result) {
							if(result){
								layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
									layer.closeAll();
									search($("#pageIndex").val());
								});
							}else{
								layer.alert("删除失败！", {icon:0,title:'提示'});
							}
							
						}
					};
					$.getJsonByUrl(option);
				});
		});
	}

	function add(){
        $("#search").hide();
        $("#detailDivId").show();
		var followupStatus = $("#followupStatus").val();
		var loadHtmlByUrlOption = {
			url :  "/life/deathMedicineCertificate/add",
			insertDiv : "detailDivId"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	function update(id){
        $("#search").hide();
        $("#detailDivId").show();
		var loadHtmlByUrlOption = {
			url :  "/life/deathMedicineCertificate/update",
			insertDiv : "detailDivId",
			param : {id : id}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	function cancel(){
    	layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("提示：结案时会连带所有业务系统内容注销。是否确认结案？", {icon:1, title:'确认提示'}, function(){
				var option = {
						url : contextPath + "/life/cancel",
						wait: true,
						callback : function(result) {
							layer.alert(result, {icon:0,title:'提示'}, function() {
								layer.closeAll();
								search($("#pageIndex").val());
							});
						}
					};
					$.getJsonByUrl(option);
				});
		});
    }

	return {
		search : search,
		view : view,
		add : add,
		cancel : cancel,
		del : del,
		update : update
	};
})();