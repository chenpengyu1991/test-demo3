var recommendation = (function() {
	$(function() {
		validate = $("#tbFormRecommendation").easyValidate();
		idmCommon.toggerAddress();
    	idmCommon.initAdress();
        toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');
        
		$.Placeholder.init({query:"#idCard",callback:function(element){
			tbCommon.queryPerson($(element).val(), validate);
		}});
		
        $("#recommendationBtnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });
        
        $("#recommendationSearch").onEnter(search, 1);
        search(1);
	});

	function search(indexPage) { 
		var searchObj = {
				url : "/idm/tb/confirmed/recommendation/list",
				insertDiv : "listDivRecommendation",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
			$("#recommendationSearchForm").submitFormLoadHtml(searchObj);
	};
	
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
		$("#detailDivRecommendation").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allRecommendation").show();		
	}	
//	function toggerAddress(){
//        /*是否流动人口*/
//        var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
//        if($.isEmpty(value)){
//            /*病人属于*/
//            value=$('input[name="generalCondition.patientAttribute"]:checked').val();
//            if('1' == value){
//                changeAddress("1");
//            }else{
//                changeAddress("2");
//            }
//            toggleOther('generalCondition.patientAttribute','pavillage_address','1');
//            toggleOther('generalCondition.patientAttribute','patown_address','1');
//            toggleOther('generalCondition.floatPopulation','pastreet_address','1');
//            toggleOther('generalCondition.floatPopulation','hrStreet_address','1');
//            toggleOther('generalCondition.patientAttribute','hrvillage_address','1');
//            toggleOther('generalCondition.patientAttribute','hrtown_address','1');
//        }else{
//            if('1' == value){
//                changeAddress("1");
//            }else{
//                changeAddress("2");
//            }
//            toggleOther('generalCondition.floatPopulation','pavillage_address','1');
//            toggleOther('generalCondition.floatPopulation','patown_address','1');
//            toggleOther('generalCondition.floatPopulation','pastreet_address','1');
//            toggleOther('generalCondition.floatPopulation','hrStreet_address','1');
//            toggleOther('generalCondition.floatPopulation','hrvillage_address','1');
//            toggleOther('generalCondition.floatPopulation','hrtown_address','1');
//        }
//        idmCommon.displayPaAddress();
//        idmCommon.displayHrAddress();
//    }
    function changeAddress(type){
        if(type=="1"){
            $("#pavillage_address").removeAttr("disabled");
            $("#hrvillage_address").removeAttr("disabled");
            $("#pastreet_address").removeAttr("disabled");
            $("#hrStreet_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
            $('#hrtown_address').removeAttr("disabled");
            $("#tempPaValue").show();
            $("#tempHrValue").show();
            $('#spanPaNumber').text("门牌号");
            $('#spanHrNumber').text("门牌号");
            $('#pahouseNumber').attr({"style":"width:180px"});
            $('#hrhouseNumber').attr({"style":"width:180px"});
        }else{
            $("#pavillage_address").attr("disabled", "disabled");
            $("#hrvillage_address").attr("disabled", "disabled");
            $("#pastreet_address").attr("disabled", "disabled");
            $("#hrStreet_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
            $("#hrtown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $("#tempHrValue").hide();
            $('#spanPaNumber').text("详细地址");
            $('#spanHrNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
            $('#hrhouseNumber').attr({'style':'width:90%'});
        }
    }
	return {
        search: search,
        searchTemp:searchTemp
	};
})();