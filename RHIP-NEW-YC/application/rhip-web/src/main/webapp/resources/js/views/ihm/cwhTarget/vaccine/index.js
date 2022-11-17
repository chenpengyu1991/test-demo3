var vaccinaTargetIndex = (function() {
	$(function() {
		/*疫苗*/
		$("#tag1").on("click", function(event)
		{	
			selectTagl("tagContent1", this);
			vaccine();
		});
		/*禁忌*/
		$("#tag2").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			taboo();
		});
        /*副反应*/
        $("#tag3").on("click", function(event)
        {
            selectTagl("tagContent1", this);
            sideEffect();
        });
        vaccine();
	});

	/*疫苗*/
	function vaccine() {
		var loadHtmlByUrlOption = {
			url : "/ihm/vaccine/vaccine",
			param : {},
			checkRepeat : true,
			insertDiv : "tagContent1",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};

    /*禁忌*/
    function taboo() {
        var loadHtmlByUrlOption = {
            url : "/ihm/vaccine/taboo",
            param : {},
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };


    /*副反应*/
    function sideEffect() {
        var loadHtmlByUrlOption = {
            url : "/ihm/vaccine/sideEffect",
            param : {},
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
	return {
	};
})();