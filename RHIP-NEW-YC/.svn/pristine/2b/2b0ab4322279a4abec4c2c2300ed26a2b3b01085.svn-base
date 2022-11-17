var flyList = (function() {
	$(function() { 
          
			   
	});
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/flyList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#flyMonitorForm #type").val()
				},
				insertDiv :"flyList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		search:search
	};
})();


