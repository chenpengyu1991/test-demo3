var hmStudentExamReport = (function() {
    var validate = $("#examReport").easyValidate();
    $(function() {
        enableChangeConfirm();
        $("#back").click(function() {
            baseLayoutLoad.popMainContent();
            hmStudentExamSearch.search(1);
            disableChangeConfirm();
        });
        $("#save").click(function() {
            var saveType;
            if ($("#studentExamId").val() == "") {
                saveType = "add";
            } else {
                saveType = "update";
            }
            var result = validate.validateForm();
            if (!result) {
                //msgUtil.alert("请根据提示正确填写");
                return;
            }
            var submitUrl;
            if (saveType == "add") {
                submitUrl = "/hm/studentExam/addStudentExam";
            } else {
                submitUrl = "/hm/studentExam/updateStudentExam";
            }
            var option = {
                url : submitUrl,
                callback : function(result) {
                    if (result == -1) {
                    	layer.alert("无法获取该学生的体检信息！", {icon:0,title:'提示'});
                    } else if (result == 0) {
                    	layer.alert("保存失败！", {icon:0,title:'提示'});
                    } else {
                        disableChangeConfirm();
                        layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
                            if (saveType == "add") {
                                baseLayoutLoad.refreshMainContent("/hm/studentExam/addExamReport", {
                                    examDate : $("input[name='examDate']").val(),
                                    manaDoctorName : $("input[name='manaDoctorName']").val(),
                                    addFlag : "1"
                                });
                            } else {
                                baseLayoutLoad.popMainContent();
                                hmStudentExamSearch.search(1);
                            }
                            layer.close(index);
                        });
                    }
                }
            };
            $("#examReport").submitFormGetJson(option);
        });

        $("#examDate").blur(function () {
            var studentExamId = $("#studentExamId").val();
            if ($.isEmpty(studentExamId)) {
                checkStudentInfo();
            }
            checkHeightAndWeight();
            checkHighBoold();
        });

        $("#height").blur(function () {
            checkHeightAndWeight();
        });

        $("#bodyWeight").blur(function () {
            checkHeightAndWeight();
        });

        $("input[name='sbp']").blur(function () {
            checkHighBoold();
        });

        $("input[name='dbp']").blur(function () {
            checkHighBoold();
        });

        $("input").blur(function(){
            checkExamResult();
        });

        $("input:radio").change(function(){
            checkExamResult();
        });
        //console.error("idCard init run");
        $.Placeholder.init({query:"#idCard",callback:checkStudentInfo});
    });

    function checkStudentInfo() {
        //debugger;
        var currentYear = new Date().getFullYear();
        var examDate = $("#examDate").val();
        if (!$.isEmpty(examDate)) {
            if ($("#addFlag").val() == '1') {
                ;
            } else if ($("#hiddenExamDate").val() == examDate) {
                return;
            }
            currentYear = examDate.substring(0,4);
        }
        if (!validate.validate("idcard")) {
            return;
        }
        var option = {
            url : "/hm/studentExam/checkStudentInfo",
            param : {
                examYear : currentYear,
                idCard : $.trim($("#idCard").val())
            },
            callback : function(studentInfo) {
                if (studentInfo == null) {
                	layer.alert("输入的身份证号不存在，请确认身份证号！", {icon:0,title:'提示'});
                    emptyStudentInfo();
                } else if (studentInfo == -1) {
                	layer.alert("该学生体检记录已存在，不要重复录入！", {icon:0,title:'提示'});
                    emptyStudentInfo();
                } else if (studentInfo == -2) {
                	layer.alert("该学生不在本医院体检范围，无法录入体检信息！", {icon:0,title:'提示'});
                    emptyStudentInfo();
                } else {
                    $("#name").val(studentInfo.name);
                    $("#personInfoId").val(studentInfo.personInfoId);
                    $("#gender").val(studentInfo.gender);
                    $("#genderName").val(studentInfo.genderName);
                    $("#birthday").val(studentInfo.birthday);
                    $("#schoolName").val(studentInfo.schoolName);
                    $("#schoolCode").val(studentInfo.schoolCode);
                    $("#gradeCode").val(studentInfo.gradeCode);
                    $("#gradeName").val(studentInfo.gradeName);
                    $("#classCode").val(studentInfo.classCode);
                    $("#inYear").val(studentInfo.inYear);
                    $("#nation").val(studentInfo.nation);
                    $("#aboBloodType").val(studentInfo.aboBloodType);
                    $("#studentNo").val(studentInfo.studentNo);
                    checkHeightAndWeight();
                    checkHighBoold();
                }
            }
        };
        $.getJsonByUrl(option);
    }

    function emptyStudentInfo() {
        $("#idCard").val("");
        $("#name").val("");
        $("#personInfoId").val("");
        $("#gender").val("");
        $("#genderName").val("");
        $("#birthday").val("");
        $("#schoolName").val("");
        $("#schoolCode").val("");
        $("#gradeCode").val("");
        $("#gradeName").val("");
        $("#classCode").val("");
        $("#inYear").val("");
        $("#nation").val("");
        $("#aboBloodType").val("");
        $("#studentNo").val("");
    }

    function checkExamResult() {
        //checkInputResult("blood", "血压异常", [{name:"sbp", value:140}, {name:"dbp", value:90}]);
        checkInputLowResult("eye", "视力不良" , [{name:"lNakedEye", value:5.0}, {name:"rNakedEye", value:5.0}],'0');
        checkInputResult("tooth", "龋齿", [{name:"decayedToothNoUpl", value:0}, {name:"decayedToothNoUpr", value:0},{name:"missingToothNoUpl", value:0},{name:"missingToothNoUpr", value:0}],'0');
        checkRadioResult("colorVision","色盲色弱", [{name:"colorVision", value:"1"}],'0');
        checkRadioResult("lTrachomaEye","左沙眼", [{name:"lTrachomaEye", value:"0"}],'2');
        checkRadioResult("rTrachomaEye","右沙眼", [{name:"rTrachomaEye", value:"0"}],'2');
        checkRadioResult("conjunctivitis","结膜炎", [{name:"conjunctivitis", value:"0"}],'0');
        checkSingleRadioResult("periodontalCehckResult","牙周病", "periodontalCehckResult","0","toothOther");
        checkSingleRadioResult("heartCheckResult","心", "heartCheckResult","0", "heartOther");
        checkSingleRadioResult("liverCheckResult","", "liverCheckResult","0", "liverOther");
        checkSingleRadioResult("lungsCheckResult","肺", "lungsCheckResult","0", "lungsOther");
        checkSingleRadioResult("spleenCheckResult","", "spleenCheckResult","0", "spleenOther");
        checkSingleRadioResult("headCheckResult","", "headCheckResult","0", "headOther");
        checkSingleRadioResult("neckCheckResult","", "neckCheckResult","0", "neckOther");
        checkSingleRadioResult("chestCheckResult","", "chestCheckResult","0", "chestOther");
        checkSingleRadioResult("spineCheckResult","", "spineCheckResult","0", "spineOther");
        checkSingleRadioResult("limbsCheckResult","", "limbsCheckResult","0", "limbsOther");
        checkSingleRadioResult("skinCheckResult","", "skinCheckResult","0", "skinOther");
        checkSingleRadioResult("lymphNodeCheckResult","", "lymphNodeCheckResult","0", "lymphNodeOther");
        showTotleExamResult();
    }

    var ExamMap = function() {

        this.errorMap = new Array();

        this.put = function(key, value) {
            if (this.containsKey(key)) {
                this.remove(key);
            }
            this.errorMap.push({key:key,value:value});
        };

        this.remove = function(key) {
            for (var i = 0; i < this.size(); i++) {
                if (this.errorMap[i].key == key) {
                    this.errorMap.splice(i, 1);
                }
            }
        };

        this.containsKey = function(key) {
            for (var i = 0; i < this.size(); i++) {
                if (this.errorMap[i].key == key) {
                    return true;
                }
            }
            return false;
        };

        this.size = function() {
            return this.errorMap.length;
        };

        this.clean = function() {
            this.errorMap.splice(0, this.size());
        };

        this.errorString = function(sp) {
            var str = "";
            for (var i = 0; i < this.size(); i++) {
                if (i > 0) {
                    str += sp;
                }
                str += this.errorMap[i].value;
            }
            return str;
        };

    };

    var map = new ExamMap();

    function checkSingleRadioResult(key, message, name, normal, otherName) {
        var checkedValue = $("input:radio[name='"+name+"']:checked").val();
        if (checkedValue == normal) {
            map.remove(key);
            return;
        }else{
            var msg = $("input:radio[name='"+name+"']:checked").attr("data-label");
            var otherValue = $("input[name='"+otherName+"']").val();
            if (!$.isEmpty(otherValue)) {
                msg = otherValue;
            }
            map.put(key, msg);
        }
    }

    function checkRadioResult(key, message, obj, type) {
        for (var i = 0; i < obj.length; i++) {
            var item = obj[i];
            var checkedValue = $("input:radio[name='"+item.name+"']:checked").val();
            if (checkedValue  != item.value) {
                if(type=='2'){
                    map.put(key, message+$("input:radio[name='"+item.name+"']:checked").attr("data-label"));
                }else if(type=='1'){
                    map.put(key, $("input:radio[name='"+item.name+"']:checked").attr("data-label"));
                }else{
                    map.put(key, message);
                }
                return;
            }
        }
        map.remove(key);
    }

    function checkInputResult(key, message, obj) {
        for (var i = 0; i < obj.length; i++) {
            var item = obj[i];
            var inputValue = $("input[name='"+item.name+"']").val();
            if (!$.isEmpty(inputValue) && parseFloat(inputValue) > item.value) {
                map.put(key, message);
                return;
            }
        }
        map.remove(key);
    }

    function checkInputLowResult(key, message, obj) {
        for (var i = 0; i < obj.length; i++) {
            var item = obj[i];
            var inputValue = $("input[name='"+item.name+"']").val();
            if (!$.isEmpty(inputValue) && parseFloat(inputValue) < item.value) {
                map.put(key, message);
                return;
            }
        }
        map.remove(key);
    }

    function checkHighBoold() {
        var birthday = $("#birthday").val();
        var gender = $("#gender").val();
        var sbp = $("input[name='sbp']").val();
        var dbp = $("input[name='dbp']").val();
        var examDate = $("#examDate").val();
        //debugger;
        if ($.isEmpty(birthday) || $.isEmpty(gender)
            || $.isEmpty(sbp) || $.isEmpty(dbp)
            || $.isEmpty(examDate)) {
            return;
        }
        var option = {
            url : "/hm/studentExam/checkHighBoold",
            callback : checkHighBooldCallback,
            param : {
                birthday : birthday,
                gender : gender,
                sbp : sbp,
                dbp : dbp,
                examDate : examDate
            }
        };
        $.getJsonByUrl(option);
    }

    function checkHighBooldCallback(data) {
        if (!data.success) {
            map.put("blood", data.message);
        } else {
            map.remove("blood");
        }
        showTotleExamResult();
    }

    function checkHeightAndWeight() {
        var birthday = $("#birthday").val();
        var gender = $("#gender").val();
        var height = $("#height").val();
        var weight = $("#bodyWeight").val();
        var examDate = $("#examDate").val();
        if ($.isEmpty(birthday) || $.isEmpty(gender)
            || $.isEmpty(height) || $.isEmpty(weight)
            || $.isEmpty(examDate)) {
            return;
        }
        var option = {
            url : "/hm/studentExam/checkHeightAndWeight",
            callback : checkHeightAndWeightCallback,
            param : {
                birthday : birthday,
                gender : gender,
                height : height,
                weight : weight,
                examDate : examDate
            }
        };
        $.getJsonByUrl(option);
    }

    function checkHeightAndWeightCallback(data) {
        //alert(data.success + ":" + data.message);
        if (!data.success) {
            map.put("bmi", data.message);
        } else {
            map.remove("bmi");
        }
        showTotleExamResult();
    }

    var healthGuidanceMap = new ExamMap();
    var healthGuidanceList = [
        "去医院复查后排除。\n",//0
        "去医院复查后治疗。\n",//1
        "督促小孩改变不良用眼习惯，培养良好的用眼方式。\n",//2
        "督促小孩培养良好的刷牙方式，饭后漱口。\n",//3
        "关心小孩的饮食习惯，保证早餐营养，多吃水果，每天吃牛奶和豆制品。\n",//4
        "纠正小孩读书写字习惯，使用双肩背书包。\n",//5
        "督促经常性体育锻炼。\n",//6
        "血压异常去医院复查后排除。\n"];//7

    function showTotleExamResult() {
        if (map.size() <= 0) {
            //$("input:radio[name='totalResult']:eq(0)").attr("checked", "checked");
            $("input[name='totalResult']").val(1);
            $("textarea[name='examinationResult']").val("正常");
        } else {
            //$("input:radio[name='totalResult']:eq(1)").attr("checked", "checked");
            $("input[name='totalResult']").val(0);
            $("textarea[name='examinationResult']").val(map.errorString(","));
        }

        healthGuidanceMap.clean();
        if (map.containsKey("tooth")) {
            healthGuidanceMap.put("1", healthGuidanceList[1]);
            healthGuidanceMap.put("3", healthGuidanceList[3]);
        }
        if (map.containsKey("eye")) {
            healthGuidanceMap.put("2", healthGuidanceList[2]);
        }
        if (map.containsKey("spineCheckResult")) {
            healthGuidanceMap.put("5", healthGuidanceList[5]);
        }
        if (map.containsKey("spineCheckResult")) {
            healthGuidanceMap.put("5", healthGuidanceList[5]);
        }
        if (map.containsKey("bmi")) {
            healthGuidanceMap.put("4", healthGuidanceList[4]);
            healthGuidanceMap.put("6", healthGuidanceList[6]);
        }
        if (map.containsKey("blood")) {
            healthGuidanceMap.put("7", healthGuidanceList[7]);
        }
        if (map.containsKey("trachomaEye")
            || map.containsKey("conjunctivitis")
            || map.containsKey("periodontalCehckResult")) {
            healthGuidanceMap.put("1", healthGuidanceList[1]);
        }
        if (map.containsKey("liverCheckResult")
            || map.containsKey("lungsCheckResult")
            || map.containsKey("spleenCheckResult")
            || map.containsKey("headCheckResult")
            || map.containsKey("neckCheckResult")
            || map.containsKey("chestCheckResult")
            || map.containsKey("spineCheckResult")
            || map.containsKey("limbsCheckResult")
            || map.containsKey("skinCheckResult")
            || map.containsKey("lymphNodeCheckResult")) {
            healthGuidanceMap.put("0", healthGuidanceList[0]);
            healthGuidanceMap.put("1", healthGuidanceList[1]);
        }
        $("textarea[name='healthGuidance']").val(healthGuidanceMap.errorString(""));
    }

    function toggle(name,otherId,value){
        var raValue = $('input:radio[name='+name+']:checked').val();
        if (raValue == value)
        {
            $("#" + otherId).show();
        } else
        {
            $("#" + otherId).hide();
        }
        $("input[name='"+otherId+"']").val('');
    }

    return {
        toggle : toggle
    };
})();