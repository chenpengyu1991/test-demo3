var maternalHealthManage = (function () {
	var validate = null;
    $(function () {
    	validate = $("#maternalHealthManageSearchForm").easyValidate();
        $("#maternalHealthManageSearch").click(function (e) {
            e.preventDefault();
        	search();
        });
        $("#Quarter").change(function(){
        	search();
        	});
        //search();
        $("#maternalHealthManageListDivExport").on("click", function(event) {
            $("#maternalHealthManageListDiv").exportExcel("孕产妇健康管理统计报表");
        });
    });

    function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
    
    function search() {
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
    	if (!$.isEmpty($("#month").val()) && $.isEmpty($("#year").val())) {
    		layer.alert("请选择年份！", {icon:0,title:'提示'});
			return;
		}
    	
        var searchObj = {
            url : "/maternalHealthManage/list",
            insertDiv : "maternalHealthManageListDiv"
        };
        $("#maternalHealthManageSearchForm").submitFormLoadHtml(searchObj);
    }
    function changeReportType(){
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){//按年
            $('#Year').show();
            $('#Quarter').hide();
        }else if(countType == '2'){//按季度
            $('#Year').show();
            $('#Quarter').show();
        }
    }
    return {
    	search : search,
        toggle:toggle,
        changeReportType:changeReportType
    };
})();

