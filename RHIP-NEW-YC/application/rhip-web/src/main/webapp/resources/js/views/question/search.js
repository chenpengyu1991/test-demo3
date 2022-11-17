var questionSearch = (function() {
	
	$(function(){
		search(1);
		
		$("#btnQuestionSearch").click(function(e){
			e.preventDefault();
			search(1);
		});
		
		$("#questionForm").onEnter(function(){
			search(1);
		});
		
		$("#questionBack").click(function(e){
			e.preventDefault();
			location.reload();
		});
	});
	
	
    function search(indexPage) {
    	
    	var createBegin = new Date($("#submitDateFrom").val());
		var createEnd = new Date($("#submitDateTo").val());
		
		if (createBegin > createEnd) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return;
		} 
    	
		var url = "/question/list";
		var searchObj = {
			 url : url,
			 insertDiv : "listDiv",
			 param : {indexPage : indexPage}
		 };
		$("#questionForm").formPost(searchObj);
	}
	
	function deleteQuestion(questionId){
		 
		var question = {
            url : "/question/delete",
            param:{
            	questionId:questionId
            },
            callback:function(data){
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			if(data > 0){
        				var index = layer.alert('删除成功！', {icon:0,title:'提示'}, function(){
        					layer.close(index);
        					search(1);
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
//				layer.msg('已删除!',{icon:1,time:1000});
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
            	questionId:questionId
			}
        };
        $.dialog(questionDialog);*/
		$.post(contextPath+"/question/answer",{questionId:questionId}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'answerQuestion',
        			  area: ['910px', '550px'],
        			  title:"解答问题",
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
            title : "修改问题",
            param : {
            	questionId:questionId,
            	fromHome:false
			}
        };
        $.dialog(questionDialog);*/
		$.post(contextPath+"/question/add",{questionId:questionId,fromHome:false}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'addQuestion',
        			  area: ['900px', '520px'],
        			  title:"修改问题",
        			  content: ret
        		  });
        		});
        	});
	}
	
	return {
		search :search,
		addQuestion:addQuestion,
		answerQuestion:answerQuestion,
		deleteQuestion:deleteQuestion
	};
})();