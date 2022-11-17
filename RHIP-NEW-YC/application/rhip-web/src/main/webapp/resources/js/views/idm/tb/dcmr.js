var dcmr = (function() {
	$(function() {
		validate = $("#tbFormDcmr").easyValidate();
		idmCommon.toggerAddress();
		idmCommon.initAdress();
        toggleOther('labExamine.cavityFlag','cavity',1);
        toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');
        toggleOtherSC('otherCondition.thisType1','thisTypeOther','99');
        toggleOther('otherCondition.thisType','thisType1',99);
        toggleOther('diagnosis.diagnosisAccording','diagnosisReasonMulti',2);
        toggleOther('otherCondition.caseSource','caseSourceOtherId','99');
        toggleOther('pastHistory.stopReason','stopCauseOther',99);
        
		$.Placeholder.init({query:"#idCard",callback:function(element){
			tbCommon.queryPerson($(element).val(), validate);
		}});
		
        search(1);
        $("#dcmrBtnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });
        
        $("#dcmrSearch").onEnter(search, 1);
        
        $("#titleUnit").change(function() {
            document.getElementById("unitName").innerHTML = $("#titleUnit").val();
           
        });
        $("#xNo").change(function() {
        	document.getElementById("xNoTemp").innerHTML = $("#xNo").val();
        });
        toggleOtherCK('diagnosis.diagnosisReasonMulti','diagnosisOther','99');
        toggleOtherCK('diagnosis.otherPhthisisMulti','otherPhthisisOther','99');
        toggleOtherCK('diagnosis.complicationMulti','complicationOther','99');
        $("#check-submit-btn2").on("click", function () {
            StartRead();
        });
	});
	
	function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }
        $("#idcard2").val(GT2ICROCX.CardNo);   
    }

	function search(indexPage) { 
		var searchObj = {
				url : "/idm/tb/treatment/dcmr/list",
				insertDiv : "listDivDcmr",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
			$("#dcmrSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
		$("#detailDivDcmr").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allDcmr").show();		
	}	
	
	return {
        search: search,
        searchTemp : searchTemp
	};
})();
/*$(document).ready(function () { 
	//按钮样式切换 
	$("#dcmrBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});*/