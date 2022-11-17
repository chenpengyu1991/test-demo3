var childCensusSearch = (function() {
	var validate = null;
	$(function() {
		validate = $("#childCensusSearchForm").easyValidate();
	    $("#childCensusExport").on("click", function(event) {
	    	$("#childCensusTable").exportExcel("0-6岁儿童健康管理");
	    });
		var admin = $("#admin").val();
		if(admin == '01'){
			$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
		}

        $("#childCensusSearchForm").onEnter(search, 1);
        $("#childCensusBtnSearch").click(function() {
            search();
        });
        search();

//        $('#year').on("blur onDatePickerChanged",function(){
//			initCreateTime(this.value);
//        });
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
		var year = $("#childCensusSearchForm #year").val();
		var month = $("#childCensusSearchForm #month").val();
		var createBeginTime = new Date($("#childCensusSearchForm #createBeginTime").val());
		var createEndTime = new Date($("#childCensusSearchForm #createEndTime").val());
		if(!checkCreateTime(year,$('#createBeginTime').val())){
			layer.alert("时间段日期必须在年份范围内！", {icon:0,title:'提示'});
    		return;
    	}
		if(!checkCreateTime(year,$('#createEndTime').val())){
			layer.alert("时间段日期必须在年份范围内！", {icon:0,title:'提示'});
    		return;
    	}    	

		if (createBeginTime > createEndTime) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return;
		} 
		
		if (!$.isEmpty($("#month").val()) && $.isEmpty($("#year").val())) {
			layer.alert("请选择年份！", {icon:0,title:'提示'});
			return;
		}
		var searchObj = {
			url : "/childCensus/list",
			insertDiv : "childCensusResultDiv"
		};
		$("#childCensusSearchForm").submitFormLoadHtml(searchObj);
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
