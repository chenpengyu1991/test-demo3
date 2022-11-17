var healthRecordCensus = (function () {
	var validate = null;
    $(function () {
    	validate = $("#healthRecordCensusForm").easyValidate();
        $("#report-export").on("click", function(event)
        {
        	event.preventDefault();
        	$("#healthRecordCensusListDiv").exportExcel("城乡居民健康档案管理统计报表");
        });
        showModify();
        //点击修改按钮，显示取消、保存按钮
        $("#modifyInfectEmer").on("click", function () {
        	if($("#reportQuarter").val()=="" || $("#reportQuarter").val()==0){
	       		 layer.alert("请选择季度！", {icon:0,title:'提示'});
	       	}else if($("#reportYearId").val()==""){
	       		layer.alert("请选择年份！", {icon:0,title:'提示'});
	       	}else{
	       		$("#noModifyTbody").hide();
	               $("#modifyTbody").show();
	               showCancel();
	       	}
        });
        //点击取消按钮，显示修改按钮
        $("#cancel").on("click", function (e) {
        	e.preventDefault();
            $("#modifyTbody").hide();
            $("#noModifyTbody").show();
            showModify();
        });
        //search();
        $("#save").click(function (e) {
        	e.preventDefault();
            // 保存修改的内容：
            saveModifyInfo();
        });
        $("#healthRecordCensusSearch").on("click", function (e) {
        	e.preventDefault();
        	search();
            showModify();
        });
        $("#reportQuarter").on("change",function (e) {
        	e.preventDefault();
        	search();
            showModify();
        });
//        $("#mhmReprtQuarterId").on("click",function () {
//            search();
//        });
    });

    function search() {
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var searchObj = {
            url: "/healthRecordCensus/list",
            insertDiv: "healthRecordCensusListDiv"
        };
        $("#healthRecordCensusForm").submitFormLoadHtml(searchObj);
    }

    //显示修改按钮，隐藏取消、保存按钮
    function showModify() {
        $("#cancelInfectEmer").hide();
        $("#modifyInfectEmer").show();
    }

    //显示取消、保存按钮，隐藏修改按钮
    function showCancel() {
        $("#modifyInfectEmer").hide();
        $("#cancelInfectEmer").show();

        //建档人数
        $("#buildRecordNum_id").on("blur", function () {
        	countPercent("permanentNum_span", "buildRecordNum_id", "buildRecordPercent");
        });
        //建档人数
        $("#buildRecordNum_id").on("blur", function () {
        	countPercent("buildRecordNum_id", "dynamicRecordNum_span", "dynamicRecordPercent");
        });
    }

    //计算报告率
    function countPercent(shouldId, hasId, percentId)
	{
    	var should;
    	if(shouldId.endsWith("_span")){
    		should = $("#" +shouldId).html();
    	}else{
    		should = $("#" +shouldId).val();
    	}
    	
		var has;
		if(hasId.endsWith("_span")){
			has = $("#" +hasId).html();
    	}else{
    		has = $("#" +hasId).val();
    	}
		
		if (should && has && $.isNumeric(should)&&$.isNumeric(has) && should!=0)
		{
			var percent = (has*100/ should).toFixed(1);
			$("#" + percentId).html(percent+"%");
		} else
		{
			$("#" + percentId).html("0%");
		}
	}
    
    //保存
    function saveModifyInfo() {
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择季度！", {icon:0,title:'提示'});
    		});
            /*layer.alert("请选择季度!");*/
            return;
        }

        var quarter = $('#reportQuarter option:selected').val();
        var year = $("#reportYearId").val();
        $("#healthRecordForm").submitFormLoadHtml({
            url: contextPath + "/healthRecordCensus/save",
            insertDiv: "healthRecordCensusListDiv",
            param:{
                quarter:quarter,
                year:year
            },
            callback:function (data) {
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert(data, {icon:0,title:'提示'});
        		});
                showModify();
                $("#modifyTbody").hide();
                $("#noModifyTbody").show();
                search();

            }
        });
    }
    
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
    //查询框
    function changeReportType(){
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){//按年
            $('#reportYearId').show();
            $('#reportQuarter').hide();
            $("#reportQuarter").val(0);
        }else if(countType == '2'){//按季度
            $('#reportYearId').show();
            $('#reportQuarter').show();
        }
    }
    return {
    	 search : search,
         toggle:toggle,
         changeReportType:changeReportType
    };
})();
