var mouseList = (function() {
	$(function() { 
          
			   
	});
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/mouseList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#mouseMonitorForm #type").val()
				},
				insertDiv :"mouseList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		search:search
	};
})();


