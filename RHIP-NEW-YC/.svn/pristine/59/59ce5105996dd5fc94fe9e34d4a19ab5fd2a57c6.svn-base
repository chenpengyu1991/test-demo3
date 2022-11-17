var medicineCensus = (function() {
	var validate = null;
	$(function() {
        $("#medicineCensusResultDivExport").on("click", function(event) {
        	event.preventDefault();
            $("#medicineCensusResultDiv").exportExcel("中医药健康管理统计报表");
        });
        $("#month").change(function(){
        	search();
        	});
        
		validate = $("#medicineCensusForm").easyValidate();
        
        $("#medicineCensusForm").onEnter(search, 1);
        $("#medicineCensusBtnSearch").click(function(e) {
            e.preventDefault();
        	search();
        });
        
       // search();
        
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
		var year = $("#medicineCensusForm #year").val();
		var month = $("#medicineCensusForm #month").val();
		
		if (!$.isEmpty($("#month").val()) && $.isEmpty($("#year").val())) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择年份！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("请选择年份!");*/
			return;
		}
		var searchObj = {
			url : "/medicineCensus/list",
			insertDiv : "medicineCensusResultDiv"
		};
		$("#medicineCensusForm").submitFormLoadHtml(searchObj);
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
	$("#medicineCensusBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});*/