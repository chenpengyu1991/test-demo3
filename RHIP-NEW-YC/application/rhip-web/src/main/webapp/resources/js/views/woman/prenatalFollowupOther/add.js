var pFOAdd = (function() {
    $(function() {
        init();
        $("#pFOBackId").on("click", function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                doBack();
            });
        });
        $("#pFOSaveId").on("click", save);

        $("#text_idcard").keyup(function () {
            var idCardValue = $("#text_idcard").val();
            $("#text_idcard").attr("value", idCardValue.toUpperCase());
        });

        $("#text_idcard").on("blur", function () {
            var idCardValue = $.trim($("#text_idcard").val());
            var inputOrganCodeValue = $("#text_inputOrganCode").val();
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
        toggleOther('classifySignTwo','classifyDescTwoId',2);
        toggleOther('classifySignThree','classifyDescThreeId',2);
        toggleOther('classifySignFour','classifyDescFourId',2);
        toggleOther('classifySignFive','classifyDescFiveId',2);
        toggleOtherCK('healthGuidanceClassTwo','healthGuidanceClassDescTwoId',99);
        toggleOtherCK('healthGuidanceClassThree','healthGuidanceClassDescThreeId',99);
        toggleOtherCK('healthGuidanceClassFour','healthGuidanceClassDescFourId',99);
        toggleOtherCK('healthGuidanceClassFive','healthGuidanceClassDescFiveId',99);
        toggleOther('referralFlagTwo','referralFlagTwoId',1);
        toggleOther('referralFlagThree','referralFlagThreeId',1);
        toggleOther('referralFlagFour','referralFlagFourId',1);
        toggleOther('referralFlagFive','referralFlagFiveId',1);
        toggleOtherCK('tcmHealthSignTwo','tcmHealthSignDescTwoId',99);
        toggleOtherCK('tcmHealthSignThree','tcmHealthSignDescThreeId',99);
        toggleOtherCK('tcmHealthSignFour','tcmHealthSignDescFourId',99);
        toggleOtherCK('tcmHealthSignFive','tcmHealthSignDescFiveId',99);
        toggleOther('otherExamTwoSign','otherExamTwoId',2);
        toggleOther('otherExamThreeSign','otherExamThreeId',2);
        toggleOther('otherExamFourSign','otherExamFourId',2);
        toggleOther('otherExamFiveSign','otherExamFiveId',2);
    }
    function setCover(data) {
        $("#healthFileNoIdd").val(data.healthFileNo);
        $("#healthFileNoId").val(data.healthFileNo);
        $("#text_personId").val(data.id);
        $("#text_name").val(data.name);
        $("#text_idcard").val(data.idcard);
        //$("#birthday").val(dateFormat(data.birthday));
        //$("#text_guardianPhoneOne").val(data.guardianPhoneOne);
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
        $("#pFOSearchDivId").show();
        $("#pFODetailDiv").hide();
    }

    function save() {
        var validate = $("#pFOAddFromId").easyValidate();
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
        $("#pFOAddFromId").submitFormGetJson({
            url : "/prenatalFollowup/other/save",
            wait : true,
            callback : function(data)
            {
                layui.use('layer',function(){
				var layer=layui.layer;
				if (data == "success")
                {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    pFOSearch.search(1);
                    doBack();
                } else {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }
				})
            }
        });

    }
})();



