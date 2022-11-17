var checkStatusUtil = (function() {
	$(function() {
		var validate = $("#followUpConclusionForm").easyValidate();
		disabledInput("overweight","overweightShow");
		disabledInput("noTrain","trainShow");
		disabledInput("currSmokingFlag","smokeShow");
		disabledInput("longtermDrinkingFlag","drinnkShow");
		disabledInput("foodGreasyFlag","foodShow");
		disabledInput("famHistoryFlag","famHistoryShow");
		if($("input[name=continueManageFlag]:checked").val()=="2"){
			$("input[name=other]").removeAttr("disabled").show();
		}
		$("input[name=continueManageFlag]").on("click",function(){
			if("1" == $(this).val()){
				$("input[name=other]").attr("disabled", "disabled").hide();
			}else{
				$("input[name=other]").removeAttr("disabled").show();
			}
		});
		$("input[name='riskLevel']").attr("disabled",true);
		calculateLevel();
		var status = $("#riskManageStatus").val();
		if(!$.isEmpty(status)){
			$("#riskFactorsInfo input").attr("disabled",true);
			$("#riskFactorsInfo select").attr("disabled",true);
			$("#riskFactorsInfo span").attr("disabled",true);
			$("#saveRiskFactors").hide();
		}
	});
	function clickShowText(obj,textId) {
		if(obj.checked) {
			$("#"+textId).removeAttr("disabled");
			$("#"+textId+" input[type='text']").removeAttr("disabled");
		} else {
			$("#"+textId+" input[type='text']").attr("disabled",true);
			$("#"+textId).attr("disabled",true);
			$("#"+textId).val("");
			$("#"+textId + " input[type='text']").attr("value","");
			$("#"+textId + " input[type='checkbox']").attr("checked",false);
		}
		calculateLevel();
	}
	function disabledInput(checkId,spanId) {
		if ($("." +checkId).attr("checked") == "checked"){
			$("#"+spanId).removeAttr("disabled");
			$("#"+spanId+" input[type='text']").removeAttr("disabled");
		}else{
			$("#"+spanId+" input[type='text']").attr("disabled",true);
			$("#"+spanId).attr("disabled",true);
			$("#"+spanId).val("");
			$("#"+spanId + " input[type='text']").attr("value","");
			$("#"+spanId + " input[type='checkbox']").attr("checked",false);
		}
	}
	function calculateLevel(){
		var  factorCount= $(".calculateLevel:checkbox:checked").length;
		if(factorCount<=2){
			$("input[name='riskLevel']").val(['1']);
		}else if(factorCount>=5){
			$("input[name='riskLevel']").val(['3']);
		}else{
			$("input[name='riskLevel']").val(['2']);
		}
	}
	return {
		clickShowText:clickShowText,
		disabledInput:disabledInput,
		calculateLevel:calculateLevel
	};
})();