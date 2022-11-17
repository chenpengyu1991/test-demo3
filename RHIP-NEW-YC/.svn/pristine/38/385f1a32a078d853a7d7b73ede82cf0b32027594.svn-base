var stopDetailSearch = (function() {
    var validate = null;

    $(function() {
        validate = $("#stop_detail_search").easyValidate();
//        $("#stop1_search_btn").click(function() {
//           
//            recordsPerform("1");
//        });
//
//        $("#stop2_search_btn").click(function() {
//            recordsPerform("2");
//        });
    });

    
    function recordsPerform(type){
    	 $("#stop1_search_btn").hide();
    	
    	if($("#startDate").val()==""){
    		layer.alert("请输入停诊开始时间！", {icon:0,title:'提示'});
    		$("#stop1_search_btn").show();
    		return;
    	}
    	if($("#endDate").val()==""){
    		layer.alert("请输入停诊结束时间！", {icon:0,title:'提示'});
    		$("#stop1_search_btn").show();
    		return;
    	}
        var sd = new Date($("#startDate").val());
        var ed = new Date($("#endDate").val());
        if (sd > ed) {
            $("#stop1_search_btn").show();
            layer.alert("停诊开始日期不能大于停诊结束日期！", {icon:0,title:'提示'});
            return;
        }
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var searchObj = {
               url : "/portal/stop/stopDetails",
               param : {
                   type : type
               },
               callback :function(data){
                    if(data == "stop_ok"){
                        layer.alert("停诊成功！", {icon:0,title:'提示'});
                        stopSearch.search(1);
                        stopDetialH.closeDialog();
                        return;
                    } else if(data == "stop_fail"){
                        layer.alert("停诊失败");
                    } else if(data == "stop_repeat"){
                        layer.alert("该医生已停诊，请勿重复停诊！", {icon:0,title:'提示'});
                    }else{
                        recordsShow(1);
                   }
               }
        };
        $("#stop_detail_search").submitFormLoadHtml(searchObj);
    }

    function recordsShow(indexPage){
        var searchObj = {
            url : "/portal/stop/stopDetailRecords",
            insertDiv : "stopDetail_records",
            param : {
                indexPage : indexPage
            }
        };
        $("#stop_detail_search").submitFormLoadHtml(searchObj);

    }

    return {
        search : recordsPerform ,
        recordsShow : recordsShow
    };
})();


