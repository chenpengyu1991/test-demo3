var saveRabiesPage = (function() {
	var validate = null;
	// 点击保存按钮
	$(function() {
		$.Placeholder.init({
			query : "#idCardTxt",
			callback : function(element) {
				var originalIdcard = $('#originalIdcard').val();
				if($(element).val() != originalIdcard){//如果身份证号码发生改变，重新加载
					getPatientInfo();
				}
			}
		});

		var ehrId = $("#ehrId").val();
		if ($.isEmpty(ehrId) && $("#rabiesType").val() != 9) {
			$("#bitelevel2").attr("checked", true);
		} else if ($.isEmpty(ehrId) && $("#rabiesType").val() == 9) {
			$("#bitelevel1").attr("checked", true);
		} else {
			showLevel();
		}
		$("#opsNameSelect").multiselect({
			header : false,
			noneSelectedText : '请选择',
			selectedList : 7,
			minWidth : "auto"
		});
		$("#bitelevel1").click(function() {
			$("#vaccineDiv").hide();
			$("#vaccineDiv input").val('');
			$("#vaccineDiv select").val('1');
		});
		
		$("#bitelevel2").click(function() {
			$("#vaccineDiv").show();
		});
		
		$("#bitelevel3").click(function() {
			$("#vaccineDiv").show();
		});
		
		validate = $("#vaccine_rabies_save").easyValidate();
		$("#rabiesSave").click(function(e) {
            e.preventDefault();
			vaccineSave();
		});
		$("#rabiesBack").click(function() {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				layer.closeAll();
				$("#vaccineDivIdSearch").show();
				$("#vaccineDivIdDetail").hide();
			});

		});
		toggleOtherSC('VaccinationDetailsDTO.traumaHistory.hurtType','hurtOther','0');
		toggleOtherSC('VaccinationDetailsDTO.traumaHistory.hurtSource','sourceOther','0');
		toggleOtherSC('VaccinationDetailsDTO.traumaHistory.exposeType','exposeOther','0');
		
		initIsInjected();
		 $("input[name='VaccinationDetailsDTO.isInjected'][type='radio']").on("change", function(event)
		{	
			initIsInjected();
//			$.getJsonByUrl({
//				url : "/ph/rabies/getVaccineType",
//				param : {
//					personId : $('#personId').val(),
//					hitDate:$('#hitDate').val()
//				},
//				callback : function(data) {
//					//根据上次咬伤日期、本次咬伤日期判断类型
//					fillVaccineAdvise(getVaccineAdvise(data.vaccineType));
//	            }
//			});			
		});
		$("#lastInjectedDate,#visitdate").on("blur", function(event)
		{	
			fillVaccineAdvise(getVaccineAdvise(0));	
		});
		$('#preOpsDateTxt').on("onDatePickerChanged",function(){
			var preOpsDate = $('#preOpsDateTxt').val();
			var opsDate = $('#hitDate').val();
			var personId = $("#personId").val();
			if(!isEmpty(personId) && !isEmpty(preOpsDate)){
				fillVaccineAdvise(getVaccineAdvise($('#vaccinaType').val()));
			}else if (!isEmpty(preOpsDate)){
				fillVaccineAdvise(getVaccineAdvise(0));
			}
			
        });	
		$('#hitDate').on("onDatePickerChanged",function(){
			var preOpsDate = $('#preOpsDateTxt').val();
			var opsDate = $('#hitDate').val();
			var personId = $("#personId").val();
			if(!isEmpty(personId) && !isEmpty(preOpsDate)){
				fillVaccineAdvise(getVaccineAdvise($('#vaccinaType').val()));
			}else if (!isEmpty(preOpsDate)){
				fillVaccineAdvise(getVaccineAdvise(0));
			}
			
        });
        fillVaccineAdvise($('#vaccinaType').val());
        mainPageH.toggerAddress();
    });
	
	 /**
     * 获取疫苗注射建议
     * vaccineType 0:未找到注射记录，1：未注射，2：未正规注射，3：正规注射
     * modify by GaoFei
     */
    function getVaccineAdvise(vaccineType){
    	var vaccineAdvise = 0;//默认系统没有记录到上次注射情况
        var preDate = $("#preOpsDateTxt").val();
        var lastInjectedDate = $("#lastInjectedDate").val();
        var visitdate = $("#visitdate").val();
        var currentDate = $("#currentDate").val();
        var intervalDays = util.getDateDiff(lastInjectedDate, visitdate);
        if (isEmpty(visitdate)) {
			return;
		}
        /**非健康人预防性接种**/
        if ($("#rabiesType").val() != 9) {
        	//上次注射在半年内且已正规注射狂犬病疫苗，此次不用再次注射
        	if (intervalDays < 183) {
        		vaccineAdvise = '2';
        	}
        	//上次注射超过三年，此次须完整注射疫苗
        	if (intervalDays >= 365 * 3) {
        		vaccineAdvise = '5';
        	}
        	//上次注射在半年内且已正规注射狂犬病疫苗，此次不用再次注射
        	if (intervalDays < 183) {
        		vaccineAdvise = '2';
        	}
        	//上次注射在半年以外一年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天分别注射一针疫苗
        	if (intervalDays >= 183 && intervalDays < 365) {
        		vaccineAdvise = '3';
        	}
        	//上次注射在一年外三年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天、第七天分别注射一针疫苗
        	if (intervalDays >= 365 && intervalDays < 365 * 3) {
        		vaccineAdvise = '4';
        	}
		} else {
			// 健康人预防接种最后1剂后未到1年，此次不需要再次注射
			if (intervalDays < 365) {
				vaccineAdvise = '6';
			}
			// 健康人预防接种最后1剂注射在一年外二年内此次注射一针加强
			if (intervalDays >= 365 && intervalDays < 365 * 2) {
				vaccineAdvise = '7';
			}
			
			// 健康人预防接种最后1剂后超过2年此次须完整注射疫苗
			if (intervalDays >= 365 * 2) {
				vaccineAdvise = '8';
			}
		}
        return vaccineAdvise;
    }

    /**
     * 获取疫苗注射建议
     * vaccineType 0:未找到咬伤记录，1：未注射，2：未正规注射，3：正规注射
     * add by yejianfei
     */
