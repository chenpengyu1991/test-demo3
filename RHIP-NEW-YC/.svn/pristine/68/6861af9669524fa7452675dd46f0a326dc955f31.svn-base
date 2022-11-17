var tubercCensusSearch = (function() {
	var validate = null;
	$(function() {
        $("#tubercCensusResultDivExport").on("click", function(event) {
        	event.preventDefault();
        	$("#tubercCensusResultDiv").exportExcel("肺结核患者管理统计报表");
        });
		$("#editBody").hide();
        showModifyButton();

        $("#modifyCommunityIdSpan").on("click", function () {
        	if($("#month").val()==""){
        		layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("请选择季度！", {icon:0,title:'提示'});
	    		});
        		 /*msgUtil.alert("请选择季度!");*/
        	}else if($("#year").val()==""){
        		/*msgUtil.alert("请选择年份!");*/
        		layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("请选择年份！", {icon:0,title:'提示'});
	    		});
        	}else{
        		$("#displayBody").hide();
                $("#editBody").show();
                showCancelButton();
        	}
        });

        $("#cancelCommunityId").click(function () {
            $("#displayBody").show();
            $("#editBody").hide();
            showModifyButton();
        });
        $("#month").change(function(){
        	search();
        	$("#editBody").hide();
            showModifyButton();
        	});
		validate = $("#tubercCensusearchForm").easyValidate();
        /*健康教育统计查询*/
        $("#tubercCensusSearchForm").onEnter(search, 1);
        $("#tubercCensusBtnSearch").click(function(e) {
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
        $("#saveCommunityId").click(function () {
            // 保存修改的内容：
            var year = $("[name='year']").val();
            var month = $("[name='month']").val();
            if(month==""||month==null||month==undefined){
            	layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("请选择季度！", {icon:0,title:'提示'});
	    		});
            	/*msgUtil.alert("请选择季度!");*/
            	return;
            }
            $("#communityInfoForm").submitFormLoadHtml({
                url: contextPath + "/tubercCensus/saveTubercCensus",
                insertDiv: "tubercCensusResultDiv",
                param: {
                    "year": year,
                    "month": month
                },
                callback: function (data) {
                	layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			layer.alert(data, {icon:0,title:'提示'}, function() {
    	    				layer.closeAll();
    	    				search();
    	                	$("#editBody").hide();
    	                    showModifyButton();
    	    			});
    	    		});
                    /*msgUtil.alert(data);
                    search();
                	$("#editBody").hide();
                    showModifyButton();*/
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
		var year = $("#tubercCensusSearchForm #year").val();
		var month = $("#tubercCensusSearchForm #month").val();
		var createBeginTime = new Date($("#tubercCensusSearchForm #createBeginTime").val());
		var createEndTime = new Date($("#tubercCensusSearchForm #createEndTime").val());
		if(!checkCreateTime(year,$('#createBeginTime').val())){
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("时间段日期必须在年份范围内！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("时间段日期必须在年份范围内");*/
    		return;
    	}
		if(!checkCreateTime(year,$('#createEndTime').val())){
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("时间段日期必须在年份范围内！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("时间段日期必须在年份范围内");*/
    		return;
    	}    	

		if (createBeginTime > createEndTime) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("开始时间不能大于结束时间");*/
			return;
		} 
		
		if (!$.isEmpty($("#month").val()) && $.isEmpty($("#year").val())) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择年份！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("请选择年份!");*/
			return;
		}
		var searchObj = {
			url : "/tubercCensus/list",
			insertDiv : "tubercCensusResultDiv"
		};
		$("#tubercCensusSearchForm").submitFormLoadHtml(searchObj);
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
        
        //辖区同期内经上级定点医疗机构确诊并通知基层医疗卫生机构管理的肺结核患者人数
        $("#tubercNum_id").on("blur", function () {
        	countPercent("tubercNum_id", "tubercManageNum_id", "tubercManagePercent");
        });
        //已管理的肺结核患者人数
        $("#tubercManageNum_id").on("blur", function () {
        	countPercent("tubercNum_id", "tubercManageNum_id", "tubercManagePercent");
        });
        
        //同期辖区内已完成治疗的肺结核患者人数
        $("#tubercCureNum_id").on("blur", function () {
        	countPercent("tubercCureNum_id", "tubercMedicationNum_id", "tubercMedicationPercent");
        });
        //按照要求规则服药的肺结核患者人数
        $("#tubercMedicationNum_id").on("blur", function () {
        	countPercent("tubercCureNum_id", "tubercMedicationNum_id", "tubercMedicationPercent");
        });
        
        //推介转诊结核病患者人数
        $("#referralTb_id").on("blur", function () {
        	countPercent("householdNum_id", "referralTb_id", "referralTbPercent");
        });
    };
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
    
    //计算报告率
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
    
	return {
        search : search,
        toggle:toggle,
        changeReportType:changeReportType
	};
})();

/*$(document).ready(function () {

	//按钮样式切换 
	$("#tubercCensusBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});*/