var bloodSearch = (function() {
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

    function viewBloodDonation(id){
        // var dialog = {
        //     url : "/bloodMgnt/bloodDonation/detail",
        //     param : {id:id},
        //     height : 550,
        //     width : 750,
        //     title : "献血记录" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/bloodMgnt/bloodDonation/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '500px'],
                title:"献血记录",
                content: ret
            });
        });
    }

    function viewBloodUse(id){
        // var dialog = {
        //     url : "/bloodMgnt/bloodUse/detail",
        //     param : {id:id},
        //     height : 350,
        //     width : 700,
        //     title : "免费用血" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/bloodMgnt/bloodUse/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '450px'],
                title:"免费用血",
                content: ret
            });
        });
    }


    function viewbloodBank(id){
        // var dialog = {
        //     url : "/bloodMgnt/bloodBank/detail",
        //     param : {id:id},
        //     height : 280,
        //     width : 700,
        //     title : "血液库存" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/bloodMgnt/bloodBank/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '280px'],
                title:"血液库存",
                content: ret
            });
        });
    }

    function viewblood2Hos(id){
        // var dialog = {
        //     url : "/bloodMgnt/blood2Hos/detail",
        //     param : {id:id},
        //     height : 350,
        //     width : 700,
        //     title : "血液出库" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/bloodMgnt/blood2Hos/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '350px'],
                title:"血液出库",
                content: ret
            });
        });
    }



	return {
		search:search,
		viewBloodDonation:viewBloodDonation,
		viewBloodUse:viewBloodUse,
		viewbloodBank:viewbloodBank,
		viewblood2Hos:viewblood2Hos
	};
})();



