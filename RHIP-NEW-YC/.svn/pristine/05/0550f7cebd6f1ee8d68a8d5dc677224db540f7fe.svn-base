/*define(['../util/upload'],function(upload) {*/
define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDivLink",searchLink);
			searchLink(1);
			$("#linkFormId").onEnter(searchLink, 1);
			$("#linkSearchBut").click(function() {
				searchLink(1);
			});
			$("#organizationLinkSearchSpanId").click(function(){
				toggle(this,'linkSearchTableId');
			});
			$("#LinkAddButId").click(function(){
				add();
			});
		});
	}
	
    function searchLink(indexPage) {
		var searchObj = {
				 url : "/organizationLink/list",
				 insertDiv : "listDivLink",
				 param : {indexPage : indexPage},
				callback: function() {
					/*为listDiv中a的添加click事件*/
					initLinkClick('viewLink',view, {linkId:"data-linkId"});
					initLinkClick('modifyLink',modify, {linkId:"data-linkId"});
					initLinkClick('publishLink',publish, {linkId:"data-linkId"});
					initLinkClick('unpublishLink',unpublish, {linkId:"data-linkId"});
					initLinkClick('deleteLink',del, {linkId:"data-linkId"});
				}
			 };
		$("#linkFormId").formPost(searchObj);
	
	}
	
    function add(){
    	$("#top_allLink").hide();
    	var option ={
			url : "/organizationLink/add",
			insertDiv : "infoDivLink",
			param : {
				operation:'3'
			},
		};
    	$.loadHtmlByUrl(option);
		$("#infoDivLink").show();
    };
    
    function view(linkId){
    	$("#top_allLink").hide();
    	var option ={
			url : "/organizationLink/detail",
			insertDiv : "infoDivLink",
			param : {
				linkId: linkId,
				operation:'1'
			}
		};
    	$.loadHtmlByUrl(option);
		$("#infoDivLink").show();
    };
    
    function modify(linkId) {
    	$("#top_allLink").hide();
    	var option = {
			url : "/organizationLink/add",
			insertDiv : "infoDivLink",
			param : {
				linkId: linkId,
				operation : '2'
			}
		};
    	$.loadHtmlByUrl(option);
		$("#infoDivLink").show();
	};
	
	function publish(linkId) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认该记录通过审核？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/organizationLink/status",
					param : {
						linkId : linkId,
						operation : "publish"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("审核成功！", {icon:0,title:'提示'}, function(index2) {
								searchLink($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("审核失败！", {icon:0,title:'提示'}, function(index2) {
							searchLink($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function unpublish(linkId) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认撤销该记录？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/organizationLink/status",
					param : {
						linkId : linkId,
						operation : "unpublish"
					},
					callback : function(data) {
						if (data == "1") {
							layer.alert("撤销成功！", {icon:0,title:'提示'}, function(index2) {
								searchLink($("#currentPage").val());
								layer.close(index2);
							});
							return;
						}
						layer.alert("撤销失败！", {icon:0,title:'提示'}, function(index2) {
							searchLink($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function del(linkId) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('是否彻底删除此项？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/organizationLink/delete",
					param : {
						linkId : linkId
					},
					callback : function(){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
							searchLink($("#currentPage").val());
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
    return{
    	load: load,
    	searchLink: searchLink
    };
});
