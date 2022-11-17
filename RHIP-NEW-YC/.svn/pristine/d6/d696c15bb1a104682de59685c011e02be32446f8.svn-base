var wsMonitorServiceRegisterSearch = (function() {
	
	$(function() {

		$("#serviceInfoAddBut").click(function (e) {
			e.preventDefault();
			add('');
		});
		$("#serviceInfoSaveBut").click(function (e) {
			e.preventDefault();
			save();
		});
		$("#serviceInfoBackBut").click(function (e) {
			e.preventDefault();
			back();
		});
		$("#serviceInfoSearchBut").click(function (e) {
			e.preventDefault();
			search(1);
		});
		$("#serviceInfoForm").onEnter(search, 1);
		search(1);

		var listDiv = $("#listDiv");
		listDiv.on("click", ".edit-link", add);
		listDiv.on("click", ".view-link", view);
		listDiv.on("click", ".delete-link", deleteService);
		listDiv.on("click", ".change-link", changeStatus);

	
	});

	function add() {
		var id = $(this).attr("data-id");
		var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/wsMonitor/serviceInfo/register/add",
			insertDiv :"detailDiv",
			param : {
				pageIndex: pageIndex,
				id: id
			}
		});
		detailButton();
	}

	function view() {
		var id = $(this).attr("data-id");
		var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/wsMonitor/serviceInfo/register/add",
			insertDiv :"detailDiv",
			param : {
				pageIndex: pageIndex,
				id: id
			}
		});
		detailButton();
		$("#serviceInfoSaveBut").hide();
	}

	function detailButton() {
		$("#serviceInfoAddBut").hide();
		$("#serviceInfoSaveBut").show();
		$("#serviceInfoBackBut").show();
		$("#searchDiv").hide();
		$("#listDiv").hide();
		$("#detailDiv").show();
	}

	function save() {
		validate = $("#serviceInfoAddForm").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		$("#serviceInfoAddForm").submitFormGetJson({
			url : "/wsMonitor/serviceInfo/register/save",
			callback: function(data) {
				
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			
	    			if(data.indexOf("success") > -1) {
	    				layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	    					layer.closeAll();
	    					back();
	    				});
	    			} else if (data.indexOf("fail") > -1) {
	    				layer.alert("保存失败！", {icon:0,title:'提示'});
	    			} else if (data.indexOf("exist") > -1) {
	    				layer.alert("wsdl地址已存在，请更换！", {icon:0,title:'提示'});
	    			} else if (data.indexOf("all") > -1) {
	    				layer.alert("接口名称(KEY)和wsdl地址均已存在，请更换！", {icon:0,title:'提示'});
	    			} else if (data.indexOf("serviceName") > -1) {
	    				layer.alert("接口名称(KEY)已存在，请更换！", {icon:0,title:'提示'});
	    			}
	    		});
			}
		});

	}

	function back() {
		$("#serviceInfoAddBut").show();
		$("#serviceInfoSaveBut").hide();
		$("#serviceInfoBackBut").hide();
		$("#searchDiv").show();
		$("#listDiv").show();
		$("#detailDiv").hide();
		search(1);
	}

	function changeStatus() {
		var id = $(this).attr("data-id");
		var serverStatus = $(this).attr("data-flag");

		var title  = "关闭"
		if(serverStatus == 1) {
			title = "开启";
		}
		/*msgUtil.confirm("你确认要"+ title +"此接口吗?", function () {
			$("#serviceInfoAddForm").submitFormGetJson({
				url : "/wsMonitor/serviceInfo/register/changeStatus",
				param : {
					id : id,
					serverStatus : serverStatus
				},
				callback: function(data) {
					layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			
    	    			if(data.indexOf("success") > -1) {
    	    				layer.alert(title + "成功！", function() {
    	    					layer.closeAll();
    	    					back();
    	    				});
    	    			}else if (data.indexOf("fail") > -1) {
    	    				msgUtil.alert(title + "失败！");
    	    			}
    	    		});
				}
			});
		});*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("你确认要"+ title +"此接口吗?", {icon:1, title:'确认提示'}, function(){
				$("#serviceInfoAddForm").submitFormGetJson({
					url : "/wsMonitor/serviceInfo/register/changeStatus",
					param : {
						id : id,
						serverStatus : serverStatus
					},
					callback: function(data) {
						layui.use('layer', function(){
	    	    			var layer = layui.layer;
	    	    			
	    	    			if(data.indexOf("success") > -1) {
	    	    				layer.alert(title + "成功！", {icon:0,title:'提示'}, function() {
	    	    					layer.closeAll();
	    	    					back();
	    	    				});
	    	    			}else if (data.indexOf("fail") > -1) {
	    	    				layer.alert(title + "失败！", {icon:0,title:'提示'});
	    	    			}
	    	    		});
					}
				});
			});
		});
	}

	function search(indexPage) {
		debugger;
		indexPage = ($.isEmpty(indexPage)?1:indexPage);
		var searchObj = {
			url : "/wsMonitor/serviceInfo/register/list",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#serviceInfoForm").submitFormLoadHtml(searchObj);
	};

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	function deleteService() {
		var id = $(this).attr("data-id");
		/*msgUtil.confirm("你确认要删除此接口吗?", function () {
			$("#clientInfoAddForm").submitFormGetJson({
				url: "/wsMonitor/serviceInfo/delete",
				param: {
					id: id
				},
				callback: function (data) {
					if (data.indexOf("success") > -1) {
						msgUtil.alert("删除成功！");
						back();
					} else{
						msgUtil.alert("删除失败！");
					}
				}
			});
		});*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('你确认要删除此接口吗？', {icon:2, title:'确认提示'}, function(){
				$("#clientInfoAddForm").submitFormGetJson({
					url: "/wsMonitor/serviceInfo/delete",
					param: {
						id: id
					},
					callback: function (data) {
						if (data.indexOf("success") > -1) {
							layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
								layer.closeAll();
								back();
							});
						} else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
	}

	return {
		add : add,
		load : load,
		save : save,
		search : search,
		changeStatus : changeStatus,
		toggle : toggle,
		deleteService: deleteService,
		view: view
	};
})();
