var hotExpertSearch = (function() {
	$(function() {
		//initPic();
		search(1);
		$("#btn_hotExpert_search").click(function(){
			$("#hospital").val("");
			$("#clinic").val("");
			$("#doctorSn").val("");
			$("#depart-level1-ul li").removeClass('select-cur');
			$("#depart-level1-ul li:first").addClass('select-cur');
			$("#showClinic").css("display","none")
			$("#showHotExpetLists").css("margin-top","10px")
			search(1);
        });
		 
		 if( $(".select-clinic").size()>24){	
			 $(".select-clinic-list").height(200);
			 $(".select-clinic-list").css("overflow-y","scroll");
		 }
	});
	
	/*function initPic() {
		for(var i = 0;i < $(".hospitalInfo_lists").find("li").length;i++) {
			var hasImgs = $(".hospital-info-li .hospital-info .pic-"+i.toString()).find("a img").html();
			if (hasImgs == undefined) {
				$(".hospital-info-li .hospital-info .pic-"+i.toString()).find('a').append("<img src="+contextPath+"/images/doctor/doctor_default_img.jpg/>");
			}
		}
	}*/
	
	function selectOption(type,code){
		$("#" + type).val(code);
		if(type == "hospital"){
			$("#clinic").val("");
		}else if(type == "clinic"){
			$("#doctorSn").val("");
			$("#empTit").val("");
		}
		$("#hotExpertSearch").submit();		
	}
	
	function search(indexPage){
		var searchContent = $("#searchContent").val();
		var option = {
			url:"/userSpace/hotExpert/list",
			insertDiv:"showHotExpetLists",
			param:{
				indexPage:indexPage,
				searchContent :searchContent
			}
		};
		$("#hotExpertSearch").submitFormLoadHtml(option);
	}
	
	function showWorkExperience(index){
		$(".workExperience").slideUp("slow");
		$("#workExperience-"+index).slideDown("slow");
	}
	
	function hideWorkExperience(index){
		$("#workExperience-"+index).hide();
	}
	

	function showHotExpertReserve(data){
		if(data.account == '') {
			window.location.href = contextPath+ "/userSpace/hotExpert/scheduleList";
		} else {
			$(".cur-reserve").slideUp("slow");
			$(".cur-reserve").removeClass("cur-reserve");
			$("#hotExpertReserve-"+data.index).slideDown();
			$("#hotExpertReserve-"+data.index).addClass("cur-reserve");
			
			$.loadHtmlByUrl({
				insertDiv:"hotExpertReserveDetail-"+data.index,
				url:"/userSpace/hotExpert/scheduleList",
				param :{
					hospital:data.hospital,
					clinic:data.clinic,
					doctor:data.doctor
				}
			});
		}
	}
	
	function hideHotExpertReserve(index) {
		$("#hotExpertReserve-"+index).hide();
		/*$("#hide"+index).hide();
		$("#show"+index).show();*/
	}
	
	function selectRegisterScheduleTimes(obj,id) {
		
		var frequentId = $("#frequent").val();
		var isAccount;
		if ($('#accountInfo').attr("disabled") == "disabled"){
			isAccount = 'noAccount';
		}
		if (frequentId == '' && isAccount == 'noAccount') {
			msgUtil.alert("预约用户不能为空！");
		} else {
			$.getJsonByUrl({
				url : "/userSpace/reserve/checkReserveStatus",
				param :{
					frequentId:frequentId
				},
				callback:function(model){
					if(!model.success){
						msgUtil.alert("该用户已被禁止预约！");
					} else {
						selectRegScheduleTimesByCheckReserveStatus(obj,id);
					}
				}
			});
		}
	}
	function selectRegScheduleTimesByCheckReserveStatus(obj,id) {		
		$(obj).parent().parent().find("td").css("border","1px solid #ddd");
		$(obj).parent().css("border","2px solid #2B6917");
		//$("[id^='showReserveTimeDiv-"+ id +"']").remove();
		//$("#showReserveTimeDiv-"+id).show();
		//$("[id^='showReserveTimeDiv-"+ id +"']").hide();
		/*var leftv = $(obj).offset().left + 145;
		var topv = $(obj).offset().top;
		$("#showReserveTimeDiv-"+id).offset({
			left : leftv,
			top : topv
		});*/
		$(obj).parent().parent().parent().parent().next().attr("id","reserveTime-" + id)
		$.loadHtmlByUrl({
			insertDiv:"reserveTime-" + id,
			url : "/userSpace/hotExpert/select",
			param :{
				scheduleId:id
			}
		});
		//$("#reserveTime-"+id).attr("id","reserveTime-" + id);
		//showReserveTimeDivPosi(id,"absolute","99");
	}
	
	function showReserveTimeDiv(){
		showReserveTimeDivPosi("absolute","99");
		$("[id^='showReserveTimeDiv']").show();
	}
	function hideReserveTimeDiv(){
		showReserveTimeDivPosi("","");
		/*$("[id^='showReserveTimeDiv']").offset({ top: 0, left: 0 });
		$("[id^='showReserveTimeDiv']").style.left("left","0");*/
		$("[id^='showReserveTimeDiv']").hide();
	}
	function showReserveTimeDivPosi(id,position, zindex) {
		$("#showReserveTimeDiv-"+id).css("position",position);
		$("#showReserveTimeDiv-"+id).css("z-index",zindex);
	}
	function select(data){
		var registerScheduleTimeDialog = {
				id :"regScheduleTime",
				url : "/userSpace/reserve/loadConfirmInfo",
				param :{
					scheduleId:data.scheduleId,
					scheduleTimeId:data.scheduleTimeId,
					frequentId:$("#frequent").val()
				},
				height:'auto',
				width : 550,
				title : "预约信息确认"
		};
		$.dialog(registerScheduleTimeDialog);
		
		//$("#regScheduleTime").css("top",$("[id^='showReserveTimeDiv']").position().top + 500 + "px");
	}
	
	//快速搜索链接
	function hotExpertSearchList(indexPage) {
		var searchContent = $("#searchContent").val();
        var option = {
            url: contextPath + "/userSpace/hotExpert/hotExpertSearchList",
            insertDiv: "showHotExpetLists",
            wait: true,
            param: {
            	searchContent: searchContent,
                indexPage: indexPage
            }
        };
        $("#hotExpert_search").submitFormLoadHtml(option);
    };
    
    function selectFrequentOption(obj, code){
		$("#frequent").val(code);
		//var p_obj = $(obj).siblings();
		//p_obj.siblings().removeClass('select-cur');
		//$(obj).addClass("select-cur");
	}
    
	return {
		selectOption:selectOption,
		search:search,
		showWorkExperience:showWorkExperience,
		hideWorkExperience:hideWorkExperience,
		showHotExpertReserve:showHotExpertReserve,
		hideHotExpertReserve:hideHotExpertReserve,
		selectRegisterScheduleTimes:selectRegisterScheduleTimes,
		showReserveTimeDiv:showReserveTimeDiv,
		hideReserveTimeDiv:hideReserveTimeDiv,
		select:select,
		selectFrequentOption:selectFrequentOption
	};
})();