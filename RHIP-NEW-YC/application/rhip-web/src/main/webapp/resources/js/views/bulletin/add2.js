var bulletinAdd = (function() {
	$(function() {

		 validate = $("#bulletinEditForm").easyValidate();
		 
		 $("#contentText").on("validatedEvent",function(event,result,tip){
			 if (!result) {
				 $(this).addClass("borderColor");
			 }else{
				 $(this).removeClass("borderColor");
			 }
		 });
		 
		 $("#saveBulletinButtonId").click(function(e) {
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
			url:"/bulletin/save",
			callback:function(data) {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			if(data > 0){
        				layer.alert('保存成功！', {icon:0,title:'提示'}, function(){
        					bulletinSearch.search(1);
        					layer.closeAll();
        				})
        			} else {
        				layer.alert('保存失败！', {icon:0,title:'提示'});
					}
        		});
				
			}
		};
		$("#bulletinEditForm").submitFormGetJson(submitObj);
	}
	
})(); 