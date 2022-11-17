var mentalEpilepsyCensus = (function () {
    $(function () {
        $("#mentalEpilepsyCensusListDivExport").on("click", function(event) {
        	event.preventDefault();
            $("#mentalEpilepsyCensusListDiv").exportExcel("严重精神障碍患者管理统计报表");
        });
        showModify();
        //点击修改按钮，显示取消、保存按钮
        $("#modifyMentalEpi").on("click", function () {
        	 if($("#Quarter").val()=="" || "#YearType".checked){
        		 layui.use('layer', function(){
 	    			var layer = layui.layer;
 	    			layer.alert("请选择季度！", {icon:0,title:'提示'});
 	    		});
	       		 /*msgUtil.alert("请选择季度!");*/
	       	}else if($("#Year").val()==""){
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
        $("#save").click(function () {
            // 保存修改的内容：
            saveModifyInfo();
        });
        //点击查询按钮
        $("#mentalEpiSearch").on("click", function (e) {
            e.preventDefault();
        	search();
        });
        //改变季度-更新列表
        $("#Quarter").on("change",function () {
            search();
        });
        //点击按季度按钮
//        $("#QuarterType").on("click",function () {
//            search();
//        });
    });

    function search() {
        var searchObj = {
            url: "/mentalEpilepsyCensus/list",
            insertDiv: "mentalEpilepsyCensusListDiv"
        };
        $("#MentalEpiForm").submitFormLoadHtml(searchObj);
        showModify();
    }

    //显示修改按钮，隐藏取消、保存按钮
    function showModify() {
        $("#cancelMentalEpi").hide();
        $("#modifyMentalEpi").show();
    }

    //显示取消、保存按钮，隐藏修改按钮
    function showCancel() {
        $("#modifyMentalEpi").hide();
        $("#cancelMentalEpi").show();
        
        //辖区内登记在册的确诊严重精神障碍患者人数
        $("#mentalNum_id").on("blur", function () {
        	countTPercent("mentalNum_id", "mentalManageNum_id","stableDiseaseNum_id", "mentalPercent", "stableDiseasePercent");
        });
        //辖区内按照规范要求进行管理的严重精神障碍患者人数
        $("#mentalManageNum_id").on("blur", function () {
        	countTPercent("mentalNum_id", "mentalManageNum_id","stableDiseaseNum_id", "mentalPercent", "stableDiseasePercent");
        });
        //最近一次随访时分类为病情稳定的患者数
        $("#stableDiseaseNum_id").on("blur", function () {
        	countTPercent("mentalNum_id", "mentalManageNum_id","stableDiseaseNum_id", "mentalPercent", "stableDiseasePercent");
        });
        //癫痫发作有效控制人数
        $("#epilepsyControlNum_id").on("blur", function () {
        	countPercent("epilepsyNum_id", "epilepsyControlNum_id", "epilepsyPercent");
        });
        //随访治疗癫痫患者数
        $("#epilepsyNum_id").on("blur", function () {
        	countPercent("epilepsyNum_id", "epilepsyControlNum_id", "epilepsyPercent");
        });
    }

    //计算报告率
    function countTPercent(shouldId, hasId1, hasId2, percentId1,  percentId2)
	{
		var should = $("#" +shouldId).val();
		var has1 = $("#" + hasId1).val();
		var has2 = $("#" + hasId2).val();
		
		if (should && has1 && $.isNumeric(should)&&$.isNumeric(has1) && should!=0){
			var percent = (has1*100/ should).toFixed(1);
			$("#" + percentId1).html(percent+"%");
		} else{
			$("#" + percentId1).html("0%");
		}
		
		if (should && has2 && $.isNumeric(should)&&$.isNumeric(has2) && should!=0){
			var percent = (has2*100/ should).toFixed(1);
			$("#" + percentId2).html(percent+"%");
		} else{
			$("#" + percentId2).html("0%");
		}
	}
    
    //保存
    function saveModifyInfo() {
        if($("#Quarter").val()==""){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择季度！", {icon:0,title:'提示'});
    		});
     		/* msgUtil.alert("请选择季度!");*/
     		 return;
     	}else if($("#Year").val()==""){
     		layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择年份！", {icon:0,title:'提示'});
    		});
     		/*msgUtil.alert("请选择年份!");*/
     		 return;
     	}
        var quarter = $('#Quarter option:selected').val();
        var year = $("#Year").val();
        $("#mentalEpilepsyCensusForm").submitFormLoadHtml({
            url: contextPath + "/mentalEpilepsyCensus/save",
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
                /*msgUtil.alert("修改成功!");
                showModify();
                $("#modifyTbody").hide();
                $("#noModifyTbody").show();
                search();*/
            }
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
