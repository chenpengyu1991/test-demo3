(function($) {
	/**
	 * 判断是不是为空
	 */
	$.isEmpty = function(source) {
		if (undefined == source) {
			return true;
		}
		if (null == source) {
			return true;
		}
		if ("" == source) {
			return true;
		}
		return false;
	};

	/**
	 * 给控件加回车事件 actin为要执行的函数 param为参数
	 */
	$.fn.onEnter = function(action, param) {
		this.keydown(function(e) {
			var ev = document.all ? window.event : e;
			if (ev.keyCode == 13) {
				ev.returnValue = false;
				action(param);
			}
		});
	};

	/**
	 * 将form序列化为对象
	 */
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				o[this.name] = o[this.name].connect(this.value || '', ",");
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

	/**
	 * 将form序列化为对象 不处理空
	 * 
	 */
	$.fn.serializeObject2 = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]!=undefined) {
				o[this.name] += "," + this.value;
			} else {
				o[this.name] = this.value;
			}
		});
		return o;
	};

	/**
	 * 给列表添加效果，需要CSS文件支持
	 * 
	 */
	$.trAddClass = function() {
		$("input:submit, input:button, button").addClass("button");
		$('.repeattable tr:odd').not(".pagefoot").addClass("listtradd");
		$('.repeattable tr:even').not(".pagefoot").addClass("listtreven");
		
		$('.repeattable tr').not(".pagefoot").mousemove(function() {
			$(this).addClass("listtrhover");
		}).mouseout(function() {
			$(this).removeClass("listtrhover");
		});
		
		$('.repeattable tr').not(".pagefoot").click(function() {
			$(".listtrselect").removeClass("listtrselect");
			$(this).addClass("listtrselect");
		});
	};

	/**
	 * checkBox的全选
	 */
	$.selectAll = function(chk) {
		var name = $(chk).val();
		var checked = $(chk).attr("checked") == "checked";
		$("input[name=" + name + "]").each(function() {
			$(this).attr("checked", checked);
		});
	};

	/**
	 * 获取值
	 */
	$.fn.getValue = function() {
		if (this.is("textarea")) {
			return this.html();
		}
		if (this.is("input[type='text'],input[type='hidden'],select")) {
			return this.val();
		}
		if (this.is("input[type='checkbox'],input[type='radio']")) {
			return this.getCheckValue();
		}
		return "";
	};

	$.fn.getCheckValue = function() {
		var value = "";
		if (!this.is("input[type='checkbox'],input[type='radio']")) {
			return;
		}
		var name = this.attr("name");
		$("input[name=" + name + "]").each(function() {
			if ($(this).attr("checked")) {
				value = value.connect($(this).val(), ",");
			}
		});
		return value;
	};

	$.dateFormat = function(str) {
		str = str.replace(/-/g, "/");
		var date = new Date(str);
		if (isNaN(date)) {
			return null;
		}
		return date;
	};
})(jQuery);