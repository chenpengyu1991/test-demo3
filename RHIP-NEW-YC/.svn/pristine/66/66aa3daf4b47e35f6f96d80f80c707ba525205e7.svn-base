/**
 * Created by wang_zhou on 2015/6/8.
 */
var hmManageReport=(function() {
    function updateAssessment(personId) {
        var validate = $("#phyExamForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            msgUtil.alert("请根据提示正确填写");
            return;
        }
/*        var params = {
            url : "/oldManHealthCare/selfAssessment",
            param : {
                personId : personId,
                year : year
            },
            callback : afterUpdate
        };
        $("#phyExamForm").submitFormGetJson(params);*/


        $("#phyExamForm").submitFormGetJson({
            url : "/oldManHealthCare/selfAssessment",
            param : {
                personId : personId
            },
            callback : function(data) {
                console.info(data);
                if (data.indexOf("fail") > -1) {
                    msgUtil.alert("提交失败！");
                }else {
                    msgUtil.alert("提交成功！");
                    //hmManageReport.updateAssessment(personId);
/*                    $("#updateAssessment").attr("disabled","disabled");
                    $("#updateAssessment").attr("disabled","disabled");*/
/*                    document.all.updateAssessment.style.display="none";
                    document.all.edit.style.display="";*/
                    bj();
                }
            }
        });

    }

    function bj() {
/*        document.all.edit.style.display="none";
        document.all.updateAssessment.style.display="";*/
        var url = '/oldManHealthCare/selfEvaluation';
        window.location.href = contextPath+ url;
    }
/*
    function afterUpdate(result) {
        if (result == 1) {
            msgUtil.alert("提交成功");
            //hmManageSearch.search(1);
        } else if (result == 0) {
            msgUtil.alert("请填写对应的内容!");
            return;
        } else {
            msgUtil.alert("提交失败");
        }
    }
*/

    function calculateAssessment() {
        var score = toNumber($(":checked[name='eatingAssessment']").val()) + toNumber($(":checked[name='cleaningAssessment']").val())
            + toNumber($(":checked[name='clothingAssessment']").val()) + toNumber($(":checked[name='defecationAssessment']").val())
            + toNumber($(":checked[name='exerciseAssessment']").val());
        if (score >= 0 && score <= 3) {
            $(":radio[name='lifeAbilitySelfAssessment'][value='1']").attr("checked", "checked");
        } else if (score >= 4 && score <= 8) {
            $(":radio[name='lifeAbilitySelfAssessment'][value='2']").attr("checked", "checked");
        } else if (score >= 9 && score <= 18) {
            $(":radio[name='lifeAbilitySelfAssessment'][value='3']").attr("checked", "checked");
        } else {
            $(":radio[name='lifeAbilitySelfAssessment'][value='4']").attr("checked", "checked");
        }
    }

    function toNumber(num) {
        var n = parseInt(num);
        if (isNaN(n)) {
            return 0;
        } else {
            return n;
        }
    }

    return {
        updateAssessment : updateAssessment,
        calculateAssessment : calculateAssessment,
        bj:bj
    };

})();
