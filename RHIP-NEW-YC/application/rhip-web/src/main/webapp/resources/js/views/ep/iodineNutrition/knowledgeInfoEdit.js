var epIodineNutritionKnowledgeInfoEdit = (function() {
	var validate = $("#infoEditForm").easyValidate();
	$(function() {
		$("#save").click(function() {
			var result = validate.validateForm();
			if (!result) {
				//layer.alert("请根据提示正确填写");
				return;
			}
			var option = {
				url : "/ep/iodineNutrition/knowledge/save",
				callback : function(result) {
					layer.alert(result.message, {icon:0,title:'提示'});
					if (result.success) {
						$.removeDialog("d1");
						epIodineNutritionKnowledgeSearch.search($("#_indexPage").val());
					}
				}
			};
			$("#infoEditForm").submitFormGetJson(option);
		});
	    $("#sampling_type").change(function(){
	    	changeSampling($(this).val());
	    });
	    $("input").blur(function(){
	    	computerResult();
	    });
	});
	
	function changeSampling(type) {
		var option = {
				url : "/ep/iodineNutrition/changeSimpling",
				callback : changeSamplingCallback,
				param : {
					type : type
				}
		};
		$.getJsonByUrl(option);
	}
	
	function changeSamplingCallback(data) {
		if (data.success) {
			var select = $("#sampling_name");
			var options = '<option value="">请选择</option>';
			var list = data.list;
			for (var index in list) {
				options += '<option value="'+list[index].id+'">'+list[index].name+'</option>';
			}
			select.empty();
			select.append(options);
		}
	}
	
	function computerResult() {
		var totalquestions = getNumberValue("totalPersonNo") * getNumberValue("questionsForEach");
		if (totalquestions > 0) {
			var awarenessRate = getNumberValue("totalCorrectAnswers") / totalquestions * 100;
			$("input[name='awarenessRate']").val(awarenessRate.toFixed(2));
		} else {
			$("input[name='awarenessRate']").val("0.00");
		}
	}
	
	function getNumberValue(name) {
		var inputValue = $("input[name='" + name  + "']").val();
		if ($.isEmpty(inputValue)) {
			return 0;
		}
		return parseFloat(inputValue);
	}
	
	
	return {
		
	};
})();