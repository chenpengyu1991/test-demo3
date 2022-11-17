var questionAnswer = (function() {
	
	$(function(){
		 validate = $("#questionAnswerForm").easyValidate();
		 
		 $("#answerContent").on("validatedEvent",function(event,result,tip){
			 if (!result) {
				 $(this).addClass("borderColor");
			 }else{
				 $(this).removeClass("borderColor");
			 }
		 });
		 
		 $("#saveButtonId").click(function(e){
				e.preventDefault();
				save();
			});
	});
	
	function save(){
		
		var result = validate.validateForm();
        if (!result) {
            return;
        }
		
		var submitObj={
			url:"/question/answerSave",
			callback:function(data){
				layui.use('layer', function(){
        			var layer = layui.layer;
        			if(data > 0){
        				layer.alert('保存成功！', {icon:0,title:'提示'}, function(){
        					if($("#fromHome").val() == "true"){
        						location.reload();
        					} else {
        						questionSearch.search(1);
        						layer.closeAll();
        					}
        				});
        			} else {
        				layer.alert('保存失败！', {icon:0,title:'提示'});
					}
        		});
/*//				msgUtil.alert("保存成功");
				if($("#fromHome").val() == "true"){
					msgUtil.alert("保存成功!", function() {
						location.reload();
					});
//					baseLayoutLoad.loadMenuContent("/home/load");
				}else{
					questionSearch.search(1);
				}
				$.removeDialog("questionDialog");*/
			}
		};
		$("#questionAnswerForm").submitFormGetJson(submitObj);
	}
	
	return {
		save:save
	};
})();
