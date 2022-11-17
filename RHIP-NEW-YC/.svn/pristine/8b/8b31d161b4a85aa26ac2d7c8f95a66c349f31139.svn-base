var mhmDrugSearch = (function() {

	var validate=null;
//    mhmCommon.initDrugSelectBox('drugSelectBox',selectFun);
	$(function() {
		validate = $("#drugSearchForm").easyValidate();
        $("#drugBtnSearch").click(function(e) {
        	e.preventDefault();
        	searchDrug();
        });	
        $("#drugExport").click(function(e) {
            e.preventDefault();
        	downloadDurg();
        });
        $("#drugSearchForm").onEnter(searchDrug, 1);

        searchDrug();

	});

	/*查询*/
	function searchDrug(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var townName = $("select[name=townCode]").find("option:selected").text()=='请选择'?'':$("select[name=townCode]").find("option:selected").text();
        var centerName = $("select[name=centerCode]").find("option:selected").text()=='请选择'?'':$("select[name=centerCode]").find("option:selected").text();
        var stationName = $("select[name=stationCode]").find("option:selected").text()=='请选择'?'':$("select[name=stationCode]").find("option:selected").text();
		var searchObj = {
			url : "/mhm/statistics/drug/list",
			insertDiv : 'drugResultDiv',
			param : {pageIndex:pageIndex,
                townName:townName,
                centerName:centerName,
                stationName:stationName
            },
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
		};
		$("#drugSearchForm").submitFormLoadHtml(searchObj);
	};

    /**
     * 选择药品后，设置相关字段
     */
    function selectFun(data){
        $('#hDrugName').val($(data).attr("drugName"));
    }

    function downloadDurg(){
        var params = $('#drugSearchForm').formSerialize();
        params = decodeURIComponent(params,true);
        location.href = contextPath + "/mhm/statistics/downDrugExcel?" + params;
    }

	return {
        searchDrug:searchDrug
	};
})();