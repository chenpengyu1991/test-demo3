var pFPAdd = (function() {
    $(function() {
        init();
        $("#pFPBackId").on("click", function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                doBack();
             });
            });
        $("#pFPSaveId").on("click", save);

        $("#text_idcard").keyup(function () {
            var idCardValue = $("#text_idcard").val();
            $("#text_idcard").attr("value", idCardValue.toUpperCase());
        });

        $("#text_idcard").on("blur", function () {
            var idCardValue = $.trim($("#text_idcard").val());
            if (idCardValue.length == 15 || idCardValue.length == 18) {
                $.getJsonByUrl({
                    url: "/personRecord/getPersonByIdcard",
                    param: {
                        idCard: idCardValue
                    },
                    callback: function (data) {
                         if (!$.isEmpty(data)) {
                            var filingFlag = data.filingFlag;
                            var personId = data.id;
                            var organCode = data.inputOrganCode;
                            var organName = data.inputOrganName;
                            setCover(data);
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
    });

    function init() {
        toggleOther('lastMenstrualDateMark','lastMenstrualDateSpanID',2);
        toggleOtherCK('pastMedicalHistory','pastMedicalHistoryDescId',99);
        toggleOtherCK('familyDiseaseHistory','familyDiseaseHistoryDescId',9);
        toggleOtherCK('personalHistory','personalHistoryDescId',9);
        toggleOther('womanSurgeryHistorySign','gynecologicalSurgeryHistoryId',2);
        toggleOther('cardiacAuscuAnomaly','cardiacAuscuAnomalyDescId',2);
        toggleOther('lungAuscuAnomaly','lungAuscuAnomalyDescId',2);
        toggleOther('vulvaAnomaly','vulvaAnomalyDescId',2);
        toggleOtherCK('vaginaAbnormal','vaginaAbnormalDescId',2);
        toggleOther('abnormalCervical','abnormalCervicalDescId',2);
        toggleOther('corpusAnomaly','corpusAnomalyDescId',2);
        toggleOther('accessoriesAnomaly','accessoriesAnomalyDescSpanId',2);
        toggleOther('vaginaSecretionsCheckResult','vaginaSecretionsCheckDescId',9);
        toggleOther('assessmentAnomalySign','healthAbnormalDescId',2);
        toggleOtherCK('healthGuidanceClass','healthGuidanceClassDescSpanId',99);
        toggleOtherCK('cmHealthManage','cmHealthManageDescSpan',99);
        toggleOther('referralFlag','referralFlagId',2);
        toggleOther('familyDiseaseHistorySign','familyDiseaseHistorySignId',2);
        toggleOther('personalHistorySign','personalHistorySignSpanId',2);
        toggleOther('pastMedicalHistorySign','pastMedicalHistorySignId',2);
        toggleOtherCK('pastMedicalHistory','pastMedicalHistoryDescId',99);
        toggleOther('referralFlag','referralFlagIdSpan',1);
    }

    function setCover(data) {
        $("#healthFileNoIdd").val(data.healthFileNo);
        $("#healthFileNoId").val(data.healthFileNo);
        $("#text_personId").val(data.id);
        $("#text_name").val(data.name);
        $("#text_idcard").val(data.idcard);
        //$("#birthday").val(dateFormat(data.birthday));
        $("#text_guardianPhoneOne").val(data.guardianPhoneOne);
        $("#ageId").val(setAge(data.idcard));
        //$("#husbandAgeId").val(setAge(data.healthFileNo));
    }

    function dateFormat(ms) {
        var d = new Date();
        d.setTime(ms);
        var y = d.getFullYear();
        var m = d.getMonth() + 1;
        var mstr = m.toString();
        if (mstr.length < 2) {
            mstr = "0" + mstr;
        }
        var da = d.getDate();
        var dstr = da.toString();
        if (dstr.length < 2) {
            dstr = "0" + dstr;
        }
        return y + "/" + mstr + "/" + dstr;
    }

    function doBack(){
        $("#pFPSearchDivId").show();
        $("#pFPDetailDiv").hide();
    }

    function save() {
        var validate = $("#pFPAddFromId").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        if($.isEmpty($("#text_personId").val())) {
			layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
        	});
            return;
        }
        // 保存
        $("#pFPAddFromId").submitFormGetJson({
            url : "/prenatalFollowup/fisrt/save",
            wait : true,
            callback : function(data)
            {
				layui.use('layer',function(){
				var layer=layui.layer;
				if (data == "success")
                {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    pFPSearch.search(1);
                    doBack();
                } else {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }
				})
                
            }
        });
    }

    $("#personHeightId").on("blur", function()
    {
        caculateBMI();
    });

    $("#personWeightId").on("blur", function()
    {
        caculateBMI();
    });

    // 根据身高、体重计算BMI值
    function caculateBMI()
    {
        var height = ($("#personHeightId").val());
        var weight = $("#personWeightId").val();

        if (height && weight&&$.isNumeric(height)&&$.isNumeric(weight))
        {
            height=height*0.01;
            var bmi = (weight / (height * height)).toFixed(2);
            $("#personBMIId").attr("value", bmi);
        } else
        {
            $("#personBMIId").attr("value", "");
        }
    }
})();



