var roachAdd = (function() {
	var validate = $("#roachForm").easyValidate();
	$(function() {
		$("#cancelButton").click(function() {
			$.removeDialog("d1");
		});
		
		$("#saveButton").click(function() {
			saveRoach();
		});
	});
	
	/*保存捕蟑螂记录*/
	function saveRoach() {
		if (validate.validateForm()) {
			$("#roachForm").submitFormGetJson({
				url : "/dmbc/vertor/saveRoach",
				callback : submitCallback,
				param : {
					type : $("#roachForm #type").val()
				}
			});
		}
			//参数
//			var saveObj = {
//				url : "/dmbc/vertor/saveRoach",
//				insertDiv : "operationDiv",
//				param : {
//					//enterpriseId : enterpriseId,
//					type:$("#roachForm #type").val()
//				}
//			};
//			$("#roachForm").submitFormLoadHtml(saveObj);
	};
	
	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.result) {
			$.removeDialog("d1");
			roachMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
		}
	}
	
	function returnSearch(){
        debugger;
        if(contentChanged){
            msgUtil.backConfirm(function(){
                var pageIndex = $("#pageIndex").val();
                roachMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            roachMonitorSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }

    }
//	return {
//		saveRoach:saveRoach
//	};
})();

$(document).ready(function () { 

});
