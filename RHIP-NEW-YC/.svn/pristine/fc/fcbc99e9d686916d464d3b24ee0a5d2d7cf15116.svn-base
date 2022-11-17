var daCommon = (function() {

    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };

    function returnSearch(methodName){
        var searchTemp = eval(methodName);
        if(contentChanged){
            msgUtil.backConfirm(function(){
                searchTemp();
            });
        }else{
            searchTemp();
        }
    }
	return {
        toggle:toggle,
        returnSearch:returnSearch
	};
})();



