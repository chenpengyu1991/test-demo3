
define(function(){
	var validate = null;
	function load() {
		$(function() { 
			/*按职业*/
			$("#tag1").on("click", function(event)
			{	
				selectTagl("tagContent1", this);
				loadOccupation();
			});
			/*按年龄*/
			$("#tag2").on("click", function(event)
			{
				selectTagl("tagContent1", this);
				loadAge();
			});
			loadOccupation();
		});
	}
	/*加载职业页面*/
	function loadOccupation() {
		var loadHtmlByUrlOption = {
			url : "/ihm/idm/epidemic/occupation",
			param : {},
			checkRepeat : true,
			insertDiv : "tagContent1",
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
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
	return {
		load: load
	}
});