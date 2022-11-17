var disinfectionRsAdd = (function() {
	var validate = $("#disinfectionRsForm").easyValidate();
	$(function() {
		$("#cancelButton").click(function() {
			$.removeDialog("d1");
		});
		
		$("#saveButton").click(function() {
			saveDisinfectionRs();
		});
	});
	
	/*保存处理记录*/
	function saveDisinfectionRs() {
		if (validate.validateForm()) {
			$("#disinfectionRsForm").submitFormGetJson({
				url : "/dmbc/medicalInst/saveDisinfectionRs",
				callback : submitCallback,
				param : {
					type : $("#disinfectionRsForm #type").val()
				}
			});
		}
			//参数
//			var saveObj = {
//				url : "/dmbc/medicalInst/saveDisinfectionRs",
//				insertDiv : "operationDiv",
//				param : {
//					//enterpriseId : enterpriseId,
//					type:$("#disinfectionRsForm #type").val()
//				}
//			};
//			$("#disinfectionRsForm").submitFormLoadHtml(saveObj);
	};
	
	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.result) {
			$.removeDialog("d1");
			disinfectionMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
		}
	}
	
	function returnSearch(){
        debugger;
        if(contentChanged){
            msgUtil.backConfirm(function(){
                var pageIndex = $("#pageIndex").val();
                disinfectionMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            disinfectionMonitorSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }

    }
//	return {
//		saveDisinfectionRs:saveDisinfectionRs
//	};
})();

$(document).ready(function () { 

});
