var configSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#configSearchForm").easyValidate();
        $("#configBtnSearch").click(function() {
           search(1);
        });
        $("#configSearch").onEnter(search, 1);
        search(1); 
    });
    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/da/config/list",
            insertDiv : "configResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#configSearchForm").submitFormLoadHtml(searchObj);
    };	

    /**
     * 查看配置信息
     * batchNo:批号
     */
    function detailSearch(organCode,organName){
        var configDetailDialog = {
            url : "/da/config/detail",
            height : 500,
            width : 800,
            title : "医院药品管理配置信息" ,
            id :"configDetailDialog",
            param : {
                organCode : organCode,
                organName:organName
            }
        };
        $.dialog(configDetailDialog);        
    }
    
    function closePopUp(){
        $.removeDialog ("configDetailDialog");
    }
    
	return {
		search:search,
		detailSearch:detailSearch,
		closePopUp:closePopUp
	};
})();



