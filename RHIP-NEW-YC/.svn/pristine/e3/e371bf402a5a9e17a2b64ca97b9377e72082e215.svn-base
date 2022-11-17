var flyAdd = (function() {
	$(function() { 
		validate = $("#flyForm").easyValidate();
		$("#cancelButton").click(function() {
			$.removeDialog("d1");
		});
		
		$("#saveButton").click(function() {
			saveFly();
		});
	});
	
	/*保存捕蝇记录*/
	function saveFly() {
		if (validate.validateForm()) {
			$("#flyForm").submitFormGetJson({
				url : "/dmbc/vertor/saveFly",
				callback : submitCallback,
				param : {
					type : $("#flyForm #type").val()
				}
			});
		}
			//参数
//			var saveObj = {
//				url : "/dmbc/vertor/saveFly",
//				insertDiv : "operationDiv",
//				param : {
//					//enterpriseId : enterpriseId,
//					type:$("#flyForm #type").val()
//				}
//			};
//			$("#flyForm").submitFormLoadHtml(saveObj);
	};
	
	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.result) {
			$.removeDialog("d1");
			flyMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
		}
	}
	
	function returnSearch(){
        debugger;
        if(contentChanged){
            msgUtil.backConfirm(function(){
                var pageIndex = $("#pageIndex").val();
                flyMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            flyMonitorSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }

    }
//	return {
//		saveFly:saveFly
//	};
})();

$(document).ready(function () { 

});
