var hrSearch = (function() {
	$(function() {
    	validate = $("#healthSearchForm").easyValidate();
    	$("#healthSearchForm").onEnter(search);
        $("#healthBtnSearch").click(function(e) {
        	e.preventDefault();
        	search();
        });
    });
	 function search() {
			var result=validate.validateForm();
	    	if(!result){
	    		return;
	    	}    	
	        var searchObj = {
	            url : $("#queryPath").val(),
	            insertDiv : "healthDiv",
	            param : {},
	            callback : function(data) {}
	        };
	        $("#healthSearchForm").submitFormLoadHtml(searchObj);
	    };		
	return {
		search : search
		
	};
})();