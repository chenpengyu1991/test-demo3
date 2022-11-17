var reserveschedule = (function() {
	$(function() {
		search(1);
		$("#reserveScheduleBtn").click(function(){
			search(1);
		});
		
		var option = autoClinic();
		
//		$("#schSelect").change(function(){
//			var hospitalCode = $("#schSelect").val();
//			var param1 = {
//				hospitalCode:hospitalCode
//			};
//			option.param = param1;
//		});
		
		$("#scheduleSearch").onEnter(function(){
			search(1);
		});
	});
	
	function autoClinic(){
		var hospitalCode = $("#schSelect").val();
		var options = {
			url : contextPath + "/portal/reserve/clinic",
			feild:{
				value:"deptSn",
				lable:"name"
			},
			param :{
				hospitalCode:hospitalCode
			}
		};
		return $("#sclinic").selectBox(options);
	}
	
	function search(indexPage){
		var option = {
			url:"/portal/reserve/scheduleList",
			insertDiv:"scheduleDiv",
			param:{
				indexPage:indexPage,
				clinicName:$("#sclinic").val()
			}
		};
		$("#scheduleSearch").submitFormLoadHtml(option);
	}
	
	function select(data){
		$.removeDialog("schDialogId");
		$("#scheduleId").val(data.scheduleId);
		$("#scheduleTimeId").val(data.scheduleTimeId);
		$("#hospitalName").val(data.hospitalName);
		$("#outClinicName").val(data.outClinicName);
		$("#outDoctorName").val(data.outDoctorName);
		$("#clinicType").val(data.clinicType);
		$("#registerFee").val(data.registerFee);
		$("#requestDate").val(data.requestDate);
		$("#takeNoTimeId").val(data.takeNoTime);
	}
	
	function showReserveTimeDiv(){
		$("#showReserveTimeDiv").show();
	}
	function hideReserveTimeDiv(){
		$("#showReserveTimeDiv").hide();
	}
	
    function selectRegisterScheduleTimes(obj,id) {
		$("#showReserveTimeDiv").show();
		var leftv = $(obj).offset().left - 250 ;
		var topv = $(obj).offset().top + 28;
		$("#showReserveTimeDiv").offset({
			left : leftv,
			top : topv
		});
		
		$.loadHtmlByUrl({
			insertDiv:"showReserveTimeDiv",
			url : "/portal/reserve/select",
			param :{
				scheduleId:id
			}
		});
	}
    
	return {
		search:search,
		select:select,
		showReserveTimeDiv:showReserveTimeDiv,
		hideReserveTimeDiv:hideReserveTimeDiv,
        selectRegisterScheduleTimes:selectRegisterScheduleTimes
	};
})();