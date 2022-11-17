var vaccinationCensus = (function() {
	var validate = null;
	$(function() {
        $("#vaccinationCensusResultDivExport").on("click", function(event) {
        	event.preventDefault();
            $("#vaccinationCensusResultDiv").exportExcel("预防接种报表统计");
        });

		$("#editBody").hide();
        showModifyButton();

        $("#modifyCommunityIdSpan").on("click", function (e) {
        	e.preventDefault();
        	if($("#month").val()==""){
        		 layer.alert("请选择季度！", {icon:0,title:'提示'});
        	}else if($("#year").val()==""){
        		layer.alert("请选择年份！", {icon:0,title:'提示'});
        	}else{
        		$("#displayBody").hide();
                $("#editBody").show();
                showCancelButton();
        	}
        });

        $("#cancelCommunityId").click(function (e) {
            e.preventDefault();
        	$("#displayBody").show();
            $("#editBody").hide();
            showModifyButton();
        });
        $("#month").change(function(){
        	search();
        	$("#editBody").hide();
            showModifyButton();
        	});
		validate = $("#vaccinationCensusForm").easyValidate();
        /*健康教育统计查询*/
        $("#vaccinationCensusForm").onEnter(search, 1);
        $("#vaccinationCensusBtnSearch").click(function(e) {
        	e.preventDefault();
            search();
        });
        //search();
        
        $('#year').on("onDatePickerChanged",function(){
			initCreateTime(this.value);
			//search();
			$("#editBody").hide();
            showModifyButton();
        });
        $("#saveCommunityId").click(function (e) {
        	e.preventDefault();
            // 保存修改的内容：
            var year = $("[name='year']").val();
            var month = $("[name='month']").val();
            if(month==""||month==null||month==undefined){
            	layer.alert("请选择季度！", {icon:0,title:'提示'});
            	return;
            }
            $("#communityInfoForm").submitFormLoadHtml({
                url: contextPath + "/vaccinationCensus/saveVaccination",
                insertDiv: "vaccinationCensusResultDiv",
                param: {
                    "year": year,
                    "month": month
                },
                callback: function (data) {
                    layer.alert(data, {icon:0,title:'提示'});
                    search();
                	$("#editBody").hide();
                    showModifyButton();
                    //initCal();
                }
            });
        
        });
	});
	/**
	 * 根据年份，生成默认时间段
	 */
	function initCreateTime(year){
		if(!$.isEmpty(year)){
			$('#createBeginTime').val(year + "/01/01");
			$('#createEndTime').val(year + "/12/31");
		}
	}
	
	/**
	 * 日期必须在年份范围内
	 */
	function checkCreateTime(year,createTimeStr){
		var result = true;
		if(!$.isEmpty(year) && !$.isEmpty(createTimeStr)){
			var createTimeYear = createTimeStr.substr(0,4);
	    	if(createTimeYear!=year){
	    		result = false;
	    	}
		}
		return result;
	}
	
	function search() {
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 		
		var year = $("#vaccinationCensusForm #year").val();
		var month = $("#vaccinationCensusForm #month").val();
		var createBeginTime = new Date($("#vaccinationCensusForm #createBeginTime").val());
		var createEndTime = new Date($("#vaccinationCensusForm #createEndTime").val());
		if(!checkCreateTime(year,$('#createBeginTime').val())){
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("时间段日期必须在年份范围内！", {icon:0,title:'提示'});
    		});
    		return;
    	}
		if(!checkCreateTime(year,$('#createEndTime').val())){
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("时间段日期必须在年份范围内！", {icon:0,title:'提示'});
    		});
    		return;
    	}    	

		if (createBeginTime > createEndTime) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			return;
		} 
		
		if (!$.isEmpty($("#month").val()) && $.isEmpty($("#year").val())) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择年份！", {icon:0,title:'提示'});
    		});
			return;
		}
		var searchObj = {
			url : "/vaccinationCensus/list",
			insertDiv : "vaccinationCensusResultDiv"
		};
		$("#vaccinationCensusForm").submitFormLoadHtml(searchObj);
	}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	function changeSummaryType(){
		var summaryType = $('input:radio[name="summaryType"]:checked').val();
		if(summaryType == '1'){
			$("#month").show();
			$('#createTime').hide();
			$('#summaryTypeTextId').text("月份");
		}else{
			$("#month").hide();
			$('#createTime').show();
			$('#summaryTypeTextId').text("时间段");
		}
	}	

    function showModifyButton() {
        $("#cancelCommunityIdSpan").hide();
        $("#modifyCommunityIdSpan").show();
        $("[name='PopulaceDTO.gbCode']").prop("disabled",false);
        $("[name='PopulaceDTO.organCode']").prop("disabled",false);
    };

    function showCancelButton() {
        $("#modifyCommunityIdSpan").hide();
        $("#cancelCommunityIdSpan").show();
        $("[name='PopulaceDTO.gbCode']").prop("disabled",true);
        $("[name='PopulaceDTO.organCode']").prop("disabled",true);
        
        //预防接种证
        $("#certificateShouldNum_id").on("blur", function () {
        	countPercent("certificateShouldNum_id", "certificateHasNum_id", "certificatePercent");
        });
        $("#certificateHasNum_id").on("blur", function () {
        	countPercent("certificateShouldNum_id", "certificateHasNum_id", "certificatePercent");
        });
        
        //乙肝疫苗
        $("#hepatitisShouldNum_id").on("blur", function () {
        	countPercent("hepatitisShouldNum_id", "hepatitisHasNum_id", "hepatitisPercent");
        });
        $("#hepatitisHasNum_id").on("blur", function () {
        	countPercent("hepatitisShouldNum_id", "hepatitisHasNum_id", "hepatitisPercent");
        });
        
        //卡介苗
        $("#bcgShouldNum_id").on("blur", function () {
        	countPercent("bcgShouldNum_id", "bcgHasNum_id", "bcgPercent");
        });
        $("#bcgHasNum_id").on("blur", function () {
        	countPercent("bcgShouldNum_id", "bcgHasNum_id", "bcgPercent");
        });
        
        //脊灰疫苗
        $("#polioShouldNum_id").on("blur", function () {
        	countPercent("polioShouldNum_id", "polioHasNum_id", "polioPercent");
        });
        $("#polioHasNum_id").on("blur", function () {
        	countPercent("polioShouldNum_id", "polioHasNum_id", "polioPercent");
        });
        
        //百白破疫苗
        $("#dptShouldNum_id").on("blur", function () {
        	countPercent("dptShouldNum_id", "dptHasNum_id", "dptPercent");
        });
        $("#dptHasNum_id").on("blur", function () {
        	countPercent("dptShouldNum_id", "dptHasNum_id", "dptPercent");
        });
        
        //含麻疹成分疫苗
        $("#measlesconstitShouldNum_id").on("blur", function () {
        	countPercent("measlesconstitShouldNum_id", "measlesconstitHasNum_id", "measlesconstitPercent");
        });
        $("#measlesconstitHasNum_id").on("blur", function () {
        	countPercent("measlesconstitShouldNum_id", "measlesconstitHasNum_id", "measlesconstitPercent");
        });
        
        //流脑疫苗
        $("#ameningococcalShouldNum_id").on("blur", function () {
        	countPercent("ameningococcalShouldNum_id", "ameningococcalHasNum_id", "ameningococcalPercent");
        });
        $("#ameningococcalHasNum_id").on("blur", function () {
        	countPercent("ameningococcalShouldNum_id", "ameningococcalHasNum_id", "ameningococcalPercent");
        });
        
        //乙脑疫苗
        $("#encephalitisShouldNum_id").on("blur", function () {
        	countPercent("encephalitisShouldNum_id", "encephalitisHasNum_id", "encephalitisPercent");
        });
        $("#encephalitisHasNum_id").on("blur", function () {
        	countPercent("encephalitisShouldNum_id", "encephalitisHasNum_id", "encephalitisPercent");
        });
        
        //甲肝疫苗
        $("#havShouldNum_id").on("blur", function () {
        	countPercent("havShouldNum_id", "havHasNum_id", "havPercent");
        });
        $("#havHasNum_id").on("blur", function () {
        	countPercent("havShouldNum_id", "havHasNum_id", "havPercent");
        });
        
        //白破疫苗 
        $("#whiteShouldNum_id").on("blur", function () {
        	countPercent("whiteShouldNum_id", "whiteHasNum_id", "whitePercent");
        });
        $("#whiteHasNum_id").on("blur", function () {
        	countPercent("whiteShouldNum_id", "whiteHasNum_id", "whitePercent");
        });
        
        //A+C群流脑疫苗
        $("#acmeningococcalShouldNum_id").on("blur", function () {
        	countPercent("acmeningococcalShouldNum_id", "acmeningococcalHasNum_id", "acmeningococcalPercent");
        });
        $("#acmeningococcalHasNum_id").on("blur", function () {
        	countPercent("acmeningococcalShouldNum_id", "acmeningococcalHasNum_id", "acmeningococcalPercent");
        });
    };
    
    //计算接种率
	function countPercent(shouldId, hasId, percentId)
	{
		var should = $("#" +shouldId).val();
		var has = $("#" + hasId).val();
		if (should && has && $.isNumeric(should)&&$.isNumeric(has) && should!=0)
		{
			var percent = (has*100/ should).toFixed(1);
			$("#" + percentId).html(percent+"%");
		} else
		{
			$("#" + percentId).html("0%");
		}
	}
	
    function monthchange(obj){
    	
    	alert($(obj).val());
    };
  //查询框
    function changeReportType(){
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){//按年
            $('#year').show();
            $('#month').hide();
            $("#month").val("");
        }else if(countType == '2'){//按季度
            $('#year').show();
            $('#month').show();
        }
    }
    
    
	return {
        search : search,
        toggle:toggle,
        changeReportType:changeReportType
	};
	
})();

/*$(document).ready(function () {

	//按钮样式切换 
	$("#vaccinationCensusBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});*/