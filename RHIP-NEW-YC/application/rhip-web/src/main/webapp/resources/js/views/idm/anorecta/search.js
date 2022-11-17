var anorectaSearch = (function() {
	$(function() {   
        search();
        $("#searchForm").onEnter(search);
        $('#beginDate0').on("blur onDatePickerChanged",function(){
            initWeek();
        });
        initForm();
	});

	function search() {
		var searchObj = {
			url : contextPath + "/idm/anorecta/list",
			insertDiv : "resultDiv"
		};
		$("#searchForm").formPost(searchObj);
	};
	/**
	 * 生成周列表
	 */
	function initWeek(){
		var year = $("#beginDate0").val();
		var text = year + '/01/01';
		var ymd = year + "-01-01";
		var week = new Date(Date.parse(text));
		var w = week.toString().substring(0, 3);
		var dd = 1;
		switch (w) {
			case "Mon": dd = 0; break;
			case "Tue": dd = 1; break;
			case "Wed": dd = 2; break;
			case "Thu": dd = 3; break;
			case "Fri": dd = 4; break;
			case "Sat": dd = 5; break;
			case "Sun": dd = 6; break;
		}
		var day = 1;
		if(((year%4==0)&&(year%100!=0))||(year%400==0)){ 
			day = 366;
	    }else {
	    	day = 365;
		}
		var aw = 53;
		$("#weekSelect").empty();
		for(var i = 0; i < 53; i++){
			var start = i * 7 + 1 - dd;
			var end = i * 7 + 7 - dd;
			if(start < 1){
				start = 1;	
			}
			if(end > day){
				end = day;
			}
			var beginMonth = new Date(year, 0, start).getMonth() + 1 ;
			var beginDay= new Date(year, 0, start).getDate();
			var endMonth = new Date(year, 0, end).getMonth() + 1 ;
			var endDay= new Date(year, 0, end).getDate();
			var str = ("第" + (i + 1) + "周 <" + beginMonth + "月" + beginDay + "号—" + endMonth + "月" + endDay  + "号>").toString();
			$("#weekSelect").append("<option value = '第" + (i + 1)+"周,"+ beginMonth+ "/" + beginDay + "-" + endMonth+ "/" + endDay + "'>" + str + "</option>");
		}
		 $('#weekSelect')[0].selectedIndex = 0;
	     var itme = $("#weekSelect").find("option:selected").text();
	     $("#weekSelect:text").val(itme.toString());	
	}
	function initForm(){
		$("#rangeType").on("change", function(){
			changeRangeType();
		});
		changeRangeType();    
	}
	function changeRangeType(){
		var rangeType = $("#rangeType").val();
		if(rangeType == '1'){
			$("#byXun").show();
			$("#byWeek").hide();
		} else if(rangeType == '2'){
			$("#byWeek").show();
			$("#byXun").hide();	
			if($.isEmpty($("#weekSelect").val())){
				initWeek();
			}
		}	
	}
	function importTable(){
		var dialogParams = {
				id : "d1",
				url : "/idm/case/showAnorectaImport",
				param : {},
				height : 200,
				width : 750,
				title : "数据导入"
		};
		$.dialog(dialogParams);		
	}
	function exportTable() {
		var table = $("#resultDiv table");
        if (table.length > 0) {
	        $("#exportTable").exportExcel("肠道门诊旬报表");
        } else {
        	layer.alert("没有数据，请先查询！", {icon:0,title:'提示'});
        }
	};
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	function importTable(){
		var dialogParams = {
				id : "d1",
				url : "/idm/case/showAnorectaImport",
				param : {},
				height : 200,
				width : 750,
				title : "数据导入"
		};
		$.dialog(dialogParams);		
	}
   
	return {
        search : search,
        toggle : toggle,
        exportTable :exportTable,
        importTable :importTable
      
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#logBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 
});
