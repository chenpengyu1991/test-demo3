var infectEmergCensus = (function () {
    var validate = null;
    $(function () {
        $("#infectEmergCensusListDivExport").on("click", function(event) {
        	event.preventDefault();
            $("#infectEmergCensusListDiv").exportExcel("传染病及突发公共卫生事件报告和处理统计报表");
        });
        showModify();
        //点击修改按钮，显示取消、保存按钮
        $("#modifyInfectEmer").on("click", function () {
            
            if($("#reportQuarter").val()==""){
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请选择季度！", {icon:0,title:'提示'});
        		});
	       		 /*msgUtil.alert("请选择季度!");*/
	       	}else if($("#reportYearId").val()==""){
	       		layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("请选择年份！", {icon:0,title:'提示'});
	    		});
	       		/*msgUtil.alert("请选择年份!");*/
	       	}else{
	       		$("#noModifyTbody").hide();
	            $("#modifyTbody").show();
	       		showCancel();
	       	}
            
        });
        //点击取消按钮，显示修改按钮
        $("#cancel").on("click", function () {
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
        $("#infectEmergCensusSearch").on("click", function (e) {
            e.preventDefault();
        	search();
        });
        $("#reportQuarter").on("change",function () {
            var quarter = $('#reportQuarter option:selected').val();
            search();
        });
//        $("#mhmReprtQuarterId").on("click",function () {
//            search();
//        });
    });

    function search() {
        var searchObj = {
            url: "/infectEmergCensus/list",
            insertDiv: "infectEmergCensusListDiv"
        };
        $("#infectEmergCensusForm").submitFormLoadHtml(searchObj);
        showModify();
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

        //登记传染病病例数
        $("#registerInfectiousNum").on("blur", function () {
        	countPercent("registerInfectiousNum", "networkInfectiousNum", "infectPercent");
        });
        //网络报告的传染病病例数
        $("#networkInfectiousNum").on("blur", function () {
        	countPercent("registerInfectiousNum", "networkInfectiousNum", "infectPercent");
        });
        
        //报告传染病病例数
        $("#reportInfectiousNum").on("blur", function () {
        	countPercent("reportInfectiousNum", "timelyInfectiousNum", "infectiousPercent");
        });
        //报告及时的病例数
        $("#timelyInfectiousNum").on("blur", function () {
        	countPercent("reportInfectiousNum", "timelyInfectiousNum", "infectiousPercent");
        });
        
        //报告突发公共卫生事件相关信息数
        $("#occurEmergenciesNum").on("blur", function () {
        	countPercent("occurEmergenciesNum", "timelyEmergenciesNum", "emergenciesPercent");
        });
        //及时报告的突发公共卫生事件相关信息数
        $("#timelyEmergenciesNum").on("blur", function () {
        	countPercent("occurEmergenciesNum", "timelyEmergenciesNum", "emergenciesPercent");
        });
    }

    //计算报告率
    function countPercent(shouldId, hasId, percentId)
	{
		var should = $("#" +shouldId).val();
		var has = $("#" + hasId).val();
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

        if($("#reportQuarter").val()==""){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择季度！", {icon:0,title:'提示'});
    		});
      		 /*msgUtil.alert("请选择季度!");*/
      		 return;
      	}else if($("#reportYearId").val()==""){
      		layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择年份！", {icon:0,title:'提示'});
    		});
      		/*msgUtil.alert("请选择年份!");*/
      		 return;
      	}
        
        var quarter = $('#reportQuarter option:selected').val();
        var year = $("#reportYearId").val();
        $("#infectEmerListForm").submitFormLoadHtml({
            url: contextPath + "/infectEmergCensus/save",
            param:{
                quarter:quarter,
                year:year
            },
            callback:function () {
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("修改成功！", {icon:0,title:'提示'}, function() {
        				layer.closeAll();
        				showModify();
    	                $("#modifyTbody").hide();
    	                $("#noModifyTbody").show();
    	                search();
        			});
        		});
               /* msgUtil.alert("修改成功!");
                showModify();
                $("#modifyTbody").hide();
                $("#noModifyTbody").show();
                search();*/

            }
        });
    }
    //查询框
    function changeReportType(){
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){//按年
            $('#reportYearId').show();
            $('#reportQuarter').hide();
        }else if(countType == '2'){//按季度
            $('#reportYearId').show();
            $('#reportQuarter').show();
        }
    }
    
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
    return {
    	search : search,
        toggle:toggle,
        changeReportType:changeReportType
    };
})();
