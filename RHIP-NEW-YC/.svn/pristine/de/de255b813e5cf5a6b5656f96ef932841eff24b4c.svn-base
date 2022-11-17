var diCensus = (function() {
	var validate = null;
	$(function() {
        $("#diCensusResultDivExport").on("click", function(event) {
        	event.preventDefault();
            $("#diCensusResultDiv").exportExcel("糖尿病患者健康管理统计报表");
        });
        $("#month").change(function(){
        	search();
        	});
        
		validate = $("#diCensusForm").easyValidate();
        
        $("#diCensusForm").onEnter(search, 1);
        $("#diCensusBtnSearch").click(function(e) {
        	e.preventDefault();
        	search();
        });
        
        //search();
        
        $('#year').on("onDatePickerChanged",function(){
			initCreateTime(this.value);
			//search();
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
	
	function search() {
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 		
		var year = $("#diCensusForm #year").val();
		var month = $("#diCensusForm #month").val();
		
		if (!$.isEmpty($("#month").val()) && $.isEmpty($("#year").val())) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择年份！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("请选择年份!");*/
			return;
		}
		var searchObj = {
			url : "/hbpDiCensus/dilist",
			insertDiv : "diCensusResultDiv"
		};
		$("#diCensusForm").submitFormLoadHtml(searchObj);
	}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
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
	$("#diCensusBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});*/