define(['../ihmCommon'],function(ihmCommon) {
	function load() {
		$(function(){
		pageUtil.bind("tagContent1",ihmCommon.search);
		/*出入库*/
		$("#tag1").on("click", function(event)
		{	
			selectTagl("tagContent1", this);
			loadChange();
		});
		/*库存*/
		$("#tag2").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			loadStorage();
		});
    	loadChange();
	});
 }

	/*加载出入库页面*/
	function loadChange(pageIndex) {
		debugger;
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var loadHtmlByUrlOption = {
			
			url : "/ihm/da/change",
			param : {pageIndex:pageIndex},
			checkRepeat : true,
			insertDiv : "tagContent1",
			errorDiv: "",
			okDiv:"",
			callback:ihmCommon.initForm
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
    /*加载库存页面*/
    function loadStorage() {
        var loadHtmlByUrlOption = {
            url : "/ihm/da/storage",
            param : {},
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:"",
            callback:ihmCommon.initForm
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
    return{
    	load: load
    };
});