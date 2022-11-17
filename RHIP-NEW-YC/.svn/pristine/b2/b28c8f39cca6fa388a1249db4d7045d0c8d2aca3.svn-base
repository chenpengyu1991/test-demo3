(function($) {
	$.fn.easyValidate = function() {
		return new $.easy_validate(this);
	};
	$.easy_validate = function(form) {
		this.form = form;
		this.debug = true;
		this.messages = {
			required : "必须字段",
			remote : "请修正该字段",
			length : "请输入一个长度是 {0} 的字符串",
			maxlength : "请输入一个长度最多是 {0} 的字符串",
			minlength : "请输入一个长度最少是 {0} 的字符串",
			rangelength : "请输入一个长度介于 {0} 和 {1} 之间的字符串",
			range : "请输入一个介于 {0} 和 {1} 之间的值",
			max : "请输入一个最大为 {0} 的值",
			min : "请输入一个最小为 {0} 的值",
			number : "请输入合法的数字",
			lettersAndNumbers : "请输入合法的字母和数字",
            lineAndNumbers : "请输入合法保健编号",
            chinese : "请输入合法的中文",
			digits : "请输入整数",
			creditcard : "请输入合法的身份证号",
			postCode : "请输入合法的邮编",
			phone : "请输入正确的电话号码,格式: 区号-电话-分机,或请输入正确手机号码",
			mobile : "请输入正确的手机号码",
			email : "请输入正确格式的电子邮件",
			url : "请输入合法的网址",
			date : "请输入合法的日期",
			dateISO : "请输入合法的日期 (ISO).",
			equalTo : "请再次输入相同的值",
			accept : "请输入拥有合法后缀名的字符串",
			idCard : "请输入正确的身份证号",
			greaterThan : "请输入一个不小于{0} 的值",
			scale : "请输入一个小数点长度最多为{0}的数字",
			passWordReg:"密码长度至少8位并且由数字、字母、特殊字符至少2种组成!"//数字+字母，数字+特殊字符，字母+特殊字符，数字+字母+特殊字符
		};
		this.validateRegExp = {
			passWordReg:"^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{8,}$",
			digits : "^\\d+$",
			date : "^\\d{4}[\\/\\-]\\d{2}[\\/\\-]\\d{2}$",
			number : "^(-?\\d+)(\\.\\d+)?$",
			chinese : "^[\\u4E00-\\u9FA5]+$",
			lettersAndNumbers : "^[a-zA-Z]{1,15}\\d{1,15}$",
            lineAndNumbers:"^[0-9]{4}\-[0-9]{4}\-[0-9]{4}\-[0-9]{4}\-[0-9]{1}$",
			creditcard : "^[0-9]{15}$|^[0-9]{18}$|^[0-9]{17}[xX]$",
			postCode : "^[0-9]{6}$",
            phone : "(^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)",
			mobile : "^0?(13[0-9]|15[0-9]|18[0-9]|14[57])[0-9]{8}$",
			userName : "^[a-z0-9]+$",
			email : "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",
			url : "^(http|https|ftp)\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&%\\$#\\=~])*$"
		};
		this.result = {};// 保存验证结果 ,name:errorMessage
		this.element = {};// 保存需要验证的控件 name:$(name)
		this.ruleMapping = {}; // 保存规则定义 name:config
		this.extensionFunction = {};// 扩展函数
		this.init();
		this.failedCssClass = "lose";
	};

	$.extend($.easy_validate.prototype, {

		init : function() {
			var inputs = this.form.find("[reg]");
			var i, $input, name, type, config;
			var length = inputs.length;
			var formId = this.form.attr("id");
			for (i = 0; i < length; i++) {
				$input = $(inputs[i]);
				name = $input.attr("name");
				if (name) {
					try {
						// 规则配置使用json方式
						var regString = $input.attr("reg");
						config = $.parseJSON(regString.replace(/'/g, '"'));
					} catch (error) {
						this.print("控件 " + name + "规则定义错误,规则:" + $input.attr("reg") + ",错误原因:" + error + ",请使用json格式!");
						throw error;
					}
					if (config.regex) {
						var regex = config.regex;
						if (!this.validateRegExp[regex]) {
							// 自定义正则,需要获取自定义消息
							this.messages[regex] = $input.attr("tip");
						}
					}
					this.ruleMapping[this.formatName(name)] = config;
					// type = $input.attr("type");
					// 如果是radio和checkbox类型,则根据其name获取一组dom
					// if (type === "radio" || type === "checkbox")
					// {
					// 增加formid ,修正多个form存在相同name的问题
					// TODO 待详细
					$input = $("#" + formId + " [name='" + $input.attr("name") + "']");
					// }
					this.element[this.formatName(name)] = $input;
					this.addElementEvent($input);
				}
			}
		},

		addElementEvent : function(input) {
			var imagePath = contextPath + "/css/images/vtip_arrow.png";
			var xOffset = -20; // x distance from mouse
			var yOffset = 20; // y distance from mouse
			var res = this.result;
			var validator = this;
			var $input = $(input);
			// 增加浮动信息
			$input.hover(function(e) {
				var name = $(this).attr('name');
				// 有错误信息则显示
				if (res[validator.formatName(name)]) {
					var top = (e.pageY + yOffset);
					var left = (e.pageX + xOffset);
					$('body').append('<p id="vtip"><img id="vtipArrow" src="' + imagePath + '"/>' + res[validator.formatName(name)] + '</p>');
					$('p#vtip').css("top", top + "px").css("left", left + "px").css("z-index","99999999999999").bgiframe();
				}
			}, function() {
				$("p#vtip").remove();
			});
			$input.mousemove(function(e) {
				var name = $(this).attr('name');
				if (res[validator.formatName(name)]) {
					var top = (e.pageY + yOffset);
					var left = (e.pageX + xOffset);
					$("p#vtip").css("top", top + "px").css("left", left + "px");
				}
			});

			// validatorEvent 自定义验证事件
			// onDatePickerChanged 日期控件选择变化事件
			$input.on("onDatePickerChanged validatorEvent", function() {
				var name = $(this).attr('name');
				validator.validate(name);
			});

			//
			$input.on("change blur", function() {
				var name = $(this).attr('name');
				validator.validate(name);
			});

		},

		validateForm : function() {
			var validator = this;
			var isSubmit = true;
			for ( var key in this.element) {
				// 检查是否需要验证
				if (validator.isNotNeedValidate(key)) {
					continue;
				}
				if (!validator.validate(key)) {
					isSubmit = false;
				}
			}

			// 调转到最近的一个错误
			if (!isSubmit) {
				this.jumpToErrorInput();
			}
			return isSubmit;
		},

		dependOn : function(obj, dependValue, dependOn) {
			// 当前支持radio和checkbox
			// 如果value 则为传递name,否则当作id,并检测是否选中
			// if (value) {
			// var $checked = $("input[name='" + param + "']:checked");
			// for (var i = 0, size = $checked.length; i < size; i++) {
			// var dependValue = $($checked[i]).val();
			// if (dependValue == value) {
			// return true;
			// }
			// }
			// } else if ($("#" + param).prop("checked")) {
			// return true;
			// }

			if (dependValue) {
				var dependTargetValue = this.getValue($("[name='" + dependOn + "']"));
				if (dependValue == dependTargetValue) {
					return true;
				} else if ($.isArray(dependTargetValue) && $.inArray(dependValue, dependTargetValue) != -1) {
					return true;
				}
			} else {
				var dependTargetValue = this.getValue($("#" + dependOn));
				if (dependTargetValue) {
					return true;
				}
			}

			return false;
		},
		required : function(obj, value, param) {
			if (!param) {
				return true;
			}
			var ret = this.hasValue(value);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.messages.required);
			}
			return ret;
		},

		maxlength : function(obj, value, param) {
			var length = $.isArray(value) ? value.length : $.trim(value).length;
			var ret = length <= Number(param);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.maxlength, param));
			}
			return ret;
		},

		regex : function(obj, value, param) {
			var regString = this.validateRegExp[param];
			if (!regString) {
				regString = param;
			}
			var reg = new RegExp(regString);

			var ret = reg.test(value);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.messages[param]);
			}
			return ret;
		},

		minlength : function(obj, value, param) {
			var length = $.isArray(value) ? value.length : $.trim(value).length;
			var ret = length >= Number(param);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.minlength, param));
			}
			return ret;
		},

		length : function(obj, value, param) {
			var length = value.length;
			var ret = length == Number(param);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.length, param));
			}
			return ret;
		},

		min : function(obj, value, param) {
			var ret = Number(value) >= Number(param);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.min, param));
			}
			return ret;
		},

		max : function(obj, value, param) {
			var ret = Number(value) <= Number(param);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.max, param));
			}
			return ret;
		},
		scale : function(obj, value, param) {
			var pointIndex = value.indexOf('.');
			var ret = null;
			if (pointIndex != -1) {
				var pointLength = value.length - pointIndex - 1;
				ret = pointLength <= Number(param);
			} else {
				ret = true;
			}
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.scale, param));
			}
			return ret;
		},
		range : function(obj, value, param) {
			var args = param.split(",");
			var ret = (Number(args[0]) <= Number(value) && Number(value) <= Number(args[1]));
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.range, param));
			}
			return ret;
		},
		idCard : function(obj, value, param) {
			// 为false,不执行验证
			if (!param) {
				return true;
			}
			var ret = idCardUtil.check(value);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.messages.idCard);
			}
			return ret;
		},
		greaterThan : function(obj, value, param) {
			var thanValue = $("#" + param).val();

			if (!thanValue) {
				return true;
			}
			var ret = null;
			if (/^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}$/.test(value)) {
				ret = new Date(value) >= new Date(thanValue);
			} else {
				ret = parseFloat(value) > parseFloat(thanValue);
			}
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.greaterThan, thanValue));
			}
			return ret;
		},
		compare : function(obj, value, param) {

			var $other = $("#" + param[0]);
			var thanValue = $other.val();

			if (!thanValue) {
				return true;
			}

			var left, right;
			if (this.isDate(value)) {
				left = this.simpleDateParse(value);
				right = this.simpleDateParse(thanValue);
			} else {
				left = parseFloat(value);
				right = parseFloat(thanValue);
			}

			var op = param[1];
			var ret = null;

			if (op === "eq") {
				ret = left === right;
			} else if (op === "ge") {
				ret = left >= right;
			} else if (op === "le") {
				ret = left <= right;
			} else if (op === "gt") {
				ret = left > right;
			} else if (op === "lt") {
				ret = left < right;
			} else if (op === "ne") {
				ret = left != right;
			}

			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", param[2]);
			} else {
				var otherName = $other.attr("name");
				if (this.result[this.formatName(otherName)]) {
					ret = ret && this.validate(otherName);
				}
			}

			return ret;
		},

		extension : function(obj, value, param) {
			var func = param[0];
			var extenFunc = this.extensionFunction[func];
			if (!extenFunc) {
				this.print("扩展验证方法:" + func + "没有注册");
				// extenFunc=window[func];
				// extenFunc=eval(func);
				return true;
			}
			var message = param[1];
			var ret = extenFunc(obj, this.element[this.formatName(obj)]);
			if (!ret) {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", message);
			}
			return ret;
		},

		ajax_validate : function(obj, value, param) {
			var url_str = param;
			if ($.trim(url_str).length == 0) {
				return false;
			}
			if (url_str.indexOf("?") != -1) {
				url_str = url_str + "&" + obj + "=" + value;
			} else {
				url_str = url_str + "?" + obj + "=" + value;
			}
			var feed_back = "";
			$.ajax({
				url : url_str,
				cache : false,
				async : false,
				dataType : "text",
				success : function(msg) {
					feed_back = msg;
				}
	
			});
			feed_back = feed_back.replace(/(^\s*)|(\s*$)/g, "");
			if (feed_back == 'success') {
				this.change_error_style(obj, "remove");
				this.change_tip(obj, "remove");
				return true;
			} else {
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", feed_back);
				return false;
			}
		},

		existsProperty : function(obj, property) {
			if (obj[property]) {
				return true;
			}
			return false;
		},

		isNotNeedValidate : function(name) {
			var element = this.element[this.formatName(name)];

			// 强制校验
			if (element.data("validate") == true) {
				return false;
			}

			// 对于没有显示的field不需要验证
			if (element.is(":hidden")) {
				// 检查是否全部隐藏,全部隐藏则不校验
				for (var i = 0, size = element.length; i < size; i++) {
					if (!$(element[i]).is(":hidden")) {
						return false;
					}
				}
				return true;
			}

			// 如果类型为radio,检查是否是全部disabled,全部disabled则不校验 modify yjf 2013-9-18
			if (element.attr('type') == 'radio') {
				for (var i = 0, size = element.length; i < size; i++) {
					if (!$(element[i]).prop("disabled")) {
						return false;
					}
				}
				return true;
			} else if (element.prop("disabled")) {// disabled的field不需要验证
				return true;
			}
			// 如果类型为radio,检查是否是全部disabled,全部disabled则不校验 modify yjf 2013-9-18
			return false;
		},

		getValue : function(obj) {
			// 多选和单选,获取选中的value,如果没有任何被选中,不设置值
			var objValue = null;
			var type = obj.attr('type');
			if ("checkbox" == type || "radio" == type) {
				var selectedItems = obj.filter(":checked").not(":hidden");
				if (selectedItems.length == 1) {
					objValue = selectedItems.val();
				} else if (selectedItems.length > 1) {
					objValue = selectedItems.map(function() {
						return $(this).val();
					}).get();
				}
			} else if (obj.length > 1) {
				objValue = obj.not(":hidden").val();
			} else {
				objValue = obj.val();
			}
			return objValue;
		},

		hasValue : function(objValue) {
			var hasValue = false;
			if (null != objValue) {
				if ($.isArray(objValue)) {
					hasValue = objValue.length > 0;
				} else {
					hasValue = $.trim(objValue).length > 0;
				}
			}
			return hasValue;
		},

		validate : function(name) {
			this.change_error_style(name, "remove");
			this.change_tip(name, "remove", null);
			var checkObj = this.ruleMapping[this.formatName(name)];
			var obj = this.element[this.formatName(name)];
			if (!obj) {// 通过addError方法添加的跳过
				return true;
			}
			var objValue = null;
			objValue = this.getValue(obj);

			var hasValue = this.hasValue(objValue);

			var ret = true;

			// 是否需要依赖,如果有依赖,且依赖不满足,则不再检验.当前支持radio或者checkboc
			if (this.existsProperty(checkObj, 'dependOn')) {
				var check = this.dependOn(name, checkObj['dependValue'], checkObj['dependOn']);
				if (!check) {
					return true;
				}
			}

			// TODO 验证方式
			if (ret && this.existsProperty(checkObj, 'required')) {
				ret = this.required(name, objValue, checkObj['required']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'regex')) {
				ret = this.regex(name, objValue, checkObj['regex']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'maxlength')) {
				ret = this.maxlength(name, objValue, checkObj['maxlength']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'minlength')) {
				ret = this.minlength(name, objValue, checkObj['minlength']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'min')) {
				ret = this.min(name, objValue, checkObj['min']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'max')) {
				ret = this.max(name, objValue, checkObj['max']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'digits')) {
				ret = this.regex(name, objValue, 'digits');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'number')) {
				ret = this.regex(name, objValue, 'number');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'phone')) {
				ret = this.regex(name, objValue, 'phone');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'mobile')) {
				ret = this.regex(name, objValue, 'mobile');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'postCode')) {
				ret = this.regex(name, objValue, 'postCode');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'email')) {
				ret = this.regex(name, objValue, 'email');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'url')) {
				ret = this.regex(name, objValue, 'url');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'creditcard')) {
				ret = this.regex(name, objValue, 'creditcard');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'idCard')) {
				ret = this.idCard(name, objValue, checkObj['idCard']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'range')) {
				ret = this.range(name, objValue, checkObj['range']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'scale')) {
				ret = this.scale(name, objValue, checkObj['scale']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'length')) {
				ret = this.length(name, objValue, checkObj['length']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'greaterThan')) {
				ret = this.greaterThan(name, objValue, checkObj['greaterThan']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'compare')) {
				ret = this.compare(name, objValue, checkObj['compare']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'remote')) {
				ret = this.ajax_validate(name, objValue, checkObj['remote']);
			}
			if (ret && this.existsProperty(checkObj, 'extension')) {
				ret = this.extension(name, objValue, checkObj['extension']);
			}

			obj.trigger("validatedEvent", [ ret, this.result[this.formatName(name)] ]);

			return ret;
		},

		addError : function(name, message) {
			var $input = this.form.find("[name='" + name + "']");
			this.change_error_style(name, "add");
			this.change_tip(name, "add", message);
			this.addElementEvent($input);
		},

		removeError : function(name) {
			this.change_error_style(name, "remove");
			this.change_tip(name, "remove");
		},

		addExtension : function(extensionName, extensionFunc) {
			this.extensionFunction[extensionName] = extensionFunc;
		},

		validExtension : function(func, name, message) {
			var reslut = func();
			if (reslut) {
				this.removeError(name);
			} else {
				this.addError(name, message);
			}
		},

		addCheckElement : function(name, checkObj, message) {
			var $input = this.form.find("[name='" + name + "']");
			if (!this.element[this.formatName(name)]) {
				this.element[this.formatName(name)] = $input;
			}
			if (!this.ruleMapping[this.formatName(name)]) {
				this.ruleMapping[this.formatName(name)] = checkObj;
			} else {
				$.extend(this.ruleMapping[this.formatName(name)], checkObj);
			}
			if (checkObj.regex) {
				this.messages[checkObj.regex] = message;
			}
			this.addElementEvent($input);
		},

		removeCheckElement : function(name) {
			this.removeError(name);
			if (this.element[this.formatName(name)]) {
				this.element[this.formatName(name)] = null;
				delete this.element[this.formatName(name)];
			}
			if (this.ruleMapping[this.formatName(name)]) {
				this.ruleMapping[this.formatName(name)] = null;
				delete this.ruleMapping[this.formatName(name)];
			}
			if (this.result[this.formatName(name)]) {
				this.result[this.formatName(name)] = null;
				delete this.result[this.formatName(name)];
			}
		},

		change_error_style : function(name, action_type) {
			var $input = (this.element[this.formatName(name)]) ? this.element[this.formatName(name)] : this.form.find("[name='" + name + "']");
			if ($input) {
				var inputType = $input.attr('type');
				if (action_type == "add") {
					$input.addClass(this.failedCssClass);
					if (inputType == "radio" || inputType == "checkbox") {
						var $next = $input.nextAll("label");
						$next.addClass(this.failedCssClass);
						var $labels = $input.parent("label");
						$labels.addClass(this.failedCssClass);
					}
				} else {
					$input.removeClass(this.failedCssClass);
					if (inputType == "radio" || inputType == "checkbox") {
						var $next = $input.nextAll("label");
						$next.removeClass(this.failedCssClass);
						var $labels = $input.parent("label");
						$labels.removeClass(this.failedCssClass);
					}
				}
			}
		},

		change_tip : function(name, action_type, msg) {
			if (action_type == "add") {
				this.result[this.formatName(name)] = msg;
			} else {
				this.result[this.formatName(name)] = null;
			}
		},

		print : function(msg) {
			if (this.debug && window.console)
				console.error("debug info: %o", msg);
		},
		formatName : function(name) {
			if (!name) {
				return name;
			}

			if (name.indexOf(".") > 0) {
				if (name.indexOf("'") == 0) {
					return "'" + name + "'";
				}
			}
			return name;
		},
		jumpToErrorInput : function() {
			// 跳转到第一个有效的出错控件
			var $errorInput = this.form.find("." + this.failedCssClass).not(":hidden,:disabled").filter(":first");
			if ($errorInput.length > 0) {
				var id = $errorInput.attr("id");
				if (!id) {
					var tmp = new Date().getTime();
					$errorInput.attr("id", tmp);
					id = tmp;
				}
				window.location.hash = id;
				// chrome失效问题,或者先置空
				window.location = window.location;
			}
		},
		isDate : function(value) {
			// TODO 目前仅支持项目内日期
			return /^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}/.test(value);
		},
		simpleDateParse : function(value) {
			// var Regx = {
			// yy : "(\\d{2})", yyyy : "(\\d{4})", G : "(\\S+)",
			// M : "([1-9]|1[012])", MM : "(0[1-9]|1[012])",
			// MMM : "(\\S+)", MMMM : "(\\S+)",
			// d : "([1-9]|[12][0-9]|3[01])", dd : "(0[1-9]|[12][0-9]|3[01])",
			// E : "(\\S+)", EE : "(\\S+)", EEE : "(\\S+)", EEEE : "(\\S+)",
			// H : "([0-9]|1[0-9]|2[0-3])", HH : "(0[0-9]|1[0-9]|2[0-3])",
			// h : "([1-9]|1[012])", hh : "(0[1-9]|1[012])", a : "(\\S+)",
			// m : "([0-9]|[1-5][0-9])", mm : "([0-5][0-9])",
			// s : "([0-9]|[1-5][0-9])", ss : "([0-5][0-9])",
			// S : "(\\d{1,3})", SSS : "(\\d{3})",
			// z : "(\\S+)", Z : "([\\-\\+]\\d{2,4})"
			// };
			// TODO parse

			if (/^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}\s+\d{1,2}$/.test(value)) {
				return new Date(value + ':00:00');
			}

			return new Date(value);

		},
		format : function(source, params) {
			// console.info(arguments);
			if (arguments.length === 1) {
				return function() {
					var args = $.makeArray(arguments);
					args.unshift(source);
					return this.format.apply(this, args);
				};
			}
			if (arguments.length > 2 && params.constructor !== Array) {
				params = $.makeArray(arguments).slice(1);
			}
			if (params.constructor !== Array) {
				if (params.constructor == String && params.indexOf(",") != -1) {
					params = params.split(",");
				} else {
					params = [ params ];
				}
			}
			$.each(params, function(i, n) {
				source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
			});
			return source;
		}
	});
})(jQuery);
