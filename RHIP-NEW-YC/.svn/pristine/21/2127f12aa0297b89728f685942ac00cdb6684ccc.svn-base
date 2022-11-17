var newCitizenScoreSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
           search(1);
        });
        $("#btnSearch").onEnter(search, 1);
        search(1);
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var url = $("#searchUrl").val();
        var searchObj = {
            url : url,
            insertDiv : "listDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };

    function viewNewCitizenScore(id){
        var dialog = {
            url : "/medicalTarget/ncs/newCitizenScore/detail",
            param : {id:id},
            height : 300,
            width : 750,
            title : "参数详情" ,
            id :"dialog"
        };
        $.dialog(dialog);
    }


	return {
		search:search,
		viewNewCitizenScore:viewNewCitizenScore
	};
})();



