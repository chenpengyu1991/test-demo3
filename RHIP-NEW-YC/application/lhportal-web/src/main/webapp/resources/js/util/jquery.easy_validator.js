(function($)
{
	$.fn.easyValidate = function()
	{
		return new $.easy_validate(this);
	};
	$.easy_validate = function(form)
	{
		this.form = form;
		this.debug = true;
		this.messages = {
			required : "必须字段",
			remote : "请修正该字段",
			maxlength : "请输入一个长度最多是 {0} 的字符串",
			minlength : "请输入一个长度最少是 {0} 的字符串",
			rangelength : "请输入一个长度介于 {0} 和 {1} 之间的字符串",
			range : "请输入一个介于 {0} 和 {1} 之间的值",
			max : "请输入一个最大为 {0} 的值",
			min : "请输入一个最小为 {0} 的值",
			number : "请输入合法的数字",
			digits : "请输入整数",
			creditcard : "请输入合法的身份证号",
			postCode : "请输入合法的邮编",
			phone : "请输入正确的电话号码,格式: 区号-电话-分机",
			email : "请输入正确格式的电子邮件",
			url : "请输入合法的网址",
			date : "请输入合法的日期",
			dateISO : "请输入合法的日期 (ISO).",
			equalTo : "请再次输入相同的值",
			accept : "请输入拥有合法后缀名的字符串",
			idCard : "请输入正确的身份证号",
			greaterThan : "请输入一个不小于{0} 的值"
		};
		this.validateRegExp = {
			digits : "^\\d+$",
			date : "^\\d{4}[\\/\\-]\\d{2}[\\/\\-]\\d{2}$",
			number : "^(-?\\d+)(\\.\\d+)?$",
			creditcard : "^[0-9]{15}$|^[0-9]{18}$|^[0-9]{17}[xX]$",
			postCode : "^[0-9]{6}$",
			phone : "(^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)",
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

		init : function()
		{
			var inputs = this.form.find("[reg]");
			var i, $input, name, type, config;
			var length = inputs.length;

			for (i = 0; i < length; i++)
			{
				$input = $(inputs[i]);
				name = $input.attr("name");
				try
				{
					// 规则配置使用json方式
					var regString = $input.attr("reg");
					config = $.parseJSON(regString.replace(/'/g, '"'));
				} catch (error)
				{
					throw("控件 " + name + "规则定义错误,规则:" + $input.attr("reg") + ",错误原因:"+error+",请使用json格式!");
				}
				if (config.regex)
				{
					var regex = config.regex;
					if (!this.validateRegExp[regex])
					{
						// 自定义正则,需要获取自定义消息
						this.messages[regex] = $input.attr("tip");
					}
				}

				this.ruleMapping[this.formatName(name)] = config;
				type = $input.attr("type");
				// 如果是radio和checkbox类型,则根据其name获取一组dom
				if (type === "radio" || type === "checkbox")
				{
					$input = $("input[name='" + $input.attr("name") + "']");
				}
				this.element[this.formatName(name)] = $input;
				this.addElementEvent($input);
			}
		},

		addElementEvent : function(input)
		{
			var imagePath = contextPath + "/css/images/vtip_arrow.png";
			var xOffset = -20; // x distance from mouse
			var yOffset = 20; // y distance from mouse
			var res = this.result;
			var validator = this;
			var $input = $(input);
			// 增加浮动信息
			$input.hover(function(e)
			{
				var name = $(this).attr('name');
				// 有错误信息则显示
				if (res[validator.formatName(name)])
				{
					var top = (e.pageY + yOffset);
					var left = (e.pageX + xOffset);
					$('body').append('<p id="vtip"><img id="vtipArrow" src="' + imagePath + '"/>' + res[validator.formatName(name)] + '</p>');
					$('p#vtip').css("top", top + "px").css("left", left + "px").bgiframe();
				}
			}, function()
			{
				$("p#vtip").remove();
			});
			$input.mousemove(function(e)
			{
				var name = $(this).attr('name');
				if (res[validator.formatName(name)])
				{
					var top = (e.pageY + yOffset);
					var left = (e.pageX + xOffset);
					$("p#vtip").css("top", top + "px").css("left", left + "px");
				}
			});
			// 日期控件在选择变化时执行验证
			if ("date" == $input.data("inputtype"))
			{
				$input.on("onDatePickerChanged", function()
				{
					var name = $(this).attr('name');
					validator.validate(name);
				});
			} else
			{
				$input.blur(function(e)
				{
					var name = $(this).attr('name');
					validator.validate(name);
				});
			}
		},

		validateForm : function()
		{
			var validator = this;
			var isSubmit = true;
			for ( var key in this.element)
			{
				// 检查是否需要验证
				if (validator.isNotNeedValidate(key))
				{
					continue;
				}
				if (!validator.validate(key))
				{
					isSubmit = false;
				}
			}
			return isSubmit;
		},

		dependOn : function(obj, value, param)
		{
			// 当前支持radio和checkbox
			// 如果value 则为传递name,否则当作id,并检测是否选中
			if (value)
			{
				var dependValue = $("input[name='" + param + "']:checked").val();
				if (value === dependValue)
				{
					return true;
				}
			} else if ($("#" + param).prop("checked"))
			{
				return true;
			}
			return false;
		},
		required : function(obj, value, param)
		{
			if (!param)
			{
				return true;
			}
			var ret = $.trim(value).length > 0;
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.messages.required);
			}
			return ret;
		},

		maxlength : function(obj, value, param)
		{
			var length = $.isArray(value) ? value.length : $.trim(value).length;
			var ret = length <= Number(param);
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.maxlength, param));
			}
			return ret;
		},

		regex : function(obj, value, param)
		{
			var regString = this.validateRegExp[param];
			if (!regString)
			{
				regString = param;
			}
			var reg = new RegExp(regString);

			var ret = reg.test(value);
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.messages[param]);
			}
			return ret;
		},

		minlength : function(obj, value, param)
		{
			var length = $.isArray(value) ? value.length : $.trim(value).length;
			var ret = length >= Number(param);
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.minlength, param));
			}
			return ret;
		},

		min : function(obj, value, param)
		{
			var ret = Number(value) >= Number(param);
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.min, param));
			}
			return ret;
		},

		max : function(obj, value, param)
		{
			var ret = Number(value) <= Number(param);
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.max, param));
			}
			return ret;
		},
		range : function(obj, value, param)
		{
			var args = param.split(",");
			var ret = (Number(args[0]) <= Number(value) && Number(value) <= Number(args[1]));
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.range, param));
			}
			return ret;
		},
		idCard : function(obj, value, param)
		{
			// 为false,不执行验证
			if (!param)
			{
				return true;
			}
			var ret = idCardUtil.check(value);
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.messages.idCard);
			}
			return ret;
		},
		greaterThan : function(obj, value, param)
		{
			var thanValue = $("#" + param).val();

			if (!thanValue)
			{
				return true;
			}
			var ret = null;
			if (/^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}$/.test(value))
			{
				ret = new Date(value) >= new Date(thanValue);
			} else
			{
				ret = parseFloat(value) > parseFloat(thanValue);
			}
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", this.format(this.messages.greaterThan, thanValue));
			}
			return ret;
		},
		compare : function(obj, value, param)
		{

			var $other = $("#" + param[0]);
			var thanValue = $other.val();

			if (!thanValue)
			{
				return true;
			}

			var left, right;
			if (/^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}$/.test(value))
			{
				left = new Date(value);
				right = new Date(thanValue);
			} else
			{
				left = parseFloat(value);
				right = parseFloat(thanValue);
			}

			var op = param[1];
			var ret = null;

			if (op === "eq")
			{
				ret = left === right;
			} else if (op === "ge")
			{
				ret = left >= right;
			} else if (op === "le")
			{
				ret = left <= right;
			} else if (op === "gt")
			{
				ret = left > right;
			} else if (op === "lt")
			{
				ret = left < right;
			}

			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", param[2]);
			} else
			{
				var otherName = $other.attr("name");
				if (this.result[this.formatName(otherName)])
				{
					ret = ret && this.validate(otherName);
				}
			}

			return ret;
		},

		extension : function(obj, value, param)
		{
			var func = param[0];
			var extenFunc = this.extensionFunction[func];
			if (!extenFunc)
			{
				this.print("扩展验证方法:" + func + "没有注册");
				// extenFunc=window[func];
				// extenFunc=eval(func);
				return true;
			}
			var message = param[1];
			var ret = extenFunc();
			if (!ret)
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", message);
			}
			return ret;
		},

		ajax_validate : function(obj, value, param)
		{
			var url_str = param;
			if ($.trim(url_str).length == 0)
			{
				return false;
			}
			if (url_str.indexOf("?") != -1)
			{
				url_str = url_str + "&" + obj + "=" + value;
			} else
			{
				url_str = url_str + "?" + obj + "=" + value;
			}
			var feed_back = $.ajax({
				url : url_str,
				cache : false,
				async : false
			}).responseText;
			feed_back = feed_back.replace(/(^\s*)|(\s*$)/g, "");
			if (feed_back == 'success')
			{
				this.change_error_style(obj, "remove");
				this.change_tip(obj, "remove");
				return true;
			} else
			{
				this.change_error_style(obj, "add");
				this.change_tip(obj, "add", feed_back);
				return false;
			}
		},

		existsProperty : function(obj, property)
		{
			if (obj[property])
			{
				return true;
			}
			return false;
		},

		isNotNeedValidate : function(name)
		{
			var element = this.element[this.formatName(name)];
			// disabled的field不需要验证
			if (element.prop("disabled"))
			{
				return true;
			}
			// 对于没有显示的field不需要验证
			if (element.is(":hidden"))
			{
				return true;
			}
			return false;
		},

		validate : function(name)
		{
			this.change_error_style(name, "remove");
			this.change_tip(name, "remove", null);
			var checkObj = this.ruleMapping[this.formatName(name)];
			var obj = this.element[this.formatName(name)];
			if (!obj)
			{// 通过addError方法添加的跳过
				return true;
			}
			var objValue = null;
			// 多选和单选,获取选中的value,如果没有任何被选中,不设置值
			var type = obj.attr('type');
			if ("checkbox" == type || "radio" == type)
			{
				var selectedItems = obj.filter(":checked");
				if (selectedItems && selectedItems.length > 0)
				{
					objValue = selectedItems.val();
				}
			} else
			{
				objValue = obj.val();
			}
			var hasValue = (null != objValue && $.trim(objValue).length > 0);

			var ret = true;

			// 是否需要依赖,如果有依赖,且依赖不满足,则不再检验.当前支持radio或者checkboc
			if (this.existsProperty(checkObj, 'dependOn'))
			{
				var check = this.dependOn(name, checkObj.dependValue, checkObj['dependOn']);
				if (!check)
				{
					return true;
				}
			}

			// TODO 验证方式
			if (ret && this.existsProperty(checkObj, 'required'))
			{
				ret = this.required(name, objValue, checkObj['required']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'regex'))
			{
				ret = this.regex(name, objValue, checkObj['regex']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'maxlength'))
			{
				ret = this.maxlength(name, objValue, checkObj['maxlength']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'minlength'))
			{
				ret = this.minlength(name, objValue, checkObj['minlength']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'min'))
			{
				ret = this.min(name, objValue, checkObj['min']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'max'))
			{
				ret = this.max(name, objValue, checkObj['max']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'digits'))
			{
				ret = this.regex(name, objValue, 'digits');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'number'))
			{
				ret = this.regex(name, objValue, 'number');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'phone'))
			{
				ret = this.regex(name, objValue, 'phone');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'postCode'))
			{
				ret = this.regex(name, objValue, 'postCode');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'email'))
			{
				ret = this.regex(name, objValue, 'email');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'url'))
			{
				ret = this.regex(name, objValue, 'url');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'creditcard'))
			{
				ret = this.regex(name, objValue, 'creditcard');
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'idCard'))
			{
				ret = this.idCard(name, objValue, checkObj['idCard']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'range'))
			{
				ret = this.range(name, objValue, checkObj['range']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'greaterThan'))
			{
				ret = this.greaterThan(name, objValue, checkObj['greaterThan']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'compare'))
			{
				ret = this.compare(name, objValue, checkObj['compare']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'remote'))
			{
				ret = this.ajax_validate(name, objValue, checkObj['remote']);
			}
			if (ret && hasValue && this.existsProperty(checkObj, 'extension'))
			{
				ret = this.extension(name, objValue, checkObj['extension']);
			}
			return ret;
		},

		addError : function(name, message)
		{
			$input = this.form.find("[name='" + name + "']");
			this.change_error_style(name, "add");
			this.change_tip(name, "add", message);
			this.addElementEvent($input);
		},

		removeError : function(name)
		{
			this.change_error_style(name, "remove");
			this.change_tip(name, "remove");
		},

		addExtension : function(extensionName, extensionFunc)
		{
			this.extensionFunction[extensionName] = extensionFunc;
		},

		validExtension : function(func, name, message)
		{
			var reslut = func();
			if (reslut)
			{
				this.removeError(name);
			} else
			{
				this.addError(name, message);
			}
		},

		addCheckElement : function(name, checkObj, message)
		{
			$input = this.form.find("[name='" + name + "']");
			if (!this.element[this.formatName(name)])
			{
				this.element[this.formatName(name)] = $input;
			}
			if (!this.ruleMapping[this.formatName(name)])
			{
				this.ruleMapping[this.formatName(name)] = checkObj;
			} else
			{
				$.extend(this.ruleMapping[this.formatName(name)], checkObj);
			}
			if (checkObj.regex)
			{
				this.messages[checkObj.regex] = message;
			}
			this.addElementEvent($input);
		},

		removeCheckElement : function(name)
		{
			this.removeError(name);
			if (this.element[this.formatName(name)])
			{
				this.element[this.formatName(name)] = null;
				delete this.element[this.formatName(name)];
			}
			if (this.ruleMapping[this.formatName(name)])
			{
				this.ruleMapping[this.formatName(name)] = null;
				delete this.ruleMapping[this.formatName(name)];
			}
			if (this.result[this.formatName(name)])
			{
				this.result[this.formatName(name)] = null;
				delete this.result[this.formatName(name)];
			}
		},

		change_error_style : function(name, action_type)
		{
			var $input = (this.element[this.formatName(name)]) ? this.element[this.formatName(name)] : this.form.find("[name='" + name + "']");
			if ($input)
			{
				if (action_type == "add")
				{
					$input.addClass(this.failedCssClass);
					if ($input.attr('type') == "radio")
					{
						var $next = $input.nextAll("label");
						if ($next)
						{
							$next.addClass(this.failedCssClass);
						}
					}
				} else
				{
					$input.removeClass(this.failedCssClass);
					if ($input.attr('type') == "radio")
					{
						var $next = $input.nextAll("label");
						if ($next)
						{
							$next.removeClass(this.failedCssClass);
						}
					}
				}
			}
		},

		change_tip : function(name, action_type, msg)
		{
			if (action_type == "add")
			{
				this.result[this.formatName(name)] = msg;
			} else
			{
				this.result[this.formatName(name)] = null;
			}
		},

		print : function(msg)
		{
			if (this.debug && window.console)
				console.error("debug info: %o", msg);
		},
		formatName : function(name)
		{
			if (!name)
			{
				return name;
			}

			if (name.indexOf(".") > 0)
			{
				if (name.indexOf("'") == 0)
				{
					return "'" + name + "'";
				}
			}
			return name;
		},
		format : function(source, params)
		{
			// console.info(arguments);
			if (arguments.length === 1)
			{
				return function()
				{
					var args = $.makeArray(arguments);
					args.unshift(source);
					return this.format.apply(this, args);
				};
			}
			if (arguments.length > 2 && params.constructor !== Array)
			{
				params = $.makeArray(arguments).slice(1);
			}
			if (params.constructor !== Array)
			{
				if (params.constructor == String && params.indexOf(",") != -1)
				{
					params = params.split(",");
				} else
				{
					params = [ params ];
				}
			}
			$.each(params, function(i, n)
			{
				source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
			});
			return source;
		}
	});
})(jQuery);