//    function getVaccineAdvise(vaccineType){
//    	debugger;
//    	var vaccineAdvise = 0;//默认系统没有记录到上次咬伤情况
//        var preDate = $("#preOpsDateTxt").val();
//        var opsDate = $("#hitDate").val();
//        var isInjected = $("input[name='VaccinationDetailsDTO.isInjected'][type='radio']:checked").val();
//		if((vaccineType == 0 || vaccineType == 1) && isInjected == '1'){//系统中没有注射记录、咬伤记录,但UI上记录已注射,则标记为正规注射
//			vaccineType = 3;//正规注射
//		}
//		if(vaccineType == 0 && isInjected == '2'){//系统中没有咬伤记录,UI上记录未注射
//			vaccineType = 0;//系统没有记录到上次咬伤情况
//			vaccineAdvise = '0';
//		}
//		if(vaccineType == 1 || vaccineType == 2){
//			vaccineAdvise = '1';//上次咬伤未注射、未正规注射狂犬疫苗，此次重新注射
//		}
//		if(vaccineType == 3){//如果是正规注射，则根据咬伤日期来判断疫苗注射建议
//	        if(isEmpty(opsDate)){//如果咬伤时间为空，默认当前日期
//	            var aDate=new Date();
//	            var thisYear=aDate.getFullYear();
//	            var thisMonth=(aDate.getMonth()+1)<10?"0"+(aDate.getMonth()+1):(aDate.getMonth()+1);
//	            var thisDay=aDate.getDate();
//	            opsDate = thisYear+"/"+thisMonth+"/"+thisDay;
//	        }else{
//	        	//移除日期中的小时
//	        	var lengthOpsDate = opsDate.length;
//	        	opsDate = opsDate.substring(0,lengthOpsDate-2);
//	        }
//	        var intervalDays = util.getDateDiff(preDate, opsDate);
//	        //上次咬伤超过三年，此次须完整注射疫苗
//	        if (intervalDays >= 365 * 3) {
//	            vaccineAdvise = '5';
//	        }
//	        //上次咬伤在半年内且已正规注射狂犬病疫苗，此次不用再次注射
//	        if (intervalDays < 183) {
//	            vaccineAdvise = '2';
//	        }
//	        //上次咬伤在半年以外一年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天分别注射一针疫苗
//	        if (intervalDays >= 183 && intervalDays < 365) {
//	            vaccineAdvise = '3';
//	        }
//	        //上次咬伤在一年外三年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天、第七天分别注射一针疫苗
//	        if (intervalDays >= 365 && intervalDays < 365 * 3) {
//	            vaccineAdvise = '4';
//	        }
//		}
//		return vaccineAdvise;
//    }
	//初始化是否注射过狂犬疫苗
	function initIsInjected()
    {
		var chkVal = $("input[name='VaccinationDetailsDTO.isInjected'][type='radio']:checked").val();
	    if(chkVal== undefined){
	   		$("input[name='VaccinationDetailsDTO.isInjected'][value=2]").attr("checked",true);//
	   		chkVal='2';
	    }
	   	if(chkVal=='1'){
			$(".isInjected").show();
			fillVaccineAdvise(getVaccineAdvise(0));	
		}else if(chkVal=='2'){
			$(".isInjected").hide();
			$("[id^='injectPattern']").hide();
		} 
    }
	 
	// 设置咬伤等级选择
	function showLevel() {
		$("#bitelevel1").attr("disabled", true);
		$("#bitelevel2").attr("disabled", true);
		$("#bitelevel3").attr("disabled", true);
		var level = $("#bitelevel1").attr("checked");
		if (level) {
			$("#vaccineDiv").hide();
			return;
		}
	}

	// 显示保存结果 ---待定
	function vaccineSave() {
        var visitdateTemp =  $('#visitdate').val();
        var hitDateTemp =  $('#hitDate').val();
        var preOpsDateTemp = $("#preOpsDateTxt").val();
        /**非健康人预防性接种**/
        if ($("#rabiesType").val() != 9) {
        	var lengthVisit = visitdateTemp.length;
        	var lengthHit = hitDateTemp.length;     
        	var lengthPreOps = preOpsDateTemp.length;
        	if(lengthHit>0 && lengthVisit>0){
        		var hitDate = new Date(hitDateTemp.substring(0,lengthHit-2));
        		var visittingDate = new Date(visitdateTemp.substring(0,lengthVisit-2));
        		if (hitDate > visittingDate) {
        			layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("咬伤日期不能大于就诊日期！", {icon:0,title:'提示'});
               		});
        			return;
        		}
        	}
        	if(lengthPreOps>0 && lengthHit>0){
        		var preOpsDate = new Date(preOpsDateTemp);
        		var hitDate = new Date(hitDateTemp.substring(0,lengthHit-2));
        		if (preOpsDate > hitDate) {
        			layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("上次咬伤日期不能大于咬伤日期！", {icon:0,title:'提示'});
               		});
        			return;
        		}
        	}
		}

		if($("#idCardTxt").val()=="输入身份证获取个人信息！")
			$("#idCardTxt").val("");
		var result = validate.validateForm();
		if (!result) {
			return;
		}

        //咬伤日期增加“时分”

		if(lengthHit > 0){
	        var opsHour = hitDateTemp.substring(lengthHit-5,lengthHit);
	        $('#opsHour').val(opsHour);
		}
        //就诊日期增加“时分”

		if(lengthVisit > 0){
	        var treatmentHour = visitdateTemp.substring(lengthVisit-5,lengthVisit);
	        $('#treatmentHour').val(treatmentHour);
		}
		$("#vaccine_rabies_save").submitFormLoadHtml({
			url : "/ph/rabies/save",
			callback : function(data) {
				
				layui.use('layer',function(){
				var layer=layui.layer;
				if (data == "1"){
                    layer.alert("保存成功！", {icon:0,title:'提示'}, function (){
					mainPageH.search(1);
					layer.closeAll();
					$("#vaccineDivIdSearch").show();
					$("#vaccineDivIdDetail").hide();
					})
                } else {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }
				})
			}
		});
	}

	// 获取患者信息
	function getPatientInfo() {
		$("#firstFlg").hide();
		validate = $("#vaccine_rabies_save").easyValidate();
		var result = validate.validate("VaccinationDetailsDTO.vaccinationMgmt.idCard");
		if (!result) {
			return;
		}
		var idCard = $("#idCardTxt").val();
		$("#vaccine_rabies_save").submitFormGetJson({
			url : "/hospital/records/flush",
			param : {
				idCard : idCard
			},
			callback : function(data) {
				fillPatientInfo(data);
				if(!isEmpty(data)){
					getHertDetail(data.personId);
				}
			}
		});
	}
	
	function getHertDetail(personId){
		$.getJsonByUrl({
			url : "/ph/rabies/getVaccineType",
			param : {
				personId : personId
			},
			callback : function(data) {

				fillLastInjected(data);//最近一次接种信息
				//根据上次咬伤日期、本次咬伤日期判断类型
				var vaccineAdvise = getVaccineAdvise(data.vaccineType);
				fillVaccineAdvise(vaccineAdvise);//疫苗接种提示
				$('#vaccinaType').val(data.vaccineType);
				// 根据接诊事件记录表中的是否全程接种标志  2017/1/19 高飞
				if (data.completeFlag == 0 || isEmpty(data.completeFlag)) {
					$("#completeFlagId0").attr("checked","checked");
				} else if (data.completeFlag == 1 || vaccineAdvise == '2') {
					$("#completeFlagId1").attr("checked","checked");
				}
            }
		});
	}
	
	/**
	 * 显示患者信息
	 */
	function fillPatientInfo(data){
		var idcard= $('#idCardTxt').val();
		var birthday = (IC.getBirthday(idcard)).substring(0,4);
		if(birthday){
			var age =(new Date().getFullYear())-parseInt(birthday, 10);
		}
		/*if(age<18){
			$("#guardianNameHide").show();
			$("#guardianPhoneHide").show();
			$("#guardianNameShow").hide();
			$("#guardianPhoneShow").hide();
		}else{
			$("#guardianNameHide").hide();
			$("#guardianPhoneHide").hide();
			$("#guardianNameShow").show();
			$("#guardianPhoneShow").show();
		}*/
		$("#ageTxt").val(age);
		if ($.isEmpty(data)) {
			$("#nameTxt").val("");
			$("#genderTxt").val("");
			$("#phoneNumberTxt").val("");
			$("input[name='VaccinationDetailsDTO.isInjected'][value=2]").attr("checked",true);
			$(".isInjected").hide();
			layui.use('layer', function() {
    			var layer = layui.layer;
    			layer.alert("系统不存在该患者,点击保存提交患者信息！", {icon:0,title:'提示'});
       		});
			return;
		}
        $('#town_address').val(data.patownShip);
        if(data.patownShip!=null){
            $("#town_address").val(data.patownShip);
            iddStreet=$("#town_address").attr("idd").replace('townId', '');
        }
        orgUtil.getStreetOpting(iddStreet, data.pastreet, '', data.paGroup);
		$("#nameTxt").val(data.name);
		$("#genderTxt").val(data.gender);
		$("#phoneNumberTxt").val(data.phoneNumber);
		$("#personId").val(data.personId);
		$("#text_pahouseNumber").val(data.pahouseNumber);
		$('input[@type=radio][name="VaccinationDetailsDTO.vaccinationMgmt.householdType"][value=' + data.householdType + ']').attr("checked",true);
		mainPageH.toggerAddress();
	}
	/**
	 * 显示最近一次接种信息
	 */
	function fillLastInjected(data){
		if(data.vaccineType != 0){
			$(".isInjected").show();
			$("input[name='VaccinationDetailsDTO.isInjected'][value=1]").attr("checked",true);
			$("input[name='VaccinationDetailsDTO.completeFlag'][value='"+data.completeFlag+"']").attr("checked",true);
			$("#lastInjectedDate").val(data.lastInjectedDate);
			$("#vaccinationCount").val(data.count);
			$("#factory").val(data.factory);
			$("#otherNote").val(data.otherNote);
			$("#preOpsDateTxt").val(data.preOpsDate);
		}
	}

	/**
	 * 疫苗注射情况提示
	 */
	function fillVaccineAdvise(vaccineType){
		if (isEmpty(vaccineType)) {
			return;
		}
		$("[id^='injectPattern']").hide();
		var id = "#injectPattern" + vaccineType;
		$('#vacciantionFlag').val(vaccineType);//本次事件的性质,0、1、5表示重新接种，其他表示加强接种。
	    $("#flagMgmtId").val(vaccineType);
		$(id).show();	
	}
		
    return {
    };
})();
