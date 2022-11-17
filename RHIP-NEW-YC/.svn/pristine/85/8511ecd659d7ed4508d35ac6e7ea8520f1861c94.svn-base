var mosquitoesAdd = (function() {
	$(function() { 
		validate = $("#mosquitoesForm").easyValidate();
		$("#cancelButton").click(function() {
			$.removeDialog("d1");
		});
		
		$("#saveButton").click(function() {
			saveMouse();
		});
	});
	
	/*保存捕蚊记录*/
	function saveMouse() {
		if (validate.validateForm()) {
			$("#mosquitoesForm").submitFormGetJson({
				url : "/dmbc/vertor/saveMosquitoes",
				callback : submitCallback,
				param : {
					type : $("#mosquitoesForm #type").val()
				}
			});
		}
			//参数
//			var saveObj = {
//				url : "/dmbc/vertor/saveMouse",
//				insertDiv : "operationDiv",
//				param : {
//					//enterpriseId : enterpriseId,
//					type:$("#mouseForm #type").val()
//				}
//			};
//			$("#mouseForm").submitFormLoadHtml(saveObj);
	};
	
	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.result) {
			$.removeDialog("d1");
			mosquitoesMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
		}
	}
	
	function returnSearch(){
        debugger;
        if(contentChanged){
            msgUtil.backConfirm(function(){
                var pageIndex = $("#pageIndex").val();
                mouseMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            mouseMonitorSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }

    }
//	return {
//		saveMouse:saveMouse
//	};
})();

$(document).ready(function () { 

});
