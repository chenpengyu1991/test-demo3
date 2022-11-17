var statisticsCommon = (function() {
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	/*报表修改或查看*/
	function changeReportStatus(status,listName) {
		if(status == 'view'){
			$('#' + listName).find("[id^='editReport']").each(function(){
				$(this).hide();
			});
			$('#' + listName).find("[id^='viewReport']").each(function(){
				$(this).show();
			});			
		}else{
			$('#' + listName).find("[id^='editReport']").each(function(){
				$(this).show();
			});
			$('#' + listName).find("[id^='viewReport']").each(function(){
				$(this).hide();
			});			
		}
	};	
	function changeActive(divId,btnId){
		disableChangeConfirm();
        $('#' + divId).find(".active").removeClass("active");
        $('#'+ btnId).parent().addClass("active");		
	}
    /*
     * 根据单位类型加载机构列表
     * type：hospital,centre 全部（市级医院、中心）
     * type：hospital 市级医院
     * type：centre 中心
     * */    
    function changeReportUnit(type){
    	var codeOther = $.isEmpty($('#codeOther').val())?'':$('#codeOther').val();
		$.getJsonByUrl({
			url : contextPath + "/organization/allOrg",
			callback : function(data)
			{
				// 删除option
				$('select[name="reportUnitCode"]:visible option').remove();
				if (data != "empty")
				{
					$('select[name="reportUnitCode"]:visible').append("<option value=\"\">请选择</option>" + data);
				} 
				// 删除option
				$('select[name="fillOrganCode"]:visible option').remove();
				if (data != "empty")
				{
					$('select[name="fillOrganCode"]:visible').append("<option value=\"\">请选择</option>" + data);
				} 				
				$("#selfSummaryUnitCodeId option[value='']").remove();//删除‘请选择’，统计时，必须选择一个单位
			},
			param : {
				type : type,codeOther:codeOther
			}
		});		
    	
    }	
	return {
		toggle:toggle,
		changeReportStatus:changeReportStatus,
		changeActive:changeActive,
		changeReportUnit:changeReportUnit
	};
})();



