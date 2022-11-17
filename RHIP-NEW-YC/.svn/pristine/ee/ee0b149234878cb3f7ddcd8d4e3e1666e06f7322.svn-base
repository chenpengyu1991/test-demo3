var epIodineNutritionSamplingInfoEdit = (function() {
	var validate = $("#infoEditForm").easyValidate();
	$(function() {
		//enableChangeConfirm();
		$("#save").click(function() {
			var result = validate.validateForm();
			if (!result) {
				//layer.alert("请根据提示正确填写");
				return;
			}
			var option = {
				url : "/ep/iodineNutrition/samplingSave",
				callback : function(result) {
					layer.alert(result.message, {icon:0,title:'提示'});
					if (result.success) {
						//disableChangeConfirm();
						$.removeDialog("d1");
						epIodineNutritionSamplingSearch.search($("#_indexPage").val());
					}
				}
			};
			$("#infoEditForm").submitFormGetJson(option);
		});
		
		var option = autoSelect();
		$("#sampling_type").change(function(){
			var param1 = {
				type : $("#sampling_type").val()
			};
			option.param = param1;
			$("input[name='code']").val("");
			$("#sampling_name").val("");
		});
	});
	
	function autoSelect() {
		var options = {
			url : contextPath + "/ep/iodineNutrition/querySamplingName",
			feild:{
				value:"value",
				lable:"name"
			},
			param : {
				type : $("#sampling_type").val()
			}
		};
		return $("#sampling_name").selectBox(options);
	}
	
	return {
		
	};
})();