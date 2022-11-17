var reserveCommon = (function() {
	
	var resultObj = {
			repeat:"该用户已预约此科室医生",
			over:"该用户今天已预约三次，不能再进行预约",
			full:"对不起，该科室医生已约满",
			fail:"提交预约失败，建议重新登录再尝试预约"
		};
	
	function save(){
		$("#loading").show();
		$("#register_form").submitFormLoadHtml({
			url : "/userSpace/reserve/save",
			param :{
				hospitalCode:$("#hospitalCode").val(),
				scheduleId:$("#scheduleId").val(),
				scheduleTimeId:$("#scheduleTimeId").val(),
				frequentId:$("#frequent").val(),
			},
			callback:function(model){
				$("#loading").hide();
				var result = resultObj[model.result];
				if(result == null && isNaN(model.result)){
					msgUtil.alert(model.result, function() {$("#overlayregScheduleTime").remove();$("#regScheduleTime").remove();});
				} else if (!isEmpty(result)){
					msgUtil.alert(result, function() {$("#overlayregScheduleTime").remove();$("#regScheduleTime").remove();});
				} else if (!isNaN(model.result) && !isEmpty(model.registTime) && model.needTip) {
					msgUtil.alert("预约成功，请携带在"+model.registTime+"办的就诊卡去就诊", function() {window.location.href= contextPath + "/userSpace/reserve/view/" + model.result;});
				} else if (!isNaN(model.result) && isEmpty(model.registTime) && model.needTip) {
					msgUtil.alert("预约成功，请就诊当日取预约号的同时，凭预约小票信息在窗口办理就诊卡", function() {window.location.href= contextPath + "/userSpace/reserve/view/" + model.result;});
				}
				else {
					msgUtil.alert("预约成功", function() {window.location.href= contextPath + "/userSpace/reserve/view/" + model.result;});
				}
			}
		});
	}
	
	function confirmClose(){
		 $("#overlayregScheduleTime").remove();
		 $("#regScheduleTime").remove();
	}
	
	// 判断是否为空
	function isEmpty(str) {
		if (null == str || "" == str) {
			return true;
		}
		return false;
	}
	
	return {
		save:save,
		confirmClose: confirmClose
	};
})();