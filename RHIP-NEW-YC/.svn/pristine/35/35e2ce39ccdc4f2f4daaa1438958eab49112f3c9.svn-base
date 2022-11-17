var reserveschedule = (function() {
	$(function() {
		initList();		
		init_dept_tab();
		/*search(1);*/
		initPic();
		init_hospital_tab();
	 $("#btn_reserve_search").click(function(){
		 $("#reserveSelect").hide();
		 reserveSearchList(1);
        });
	 if( $(".select-clinic").size()>24){	
		 $(".clinic-list").height(200);
		 $(".clinic-list").css("overflow-y","scroll");
	 }	 
	});
	
	
	function selectOption(obj,type,code){
		$("#" + type).val(code);
		var typeCode = $("#type").val();
		var option;
		
		if (type == 'hospital') {
			$("#depart-level1-ul-hospital li").removeClass("select-cur");
			$(obj).addClass("select-cur");
			$("#showJinggao").hide();
			$("#clinic").val("");
			$("#clinicType").val("");
			option = {
				url:"/userSpace/reserve/scheduleClinic",
				insertDiv:"scheduleClinicDiv",
				param:{
					type:typeCode
				}
			};
		}
		if (type == 'clinic') {
			if ($("#hospital").val() == "45404094-7" && code == '32900') {
				msgUtil.alert("康复科门诊，多胞胎请挂多个号！");
			}
			$("#depart-level1-ul-clinic li").removeClass("select-cur");
			$(obj).addClass("select-cur");
			$("#clinicType").val("");
			$("#deptName").val($.trim($(obj).text()));
			$("#medtitle-ul li").removeClass("select-cur");
			$("#medtitle-ul li:first").addClass("select-cur");
			$("#clinicTypeID").show();
			option = {
				url:"/userSpace/reserve/scheduleList",
				insertDiv:"scheduleDiv",
				param:{
					indexPage:1,
					type:typeCode
				}
			};
		}
		
		if (type == 'clinicType') {
			$("#medtitle-ul li").removeClass("select-cur");
			$(obj).addClass("select-cur");
			option = {
					url:"/userSpace/reserve/scheduleList",
					insertDiv:"scheduleDiv",
					param:{
						indexPage:1,
						type:typeCode
					}
				};
		}
		
		$("#scheduleSearch").submitFormLoadHtml(option);
		/*if(type == "clinic"){
			$("#flowChart").addClass("select-hospital-num-node");
			$("#clinicType").val("");
		}*/
	}
	
	//快速搜索链接
	function selectOptions(data){
		$("#clinic").val(data.clinic);
		$("#hospital").val(data.hospital);
		$("#deptName").val(data.deptName);
		$("#doctor").val("");
		$("#scheduleSearch").submit();
	}
	
	function hideReserveCnt(){
		$("#showCount").hide();
	}
	
	function search(indexPage){
		var option = {
			url:"/userSpace/reserve/scheduleList",
			insertDiv:"scheduleDiv",
			param:{
				indexPage:indexPage,
				type:$("#type").val()
			}
		};
		$("#scheduleSearch").submitFormLoadHtml(option);
	}
	
	function select(data){
		var tableData = [];
		var popObj = {};
		popObj["hospitalCode"] = data.hopsitalCode;
		popObj["hospitalName"] = data.hospitalName;
		popObj["deptSn"] = data.deptSn;
		popObj["deptName"] = data.outClinicName;
		popObj["doctorSn"] = data.doctorSn;
		popObj["doctorName"] = data.outDoctorName;
		popObj["registerFee"] = data.registerFee;
		popObj["requestDate"] = data.requestDate;
		popObj["ampm"] = data.ampm;
		popObj["id"] = data.scheduleId;
		popObj["timeIntervalStart"] = data.timeIntervalStart;
		popObj["timeIntervalEnd"] = data.timeIntervalEnd;
		popObj["clinicType"] = data.clinicType;
		tableData.push(popObj);
		var registerScheduleTimeDialog = {
				id :"regScheduleTime",
				url : "/userSpace/reserve/loadConfirmInfo",
				param :{
					data:((Obj2str(tableData))),
					frequentId:$("#frequent").val(),
					scheduleTimeId:data.scheduleTimeId,
					scheduleId:data.scheduleId
				},
				height:'auto',
				width : 550,
				title : "预约信息确认"
		};
		$.dialog(registerScheduleTimeDialog);
			
		$("#regScheduleTime").css("top",$("#showReserveTimeDiv").position().top + 500 + "px");
	}
	
	function showReserveTimeDiv(){
		$("#showReserveTimeDiv").show();
	}
	function hideReserveTimeDiv(){
		$("#showReserveTimeDiv").hide();
	}
	
	function selectRegisterScheduleTimes(obj,data) {
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
						selectRegScheduleTimesByCheckReserveStatus(obj,data);
					}
				}
			});
		}
	}

	function selectRegScheduleTimesByCheckReserveStatus(obj,data) {
		$("#showReserveTimeDiv").show();
		var leftv = $(obj).offset().left - 255 ;
		var topv = $(obj).offset().top + 25;
		$("#showReserveTimeDiv").offset({
			left : leftv,
			top : topv
		});
		
		$.loadHtmlByUrl({
			insertDiv:"showReserveTimeDiv",
			url : "/userSpace/reserve/select",
			param :{
				data:((Obj2str(data)))
			}
		});
	}
	
	
	function initPic() {
		var hasImg = $(".hospital-pic").find("img").html();
		if (hasImg == undefined) {
			$(".hospital-pic").append("<img src="+contextPath+"/images/hospic.png/>");
		}
	}
	
	//医院信息滚动
	function init_hospital_tab() {
		$("#titles").find("li").click(function() {
			var tabLiList=$("#titles li").find("a");
			var current_index = $(this).index();
			for(var i = 0;i < $("#titles").find("li").length;i++)
			{
				if(i == current_index){
					tabLiList.eq(i).addClass("select");
					$("#titleContent1_item0_" + i.toString()).show();
				}else{
					tabLiList.eq(i).removeClass("select");
					$("#titleContent1_item0_" + i.toString()).hide();
				}
			}
		});
	}
	
	//科室信息选择
	function init_dept_tab() {
		$("#depart-level1-ul").find("li").click(function() {
			var tabLiList=$("#depart-level1-ul").find("li");
			var current_index = $(this).index();
			for(var i = 0;i < $("#depart-level1-ul").find("li").length;i++)
			{
				if(i == current_index){
					if((tabLiList.eq(i).html()).trim() == ($("#clinicName").val()).trim())
					tabLiList.eq(i).addClass("select-cur");
				}else{
					tabLiList.eq(i).removeClass("select-cur");
				}
			}
		});
	}
	
	function reserveSearchList(indexPage) {
		var searchContent = $("#searchContent").val();
		var type = $("#type").val();
        var option = {
            url: contextPath + "/userSpace/reserve/reserveSearchList",
            insertDiv: "reserveSearchList",
            wait: true,
            param: {
            	searchContent: searchContent,
            	type: type,
                indexPage: indexPage
            }
        };
        $("#reserve_search").submitFormLoadHtml(option);
    };
	
    function initList() {
		for(var i = 0;i < $(".item").find(".tro").length;i++)
		{
			var description = $(".item .detail-"+i.toString()).html();
			description=description.replace(/<\/?[^>]*>/gim,"");
			description = description.replace(/(^\s+)|(\s+$)/g, ""); 
			description = description.replace(/(\&nbsp;)/g, "");
			if(description.length > 100) {
				description = description.substring(0,100)+" . . ."; 
			}
			$(".item .detail-"+i.toString()).html(description);
		}
	}
    
    function selectFrequentOption(obj, code){
		$("#frequent").val(code);
	}
    
    
    /* 对象转成json/json数组 */
	function Obj2str(o)
	{
		if (o == undefined)
		{
			return "";
		}
		var r = [];
		if (typeof o == "string")
			return "\"" + o.replace(/([\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
		if (typeof o == "object")
		{
			if (!o.sort)
			{
				for ( var i in o)
					r.push("\"" + i + "\":" + Obj2str(o[i]));
				if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString))
				{
					r.push("toString:" + o.toString.toString());
				}
				r = "{" + r.join() + "}";
			} else
			{
				for ( var i = 0; i < o.length; i++)
					r.push(Obj2str(o[i]));
				r = "[" + r.join() + "]";
			}
			return r;
		}
		return o.toString().replace(/\"\:/g, '":""');
	}
	
	
	return {
		search:search,
		select:select,
		selectOption:selectOption,
		selectOptions:selectOptions,
		selectFrequentOption:selectFrequentOption,
		showReserveTimeDiv:showReserveTimeDiv,
		hideReserveTimeDiv:hideReserveTimeDiv,
		hideReserveCnt:hideReserveCnt,
		selectRegisterScheduleTimes:selectRegisterScheduleTimes,
		reserveSearchList:reserveSearchList
	};
})();