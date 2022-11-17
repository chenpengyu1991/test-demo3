var echReport = (function() {
	var validate = null;
	$(function() {
		validate = $("#reportForm").easyValidate();
		initForm();
		enableChangeConfirm();
	});

	function initForm(){
		var editflag = $('#editflag').val();
		if(editflag == 'edit'){
			$("th div").mouseout(function() {
				if (this.id != "") {
					if (this.className != "optionSelect") {
						this.className = "optionNormal";
					}
				}
			});
			$("th div").mouseover(function() {
				if (this.id != "") {
					if (this.className != "optionSelect") {
						this.className = "optionOver";
					}
				}
			});	
			$("th div").click(function() {
				if (this.id != "") {
					var ids = this.id.split('_');
					$("#" + ids[0] + "_0" ).attr("class", "optionNormal");
					$("#" + ids[0] + "_1" ).attr("class", "optionNormal");
					/*$("#" + ids[0] + "_3" ).attr("class", "optionNormal");
					$("#" + ids[0] + "_4" ).attr("class", "optionNormal");
					$("#" + ids[0] + "_5" ).attr("class", "optionNormal");*/
					this.className = "optionSelect";
					contentChanged = true;
					checkSorce($(this).data('optionNo'));
				}
			});	
			$("#save").click(function() {
				saveReport();
			});
			$("#calcTZJG").click(function() {
				calcTizhijieguo();
			});
			$("#cancelButton").click(function() {
				closeEchCalc();
			});
		}else{
			$("#reportForm").diabaleForm();
			$('.required').removeClass("required");			
		}
		initScore();
	}
	
	/**
	 * 初始化分数
	 */
	function initScore(){
		var options = $('#options').val();
		if(!$.isEmpty(options)){
			var optionDatas = options.split(';');
			 for(var option in optionDatas){  
			 	$("#" + optionDatas[option] ).attr("class", "optionSelect");
			 }
		}
	}
	
	/**
	 * 检查33道题是否全部选择
	 */
	function checkAllScore(){
		var i = 0;
		var selectFlag = true;
		for (i = 1; i < 31; i++) { 
			if(!checkSorce(i)){
				selectFlag = false;
			}
		}
		return selectFlag
	}
	/**
	 * 检查题目是否被选择
	 */
	function checkSorce(optionId){
		var selectFlag = $("th div[data-option-no='"+ optionId + "']").hasClass('optionSelect');
		if(!selectFlag){
			$("th div[id='option"+ optionId + "_1']").parent().prev().addClass('optionLose');
			$("th div[id='option"+ optionId + "_0']").parent().prev().addClass('optionLose');
		}else{
			$("th div[id='option"+ optionId + "_1']").parent().prev().removeClass('optionLose');
			$("th div[id='option"+ optionId + "_0']").parent().prev().removeClass('optionLose');
		}
		return selectFlag
	}
	
	/**
	 * 保存辨识表
	 */
	function saveReport(){
		if(!checkAllScore()){
			layer.alert("服务记录表未填写完整！", {icon:0,title:'提示'});
			return;
		}
		var optionDatas = getOptionData();
		var optionDatasNum = getOptionDataNum();
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
    	var sourceFlag = $('#sourceFlag').val();
    	$("#emotionScreenResultStr").val(util.Obj2str(optionDatas));
    	$("input[id='depressionScore']").val(optionDatasNum);
    	
    	if (optionDatasNum >= 15) {
			
			contentChanged = false;
//	    	$.removeDialog ("depressedDialog");
//	       	$("#CMedicine").show();
	    	var index = layer.alert("保存成功！老年抑郁可能，转上级医院精神科处理。", {icon:0,title:'提示'}, function() {
	    		layer.close(index);
	    		layer.close(index-1);
	    	});
	        return false;
        }else{
        	contentChanged = false;
//	    	$.removeDialog ("depressedDialog");
//	       	$("#CMedicine").show();
        	var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	    		layer.close(index);
	    		layer.close(index-1);
	    	});
            return false;
        }
    	
    	
    	
    	/*if("1" == $('#sourceFlag').val()){//来源：中医药
	        $("#reportForm").submitFormLoadHtml({
				url : "/personRecord/saveDepressed",
	            wait : true,
	            insertDiv : "result",
	            param : {
					optionDatas : util.Obj2str(optionDatas),
					sourceFlag:$('#sourceFlag').val()
				},
				callback : function(data) {
					if (data.indexOf("fail") > -1) {
						msgUtil.alert("保存失败！");
	                }else{
	                    msgUtil.alert("保存成功！");
		                $("#report").hide();
					    $("#result").show();
		                contentChanged = false;
	                    return false;
	                }
				}
			});	    		
    	}else{*///来源：健康档案
	         /*$("#reportForm").submitFormGetJson({
				url : "/ech/manage/report/save1",
	            wait : true,
	            param : {
					optionDatas : util.Obj2str(optionDatas),
					sourceFlag:$('#sourceFlag').val()
				},
				callback : function(data) {
					if ($.isEmpty(data)) {
						msgUtil.alert("保存失败！");
	                }else{
	                	contentChanged = false;
	                   	updateEch(data);
	                   	$("#CMedicine").show();
	                    msgUtil.alert("保存成功！");
	                    return false;
	                }
				}
			});	 */  		
    	//}
		
	}

	/**
	 * 计算中医体质结果
	 */
	function calcTizhijieguo(){
		if(!checkAllScore()){
			layer.alert("服务记录表未填写完整！", {icon:0,title:'提示'});
			return;
		}
		var optionDatas = getOptionData();
		/*var result=validate.validateForm();
		if(!result){
			return;
		}*/
		var sourceFlag = $('#sourceFlag').val();
		var echCalc = {
			id :"d1",
			url : "/ech/manage/report/calc",
			height : 320,
			width : 450,
			param : {
				optionDatas : util.Obj2str(optionDatas),
				sourceFlag:$('#sourceFlag').val()
			},
			title : "计算结果",
			showClose : false
		};
		$.dialog(echCalc);
	}

