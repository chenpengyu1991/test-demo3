var examAnalyzeJS = (function(){
	var validate=null;
	$(function() {
		validate = $("#analyzeSearchForm").easyValidate();
		$("#analyzeForm").on("click", function(){
			examAnalyze(1);
		});
	});
	
	function examAnalyze(indexPage) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
		$("#analyzeSearchForm").submitFormLoadHtml({
			url :  contextPath + "/physicalExam/analyze/list",
            insertDiv : "examSearchListDiv",
            param:{
                indexPage : indexPage,
                beginDate:$('#beginDateId').val(),
				endDate:$('#endDateId').val(),
				phyExamOrg:$("input[name='phyExamOrg']").val(),
				phyType:$('#phyType').val(),
				name:$('#name').val(),
				idcard  :$('#idcard').val()
            },
            callback : function(){
            	$.removeDialog("analyzeSearchDialog");
            }
		});
	}
	
})();