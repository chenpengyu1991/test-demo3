var homepageInit = (function() {
	
	function showBulletin(bulletinId){
		/*var bulletinDialog = {
			id :"bulletinDialog",
            url : "/bulletin/view",
            height : 480,
            width : 900,
            title : "公告",
            param : {
            	bulletinId:bulletinId
			}
        };
        $.dialog(bulletinDialog);*/
		$.post(contextPath+"/bulletin/view",{bulletinId:bulletinId}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'homeBulletin',
        			  area: ['900px', '500px'],
        			  title:"公告",
        			  content: ret
        		  });
        		});
        	});
	}
	
	function addQuestion(questionId){
		/*var questionDialog = {
			id :"questionDialog",
            url : "/question/add",
            height : 480,
            width : 900,
            title : "新建问题",
            param : {
            	questionId:questionId,
            	fromHome:true
			}
        };
        $.dialog(questionDialog);*/
		$.post(contextPath+"/question/add",{questionId:questionId,fromHome:true}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'homeAddQuestion',
        			  area: ['900px', '530px'],
        			  title:"新建问题",
        			  content: ret
        		  });
        		});
        	});
		
	}
	
	function deleteQuestion(questionId) {
		/*var question = {
            url : "/question/delete",
            param:{
            	questionId:questionId
            },
            callback:function(data){
            	if(data > 0){
            		layer.alert("删除成功");
                	baseLayoutLoad.loadMenuContent("/home/load");
            		return;
            	}
            	layer.alert("删除失败");
            }
        };
		
		layer.confirm("你确定此答疑吗?",function(index){
			$.getJsonByUrl(question);
			layer.close(index);
		});*/
		 
		var question = {
            url : "/question/delete",
            param:{
            	questionId:questionId
            },
            callback:function(data){
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			if(data > 0){
        				var index = layer.alert('删除成功', {icon:0,title:'提示'}, function() {
        					layer.close(index);
        					location.reload();
        				});
        			} else {
        				layer.alert('删除失败！', {icon:0,title:'提示'});
        			}
        		});
            }
        };
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确认要删除吗？', {icon:2, title:'确认提示'}, function(index){
				//发异步删除数据
				$.getJsonByUrl(question);
			});
		});
		
	}
	
	function answerQuestion(questionId){
		/*var questionDialog = {
			id :"questionDialog",
            url : "/question/answer",
            height : 480,
            width : 900,
            title : "解答问题",
            param : {
            	questionId:questionId,
            	fromHome:true
			}
        };
        $.dialog(questionDialog);*/
		$.post(contextPath+"/question/answer",{questionId:questionId,fromHome:true}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'homeAnswerQuestion',
        			  area: ['910px', '550px'],
        			  title:"解答问题",
        			  content: ret
        		  });
        		});
        	});
	}
	
	function viewQuestion(questionId){
		/*var questionDialog = {
			id :"questionDialog",
            url : "/question/view",
            height : 480,
            width : 900,
            title : "解答问题",
            param : {
            	questionId:questionId
			}
        };
        $.dialog(questionDialog);*/
		$.post(contextPath+"/question/view",{questionId:questionId}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'homeViewQuestion',
        			  area: ['900px', '510px'],
        			  title:"查看问题",
        			  content: ret
        		  });
        		});
        	});
	}
	
	function moreBulletin(){
		$("#homeDiv").hide();
		var loadHtml={
			url: "/bulletin/search",
			insertDiv:"moreDiv",
			param:{
				fromHome:true
			}
		};
		$.loadHtmlByUrl(loadHtml);
	}
	
	function moreQuestion(){
		$("#homeDiv").hide();
		var loadHtml={
			url: "/question/search",
			insertDiv:"moreDiv",
			param:{
				fromHome:true
			}
		};
		$.loadHtmlByUrl(loadHtml);
	}
	
	return {
		showBulletin : showBulletin,
		addQuestion:addQuestion,
		deleteQuestion:deleteQuestion,
		answerQuestion:answerQuestion,
		viewQuestion:viewQuestion,
		moreBulletin:moreBulletin,
		moreQuestion:moreQuestion
	};
})();