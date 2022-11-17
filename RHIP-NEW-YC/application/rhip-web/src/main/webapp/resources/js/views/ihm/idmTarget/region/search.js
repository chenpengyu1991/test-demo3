var regionSearch = (function() {
/*define(function(){*/
	var validate = null;
	$(function() { 
		validate = $("#targetSearchForm").easyValidate();
        $("#targetSearchForm").onEnter(search,1);
        $("#idmBtnSearch").click(function(e) {
        	e.preventDefault();
            search(1);
        });	
        search(1);
        $('#beginDate0').on("blur onDatePickerChanged",function(){
            initWeek();
        });        
        initForm();
	});
	function search(pageIndex){
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}  
    	changeOrgType();
    	changeRangeType();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $('#searchUrl').val(),
            insertDiv : "resultDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#targetSearchForm").submitFormLoadHtml(searchObj);		
	}
	
	/**
	 * 根据月份生成周列表
	 */
	function initWeek(){
		var text = $("#beginDate0").val() + '/01';
        var ymd = text.substring(0, 4) + "-" + text.substring(5, 7) + "-1";
        var week = new Date(Date.parse(ymd.replace(/\-/g, "/")));
        var w = week.toString().substring(0, 3);
        var yymm = new Date(text.substring(0, 4), text.substring(5, 7), 0);
        var day = yymm.getDate();
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
        var aw = 6;
        if (day == 28 && dd == 0) {
            aw = 4;
        }
        var i = 1;
        $("#weekSelect").empty();
        for (var i = 0; i < aw; i++) {
            var start = i * 7 + 1 - dd;
            var end = i * 7 + 7 - dd;
            if(start > day){
            	break;
            }
            if (start < 1) {
                start = 1;
            }
            if (end > day) {
                end = day;
            }
            var str = ("第" + (i + 1) + "周 <" + text.substring(5, 7) + "月" + start + "号—" + text.substring(5, 7) + "月" + end + "号>").toString();
            $("#weekSelect").append("<option value='"+ parseInt(i + 1) +"'>" + str + "</option>");
            $('#weekBeginDate' + parseInt(i + 1)).val(start);
            $('#weekEndDate' + parseInt(i + 1)).val(end);
        }
//        if(day>end){
//            var str = ("第" + (aw + 1) + "周 <" + text.substring(5, 7) + "月" + day + "号—" + text.substring(5, 7) + "月" + day + "号>").toString();
//            $("#weekSelect").append("<option value='"+ parseInt(aw + 1) +"'>" + str + "</option>");
//            $('#weekBeginDate' + parseInt(aw + 1)).val(day);
//            $('#weekEndDate' + parseInt(aw + 1)).val(day);        	
//        }
        $('#weekSelect')[0].selectedIndex = 0;
        var itme = $("#weekSelect").find("option:selected").text();
        $("#weekSelect:text").val(itme.toString());		
	}
	
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
        $('#genreCode').on("change",function(){
            changeOrgType();
        });
        $('#rangeType').on("change",function(){
            changeRangeType();
        });        
        changeOrgType();
        changeRangeType();
    }   
	function changeOrgType(){
		var genreCode = $('#genreCode').val();
		if(genreCode == 'A100'){
			$('#byHospital').show();
			$('#byCentre').hide();
			$('#byTown').hide();
			$('#byStation').hide();
			getCurrentOrgCode(0);
		}else if(genreCode == 'B100'){
			$('#byHospital').hide();
			$('#byCentre').show();
			$('#byTown').hide();
			$('#byStation').hide();
			getCurrentOrgCode(1);
		}else if(genreCode == '0'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').show();
			getCurrentOrgCode(3);
		}else if(genreCode == 'B200'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byTown').hide();
			$('#byStation').show();
			getCurrentOrgCode(2);
		}
	}   
	
	function changeRangeType(){
		var yearType = $('input[name="yearType"]:checked').val();
		if($.isEmpty(yearType)){
			$('input[name="yearType"]:eq(0)').attr("checked",'checked'); 
		}
		var rangeType = $('#rangeType').val();
		if(rangeType == '5'){//按周
			$('#byWeek').show();
			$('#byMonth').hide();
			$('#byQuarter').hide();
			$('#byYear').hide();
			if($.isEmpty($('#weekSelect').val())){
				initWeek();
			}
			$('#weekNumber').val($('#weekSelect').val());
		}else if(rangeType == '1'){//按月
			$('#byWeek').hide();
			$('#byMonth').show();
			$('#byQuarter').hide();
			$('#byYear').hide();
		}else if(rangeType == '2'){//按季度
			$('#byWeek').hide();
			$('#byMonth').hide();
			$('#byQuarter').show();
			$('#byYear').hide();
		}else if(rangeType == '3'){
			$('#byWeek').hide();
			$('#byMonth').hide();
			$('#byQuarter').hide();
			$('#byYear').show();
			$('#beginDate').val($('#beginDate4').val());
			$('#endDate').val($('#endDate4').val());
		}
	} 
	function getCurrentOrgCode(index){
		$('#gbCode').val($('#town' + index).val());
		if(index==0){//医院
			$('#superOrganCode').val($('#organCode' + index).val());
		}else if(index == 1 || index == 2){ // 中心 、站
			$('#superOrganCode').val($('#centre' + index).val());	
			$('#organCode').val($('#station' + index).val());
		}else if(index == 3){ //镇
			$('#superOrganCode').val("");	
			$('#organCode').val("");
		}
	}
	return {
		search:search
	};
})();
