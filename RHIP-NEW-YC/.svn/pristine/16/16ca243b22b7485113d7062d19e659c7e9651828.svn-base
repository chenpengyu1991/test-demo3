var bulletinSearch = (function() {
	$(function(){
		pageUtil.bind("listDiv",search);
		search(1);
		
		$("#btnBulletinSearch").click(function(e){
			e.preventDefault();
			search(1);
		});
		
		$("#bulletinForm").onEnter(function(){
			search(1);
		});
		$("#back").click(function(e){
			e.preventDefault();
			location.reload();
		});
		$("#bulletinSearchSpanId").click(function(e){
			e.preventDefault();
			toggle(this,'bulletinSearch');
		});
		$("#bulletinAddButId").click(function(e){
			e.preventDefault();
			dialog(0);
		});
	});
	 function search(indexPage) {
	    	
	    	var createBegin = new Date($("#submitDateFrom").val());
			var createEnd = new Date($("#submitDateTo").val());
			
			if (createBegin > createEnd) {
				layer.alert("开始时间不能大于结束时间!", {icon:0,title:'提示'});
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
	    	var deleteObj={
	    			url:"/bulletin/delete",
	    			param:{
	    				bulletinId:bulletinId
	    			},
	    			callback:function(data){
	    				/*layui.use('layer', function(){
	    					var layer = layui.layer;
	    					if(data > 0) {
	    						layer.msg('删除成功', function(){
	    							search(1);
	    						});
	    					} else {
	    						layer.msg('删除失败');
	    					}
	    				});*/
	    				if (data > 0) {
	    					myAlert('删除成功!', search, '',1);
	    				} else {
	    					myAlert('删除失败!');
	    				}
	    			}
	    	};
	    	/*layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认要删除吗？',function(index){
					//发异步删除数据
					$.getJsonByUrl(deleteObj);
//					layer.msg('已删除!',{icon:1,time:1000});
				});
			});*/
	    	
	    	layer.confirm('确认要删除吗？',{icon: 2, title:'确认提示'}, function() {
	    		$.getJsonByUrl(deleteObj);
	    	});
	    }
		
		function dialog(bulletinId) {
			/*var bulletinDialog = {
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
	        $.dialog(bulletinDialog);*/
			var title = "添加公告";
			var url = "/bulletin/add";
			if (bulletinId != 0) {
				title = "修改公告";
				url = "/bulletin/edit";
			}
			$.post(contextPath+url,{bulletinId:bulletinId}, function(ret){
				layui.use(['layer'], function() {
            		  var layer = layui.layer
            		  layer.open({
            			  type: 1,
            			  id:'addOrModifyBulletin',
            			  area: ['900px', '520px'],
            			  title:title,
            			  content: ret
            		  });
            		});
            	});
		}
		
		function view(bulletinId){
			/*var bulletinDialog = {
				id :"bulletinDialog",
	            url : "/bulletin/view",
	            height : 480,
	            width : 900,
	            title : "查看",
	            param : {
	            	bulletinId:bulletinId
				}
	        };
	        $.dialog(bulletinDialog);*/
	        $.post(contextPath+'/bulletin/view',{bulletinId:bulletinId}, function(ret){
            	layui.use(['layer'], function() {
            		  var layer = layui.layer
            		  layer.open({
            			  type: 1,
            			  id:'viewBulletin',
            			  area: ['900px', '510px'],
            			  title:'查看',
            			  content: ret
            		  });
            		});
            	});
		}
		
		function back(){
			$("#moreDiv").html("");
			$("#homeDiv").show();
		}
		return {
			search: search
		}
})(); 