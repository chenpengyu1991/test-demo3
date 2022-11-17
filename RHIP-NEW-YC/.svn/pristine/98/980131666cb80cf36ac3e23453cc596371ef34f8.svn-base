var popTarget = (function() {
    $(function() {
    	//validate = $("#targetSearchForm").easyValidate();
        $("#popTargetBtnSearch").click(function(e) {
        	e.preventDefault();
           search();
        });
        $("#popTargetSearchForm").onEnter(search);
        $('#genreCodePopId').on("change",function(){
            changeOrgType();
        });
        changeOrgType();
    });
   
	function changeOrgType(){
		var genreCode = $('#genreCodePopId').val();
		if(genreCode == 'B1'){
			$('#byCentre').show();
			$('#byTown').hide();
		}else if(genreCode == '0'){
			$('#byCentre').hide();
			$('#byTown').show();
		}
	}    

	function search() {
		$("#popTargetSearchForm").submitFormLoadHtml({
			url : "/populace/popTargetList",
			insertDiv : "resultDiv"
		});
	}
    
})();