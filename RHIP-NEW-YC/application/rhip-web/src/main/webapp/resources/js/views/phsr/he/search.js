var healthEducationStatisticsSearch = (function() {
	var validate = null;
	$(function() {
		validate = $("#healthEducationStatisticsSearchForm").easyValidate();
	    $("#healthEducationStatisticsExport").on("click", function(event) {
	    	event.preventDefault();
	    	$("#healthEducationStatisticsTable").exportExcel("健康教育报表统计");
	    });
		var admin = $("#admin").val();
		if(admin == '01'){
			$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
		}

        /*健康教育统计查询*/
        $("#healthEducationStatisticsSearchForm").onEnter(search, 1);
        $("#healthEducationStatisticsBtnSearch").click(function(e) {
            e.preventDefault();
        	search();
        });
        // search();

        $('#year').on("blur onDatePickerChanged",function(){
			initCreateTime(this.value);
        });
        $("#monthType").click(function() {
            $("#createBeginTime").val("");
            $("#createEndTime").val("");
        });
        $("#createTimeType").click(function() {
            $("#month").val("");
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
		var year = $("#healthEducationStatisticsSearchForm #year").val();
		var month = $("#healthEducationStatisticsSearchForm #month").val();
		var createBeginTime = new Date($("#healthEducationStatisticsSearchForm #createBeginTime").val());
		var createEndTime = new Date($("#healthEducationStatisticsSearchForm #createEndTime").val());
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
			url : "/phsr/he/report/list",
			insertDiv : "healthEducationStatisticsResultDiv"
		};
		$("#healthEducationStatisticsSearchForm").submitFormLoadHtml(searchObj);
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
	
	return {
        search : search,
        toggle:toggle,
        changeSummaryType:changeSummaryType
	};
})();

$(document).ready(function () {

	//按钮样式切换 
	$("#healthEducationSupervisorBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});