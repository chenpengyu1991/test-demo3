var idmEpidemicTargetIndex = (function() {
	$(function() {
		/*门诊摘要(挂号)*/
		$("#tag1").on("click", function(event)
		{	
			selectTagl("tagContent1", this);
			loadRegister();
		});
		/*处方*/
		$("#tag2").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			loadPrescription();
		});
		loadRegister();
	});

	/*加载门诊摘要(挂号)页面*/
	function loadRegister() {
		var loadHtmlByUrlOption = {
			url : "/pam/person/medical/register",
			param : {},
			checkRepeat : true,
			insertDiv : "tagContent1",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};

    /*加载处方页面*/
    function loadPrescription() {
        var loadHtmlByUrlOption = {
            url : "/pam/person/medical/prescription",
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