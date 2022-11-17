var contentPage =  (function() {
	function recordsPerform(indexPage) {
		var code = $("#code").val();
		var parentCode = $("#parentCode").val();
		if(code != ''){
			window.location.href = contextPath + "/infoShow/infoChildList?code=" + code + "&indexPage=" + indexPage + "&parentCode=" + parentCode;
		}else{
			window.location.href = contextPath + "/infoShow/infoList?code=" + parentCode + "&indexPage=" + indexPage;
		}
	}
	
	function yyjgSearch(indexPage){
		var grade = $("#grade").val();
		window.location.href = contextPath + "/infoShow/hospitalList?grade=" + grade + "&indexPage="+indexPage;
	};
	function yyjtSearch(indexPage){
		var orgType = $("#orgType").val();
		window.location.href = contextPath + "/infoShow/hospitalGroupList?orgType=" + orgType + "&indexPage="+indexPage;
	};
	function fileManagerSearch(indexPage){
		window.location.href = contextPath + "/fileManager/index?indexPage="+indexPage;
	};
	
	function surveySearch(indexPage){
		window.location.href = contextPath + "/survey/index?indexPage="+indexPage;
	};

	function prescriptionSearch(indexPage){
		window.location.href = contextPath + "/health/prescriptionMh/list?indexPage="+indexPage;
	};

	function promorionSearch(indexPage){
		window.location.href = contextPath + "/health/promorionMh/list?indexPage="+indexPage;
	};

	return{
		recordsPerform : recordsPerform,
		yyjgSearch:yyjgSearch,
		yyjtSearch:yyjtSearch,
		fileManagerSearch : fileManagerSearch,
		surveySearch : surveySearch,
		prescriptionSearch: prescriptionSearch,
		promorionSearch:promorionSearch
	};
})();
