define(function(){
	function load(){
		$(function(){
			pageUtil.bind("listDiv",search);
			search(1);
			
			$("#btnBulletinSearch").click(function(){
				search(1);
			});
			
			$("#bulletinForm").onEnter(function(){
				search(1);
			});
			$("#back").click(function(){
				baseLayoutLoad.loadMenuContent('/home/load');
			});
			$("#bulletinSearchSpanId").click(function(){
				toggle(this,'bulletinSearch');
			});
			$("#bulletinAddButId").click(function(){
				dialog(0);
			});
		});
	}
	
	 function search(indexPage) {
	    	
	    	var createBegin = new Date($("#submitDateFrom").val());
			var createEnd = new Date($("#submitDateTo").val());
			
			if (createBegin > createEnd) {
				layui.use('layer', function() {
           			var layer = layui.layer;
           			layer.alert("开始时间不能大于结束时间", {icon:0,title:'提示'});
              	});
				return;
			} 
	    	
			var url = "/bulletin/list";
			var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : {indexPage : indexPage},
				 callback: function() {
					/*为listDiv中a的添加click事件*/
				    initLinkClick('modifyBulletin',edit, {bulletinId:"data-id"});
					initLinkClick('deleteBulletin',deleteBulletin, {bulletinId:"data-id"});
					initLinkClick('bulletinSearchView',view, {bulletinId:"data-id"});
				}	   

			 };
			$("#bulletinForm").formPost(searchObj);
		}

	    
	    function edit(id){
	    	dialog(id);
	    }
	    
	    function deleteBulletin(bulletinId,title){
	    	var index = layer.confirm("是否确认删除", {icon:2, title:'确认提示'}, function() {
	    		var deleteObj={
    	    		url:"/bulletin/delete",
    	    		param:{
    	    			bulletinId:bulletinId
    	    		},
    	    		callback:function(data){
    	    			if(data > 0){
    	    				layui.use('layer', function() {
    	    					var layer = layui.layer;
    	    					layer.alert("删除成功!", {icon:0,title:'提示'});
    	    				});
    	    				search(1);
    	    				return;
    	    			}
    	    			layui.use('layer', function() {
    	    				var layer = layui.layer;
    	    				layer.alert("删除失败!", {icon:0,title:'提示'});
    	    			});
    	    		}
    	    	};
    	    	$.getJsonByUrl(deleteObj);
	    		layer.close(index);
	    	});
	    }
		
		function dialog(bulletinId) {
			var bulletinDialog = {
				id :"bulletinDialog",
	            url : "/bulletin/add",
	            height : 480,
	            width : 900,
	            title : "添加公告",
	            param : {
	            	bulletinId:bulletinId
				}
	        };
			if(bulletinId != 0){
				bulletinDialog.title = "修改公告";
				bulletinDialog.url = "/bulletin/edit";
			}
	        $.dialog(bulletinDialog);
		}
		
		function view(bulletinId){
			var bulletinDialog = {
				id :"bulletinDialog",
	            url : "/bulletin/view",
	            height : 480,
	            width : 900,
	            title : "查看",
	            param : {
	            	bulletinId:bulletinId
				}
	        };
	        $.dialog(bulletinDialog);
		}
		
		function back(){
			$("#moreDiv").html("");
			$("#homeDiv").show();
		}
		
		
	    return{
	    	load: load,
	    	search: search
	    };
	});
