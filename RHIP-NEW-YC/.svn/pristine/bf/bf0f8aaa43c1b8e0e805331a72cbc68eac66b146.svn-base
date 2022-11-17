define(['../interaction/search'],function(interactioSearch){
	function load(){
		$(function(){
			 $("#unitSave").click(function() {
		        	var validate = $("#unit_form").easyValidate();
		     		var result = validate.validateForm();
		     		if (!result) {
		     			return;
		     		}
		          unitSave();
		        });
	        
	        $("#unitCancle").click(function() {
	            $.removeDialog("popuOrgDialog");
	        });
		});
	}

		function unitSave(){
			 validate = $("#unit_form").easyValidate();
		        var result = validate.validateForm();
		        if (!result) {
		            return;
		        }
		        
			$("#unit_form").submitFormGetJson({
	            url : "/interaction/saveNextunit",
	            param : {
	            	id : $("#id").val(),
	            	nextUnit : $("#unit").val()
	            },
	            callback :function(data){
					if(data == "1"){
						layer.alert("转交成功！", {icon:0,title:'提示'}, function(index){
							$.removeDialog("popuOrgDialog");
							interactioSearch.searchInteraction($("#currentPage").val());
							layer.close(index);
						});
						return;
					}else {
						layer.alert("转交失败！", {icon:0,title:'提示'}, function(index){
							$.removeDialog("popuOrgDialog");
							interactioSearch.searchInteraction($("#currentPage").val());
							layer.close(index);
						});
						return;
					}
				}
	        });
		}
		
	return{
		load : load,
	}
});
