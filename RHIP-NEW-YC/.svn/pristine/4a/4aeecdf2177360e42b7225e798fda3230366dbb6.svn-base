var treatmentList = (function() {
	$(function() { 
          
			   
	});
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/medicalInst/treatmentList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#sewageTreatmentForm #type").val()
				},
				insertDiv :"treatmentList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		search:search
	};
})();


