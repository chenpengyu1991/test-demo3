var treatmentAdd = (function() {
	var validate = $("#treatmentForm").easyValidate();
	$(function() {
		$("#cancelButton").click(function() {
			$.removeDialog("d1");
		});
		
		$("#saveButton").click(function() {
			saveTreatment();
		});
	});
	
	/*保存处理记录*/
	function saveTreatment() {
		if (validate.validateForm()) {
			$("#treatmentForm").submitFormGetJson({
				url : "/dmbc/medicalInst/saveTreatment",
				callback : submitCallback,
				param : {
					type : $("#treatmentForm #type").val()
				}
			});
		}
			//参数
//			var saveObj = {
//				url : "/dmbc/medicalInst/saveTreatment",
//				insertDiv : "operationDiv",
//				param : {
//					//enterpriseId : enterpriseId,
//					type:$("#treatmentForm #type").val()
//				}
//			};
//			$("#treatmentForm").submitFormLoadHtml(saveObj);
	};
	
	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.result) {
			$.removeDialog("d1");
			sewageTreatmentList.viewOrEdit($("#monitorId").val(),$("#type").val());
		}
	}
	
	function returnSearch(){
        debugger;
        if(contentChanged){
            msgUtil.backConfirm(function(){
                var pageIndex = $("#pageIndex").val();
                sewageTreatmentSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            sewageTreatmentSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }

    }
//	return {
//		saveTreatment:saveTreatment
//	};
})();

$(document).ready(function () { 

});
