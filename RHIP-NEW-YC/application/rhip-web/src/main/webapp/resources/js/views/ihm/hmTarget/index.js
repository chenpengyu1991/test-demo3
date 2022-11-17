var idmEpidemicTargetIndex = (function() {
	$(function() {
		/*指标
		$("#tag1").on("click", function(event)
		{	
			selectTagl("tagContent1", this);
			loadTarget();
		});
		管理率
		$("#tag2").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			loadRate();
		});*/
		loadTarget();
	});

	/*加载指标页面*/
	function loadTarget() {
		var loadHtmlByUrlOption = {
			url : "/hm/hm/targetsearch",
			param : {},
			checkRepeat : true,
			insertDiv : "physicalExamDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};

    /*加载管理率页面*/
    function loadRate() {
        var loadHtmlByUrlOption = {
            url : "/hm/hm/ratesearch",
            param : {},
            insertDiv : "healthManageDiv",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
	return {
		loadTarget : loadTarget,
		loadRate :loadRate
	};
})();