var tuberculosisSearch = (function() {
	var validate = null;
	$(function() {
		$("#editBody").hide();
        showModifyButton();

        $("#modifyCommunityIdSpan").on("click", function () {
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
		validate = $("#tuberculosisearchForm").easyValidate();
        /*健康教育统计查询*/
        $("#tuberculosisSearchForm").onEnter(search, 1);
        $("#tuberculosisBtnSearch").click(function() {
            search();
        });
        search();
        
        $('#year').on("onDatePickerChanged",function(){
			initCreateTime(this.value);
			search();
			$("#editBody").hide();
            showModifyButton();
        });
        $("#saveCommunityId").click(function () {
            // 保存修改的内容：
            var year = $("[name='year']").val();
            var month = $("[name='month']").val();
            if(month==""||month==null||month==undefined){
            	layer.alert("请选择季度！", {icon:0,title:'提示'});
            	return;
            }
            $("#communityInfoForm").submitFormLoadHtml({
                url: contextPath + "/tuberculosis/saveTuberculosis",
                insertDiv: "tuberculosisResultDiv",
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
		var year = $("#tuberculosisSearchForm #year").val();
		var month = $("#tuberculosisSearchForm #month").val();
		var createBeginTime = new Date($("#tuberculosisSearchForm #createBeginTime").val());
		var createEndTime = new Date($("#tuberculosisSearchForm #createEndTime").val());
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
			url : "/tuberculosis/list",
			insertDiv : "tuberculosisResultDiv"
		};
		$("#tuberculosisSearchForm").submitFormLoadHtml(searchObj);
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
	return {
        search : search,
        toggle:toggle,
        changeReportType:changeReportType
	};
})();

$(document).ready(function () {

	//按钮样式切换 
	$("#tuberculosisBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});