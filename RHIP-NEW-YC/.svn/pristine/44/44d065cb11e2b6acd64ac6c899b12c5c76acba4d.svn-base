var isRun = false;

function updateSurvey(op,surveyOneId){
	if(op=='started'){
		if (!confirm("您确认要开启调查吗?")) return false;
	} else{
		if (!confirm("您确认要结束调查吗?")) return false;
	}
	if(isRun){
		return;
	}
	isRun = true;
	var url = "/surveyAdmin/updateStatus";
	$("#span"+surveyOneId).html(loadingSource);
	
	$.postRepeat(contextPath+url,'', function(data){
		isRun = false;
		if (data == "success") {
			search(1);
			$("#msgOK").html("操作成功！");
			$("#msgOK").show();
			$("#msgError").hide();
		} else if (data == "fail") {
			search(1);
			$("#msgError").html("操作失败！");
			$("#msgOK").hide();
			$("#msgError").show();
		} else {
			search(1);
		    $("#msgOK").html(data);
			$("#msgError").hide();
			$("#msgOK").show();
		}
		goTop();
	},"html","status=" + op + "&id=" + surveyOneId);
}
