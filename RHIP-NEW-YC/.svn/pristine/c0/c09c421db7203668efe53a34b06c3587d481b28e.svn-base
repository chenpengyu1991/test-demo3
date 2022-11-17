var highRiskMaternalVisit = (function(){
	$(function(){
        initTree();
        getHighRiskMaternalDetail($(".gwsf:first").val());
	});

    function initTree() {
        $("#postnatlTree").treeview({
            animated: "fast",
            collapsed: true,
            unique: true,
            persist: "location"
        });

        $("#postnatlTree").find("a").click(function () {
            $("#postnatlTree").find("span.active").removeClass("active");
            $(this).parent().addClass("active");
        });
    }

	function getHighRiskMaternalDetail(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/highRiskMaternalVisit",
			insertDiv : "highRiskMaternalVisitDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getHighRiskMaternalDetail : getHighRiskMaternalDetail
	};
})();