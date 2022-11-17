define(function() {
	function load() {
		$(function() {
			/*卫生人员统计*/
			$("#tag1").on("click", function(event)
			{	
				selectTagl("tagContent1", this);
				loadHealth();
			});
			/*每千人卫生人员统计*/
			$("#tag2").on("click", function(event)
			{
				selectTagl("tagContent1", this);
				loadHealthThousand();
			});
	        /*按执业类型、职称统计*/
	        $("#tag3").on("click", function(event)
	        {
	            selectTagl("tagContent1", this);
	            loadPractice();
	        });
            //返回
            $("#staffReturn").on("click", function(event){
                returnStaffMain();
            });
			loadHealth();
		});
	}

    function returnStaffMain(){
        $('#staffMain').show();
        $('#detail').hide();
    }

	/*加载卫生人员统计页面*/
	function loadHealth() {
		var loadHtmlByUrlOption = {
			url : "/ihm/hr/health",
			param : {},
			checkRepeat : true,
			insertDiv : "tagContent1",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};

    /*加载每千人卫生人员统计页面*/
    function loadHealthThousand() {
        var loadHtmlByUrlOption = {
            url : "/ihm/hr/healththousand",
            param : {},
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
    /*加载执业职称统计页面*/
    function loadPractice() {
        var loadHtmlByUrlOption = {
            url : "/ihm/hr/practice",
            param : {},
            checkRepeat : true,
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
	return {
		load:load
	};
});