var disinfectionRsList = (function() {
	$(function() { 
          
			   
	});
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/medicalInst/disinfectionRsList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#disinfectionMonitorForm #type").val()
				},
				insertDiv :"disinfectionRsList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		search:search
	};
})();


