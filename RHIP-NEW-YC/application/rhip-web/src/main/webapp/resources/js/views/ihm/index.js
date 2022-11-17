var statisticsIndex = (function(){
	var loadingImg = "<span><img src='" + contextPath + "/images/AjaxLoader16.gif' style='vertical-align:top;'/></span>";
	$(function(){
		$("#outAndHos").append(loadingImg);
		getChartData();
		getEHRTarget();
		getCDMTarget();
		getOutpatientTarget();
		getOutpatientMonthTarget();
		getYearTarget();
		getVaccinationTarget();
		getWomenChildrenTarget();
		getIDMTarget();
	});

	/**
	 * 全市电子健康档案
	 */
	function getEHRTarget(){
		var params = {
			url : '/hm/getEHRTarget',
			checkRepeat : false,
			callback : function(result){
				$('#ehr003').text(result.PH001+result.PH002);//全市已建档
				$('#ehr001').text(result.PH001);//全市已建档(非户籍)
				$('#ehr002').text(result.PH002);//全市已建档(户籍)
				$('#docReadNum').text(result.docReadNum);//医生使用档案
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	/**
	 * 全市社区公共卫生
	 */
	function getCDMTarget(){
		var params = {
			url : '/hm/getCDMTarget',
			checkRepeat : false,
			callback : function(result){
				$('#cdm032').text(result.PH032);//高血压建卡
				$('#cdm058').text(result.PH058);//糖尿病建卡
				$('#cdm061').text(result.PH061);//糖尿病随访
				$('#cdm062').text(result.PH062);//高血压随访
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	/**
	 * 全市实际门急诊业务（天）
	 */
	function getOutpatientTarget(){
		var params = {
			url : '/hm/getOutpatientTarget',
			checkRepeat : false,
			callback : function(result){
				$('#allNum').text(result.outpatientDay.allNum);//昨日门急诊
				$('#allFee').text(result.outpatientDay.allFee);//总费用
				$('#medicinalFee').text(result.outpatientDay.medicinalFee);//药品费用
				$('#insuranceFee').text(result.outpatientDay.insuranceFee);//医保医疗
				$('#personalFee').text(result.outpatientDay.personalFee);//个人承担
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	/**
	 * 全市实际住院业务（月）
	 */
	function getOutpatientMonthTarget(){
		var params = {
			url : '/hm/getOutpatientMonthTarget',
			checkRepeat : false,
			callback : function(result){
				$('#leaveHospitalNum').text(result.hospitalizeMonth.leaveHospitalNum);//上月出院
				$('#inHosFee').text(result.hospitalizeMonth.inHosFee);//总费用
				$('#inHosMedicinalFee').text(result.hospitalizeMonth.inHosMedicinalFee);//药品费用
				$('#inInsuranceFee').text(result.hospitalizeMonth.inInsuranceFee);//医保医疗
				$('#inPersonalFee').text(result.hospitalizeMonth.inPersonalFee);//个人承担
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	/**
	 * 全市实际门急诊业务（年）,全市实际住院业务（年）,全市实际医疗费用（年）
	 */
	function getYearTarget(){
		var params = {
			url : '/hm/getYearTarget',
			checkRepeat : false,
			callback : function(result){
				//全市实际门急诊业务（年）
				$('#allNumYear').text(result.outpatientYear.allNum);//今年门急诊
				$('#allFeeYear').text(result.outpatientYear.allFee);//总费用
				$('#medicinalFeeYear').text(result.outpatientYear.medicinalFee);//药品费用
				$('#insuranceFeeYear').text(result.outpatientYear.insuranceFee);//医保医疗
				$('#personalFeeYear').text(result.outpatientYear.personalFee);//个人承担
				//全市实际住院业务（年）
				$('#leaveHospitalNumYear').text(result.hospitalizeYear.leaveHospitalNum);//今年出院
				$('#inHosFeeYear').text(result.hospitalizeYear.inHosFee);//总费用
				$('#inHosMedicinalFeeYear').text(result.hospitalizeYear.inHosMedicinalFee);//药品费用
				$('#inInsuranceFeeYear').text(result.hospitalizeYear.inInsuranceFee);//医保医疗
				$('#inPersonalFeeYear').text(result.hospitalizeYear.inPersonalFee);//个人承担
				//全市实际医疗费用（年）
				$('#allFeeTotal').text(result.outpatientYear.allFee + result.hospitalizeYear.inHosFee);//总收入

				$('#allFeeAvg').text(result.allFeeAvg);//门急诊人均费用
				$('#inHosFeeAvg').text(result.inHosFeeAvg);//住院人均费用
				$('#medicinalPercent').text(result.medicinalPercent);//药品费用比例
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	/**
	 * 预防接种
	 */
	function getVaccinationTarget(){
		var params = {
			url : '/hm/getVaccinationTarget',
			checkRepeat : false,
			callback : function(result){
				$('#vaccinationNum').text(result.vaccinationNum);//预防接种总人数
				$('#vaccinationCurrentYear').text(result.vaccinationCurrentYear);//本年接种人数
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	/**
	 * 妇幼保健
	 */
	function getWomenChildrenTarget(){
		var params = {
			url : '/hm/getWomenChildrenTarget',
			checkRepeat : false,
			callback : function(result){
				$('#wc021').text(result.PH021);//新生儿访视人数
				$('#wc022').text(result.PH022);//婴幼儿健康管理数
				$('#wc027').text(result.PH027);//产后访视人数
				$('#wc028').text(result.PH028);//产后42天健康检查人数
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	/**
	 * 全市医疗单位信息
	 */
	function getIDMTarget(){
		var params = {
			url : '/hm/getIDMTarget',
			checkRepeat : false,
			callback : function(result){
				$('#idm056').text(result.PH056);//昨日上报数
				$('#idm053').text(result.PH053);//总上报数
			},
			param :{}
		};
		$.getJsonByUrl(params);
	}

	function getChartData(){
		$.getJsonByUrl({
			url : "/hm/chart",
			callback : callback
		});
	}
	
	function callback(data){
		$(loadingImg).remove();
		var year = data["year"];
		var outData = data["outpatient"];
		var hosData = data["hospitalize"];
		var outFeeData = data["outfees"];
		var outInsuranceFeeData = data["outinsurancefees"];
		var hosFeeData = data["hosfees"];
		var hosInsuranceFeeData = data["hosinsurancefees"];
		
		var outDataArray = new Array();
		var hosDataArray = new Array();
		var outFeeDataArray = new Array();
		var outInsuranceFeeDataArray = new Array();
		var hosFeeDataArray = new Array();
		var hosInsuranceFeeDataArray = new Array();
		var monthArray = new Array();
		
		for(var i=0; i<12; i++){
			var out = outData["outpatient"+i];
			var hos = hosData["hospitalize"+i];
			var outFee = outFeeData["outfee"+i];
			var outInsuranceFee = outInsuranceFeeData["outinsurancefee"+i];
			var hosFee = hosFeeData["hosfee"+i];
			var hosInsuranceFee = hosInsuranceFeeData["hosinsurancefee"+i];
			if(out == undefined){
				break;
			}
			outDataArray.push(out);
			hosDataArray.push(hos);
			outFeeDataArray.push(outFee);
			outInsuranceFeeDataArray.push(outInsuranceFee);
			hosFeeDataArray.push(hosFee);
			hosInsuranceFeeDataArray.push(hosInsuranceFee);
			monthArray.push(i + 1 + "月");
		}
		
		Highcharts.setOptions({
			lang : {
				numericSymbols : null
			}
		});
		
		var outHosChart = new Highcharts.Chart({
			chart : {
				borderColor: '#C0c0c0',
				borderWidth: 1,
//				backgroundColor: '#ACE4FF',
				renderTo : 'outAndHos'
			},
			credits : {
				enabled : false
			},
			title : {
				text : '全市医院' + year + '年门急诊、住院业务量月趋势图(人次)'
			},
			xAxis : {
				categories : monthArray
			},
			yAxis : {
				title : {
					text : null
				}
			},
			exporting : {
				enabled : false
			},
			lang : {
				numericSymbols : 'null'
			},
			tooltip: {
	            formatter: function() {
	                return this.x + "：" + this.y + "人";
	            }
	        },
			series : [{
				type : 'column',
				name : '门急诊',
				data : outDataArray
			},
			{
				type : 'column',
				name : '住院',
				data : hosDataArray
			}]
		});
		
		var outHosFeeChart = new Highcharts.Chart({
			chart : {
				borderColor: '#C0c0c0',
				borderWidth: 1,
				renderTo : 'outAndHosFee'
			},
			credits : {
				enabled : false
			},
			title : {
				text : '全市医院' + year + '年门急诊、住院费用趋势图(元)'
			},
			xAxis : {
				categories : monthArray
			},
			yAxis : {
				title : {
					text : null
				}
			},
			exporting : {
				enabled : false
			},
			lang : {
				numericSymbols : 'null'
			},
			tooltip: {
	            formatter: function() {
	                return this.x + "：" + this.y + "元";
	            }
	        },
			series : [{
				type : 'column',
				name : '门急诊',
				data : outFeeDataArray
			},
			{
				type : 'column',
				name : '门诊医保费用',
				data : outInsuranceFeeDataArray
			},
			{
				type : 'column',
				name : '住院费用',
				data : hosFeeDataArray
			},
			{
				type : 'column',
				name : '住院医保费用',
				data : hosInsuranceFeeDataArray
			}]
		});
	}
})();