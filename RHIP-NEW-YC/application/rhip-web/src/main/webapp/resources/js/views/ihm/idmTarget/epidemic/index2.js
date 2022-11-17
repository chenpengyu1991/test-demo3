var idmEpidemicSearch = (function() {
	$(function() {
		loadOccupation();
	});

	/*加载职业页面*/
	function loadOccupation() {
		var loadHtmlByUrlOption = {
			url : "/ihm/idm/epidemic/occupation",
			param : {},
			checkRepeat : true,
			insertDiv : "occupationDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

    /*加载年龄页面*/
    function loadAge() {
        var loadHtmlByUrlOption = {
            url : "/ihm/idm/epidemic/age",
            param : {},
            insertDiv : "ageDiv",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
	return {
		loadOccupation : loadOccupation,
		loadAge : loadAge
	};
})();
