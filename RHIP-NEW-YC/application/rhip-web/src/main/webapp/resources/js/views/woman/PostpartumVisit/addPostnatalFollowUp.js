var addPostnatalFollowUp = (function() {
    $(function() {
        $("#revert").on("click", function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                doBack();
                });
            });
        //新增保存
        $("#button_save").on("click" ,function(){
            save();
        });
        //修改保存
        $("#modifySave").on("click" ,function(){
            modifySave();
        });
        //同步基本信息
        $("#idCard").on("blur", function () {
            var idCardValue = $.trim($("#idCard").val());
            if (idCardValue.length == 15 || idCardValue.length == 18) {
                $.getJsonByUrl({
                    url: "/maternal/getMaternalByIdcard",
                    param: {
                        idCard: idCardValue
                    },
                    callback: function (data) {
                        if(!$.isEmpty(data)){
                            $("#name").val(data.name);
                            $("#Maternalname").val(data.name);
                            $("#healthFileNo").val(data.healthFileNo);
                            if($.isEmpty(data.healthFileNo)) {
                                layui.use('layer', function(){
				        			var layer = layui.layer;
				        			layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
	        					});
                            }
                        } else {
                            layui.use('layer', function(){
				        			var layer = layui.layer;
				        			layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
	        					});
                        }
                    }
                });
            }
        });
        //修改页面-指导
        var GuidanceText = $("#GuidanceText").val();
        if(GuidanceText.indexOf("99") != -1){
            $("#other_Guidance").css("display","inline");
        }else {
            $("#other_Guidance").css("display","none");
        }

        var ManageFlagval = $("#ManageFlag").val();
        if(ManageFlagval.indexOf("99") != -1){
            $("#other_CMediciManage").css("display","inline");
        }else {
            $("#other_CMediciManage").css("display","none");
        }

        //指导
        $("input[name='healthGuidanceClass']").on("click", function(){
            dic_other("healthGuidanceClass", "other_Guidance",
                      "healthGuidanceDesc");
        });

        //中医药健康管理
        $("input[name='cmediciManageFlag']").on("click", function(){
            dic_other("cmediciManageFlag", "other_CMediciManage",
                      "otherCmediciManage");
        });

        //修改页面-异常具体情况显示
        showst("breastAnomalyFlag","breastAnomalyDescText");
        showst("lochiaAnomalyFlag","lochiaConditionText");
        showst("corpusAnomalyFlagEx","corpusAnomalyDescText");
        showst("woundAnomalyFlag","woundAnomalyDescText");
        showst("classifyFlag","classifyDescText");
        showst("referralFlag","referralReason");

    });

    function doBack() {
        $("#pFOUpDiv").hide();
        $("#pFollowupId").show();
    }
    function showst(checkId,someId) {
        if ($("#" +checkId).attr("checked") == "checked"){
            $("#"+someId).show();
        }
    }

    //修改保存
    function modifySave() {
        var healthFileNo = $("#healthFileNo").val();
        if(healthFileNo.length>17){
            layui.use('layer', function() {
    			var layer = layui.layer;
    			layer.alert("该人员档案编号错误！", {icon:0,title:'提示'});
       		});
            return;
        }
        var validate = $("#modifyPostnatalForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var option = {
            url: contextPath + "/maternal/savemodifyPostpartumVisit",
            param: {
            },
            callback: function (data) {
	
				layui.use('layer',function(){
				var layer=layui.layer;
				if (data.indexOf("success") > -1)
                {
                    layer.alert("修改成功！", {icon:0,title:'提示'});
                    womanSearch.search(1);
                    doBack();
                }else if(data.indexOf("failed") > -1){
					layer.alert("修改失败！", {icon:0,title:'提示'});
				} else {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }
				})
            }
        };
        $("#modifyPostnatalForm").submitFormGetJson(option);
    }

    //新增保存
    function save() {
        var healthFileNo = $("#healthFileNo").val();
        if(healthFileNo.length>17){
            layui.use('layer', function() {
    			var layer = layui.layer;
    			layer.alert("该人员档案编号错误！", {icon:0,title:'提示'});
       		});
            return;
        }
        var validate = $("#addPostnatalForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var option = {
            url: contextPath + "/maternal/saveAddPostpartumVisit",
            param: {
            },
            callback: function (data) {
                if(data.indexOf("success") > -1){
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'});
               		});
                    /*$.removeDialog("dialog");*/
                    doBack();
                    womanSearch.search(1);
                }else if(data.indexOf("failed") > -1){
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
               		});
                }else {
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
               		});
                }
            }
        };
        $("#addPostnatalForm").submitFormGetJson(option);
    }
    
    function dic_other(dicName, hiddenId, otherName){
        if($("input[name='" + dicName + "']:last").is(":checked")){
            $("#" + hiddenId).css("display","inline");
        }else {
            $("input[name='" + otherName + "']").attr("value", "");
            $("#" + hiddenId).css("display","none");
        }
    }
})();
