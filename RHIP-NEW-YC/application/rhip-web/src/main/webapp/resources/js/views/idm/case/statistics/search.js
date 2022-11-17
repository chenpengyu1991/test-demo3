var ihmCommen = (function() {
	
	$(function() {
    	validate = $("#targetSearchForm").easyValidate();
    	search(1);
        $("#targetBtnSearch").click(function(e) {
	        e.preventDefault();  
        	search(1);
        });
    	$("#targetBtnSearch").onEnter(search, 1);

        initForm();
    });

	function initForm(){
		$('#centre1').on("change",function(){
		$('#superOrganCode').val(this.value);
		});
		$('#town1').on("change",function(){
		$('#gbCode').val(this.value);
		});
		$('#centre2').on("change",function(){
		$('#superOrganCode').val(this.value);
		});
		$('#town2').on("change",function(){
		$('#gbCode').val(this.value);
		});
		$('#station2').on("change",function(){
		$('#organCode').val(this.value);
		});
		$('#genreCode').on("change",function(){
			changeOrgType();
		});
		$('#rangeType').on("change",function(){
				changeRangeType();
			});
	    changeOrgType();
	    changeRangeType();
	}
	function changeRangeType(){
		var yearType = $('input[name="yearType"]:checked').val();
	if($.isEmpty(yearType)){
		$('input[name="yearType"]:eq(0)').attr("checked",'checked'); 
	}
	var rangeType = $('#rangeType').val();
	if(rangeType == '1'){
		$('#byMonth').show();
		$('#byQuarter').hide();
		$('#byYear').hide();
		$('#byRange').hide();
	}else if(rangeType == '2'){
		$('#byMonth').hide();
		$('#byQuarter').show();
		$('#byYear').hide();
		$('#byRange').hide();
	}else if(rangeType == '3'){
		$('#byMonth').hide();
		$('#byQuarter').hide();
		$('#byYear').show();
		$('#byRange').hide();
	}else if(rangeType == '4'){
		$('#byMonth').hide();
		$('#byQuarter').hide();
		$('#byYear').hide();
		$('#byRange').show();
		$('#beginDate').val($('#beginDate4').val());
		$('#endDate').val($('#endDate4').val());
		}
	} 
	function changeOrgType(){
		var genreCode = $('#genreCode').val();
		if(genreCode == 'A100'){
			$('#byHospital').show();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(0);
		}else if(genreCode == 'B100'){
			$('#byHospital').hide();
			$('#byCentre').show();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(1);
		}else if(genreCode == 'B200'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').show();
			$('#byTown').hide();
			getCurrentOrgCode(2);
		}else if(genreCode == '0'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').show();
			getCurrentOrgCode(3);
		}else if(genreCode == '46714114-9'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
				getCurrentOrgCode(3);
		}
	}    
	
	function getCurrentOrgCode(index){
		$('#gbCode').val($('#town' + index).val());
	if(index==0){
		/*$('#superOrganCode').val($('#organCode' + index).val());*/
		$('#organCode').val($('#organCode' + index).val());//市级医院
	}else if(index == '46714114-9'){
		$('#superOrganCode').val($('#genreCode').val());
		$('#genreCode').val('R2');
	}else if(index == 1){//中心
		$('#organCode').val($('#centre' + index).val());
	}else if(index == 2){//站
		$('#superOrganCode').val($('#centre' + index).val());
		$('#organCode').val($('#station' + index).val());
	}else if(index != 3){
		alert(4);
		$('#superOrganCode').val($('#centre' + index).val());	
		$('#organCode').val($('#station' + index).val());
	}else{
		alert(5);
		$('#superOrganCode').val("");	
		$('#organCode').val("");
		}
	}
	function search(pageIndex) {
		var result=validate.validateForm();
		if(!result){
			return;
		}  
		
		var beginDate = new Date($("#beginDate4").val());
		var endDate = new Date($("#endDate4").val());
		
		if (beginDate > endDate) {
			layui.use('layer', function(){
				var layer = layui.layer;
				
				layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			});
			return;
		} 
		
		changeOrgType();
		changeRangeType();
	    //pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
	    var searchObj = {
	        url : "/idm/case/statisticsList",
			insertDiv : "resultDiv",
			param : {
			    indexPage : 1
			},
			callback : function(data) {
				//$("#pageIndex").val(pageIndex);
			    //scrollYFun($('#searchUrl').val());
			      
			    }
			};
		$("#targetSearchForm").submitFormLoadHtml(searchObj);
	};
	

	function getNumVal(inputVal) {
	    var val = $("#" + inputVal).val();
	var result = val.split(",");
	    for(var i = 0; i<result.length; i++){
	       if (isNaN(result[i])) {
	           result[i] = 0;
	    }
	        result[i] = parseInt(result[i]);
	    }
	    return result;
	}
	
	
	
	/**
	 * 图表表格切换
	 */
	
	function changeEcharts(val){
		if (val == 1){
			$("#resultDiv").hide();
	$("#resultEchartsDiv").show();
	} else{
		$("#resultDiv").show();
	$("#resultEchartsDiv").hide();
		}  
	}
	
	/**
	 * 是否出现滚动条对列表宽度影响
	 */
	function scrollYFun(url) {
	    switch (url) {
	        case "/ihm/medical/inpatientlist":
	    scrollYFunDetail("ihmpatientlisttable");
	            break;
	    }
	}
	
	function scrollYFunDetail(id) {
	    var tableId = id+"Div";
	var mainId = id+"TopDiv";
	var obj=document.getElementById(tableId);
	if(obj == null){
	    return;
	}
	if(obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight){
	    document.getElementById(mainId).setAttribute("class","paddingright17");
	}else{
	    document.getElementById(mainId).removeAttribute("class");
	    }
	}
	 
	return {
		load:load,
		changeOrgType:changeOrgType,
		search:search
	};
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//$(function() {
	//		$("#progressStatisticsYear").val(new Date().getFullYear());
     //       /*体检进度查询*/
     //       $("#progressBtnSearch").onEnter(search, 1);
     //       $("#progressBtnSearch").click(function() {
     //           search(1);
     //       });
     //       search(1);
     //       //util.checkBoxAll("reportChk","reportChkRef");
	//});
    //
	//function search(indexPage) {
	//	var startDate = new Date($("#progressSearchForm #startDate").val());
	//	var endDate = new Date($("#progressSearchForm #endDate").val());
    //
	//	if (startDate > endDate) {
	//		msgUtil.alert("开始时间不能大于结束时间");
	//		return;
	//	}
	//	var searchObj = {
	//		url : "/hm/progress/list",
	//		insertDiv : "progressResultDiv",
	//		param : {
	//			indexPage : indexPage
	//		}
	//	};
	//	$("#progressSearchForm").submitFormLoadHtml(searchObj);
	//};
    //
	//function toggle(obj,tableId) {
	//	$(obj).toggleClass("ico-top");
	//	$(obj).toggleClass("ico-bottom");
	//	$("#" + tableId).toggle();
	//};
	//return {
     //   search : search,
     //   toggle:toggle
	//};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#progressBtnSearch").hover( 
	function () { 
	$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
	$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});