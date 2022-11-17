var intoPatient = (function() {

    $(function() {
        init();
    });

    function init(){
        $("#intoBtnSearch").click(function(e) {
            e.preventDefault();
        	search();
        });
        $("#intoSearch").onEnter(search, 1);
        //$("#intoSearchForm").onEnter(intoSearch, 1);
        search();
    }

    function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$("#pageIndex").val():pageIndex);
        var searchObj = {
            url : "/mhm/patient/into/list",
            insertDiv : "intoResultDiv",
            param : {
                pageIndex : pageIndex
            },
//            wait:true,
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#intoSearchForm").submitFormLoadHtml(searchObj);
    };

    function into(statusId,eventId,logoff){
        /*var intoDialog = {
            url : "/mhm/patient/into/add",
            height : 600,
            id : "intoDialog",
            width : 900,
            param : {statusId : statusId, eventId: eventId, logoff:logoff},
            title : "纳入管理－患者基本档案"
        };
        $.dialog(intoDialog);*/
        
        $.post(contextPath+'/mhm/patient/into/add',
        		{ statusId : statusId, eventId: eventId, logoff:logoff
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'intoDialog',
        			  area: ['900px', '600px'],
        			  title:'纳入管理－患者基本档案',
        			  content: ret
        		  });
        		});
        	});
    }

    return {
        search:search,
        into:into
    };
})();



