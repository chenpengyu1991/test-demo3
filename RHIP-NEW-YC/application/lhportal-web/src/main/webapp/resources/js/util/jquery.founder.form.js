(function($) {
	
	$.fn.diabaleForm = function(){
		$(this).find("input[type='text']").each(function() {
			$(this).attr("readonly","readonly" );
		});
		
		$(this).find("textarea").each(function() {
			$(this).attr("readonly","readonly" );
		});
		
		$(this).find("input[type='radio']").each(function() {
			$(this).attr("disabled","disabled" );
		});
		
		$(this).find("input[type='checkbox']").each(function() {
			$(this).attr("disabled","disabled");
		});
		
		$(this).find("input[type='button']").each(function() {
			$(this).hide();
		});
		
		$("a[type=disLink]").each(function() {
			$(this).attr("disabled","disabled" );
		});
		
		$(this).find("select").each(function() {
			$(this).find("option[selected!=selected]").each(function(){
					$(this).remove();
			});
		});
	};
	
	$.fn.fromTrim = function() {
		$(this).find("input[type='text']").each(function() {
			$(this).tagTrim();
		});
		$(this).find("input[type='hidden']").each(function() {
			$(this).tagTrim();
		});
		$(this).find("textarea").each(function() {
			$(this).tagTrim();
		});
	};

	$.fn.tagTrim = function() {
		if ($(this).is("input")) {
			var txt = $.trim($(this).val());
			$(this).val(txt);
		}
		if ($(this).is("textarea")) {
			var htm = $.trim($(this).html());
			$(this).html(htm);
		}
	};
	/**
	 * 对一个表单元素进行check
	 */
	$.fn.tagValidate = function(expressions) {
		var value = $(this).getValue();
		var error = checkOption(expressions, value);
		return error;
	};

	//
	$.fn.formValidate = function(option) {
		var formData = $(this).serializeObject();
		if(!$.isEmpty(formData["startDate"]) && !$.isEmpty(formData["endDate"])) {
			if($.isEmpty(option)){
				option = new Object();
				option["startDate"] = new Array("dateCheck|开始时间不能晚于结束时间|endDate");
			}
		}
		var error = "";
		if (!$.isEmpty(option)) {
			error = checkOptions(option, formData);
		}
		return error;
	};
	
	function checkOptions(option, formData) {
		var error = "";
		for (prop in option) {
			var tagExpressions = option[prop];
			var tagValue = formData[prop];
			var tagError = checkOption(tagExpressions, tagValue,formData);
			error = error.connect(tagError, "\n");
		}
		return error;
	}
	
	function checkOption(expressions, value,formData) {
		var error = "";
		for ( var i = 0; i < expressions.length; i++) {
			var option = parseExpression(expressions[i]);
			var oneError = excuteFunction(value, option,formData);
			error = error.connect(oneError, "\n");
		}
		return error;
	}
	/**
	 * 解析表达式
	 */
	function parseExpression(expression) {
		if ($.isEmpty(expression)) {
			return null;
		}
		var detailArray = expression.split("|");
		if (detailArray.length < 2) {
			return null;
		}
		var object = {
			method : detailArray[0],
			msg : detailArray[1]
		};
		if (detailArray.length >= 3) {
			object.value = detailArray.slice(2);
		}
		return object;
	}
	/**
	 * 执行函数
	 */
	function excuteFunction(value, option,formData) {
		if ($.isEmpty(option)) {
			return "";
		}
		try {
			var func = eval("_validate." + option.method);
			if (typeof (func) == "function") {
				return func(value, option,formData);
			}
		} catch (e) {
			return "";
		}
		return "";
	}
})(jQuery);


//var option = {
//		method:
//		msg:
//		value:
//};

var valueRange = { height: { max: 170, min: 150 },
				   width: { max: 150, min: 120 }};

var valueList = { weight: [ 'g', 'kg' ],
				  length: [ 'cm', 'km'] };

var _validate = {
	//不为空
	notEmpty:function(value, option) {
		if ($.isEmpty(value)) {
			return option.msg;
		}
		return "";
	},
	//输入的最大长度
	maxLength:function (value, option) {
		if (value.length > option.value[0]) {
			return option.msg;
		}
		return "";
	},
	//是否为数字
	isNumeric:function(value, option) {
		if(isNaN(value)) {
			return option.msg;
		}
		return "";
	},
	//根据正则表达式验证
	regTest:function(value,option){
		if($.isEmpty(value)){
			return "";
		}
		var r = eval(option.value[0]);
		if(r.test(value)){
			return "";
		}
		return option.msg;
	},
	//验证数字在某一范围以内
	numberIn:function(value, option){
		if($.isEmpty(value)){
			return "";
		}
		if(isNaN(value)) {
			return "";
		}
		if(Number(value) >= Number(option.value[0]) && Number(value) <= Number(option.value[1]) ){
			return "";
		}
		return option.msg;
	},
	valueBetween:function(value, option) {
		var val = Number(value);
		var range = valueRange[option.value];
		if(val >= range.min && val <= range.max) {
			return "";
		} else {
			return option.msg;
		}
	},
	//验证日期
	dateCheck:function(value, option, formData) {
		var startDate = $.dateFormat(value);
		var endDate = $.dateFormat(formData[option.value]);
		if($.isEmpty(startDate) || $.isEmpty(endDate)){
			return "";
		}
		if(startDate.valueOf() > endDate.valueOf()){
			return option.msg;
		}
		return "";
		
	},
	//验证输入值在某一数组中
	valueIn:function(value, option) {
		list = valueList[option.value];
		for(v in list) {
			if(value == list[v]) {
				return "";
			}
		}
		return option.msg;
	},
	//输入日期晚于今天
	laterThanToday:function(value, option) {
		var date = $.dateFormat(value);
		if($.isEmpty(date)) return "";
		var now = new Date();
		if(date.valueOf() <= now.valueOf()) {
			return option.msg;
		} else {
			return "";
		}
	},
	//输入日期早于今天
	earlierThanToday:function(value, option) {
		var date = $.dateFormat(value);
		if($.isEmpty(date)) return "";
		var now = new Date();
		if(date.valueOf() >= now.valueOf()) {
			return option.msg;
		} else {
			return "";
		}
	},
	itemEmptyCheck:function(value, option, formData) {
		var msg = "";
		var values1 = value.split(',');
		var msgs = option.msg.split(',');
		var length = values1.length;
		for(val in values1) {
			if(values1[val] == "#@#") {
				msg += msgs[0] + "\n";
				break;
			}
		}
		
		var eleRest = option.value.split(',');
		var msgPtr = 0;
		for(ele in eleRest) {
			var values = formData[eleRest[ele]].split(',');
			msgPtr++;
			if(values.length < length) {
				msg += msgs[msgPtr];
				continue;
			}
		}
		
		return msg;
	}
};