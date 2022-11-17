var messageSearch = (function() {
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
        $("#messageDiv").remove();
        $("#top_all").show();
        $("#detailDiv").hide();
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
    	
        var startDateVal = $("#dateFromId").val();
 		var endDateVal = $("#dateToId").val();
 		if (startDateVal && endDateVal)
 		{
 			var startDate = new Date(startDateVal);
 			var endDate = new Date(endDateVal);
 			if (startDate > endDate)
 			{
 				layer.alert("开始日期不能大于结束日期！", {icon:0,title:'提示'});
 				return;
 			}
 		}
 		
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var personal = $("#personal").val();
        var searchObj = {
            url : '/msg/sentList',
            insertDiv : "resultDiv",
            param : {
                pageIndex : pageIndex,
                personal : personal
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };


    function addMessage() {
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/msg/initAdd",
            insertDiv :"detailDiv"
        });
        $("#detailDiv").show();
    }

    function save() {
        validate = $("#messageForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#messageForm").submitFormGetJson({
            url : "/msg/add",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("消息发布失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("消息发布成功！", {icon:0,title:'提示'});
                    search(1);
                }
            }
        });
    }
    function view(id){
        var personal = $("#personal").val();
//        var dialog = {
//            url : "/msg/view",
//            param : {id:id, personal:personal},
//            height : 380,
//            width : 750,
//            title : "消息" ,
//            id :"dialog"
//        };
//        $.dialog(dialog);
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/msg/view",
            param : {id:id, personal:personal},
            insertDiv :"detailDiv"
        });
        $("#detailDiv").show();
    }

	return {
		search:search,
        addMessage:addMessage,
        save:save,
        view:view
	};
})();



