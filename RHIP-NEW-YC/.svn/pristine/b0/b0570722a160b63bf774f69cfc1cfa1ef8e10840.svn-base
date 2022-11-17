define(function() {
	function load() {
		$(function(){
	        $(".addQuestion").click(function() {addQuestion(0)});
	        $(".deleteQuestion").click(function(){
	            var id = $(this).attr('data-id');
	            deleteQuestion(id);
	        } );
	        $(".deleteQuestion").click(function(){
	            var id = $(this).attr('data-id');
	            deleteQuestion(id);
	        } );

	        $(".answerQuestion").click(function(){
	            var id = $(this).attr('data-id');
	            answerQuestion(id);
	        } );
	        $(".viewQuestion").click(function(){
	            var id = $(this).attr('data-id');
	            viewQuestion(id);
	        } );
	        $("#moreBulletin").click(function(){
	        	 moreBulletin();
	        } );
	        $("#moreQuestion").click(function(){
	        	moreQuestion(0);
	        } );

	        $(".showBulletin").click(function(){
	        	var id = $(this).attr('data-id');
	        	showBulletin(id);
	        } );
	    });
	}
	


	
	function showBulletin(bulletinId){
		var bulletinDialog = {
			id :"bulletinDialog",
            url : "/bulletin/view",
            height : 480,
            width : 900,
            title : "公告",
            param : {
            	bulletinId:bulletinId
			}
        };
        $.dialog(bulletinDialog);
	}
	
	function addQuestion(questionId){
		var questionDialog = {
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
        $.dialog(questionDialog);
	}
	
	function deleteQuestion(questionId){
		layui.use('layer', function(){
			var layer = layui.layer;
			var question = {
	            url : "/question/delete",
	            param:{
	            	questionId:questionId
	            },
	            callback:function(data){
	            	if(data > 0){
	            		layer.alert("删除成功！", {icon:0,title:'提示'});
	                	baseLayoutLoad.loadMenuContent("/home/load");
	            		return;
	            	}
	            	layer.alert("删除失败！", {icon:0,title:'提示'});
	            }
	        };
			layer.confirm('你确定此答疑吗?', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl(question);
				layer.close(index);
			});
		});
	}
	
	function answerQuestion(questionId){
		var questionDialog = {
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
        $.dialog(questionDialog);
	}
	
	function viewQuestion(questionId){
		var questionDialog = {
			id :"questionDialog",
            url : "/question/view",
            height : 480,
            width : 900,
            title : "解答问题",
            param : {
            	questionId:questionId
			}
        };
        $.dialog(questionDialog);
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
		load: load
	}
});