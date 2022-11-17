var postpartumFTwo = (function() {
    $(function() {

        toggleOtherCK('cmHealthManage','cmHealthManageDescSpan',99);

        $("#revert").on("click", function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                doBack();
             });
            });
        //新增保存
        $("#PosFTwoSave").on("click" ,function(){
            save();
        });
        //修改保存
        $("#modifyPosFTwoSave").on("click" ,function(){
            modifySave();
        });
        //同步基本信息
        $("#idCard").on("blur", function () {
            var idCardValue = $.trim($("#idCard").val());
            if (idCardValue.length == 15 || idCardValue.length == 18) {
                $.getJsonByUrl({
                    url: "/postpartum/getMaternalByIdcard",
                    param: {
                        idCard: idCardValue
                    },
                    callback: function (data) {
                        if(!$.isEmpty(data)){
                            $("#name").val(data.name);
                            $("#healthFileNo").val(data.healthFileNo);
                            $("#personId").val(data.id);
                            if($.isEmpty(data.healthFileNo)) {
                                layui.use('layer', function() {
        	            			var layer = layui.layer;
        	            			layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
        	               		});
                            }
                        }else{
                            layui.use('layer', function() {
    	            			var layer = layui.layer;
    	            			layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
    	               		});
                        }
                    }
                });
            }
        });

        var GuidanceText = $("#GuidanceText").val();
        if(GuidanceText.indexOf("99") != -1){
            $("#other_Guidance").css("display","inline");
        }else {
            $("#other_Guidance").css("display","none");
        }
        //指导
        $("input[name='healthGuidanceClass']").on("click", function(){
            dic_other("healthGuidanceClass", "other_Guidance", "healthGuidanceDesc");
        });

        //处理按钮--待处理
        $("input[name='finalMark']").eq(0).click(function () {
            $("input[name='referralFlag']").eq(1).attr("checked",false);
            $("input[name='referralFlag']").eq(1).siblings().removeAttr("checked");
        });
        $("input[name='referralFlag']").eq(1).click(function () {
            $("input[name='finalMark']").eq(0).removeAttr("checked");
        });
        //修改页面-异常具体情况显示
        showst("breastAnomalySign","breastAnomalyDescText");
        showst("lochiaAnomalySign","lochiaConditionText");
        showst("corpusAnomaly","corpusAnomalyDescText");
        showst("woundAnomalySign","woundAnomalyDescText");
        showst("classifyFlag","classifyDescText");
        showst("referralFlag","referralReasonText");
    });

    function doBack() {
        $("#insertPostForT").hide();
        $("#postForTwo").show();
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
        var validate = $("#modifyPosFTwoForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var option = {
            url: contextPath + "/postpartum/saveModifyPostpartumFTwo",
            param: {
            },
            callback: function (data) {
                if(data.indexOf("success") > -1){
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("修改成功！", {icon:0,title:'提示'});
               		});
                    womanSearch.search(1);
                    doBack();
                }else if(data.indexOf("failed") > -1){
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("修改失败！", {icon:0,title:'提示'});
               		});
                }else {
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
               		});
                }
            }
        };
        $("#modifyPosFTwoForm").submitFormGetJson(option);
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
        var validate = $("#addPosFTwoForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var healthFileNo = $("#healthFileNo").val();
        if(healthFileNo){

        }
        var option = {
            url: contextPath + "/postpartum/saveAddPostpartumFTwo",
            param: {
            },
            callback: function (data) {
                if(data.indexOf("success") > -1){
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'});
               		});
                    womanSearch.search(1);
                    doBack();
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
        $("#addPosFTwoForm").submitFormGetJson(option);
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
