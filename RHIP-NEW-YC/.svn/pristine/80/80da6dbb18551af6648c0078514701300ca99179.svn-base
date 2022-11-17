var loadingSource = "<span><img src='" + contextPath
		+ "/images/AjaxLoader24.gif' style='vertical-align:top;'/></span>";

var util = (function() {
	// /参数1为要全选或反选的chkBox的chkRef属性，
	// 参数2为当前的checkBox的ID
	function checkBoxAll(chk, chkRef) {
		$("#" + chk).click(function() {
			var checked = $(this).prop("checked");

			if (checked != true && checked != false && checked != "checked") {
				checked = false;
			}

			$("input[chkRef=" + chkRef + "]").each(function() {
				$(this).prop("checked", checked);
			});
		});

		$("input[chkRef=" + chkRef + "]").each(function() {
			$(this).click(function() {
				var checked = true;
				$("#" + chk).prop("checked", checked);
				$("input[chkRef=" + chkRef + "]").each(function() {
					var checked1 = $(this).prop("checked");
					if (checked1 != true && checked1 != "checked") {
						checked = false;
					}
				});
				$("#" + chk).prop("checked", checked);
			});
		});
	}

	function clickShowText(obj, textId) {
		//****radio button不能使用.attr("checked")的方式，而且要直接布尔型，不能等于的判断，只能使用.prop("checked")。建议全部用prop替换attr
		if ($(obj).attr("checked") == "checked" || $(obj).prop("checked")) {
			$("#" + textId).show();
			// $("#"+textId).animate({ width:"60%"}, 1000 );
		} else {
			$("#" + textId).hide();
			// $("#"+textId).animate({ width:"60%"}, 1000 );
			$("#" + textId).val("").attr("value", "");
			$("#" + textId + " input[type='text']").attr("value", "");
		}
	}
	function clickShowTexts(obj, textId) {
		//****radio button不能使用.attr("checked")的方式，而且要直接布尔型，不能等于的判断，只能使用.prop("checked")。建议全部用prop替换attr
		if ($(obj).attr("checked") == "checked" || $(obj).prop("checked")) {
			$("#" + textId).show();
			// $("#"+textId).animate({ width:"60%"}, 1000 );
		} else {
			$("#" + textId).hide();
			// $("#"+textId).animate({ width:"60%"}, 1000 );
			$("#" + textId).val("").attr("value", "");
			$("#" + textId + " input[type='text']").attr("value", "");
		}
	}
	function clickHideText(obj, textId) {
		$("#" + textId).hide();
		// $("#"+textId).animate({ width:"60%"}, 1000 );
		$("#" + textId).attr("value", "");
		$("#" + textId + " input[type='text']").attr("value", "");
	}
	function clickHideTexts(obj, textId) {
		$("#" + textId).hide();
		// $("#"+textId).animate({ width:"60%"}, 1000 );
		$("#" + textId).attr("value", "");
		$("#" + textId + " input[type='text']").attr("value", "");
		$("#povertyTypes").attr('value', '');
		$("#veryPovertyTypes").attr('value', '');
		$("#ylTypes").attr('value', '');
	}
	function clickShowTable(obj, tableId, textId) {
		//****radio button不能使用.attr("checked")的方式，而且要直接布尔型，不能等于的判断，只能使用.prop("checked")
		if ($(obj).attr("checked") == "checked" || $(obj).prop("checked")) {
			$("#" + textId).hide();
			$("#" + textId).val("").attr("value", "");
			$("#" + textId + " input[type='text']").attr("value", "");
			if ("ttb7" == tableId) {
				$("#ttb3").hide();
				$("#ttb4").hide();
				$("#ttb5").hide();
			}
			$("#" + tableId).show();
		} else {
			$("#" + tableId).hide();
			// $("#"+textId).animate({ width:"60%"}, 1000 );
			$("#" + tableId).val("").attr("value", "");
			$("#" + tableId + " input[type='text']").attr("value", "");
		}
		// $("#"+textId).animate({ width:"60%"}, 1000 );
	}

	function clickHideTable(obj, tableId) {
		$("#" + tableId).hide();
		$("#" + tableId + " input[type!='radio']").each(function() {
			$(this).attr("value", "");
		});
		$("#" + tableId + " input[type='radio']").each(function() {
			$(this).removeAttr("checked");
		});
		if ("ttb22" == tableId) {
			$("#" + tableId + " input[type='radio']").each(function() {
				$(this).removeAttr("checked");
			});
			for ( var i = 1; i <= 5; i++) {
				if ($.isEmpty($("#dicList" + i).get(0))) {
					continue;
				}
				$("#dicList" + i).get(0).selectedIndex = 0;
			}
		}
		$("#" + tableId + " input[type='checkbox']").each(function() {
			$(this).removeAttr("checked");
		});
		//$("#" + tableId + " input[name=]").val();

	}
	function formatOperateTime(operateTime) {
		var ret = "";
		if (operateTime && operateTime.length >= 8) {
			ret += operateTime.substr(0, 4);
			ret += "/";
			ret += operateTime.substr(4, 2);
			ret += "/";
			ret += operateTime.substr(6, 2);
			if (operateTime.length >= 14) {
				ret += " ";
				ret += operateTime.substr(8, 2);
				ret += ":";
				ret += operateTime.substr(10, 2);
				ret += ":";
				ret += operateTime.substr(12, 2);
			}
		} else {
			ret = operateTime;
		}
		return ret;
	}

	function reset(formId) {
		$("#" + formId).find("input:text").val("");
		$("#" + formId).find("input:radio").val("");
		$("#" + formId).find("input:checkbox").val("");
		$("#" + formId).find("select").val("");
	}

	function showLog(msg) {
		if (window.console) {
			if ($.type(msg) === "object") {
				console.error("debug info: %o", dump_obj(msg));
			} else {
				console.error("debug info: %o", msg);
			}
		}
	}

	function dump_obj(myObject) {
		var s = "";
		var child = null;
		for ( var property in myObject) {
			child = myObject[property];
			if (child instanceof Array) {
				for ( var index in child) {
					s += dump_obj(child[index]);
				}
			} else if (child instanceof Object) {
				s += dump_obj(child);
			} else {
				s += "\n " + property + ": " + child;
			}
		}
		return s;
	}

	function printPage(url) {
		var windowAttr = "location=no,statusbar=no,directories=no,menubar=no,titlebar=no,toolbar=no,scrollbars=yes,";
		windowAttr += "width=800,height=600,resizable=yes";
		window.open(url, "_blank", windowAttr);
	}

	function showDialog(imgId, title, width, height) {
		if ($.isEmpty(width)) {
			width = 900;
		}
		if ($.isEmpty(height)) {
			height = 480;
		}
		
		$.dialog({
			url : "/dialog/showImage",
			height : 480,
			width : 900,
			title : title,
			param:{
				imgId:imgId
			}
		});
	}

	function getNowDateFormate(now,isFirstDay){ 
		strTime = now.toLocaleString(); 
		strYear = now.getYear(); 
		strMonth = now.getMonth(); 
		strDay = now.getDay(); 
		var displayTime = strYear +"/"+strMonth+"/"+strDay;   

		if(isFirstDay){
			 if(strTime.substring(5,6)<10){ 
				 displayTime = strTime.substring(0,4)+"/0"+strTime.substring(5,6)+"/01";
			 }else{ 
				 displayTime = strTime.substring(0,4)+"/"+strTime.substring(5,7)+"/01"; 
			 }
		 }else{
			 if(strTime.substring(5,6)<10){ 
				 displayTime = strTime.substring(0,4)+"/0"+strTime.substring(5,6)+"/"+strTime.substring(7,9);
			 }else{ 
				 displayTime = strTime.substring(0,4)+"/"+strTime.substring(5,7)+"/"+strTime.substring(8,10);
			 }
		 }
		 return displayTime;
	}


    /**
     * 取间隔天数
     * @param startDate
     * @param endDate
     * @returns {number}
     * @constructor
     */
    function getDateDiff(startDate,endDate)
    {
        var startTime = new Date(Date.parse(startDate.replace(/-/g, "/"))).getTime();
        var endTime = new Date(Date.parse(endDate.replace(/-/g, "/"))).getTime();
        var dates = Math.abs((startTime - endTime))/(1000*60*60*24);
        return dates;
    }

    // verify string is blank
    function isBlank(val)
    {
    	if (!val)
    		return false;
    	var strP = /^\s*$/;
    	if (!strP.test(val))
    		return false;

    	return true;
    }

    function trim(val)
    {
    	return val.replace(/(^\s*)|(\s*$)/g, "");
    }

    // verify positive integer, above zero\s
    function isNumber(oNum)
    {
    	if (!oNum)
    		return false;
    	var strP = /^[1-9]\d*$/;
    	if (!strP.test(oNum))
    		return false;
    	try
    	{
    		if (parseFloat(oNum) != oNum)
    			return false;
    	} catch (ex)
    	{
    		return false;
    	}
    	return true;
    }

    function isDate(str)
    {
    	var d = new Date(str);
    	return !isNaN(d);
    }

    // verify float
    function isFloat(oNum)
    {
    	if (!oNum)
    		return false;
    	var strP = /^\d+(\.\d+)?$/;
    	if (!strP.test(oNum))
    		return false;
    	try
    	{
    		if (parseFloat(oNum) != oNum)
    			return false;
    	} catch (ex)
    	{
    		return false;
    	}
    	return true;
    }
    
    /* 对象转成json/json数组 */
    function Obj2str(o)
    {
    	if (o == undefined)
    	{
    		return "";
    	}
    	var r = [];
    	if (typeof o == "string")
    		return "\"" + o.replace(/([\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
    	if (typeof o == "object")
    	{
    		if (!o.sort)
    		{
    			for ( var i in o)
    				r.push("\"" + i + "\":" + Obj2str(o[i]));
    			if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString))
    			{
    				r.push("toString:" + o.toString.toString());
    			}
    			r = "{" + r.join() + "}";
    		} else
    		{
    			for ( var i = 0; i < o.length; i++)
    				r.push(Obj2str(o[i]));
    			r = "[" + r.join() + "]";
    		}
    		return r;
    	}
    	return o.toString().replace(/\"\:/g, '":""');
    }
   
    /**
     * 比如取“方正abc"字符串长度，一般结果为：5 用此代码取值为：7
     * 
     * @param strTemp
     * @returns sum
     */
    function fucCheckLength(strTemp)
    {
    	var i, sum;
    	sum = 0;
    	for (i = 0; i < strTemp.length; i++)
    	{
    		if ((strTemp.charCodeAt(i) >= 0) && (strTemp.charCodeAt(i) <= 255))
    			sum = sum + 1;
    		else
    			sum = sum + 2;
    	}
    	return sum;
    }
    
	
	function cloneJsonObj(jsonObj) {
		var  buf;
		 if  (jsonObj  instanceof  Array) {   
	        buf = [];   
	        var  i = jsonObj.length;   
	        while  (i--) {   
	            buf[i] = cloneJsonObj(jsonObj[i]);   
	        }   
	        return  buf;   
    	} else   if  (jsonObj  instanceof  Object) {   
		        buf = {};   
		        for  ( var  k  in  jsonObj) {   
		            buf[k] = cloneJsonObj(jsonObj[k]);   
		        }   
       	 	return  buf;   
    	} else {
    		return  jsonObj; 
    	}
	}

	function showHideDiv(divId){
		var divShow = $("#"+divId).css("display");
		if(divShow == "none"){
			$("#"+divId).css("display","block");
		}else{
			$("#"+divId).css("display","none");
		}
	}
	
    return {
		showLog : showLog,
		showHideDiv:showHideDiv,
		dump_obj : dump_obj,
		reset : reset,
		formatOperateTime : formatOperateTime,
		checkBoxAll : checkBoxAll,
		clickShowText : clickShowText,
		clickHideText : clickHideText,
		clickShowTexts : clickShowTexts,
		clickHideTexts : clickHideTexts,
		clickShowTable : clickShowTable,
		clickHideTable : clickHideTable,
		printPage : printPage,
		showDialog : showDialog,
		getNowDateFormate:getNowDateFormate,
        getDateDiff : getDateDiff,
        isFloat: isFloat,
        isDate : isDate,
        isNumber : isNumber,
        trim : trim,
        isBlank : isBlank,
        Obj2str: Obj2str,
        fucCheckLength: fucCheckLength,
        cloneJsonObj:cloneJsonObj
	};
})();

String.prototype.connect = function(value, connector) {
	if (value == null || value == "") {
		return this;
	}
	if (this == "") {
		return value;
	}
	if (connector == null || connector == "") {
		connector = "";
	}
	return this + connector + value;
};

Date.prototype.pattern = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, // 小时
		"H+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	var week = {
		"0" : "/u65e5",
		"1" : "/u4e00",
		"2" : "/u4e8c",
		"3" : "/u4e09",
		"4" : "/u56db",
		"5" : "/u4e94",
		"6" : "/u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt
				.replace(
						RegExp.$1,
						((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
								: "/u5468")
								: "")
								+ week[this.getDay() + ""]);
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};

var message = {
	enterErrorMsg : "请先暂存基本信息"
};
