
var surveyInit = (function(){

	$(function() {
		/*调查问卷*/
		$("#dcwj, #dcwj1").click(function() {
			window.location.href = contextPath+ "/survey/index?indexPage=1";
		});
		$("#submitSurvey").click(function() {
			addPoll();
		});
		$("#clearSurvey").click(function() {
			clear('pollOption');
		});
		/*调查问卷 end*/
		initLinkClick('surveyDetail',surveyDetail, {id:"data-id"});
	});

	function surveyDetail(id) {
		window.location.href = contextPath+ "/survey/surveyDetail?id="+id;
	}
	function addPoll() {
		$("#optionListJson").val((Obj2str(getPopObj('surveyOptions'))));
		/*alert($("#optionListJson").val());*/
		var trlength = ($("#surveyOptions tr").length)/3;
		var len = Obj2str(getPopObj('surveyOptions').length);
		if($($("#pollOption")).easyValidate().validateForm()) {
			$("#pollOption").submitFormGetJson({
				url : contextPath + "/survey/addPoll",
				callback : function(model) {
					if (model.success) {
						msgUtil.alert(model.msg, function() {window.location.href = contextPath+ "/survey/index?indexPage=1";});
					} else {
						msgUtil.alert(model.msg);
					}
				}
			});
		} else {
			msgUtil.alert("您有必答项没答！");
		}
	}
	/**
	 *
	 * @param tableId 弹出子表的tableId
	 * @returns {{}}
	 */
	function getPopObj(tableId){
		var tableData = [];
		$("#"+tableId).find("td input").each(function(index, obj) {
			var popObj = {};
			if(obj.type == "radio" || obj.type == "checkbox"){
				if($(this).is(":checked")){
					popObj["type"] = $(this).attr("type");
					popObj["itemId"] = $(this).attr("itemId");
					popObj["pollId"] = $(this).attr("id");
					popObj["value"] = $.trim($(this).val());
					if($.trim($(this).val()) != '') {
						tableData.push(popObj);
					}
				}
			}

			if (obj.type == "text") {
				popObj["type"] = $(this).attr("type");
				popObj["itemId"] = $(this).attr("itemId");
				popObj["pollId"] = $(this).attr("id");
				popObj["value"] = $.trim($(this).val());
				if($.trim($(this).val()) != '') {
					tableData.push(popObj);
				}
			}
		});
		return tableData;
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

})();