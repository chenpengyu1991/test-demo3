define(['./search'],function(bulletinSearch) {
	function load() {	
		$(function(){
			 validate = $("#bulletinEditForm").easyValidate();
			 
			 $("#contentText").on("validatedEvent",function(event,result,tip){
				 if (!result) {
					 $(this).addClass("borderColor");
				 }else{
					 $(this).removeClass("borderColor");
				 }
			 });
			 
			 $("#saveBulletinButtonId").click(save);
		});
	}
	
	function save(){
		var result = validate.validateForm();
        if (!result) {
            return;
        }
		var submitObj={
			url:"/bulletin/save",
			callback:function(data){
				if(data < 0) {
					layer.alert("保存失败!", {icon:0,title:'提示'});
					return;
				}
				
				layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
					bulletinSearch.search(1);
				});
			}
		};
		$("#bulletinEditForm").submitFormGetJson(submitObj);
	}
	
	return {
		load: load
	};

});
