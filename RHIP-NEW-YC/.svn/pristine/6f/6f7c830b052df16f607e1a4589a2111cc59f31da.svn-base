define(function(){
	function load(){
		$(function(){
			//分页绑定函数
			pageUtil.bind("accountInfo_records",accountInfoSearch);
			accountInfoSearch(1);
			$("#form_search").onEnter(accountInfoSearch,1);
			$("#accountInfoSearchBut").click(function() {
				accountInfoSearch(1);
			});
			$("#returnContact").click(returnSearch);
		});
	}
	
	function accountInfoSearch(indexPage) {
		var searchObj = {
			url : "/lhaccountInfo/list",
			insertDiv : "accountInfo_records",
			param : {
				indexPage : indexPage
			},
			callback: function(){
				/*为accountInfo_records中a的添加click事件*/
				initLinkClick('viewAccountInfo',viewAccountInfo, {id:"data-fileCode"});
				initLinkClick('enableAccountInfo',enableAccountInfo, {id:"data-fileCode"});
				initLinkClick('disableAccountInfo',disableAccountInfo, {id:"data-fileCode"});
				initLinkClick('enableReserveAccountInfo',enableReserveAccountInfo, {id:"data-fileCode"});
				initLinkClick('disableReserveAccountInfo',disableReserveAccountInfo, {id:"data-fileCode"});
				initLinkClick('deleteAccountInfo',deleteAccountInfo, {id:"data-fileCode"});
				initLinkClick('passwordAccountInfo',passwordAccountInfo, {userId:"data-fileCode"});
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	function viewAccountInfo(id){
		$("#top_allLink").hide();
			var option = {
					url : "/lhaccountInfo/showAccountInfo",
					insertDiv : "accountInfoDetails",
					param : {
						id : id
					}
			};
		$.loadHtmlByUrl(option);
		$("#accountInfoDetails").show();
	}
	
	function enableAccountInfo(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认启用该记录？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/lhaccountInfo/status",
					param : {
						id : id,
						operation : "enable"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("启用成功！", {icon:0,title:'提示'}, function(index2) {
								accountInfoSearch($("#currentPage").val())
								layer.close(index2);
							});
							return;
						}
						layer.alert("启用失败！", {icon:0,title:'提示'}, function(index2) {
							accountInfoSearch($("#currentPage").val())
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function disableAccountInfo(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认禁用该记录？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/lhaccountInfo/status",
					param : {
						id : id,
						operation : "disable"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("禁用成功！", {icon:0,title:'提示'}, function(index2) {
								accountInfoSearch($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("禁用失败！", {icon:0,title:'提示'}, function(index2) {
							accountInfoSearch($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function enableReserveAccountInfo(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认启用预约该记录？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/lhaccountInfo/status",
					param : {
						id : id,
						operation : "enableReserve"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("启用成功！", {icon:0,title:'提示'}, function(index2) {
								accountInfoSearch($("#currentPage").val());
								layer.close(index2);
							});	
							return;
						}
						layer.alert("启用失败！", {icon:0,title:'提示'}, function(index2) {
							accountInfoSearch($("#currentPage").val());
							layer.close(index2);
						});	
					}
				});
				layer.close(index);
			});
		});
	}
	
	function disableReserveAccountInfo(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("确认禁用预约该记录？", {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : "/lhaccountInfo/status",
					param : {
						id : id,
						operation : "disableReserve"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("禁用成功！", {icon:0,title:'提示'}, function(index2) {
								accountInfoSearch($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("禁用失败！", {icon:0,title:'提示'}, function(index2) {
							accountInfoSearch($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});		
	}
	
	function deleteAccountInfo(id){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("是否彻底删除此项？", {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : "/lhaccountInfo/delete",
					param : {
						id : id
					},
					callback : function(){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
							accountInfoSearch($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});		
	}

	function passwordAccountInfo(userId){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("你确定要重置密码吗？", {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url:"/lhaccountInfo/psdUpdate",
					param:{
						userId:userId
					},
					callback:function(data){
						if(data == 1){
							layer.alert("密码重置成功！", {icon:0,title:'提示'});
						}else{
							layer.alert("用户重置失败！", {icon:0,title:'提示'});
						}
					}
				});
				layer.close(index);
			});
		});		
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
	
	function returnfunction() {
		$("#accountInfoDetails").empty();
        $("#top_allLink").show();
        accountInfoSearch($("#currentPage").val());	
	}
	
	return {
		load : load
	};
});
