var medication = (function() {
	$(function() { 	
        $("#medicationBtnSearch").click(function(e) {
        	e.preventDefault();
        	search();
        });
        search();
        $("#saveMedication").click(function(e) {
        	e.preventDefault();
        	medication.saveMedication('add');
        });
        $("#modifyMedication").click(function(e) {
        	e.preventDefault();
        	medication.saveMedication('edit');
        }); 
        $("#cancelMedication").click(function(e) {
        	e.preventDefault();
//        	mhmCommon.closePopUp('medicationDialog');
        	mhmCommon.closeLayUiDialog();
        });  
		mhmCommon.initDrugSelectBox('drugSelectBox',selectFun);
	});
	/**
	 * 选择药品后，设置相关字段
	 */
	function selectFun(data){
		$('#hDrugName').val($(data).attr("drugName"));
		$('#hUnit').val($(data).attr("drugUnit"));
		$('#unit').text($(data).attr("drugUnit"));	
	}
	/*查询*/
	function search(pageIndex) {
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/mhm/followUp/druglist",
			insertDiv : 'medicationResultDiv',
			param : {
				pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
                $("#medicationPageIndex").val(pageIndex);
            }
		};
		$("#medicationSearchForm").submitFormLoadHtml(searchObj);
	};
	/*添加服药记录*/
	function saveMedication(type){
		var validate = $("#medicationForm").easyValidate();
		var drugPriceId = $("#medicationForm input[name='drugId']").val();
		if($.isEmpty(drugPriceId)){
			validate.addError('drugId_name',"请选择药品！");
			return;
		}
        var result=validate.validateForm();
        if(!result){
            return;
        }
		var html = fillData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#frMedicationTable tr").eq(rowIndex).html(html);
        }else{
            $("#frMedicationTable").append(html);
        }        
        contentChanged = true;
//	    mhmCommon.closePopUp('medicationDialog');
	    mhmCommon.closeLayUiDialog();
	}
	function fillData(){
        var frObj = mhmCommon.getPopObj('medicationDetailTable');
        var frShowFields = ['drugName', 'drugMorning', 'drugNoon','drugEvening','unit','drugSpecial'];
        var frHideFields = ['type','drugId'];
        var frShowValues = [frObj.drugName,frObj.drugMorning,frObj.drugNoon,frObj.drugEvening,frObj.unit,frObj.drugSpecial];
        var frHideValues = [frObj.type,frObj.drugId];
        var editMethod = "followUpEdit.popupMedication(this,'edit')";
        return mhmCommon.generateTrHtml(frShowFields, frHideFields, frShowValues, frHideValues, editMethod);
	}	
	return {
        search:search,
		saveMedication:saveMedication
	};
})();