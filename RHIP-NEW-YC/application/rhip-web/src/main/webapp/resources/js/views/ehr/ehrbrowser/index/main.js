var ehrbrowserIndex = (function () {
    var menuClass = "ehrbrowser-menu";
    var mainId = "ehrbrowser-content";
    var serviceType = "brwservice";
    var personid = $("#ehrbrowser_person_id_input").val();
    var doctorSetMap = $("#doctorSetMap").val();
    var doctorType = $("#doctortype").val();
    $(function () {
        if (personid != "" && personid.length > 0) {
            $("." + menuClass).on("click", function (event) {
                event.preventDefault();
                var $this = $(this);
                var type = $this.data("ehrType");
                if (type == serviceType) {
                    checkIdcard(function (idcard) {
                        $.loadHtmlByUrl({
                            url: $this.attr("href"),
                            param: {
                                personId: personid,
                                idcard: idcard,
                                doctorSetMap : doctorSetMap,
                                doctorType : doctorType
                            },
                            insertDiv: mainId
                        });
                    });
                } else {
                	debugger;
                    $.loadHtmlByUrl({
                        url: $this.attr("href"),
                        param: {
                            personId: personid
                        },
                        insertDiv: mainId
                    });
                }
            });
        } else {
        	layer.alert("所查询人员档案不存在！", {icon:0,title:'提示'});
        }

        $("." + menuClass + ":first").click();
    });


    function checkIdcard(callback) {
    //    var result = readIdCard();
    //    var resultType = result.result;
    //    if (resultType == 1) {
    //        msgUtil.alert("市民卡读取失败,请检查是否已经连接读卡器或者已经安装插件!");
    //        return;
    //    }
    //
    //    if (resultType == 2) {
    //        msgUtil.alert("请刷市民卡!");
    //        return;
    //    }
    //
    //    if (resultType == 3) {
    //        msgUtil.alert("市民卡身份证号读取失败!");
    //        return;
    //    }
    //
    //    var idCard = result.idCard;
    //    var currentIdCard = $("#ehrbrowser_person_idcard_input").val() || "";
    //    currentIdCard = $.trim(currentIdCard.toLowerCase())
    //
    //    if(currentIdCard){
    //        if (idCard == currentIdCard) {
    //            if ($.isFunction(callback)) {
    //                callback(idCard);
    //            }
    //        } else {
    //            msgUtil.alert("市民卡身份证与当前信息不匹配!");
    //        }
    //    }else{
    //        msgUtil.alert("当前人员无身份证信息,请检查是否已经建档!");
    //    }
    //
    }

    function readIdCard() {
        return  readIdCardForPro();
    }

    function readIdCardForDev() {
        var result = {result: 9, idCard: ""};
        var currentIdCard = $("#ehrbrowser_person_idcard_input").val() || "";
        currentIdCard = $.trim(currentIdCard.toLowerCase())
        result.idCard=currentIdCard;
        return result
    }

    function readIdCardForPro() {
        var result = {result: 1, idCard: ""};
        var smkInfoObj;
        try {
            smkInfoObj = readCsSmk();
        } catch (e) {
            smkInfoObj = null;
        }

        if (null == smkInfoObj) {
            result.result = 1;//读卡失败
        } else if (smkInfoObj == 'error') {
            result.result = 2;//请正确放入市民卡
        } else if (!$.isPlainObject(smkInfoObj) || smkInfoObj.IDCardNum == null || smkInfoObj.IDCardNum == "") {
            result.result = 3;//市民卡身份证号读取失败
        } else {
            result.result = 9;//
            var idCard = smkInfoObj.IDCardNum || "";
            idCard=$.trim(idCard.toString());
            result.idCard = idCard.toLowerCase();
        }
        return result;
    }

    return {checkIdcard: checkIdcard}

})();


//!!!!!!!!!!!!!!!!!!!请勿修改以下代码!!!!!!!!!!!!!!!////
////liuk 临时解决生命事件打开窗口错误问题
////TODO 与医疗服务合并
var ehrbrowserServiceIndex = (function () {
    // 检验报告单
    function openExamReport($this, param) {
        openReport($this, param, 900, 500);
    }

    // 检查报告单
    function openStudyReport($this, param) {
        openReport($this, param, 600, 500);
    }


    // 处方
    function openDrugReport($this, param) {
        // openReport($this, param, 650, 500);
        openReport($this, param, 800, 550);
    }

    // 体检
    function openCdExam($this, param) {
        openReport($this, param, 1000, 500);
    }

    // 学生体检
    function openStudentExam($this, param) {
        openReport($this, param, 800, 650);
    }

    // 其它类型体检
    function openOtherExam($this, param) {
        openReport($this, param, 800, 650);
    }

    // 临床图表
    function openDrugInpatientChart($this, param) {
        openReport($this, param, 800, 630);
    }

    function openReport($this, param, width, height) {
        var dialogObj = {
            url: $this.attr("href"),
            title: $this.attr("title") || $this.text(),
        };
        if (param) {
            dialogObj.param = param;
        }
        if (width) {
            dialogObj.width = width;
        }
        if (height) {
            dialogObj.height = height;
        }
        $.dialog(dialogObj);
        return false;
    }

    function initCollspse(parentId) {
        $("#" + parentId + " .f-collspse-btn").on("click", function () {
            var $this = $(this);
            var btnId = $this.attr("id");
            if (btnId) {
                var $targetId = $("#" + parentId + " #" + btnId.replace("-btn-", "-target-"));
                if ($targetId.hasClass("f-collapse-in")) {
                    $("#" + parentId + " .f-collapse-in").removeClass("f-collapse-in");
                } else {
                    $("#" + parentId + " .f-collapse-in").removeClass("f-collapse-in");
                    $targetId.addClass("f-collapse-in");
                }
                ;
            }
        });
    }

    return {
        openReportByA: openReport,
        openExamReport: openExamReport,
        openStudyReport: openStudyReport,
        openDrugReport: openDrugReport,
        openDrugInpatientChart: openDrugInpatientChart,
        initCollspse: initCollspse,
        openCdExam: openCdExam,
        openStudentExam: openStudentExam,
        openOtherExam: openOtherExam
    };

})();


