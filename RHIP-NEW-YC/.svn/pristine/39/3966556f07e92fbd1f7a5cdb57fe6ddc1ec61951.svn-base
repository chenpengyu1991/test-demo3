var interactionAdd = (function(){
	$(function() {
		$("#submitIneractionId").click(check);
		$("#clearIneractionId").click(function() {
			clear('interactionForm');
			$("span").html("");
		});
	});

	function check() {
		var msg;
		msg = checkRealName($("#name"));
		msg = msg + checkTelephone($("#phoneNumber"));
		msg = msg + checkCardType($("#idcardType"));
		msg = msg + checkCardNo($("#idcard"));
		msg = msg + checkEventType($("#eventType"));
		msg = msg + checkOrgCode($("#orgCode"));
		msg = msg + checkTitle($("#title"));
		msg = msg + checkContent($("#content"));
		if(msg == '8'){
			add();
		}
	}
	function checkCardType(obj) {
		var value = obj.val();
		/*var value = $("select[name='idcardType']").find("option:selected").val();*/
		if (isEmpty(value)) {
			$("#idcardTypeSpan").css("color", "red").html("证件类型不能为空!");
			return false;
		}
		$("#idcardTypeSpan").empty();
		return true;
	}
	function checkCardNo(obj) {
		var value = obj.val();
		var idcardType = $("select[name='idcardType']").find("option:selected").val();
		var checkFlag = new clsIDCard($("#idcard").val());
		if (isEmpty(value)) {
			$("#idcardSpan").css("color", "red").html("证件号不能为空!");
			return false;
		} else {
			if (!checkFlag.IsValid() && idcardType == '0') {
				$("#idcardSpan").css("color", "red").html("输入的身份证号无效,请输入真实的身份证号!");
				return false;
			}
		}
		$("#idcardSpan").empty();
		return true;
	}
	function checkPostcode(obj) {
		var postcode= /^[1-9][0-9]{5}$/;
		var value = obj.val();
		if (!isEmpty(value) && !postcode.test(value)) {
			$("#postcodeSpan").css("color", "red").html("请输入正确的邮政编码!");
			return false;
		}
		$("#postcodeSpan").empty();
		return true;
	}
	function checkEventType(obj) {
		var value = obj.val();
		if (isEmpty(value)) {
			$("#eventTypeSpan").css("color", "red").html("咨询类型不能为空!");
			return false;
		}
		$("#eventTypeSpan").empty();
		return true;
	}
	function checkOrgCode(obj) {
		var value = obj.val();
		if (isEmpty(value)) {
			$("#orgCodeSpan").css("color", "red").html("咨询对象不能为空!");
			return false;
		}
		$("#orgCodeSpan").empty();
		return true;
	}
	function checkTelephone(obj) {
		var value = obj.val();
		if (isEmpty(value)) {
			$("#phoneNumberSpan").css("color", "red").html("联系电话不能为空!");
			return false;
		} else {
			var mobile = /^0?(13[0-9]|15[0-9]|18[0-9]|14[57])[0-9]{8}$/;
			var phone = /(^(\d{2,4}[-_－—]?)?\d{3,8}([-_－—]?\d{3,8})?([-_－—]?\d{1,7})?$)|(^0?1[35]\d{9}$)/;
			//var mobile = /^\d{11}$/;
			if (!mobile.test(obj.val())) {
				$("#phoneNumberSpan").css("color", "red").html("请输入正确的手机号码!");
				return false;
			}
		}
		$("#phoneNumberSpan").empty();
		return true;
	}

	function checkEmail(obj) {
		var value = obj.val();
		if (isEmpty(value)) {
			return "email不能为空!\n";
			
		} else {
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if (!myreg.test(obj.val())) {
				return "请输入有效的E_mail！\n";
				
			}
		}
		return true;
	}
	function checkRealName(obj) {
		var value = obj.val();
		if (isEmpty(value)) {
			$("#nameSpan").css("color", "red").html("姓名不能为空!");
			return false;
		} else if(value.length > 10) {
			$("#nameSpan").css("color", "red").html("姓名的最大长度为10!");
			return false;
		}
		$("#nameSpan").empty();
		return true;
	}
	function checkTitle(obj) {
		var value = obj.val();
		if (isEmpty(value)) {
			$("#titleSpan").css("color", "red").html("主题不能为空!");
			return false;
		} else if(value.length > 20) {
			$("#titleSpan").css("color", "red").html("主题的最大长度为20!");
			return false;
		}
		$("#titleSpan").empty();
		return true;
	}
	function checkContent(obj) {
		var value = obj.val();
		if (isEmpty(value)) {
			$("#contentSpan").css("color", "red").html("内容不能为空!");
			return false;
		} else if(value.length > 500) {
			$("#contentSpan").css("color", "red").html("内容的最大长度为500!");
			return false;
		}
		$("#contentSpan").empty();
		return true;
	}
	function add() {
		$("#interactionForm").submitFormGetJson({
			url : contextPath + "/interactionShow/save",
			callback : function(model) {
				if (model.success) {
					msgUtil.alert(model.msg, function() {window.location.href = contextPath+ "/interactionShow/index?indexPage=1";});
				} else {
					msgUtil.alert(model.msg);
				}
			}
		});
	}

})();