var ihmDaTarget = (function() {
    $(function() {
    	loadChange(1);
	});
    
    /*加载出入库页面*/
	function loadChange(pageIndex) {
		debugger;
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var loadHtmlByUrlOption = {
			url : "/ihm/da/change",
			param : {pageIndex:pageIndex},
			checkRepeat : true,
			insertDiv : "changeDiv",
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
            insertDiv : "storageDiv",
            errorDiv: "",
            okDiv:"",
            callback:ihmCommon.initForm
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };

	return {
		loadChange : loadChange,
		loadStorage : loadStorage
	};
})();