/*	function closeEchCalc(){
		$.removeDialog("d1");
	}*/
	/**
      * 更新健康档案中体检记录页面中的健康体质
      *
      */
     function updateEch(data){
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmPeacefulQuality"][value="' + data.peacefulFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmQiQuality"][value="' + data.qiFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmYangQuality"][value="' + data.yangFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmYinDeficiency"][value="' + data.yinDeficiencyFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmPhlegmWetness"][value="' + data.phlegmWetnessFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmHeatMedium"][value="' + data.heatMediumFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmBloodQuality"][value="' + data.bloodFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmQiStagnation"][value="' + data.qiStagnationFlag + '"]').attr("checked", 'checked');
     	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmSpecialQuality"][value="' + data.specialFlag + '"]').attr("checked", 'checked');
     	//更新慢病体检表中的体制辨识 add by Hao Jingqiu 2017-03-29
        $('input[name="tcmPeacefulQuality"][value="' + data.peacefulFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmQiQuality"][value="' + data.qiFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmYangQuality"][value="' + data.yangFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmYinDeficiency"][value="' + data.yinDeficiencyFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmPhlegmWetness"][value="' + data.phlegmWetnessFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmHeatMedium"][value="' + data.heatMediumFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmBloodQuality"][value="' + data.bloodFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmQiStagnation"][value="' + data.qiStagnationFlag + '"]').attr("checked", 'checked');
        $('input[name="tcmSpecialQuality"][value="' + data.specialFlag + '"]').attr("checked", 'checked');
     	$.removeDialog ("echDialog");
     }
	function getOptionData(){
		var optionDatas = [];
		$("th div[id^='option']").each(function(){
			var optionData = {};
			if($(this).hasClass("optionSelect")){
				optionData['optionNo'] = $(this).data('optionNo');
				var ids = this.id.split('_');
				optionData['score'] = ids[1];
				optionDatas.push(optionData);
			}
        });
        return optionDatas;
    }
    
	function getOptionDataNum(){
		var optionDatas=0;
		$("th div[id^='option']").each(function(){
			if($(this).hasClass("optionSelect")){
				var ids = this.id.split('_');
				optionDatas=optionDatas+parseInt(ids[1]);
				
			}
        });
        return optionDatas;
    }
    /**
     * 打印健康教育处方指导意见
     */
    function printHealthEducation(type){
		var url = contextPath + "/ech/manage/report/printHealthEducation?type=" + type;
		util.printPage(url);    	
    }
	return {
		printHealthEducation:printHealthEducation

	}
})();