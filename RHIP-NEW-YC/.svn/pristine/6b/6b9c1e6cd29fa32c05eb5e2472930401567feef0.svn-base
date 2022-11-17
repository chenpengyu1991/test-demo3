var occPatientReportSearch = (function() {
	$(function() { 
		search(1);
		$("#occPatientSearchForm").onEnter(search, 1);
        $("#odReportSearchBtn").click(function(e) {
            e.preventDefault();//防止整个页面刷新
            search(1);
        });
        $("#initAddReport").click(function(e) {
            e.preventDefault();//防止整个页面刷新
            initAddReport();
        });
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/oh/occPatient/reportList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#occPatientSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAddReport(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/oh/occPatient/initAddReport",
				insertDiv : "operationDiv"//,
//				param :{
//					operatorType:'3'
//				}
		};
		$.loadHtmlByUrl(option);
	}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};


	
	return {
        search : search,
		initAddReport : initAddReport,
        toggle:toggle
	};
})();