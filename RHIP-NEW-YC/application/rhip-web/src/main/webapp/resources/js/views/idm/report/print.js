var reportPrint = (function() {
	$(function() {
        toggleOther('deleteContent','deleteContentOtherId','99');
	});

	function returnSearch(){
		$("#detailDiv").empty();
		reportSearch.search(1);
		$("#top_all").show();
        $("#detailDiv").removeClass("toolbarfixed");
    };


    function print(id){
        var url = contextPath + "/idm/report/print/" + id;
        util.printPage(url);

    };


    function approvalDialog(id) {
       /* var dialogObj = {
            url : contextPath + "/idm/report/popApproval",
            param : {idmId:id},
            title : "操作记录"
        };
        $.dialog(dialogObj);*/
        $.post(contextPath+'/idm/report/popApproval',
        		{ idmId:id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'idmReportOperateRecordDialog',
        			  area: ['650px', '310px'],
        			  title:'操作记录',
        			  content: ret
        		  });
        		});
        	});
    };

    return {
        returnSearch:returnSearch,
        print:print,
        approvalDialog:approvalDialog
    };

})();