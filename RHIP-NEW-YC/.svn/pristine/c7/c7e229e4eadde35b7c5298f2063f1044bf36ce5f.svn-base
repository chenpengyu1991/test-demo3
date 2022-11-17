var dieStatisticsSearch = (function() {
	$(function() {
		initForm();
		$("#dieTargetBtnSearch").click(function(e) {
			e.preventDefault();
			search();
		});

		$("#dieTargetSearchForm").onEnter(function(e) {
			e.preventDefault();
			search();
		});
	});

	function search() {
		$("#dieTargetSearchForm").submitFormLoadHtml({
			url : "/ihm/ehr/die/result",
			insertDiv : "resultDiv"
		});
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
			$('#orgLabelId').show();
			getCurrentOrgCode(0);
		}else if(genreCode == 'B100'){
			$('#byHospital').hide();
			$('#byCentre').show();
			$('#byStation').hide();
			$('#byTown').hide();
			$('#orgLabelId').show();
			getCurrentOrgCode(1);
		}else if(genreCode == 'B200'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').show();
			$('#byTown').hide();
			$('#orgLabelId').show();
			getCurrentOrgCode(2);
		}else if(genreCode == '0'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').show();
			$('#orgLabelId').show();
			getCurrentOrgCode(3);
		}else if(genreCode == 'R2'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
			$('#orgLabelId').hide();
			getCurrentOrgCode(4);
		}
	}    

	function getCurrentOrgCode(index){
		$('#gbCode').val($('#town' + index).val());
		if(index==0){
			$('#superOrganCode').val($('#organCode' + index).val());
		}else if(index == 4){
			$('#superOrganCode').val('46714114-9');
		}else if(index != 3){
			$('#superOrganCode').val($('#centre' + index).val());	
			$('#organCode').val($('#station' + index).val());
		}else{
			$('#superOrganCode').val("");	
			$('#organCode').val("");
		}
	}
	return {
		changeOrgType:changeOrgType
	};
})();
