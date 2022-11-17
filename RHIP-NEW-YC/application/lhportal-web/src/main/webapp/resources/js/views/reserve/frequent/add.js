var frequentAdd = (function () {
    $(function () {
        $("#submitFrequentContacts").click(check);
        $("#clearFrequentContacts").click(function () {
			$('#addFrequentForm').slideToggle();
        });
    });

    function check() {
        var msg;
        msg = checkFrequentName($("#frequentName_id"));
        msg += checkGender($("input[name=gender]:checked"));
        msg += checkTelephone($("#telephone"));  
        msg += checkCardNo($("#cardNo"));
        msg += checkBirthday($("#birthday"));
        if(msg == '5'){
            add();
        }
    }

    function checkFrequentName(obj) {
        var value = obj.val();
        if (isEmpty(value)) {
            $("#frequentNameSpan").css("color", "red").html("姓名不能为空!");
            return false;
        } else if (value.length > 50) {
            $("#frequentNameSpan").css("color", "red").html("姓名的最大长度为10!");
            return false;
        }
        $("#frequentNameSpan").empty();
        return true;
    }

    function checkGender(obj) {
        var value = obj.val();
        if (isEmpty(value)) {
            $("#genderSpan").css("color", "red").html("性别不能为空!");
            return false;
        }
        $("#genderSpan").empty();
        return true;
    }

    function checkTelephone(obj) {
        var value = obj.val();
        if (isEmpty(value)) {
            $("#telephoneSpan").css("color", "red").html("手机号码不能为空!");
            return false;
        } else {
            var mobile = /^0?(13[0-9]|15[0-9]|18[0-9]|14[57])[0-9]{8}$/;
            var phone = /(^(\d{2,4}[-_－—]?)?\d{3,8}([-_－—]?\d{3,8})?([-_－—]?\d{1,7})?$)|(^0?1[35]\d{9}$)/;
            //var mobile = /^\d{11}$/;
            if (!mobile.test(obj.val())) {
                $("#telephoneSpan").css("color", "red").html("请输入正确的手机号码!");
                return false;
            }
        }
        $("#telephoneSpan").empty();
        return true;
    }

    function checkCardNo(obj) {
        var value = obj.val();
        var checkFlag = new clsIDCard(value);
        if (isEmpty(value)) {
            $("#cardNoSpan").css("color", "red").html("证件号不能为空!");
            return false;
        } else {
            if (!checkFlag.IsValid()) {
                $("#cardNoSpan").css("color", "red").html("输入的身份证号无效,请输入真实的身份证号!");
                return false;
            }
        }
        $("#cardNoSpan").empty();
        return true;
    }

    function checkBirthday(obj) {
        var value = obj.val();
        if (isEmpty(value)) {
            $("#birthdaySpan").css("color", "red").html("出生日期不能为空!");
            return false;
        }
        $("#birthdaySpan").empty();
        return true;
    }

    function add() {
        $("#frequentContactsForm").submitFormGetJson({
            url: contextPath + "/userSpace/reserve/frequent/save",
            callback: function (data) {
                if(data == "ok"){
                    msgUtil.alert("保存常用联系人信息成功！");
                    frequentSearch.search(1);
                } else if(data == "fail"){
                    msgUtil.alert("保存常用联系人信息失败！");
                    return;
                }else if(data == "repeatAccount"){
                	msgUtil.alert("不能保存当前登录用户作为常用联系人！");
                    return;
                }else if(data == "repeat"){
                    $("#cardNoSpan").css("color", "red").html("该身份证号码已经存在!");
                    return;
                }
            }
        });
    }

})();