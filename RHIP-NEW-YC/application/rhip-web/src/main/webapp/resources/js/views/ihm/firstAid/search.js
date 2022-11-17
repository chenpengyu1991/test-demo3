var firstAidSearch = (function() {
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

    function viewAcceptEvent(id){
        // var dialog = {
        //     url : "/firstAid/acceptEvents/detail",
        //     param : {id:id},
        //     height : 300,
        //     width : 700,
        //     title : "接受事件" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/firstAid/acceptEvents/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '320px'],
                title:"接受事件",
                content: ret
            });
        });
    }

    function viewAmbulance(id){
        // var dialog = {
        //     url : "/firstAid/ambulanceInfo/detail",
        //     param : {id:id},
        //     height : 350,
        //     width : 700,
        //     title : "车辆信息" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/firstAid/ambulanceInfo/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '350px'],
                title:"车辆信息",
                content: ret
            });
        });
    }


    function viewCallEvent(id){
        // var dialog = {
        //     url : "/firstAid/callEvents/detail",
        //     param : {id:id},
        //     height : 280,
        //     width : 700,
        //     title : "呼叫事件" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/firstAid/callEvents/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '280px'],
                title:"呼叫事件",
                content: ret
            });
        });
    }

    function viewTask(id){
        // var dialog = {
        //     url : "/firstAid/task/detail",
        //     param : {id:id},
        //     height : 350,
        //     width : 700,
        //     title : "任务" ,
        //     id :"dialog"
        // };
        // $.dialog(dialog);
        $.post(contextPath+"/firstAid/task/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['700px', '350px'],
                title:"任务",
                content: ret
            });
        });
    }



	return {
		search:search,
        viewAcceptEvent:viewAcceptEvent,
        viewAmbulance:viewAmbulance,
        viewCallEvent:viewCallEvent,
        viewTask:viewTask
	};
})();



