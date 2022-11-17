var mosquitoesList = (function() {
	$(function() { 
          
			   
	});
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/mosquitoesList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#mosquitoesMonitorForm #type").val()
				},
				insertDiv :"mosquitoesList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		search:search
	};
})();


