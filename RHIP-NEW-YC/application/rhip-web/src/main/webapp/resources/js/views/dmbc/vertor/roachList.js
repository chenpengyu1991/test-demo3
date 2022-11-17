var roachList = (function() {
	$(function() { 
          
			   
	});
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/roachList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#roachMonitorForm #type").val()
				},
				insertDiv :"roachList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	}
	
	return {
		search:search
	};
})();


