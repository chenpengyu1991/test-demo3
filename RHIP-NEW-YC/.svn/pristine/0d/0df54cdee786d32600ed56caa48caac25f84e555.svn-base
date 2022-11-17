var frequentSearch = (function() {

	$(function(){
		//分页绑定函数
		pageUtil.bind("frequent_records",frequentSearch);
		frequentSearch(1);
		$("#form_search").onEnter(frequentSearch,1);
		$("#frequentSearchBut").click(function() {
			frequentSearch(1);
		});
		$("#frequentSearchSpanId").click(function(){
			toggle(this,'frequentSearchTable');
		});
	});

	function frequentSearch (indexPage) {
		var searchObj = {
			url : "/frequent/list",
			insertDiv : "frequent_records",
			param : {
				indexPage : indexPage
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	
	function viewFrequent (id){
		$("#top_allLink").hide();
			var option = {
					url : "/frequent/showFrequent",
					insertDiv : "frequentDetails",
					param : {
						id : id
					}
			};
		$.loadHtmlByUrl(option);
		$("#frequentDetails").show();
	}
	
	
	function enableReserveFrequent (id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认启用预约该记录？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/frequent/status",
					param : {
						id : id,
						operation : "enableReserve"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("启用成功！", {icon:0,title:'提示'}, function(index2) {
								frequentSearch($("#currentPage").val())
								layer.close(index2);
							});	
							return;
						}
						layer.alert("启用失败！", {icon:0,title:'提示'}, function(index2) {
							frequentSearch($("#currentPage").val())
							layer.close(index2);
						});	
					}
				});
				layer.close(index);
			});
		});
	}
	
	function disableReserveFrequent (id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认禁用预约该记录？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/frequent/status",
					param : {
						id : id,
						operation : "disableReserve"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("禁用成功！", {icon:0,title:'提示'}, function(index2) {
								frequentSearch($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("禁用失败！", {icon:0,title:'提示'}, function(index2) {
							frequentSearch($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function deleteFrequent (id){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('是否彻底删除此项？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/frequent/delete",
					param : {
						id : id
					},
					callback : function(){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
							frequentSearch($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}

	
	return {
		frequentSearch : frequentSearch,
		viewFrequent:viewFrequent,
		enableReserveFrequent:enableReserveFrequent,
		disableReserveFrequent:disableReserveFrequent,
		deleteFrequent:deleteFrequent
	};
})();