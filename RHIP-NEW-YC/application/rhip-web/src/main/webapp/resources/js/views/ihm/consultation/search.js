var consultationSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
           e.preventDefault();
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
        pageIndex = (isEmpty(pageIndex)?1:pageIndex);
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

    function viewBloodDonation(id){
        /*var dialog = {
            url : "/ihm/consultation/view",
            param : {id:id},
            height : 550,
            width : 750,
            title : "会诊信息" ,
            id :"dialog"
        };
        $.dialog(dialog);
        */
        $.post(contextPath+"/ihm/consultation/view",{id:id}, function(ret){
        		  layer.open({
        			  type: 1,
        			  id:'consultaionDetailDialog',
        			  area: ['800px', '580px'],
        			  title:"会诊信息",
        			  content: ret
        		  });
        	});
    }



	return {
		search:search,
		viewBloodDonation:viewBloodDonation
	};
})();



