var deathMedicineCertificateSearchView = (function() {
	$(function(){
		ajaxLoadCategoryNo();
		deathSiteRadio();
		noTreatReasonOtherRadio();
		var isAdd = $("#isAddHid").val();
		if(isAdd == '1') {
			$("#isAdd").attr("checked",'checked');
		}
		$("#town_address").attr("disabled","disabled");
		$("#street_address").attr("disabled","disabled");
		$("#village_address").attr("disabled","disabled");
		$("#childDeathViewBack").on("click", doBack);
	});
	
	// 加载编码分类
	function ajaxLoadCategoryNo() {
		var categoryNo = $("#categoryNoValue").val();
		$.getJsonByUrl({
			url : contextPath + "/childDeathReport/queryCategoryNo",
			checkRepeat : false,
			callback : function(data)
			{
				$("#categoryNoSelect").html("");
				$("#categoryNoSelect").append(data);
			},
			param : {
				categoryNo : categoryNo
			}
		});
	}
	
	// 加载死亡地点
	function deathSiteRadio() {
		var value = $("#deathSiteOtherMarkHid").val();
		var str = '<input type="text" style="width:60px;" readonly="readonly" reg=\'{"required":true}\' name="deathSiteOtherMark" value="'+value+'"/>';
		var deathSite = $("input[name='deathMedicineCertificate.deathSite']:checked").val();
		if(deathSite == '4') { // 选中其他事件，需要显示其他输入框
			$(str).insertBefore($("input[name='deathMedicineCertificate.deathSite']").get(4));
		} else {
			$("input[name='deathSiteOtherMark']").remove();
		}
	}
	
	// 未治疗或未就医主要原因其他输入框
	function noTreatReasonOtherRadio() {
		var value = $("#noTreatReasonHid").val();
		var str = '<input type="text" readonly="readonly" style="width:60px;" reg=\'{"required":true}\' name="noTreatReasonOther" value="'+value+'"/>';
		var deathSite = $("input[name='deathMedicineCertificate.noTreatReason']:checked").val();
		if(deathSite == '6') { // 选中其他事件，需要显示其他输入框
			$(str).insertBefore($("input[name='deathMedicineCertificate.noTreatReason']").get(6));
		} else {
			$("input[name='noTreatReasonOther']").remove();
		}
	}
	
	function doBack(){
        $("#childDeathListDiv").show();
        $("#childDeathDiv").hide();
    }
	
	return {
		ajaxLoadCategoryNo : ajaxLoadCategoryNo,
		deathSiteRadio : deathSiteRadio,
		noTreatReasonOtherRadio : noTreatReasonOtherRadio,
		doBack : doBack
	};
})();