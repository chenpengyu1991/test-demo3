define(function() {
	function load() {
		$(function() {
	    	validate = $("#healthSearchForm").easyValidate();
	    	$("#healthSearchForm").onEnter(search);
	        $("#healthBtnSearch").click(function() {
	        	search();
	        });
	    });
	}

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
		load:load,
		search:search
	};
});
