var healthCardList = (function() {
	$(function() {

		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

		if($.isEmpty($("#fromHomeId").val())) {
			search(1);
		} else {//站角色首页进入页面
			$(".to-followup-link").removeAttr("style");
			$("a[data-followupflag='" + $("#followupStatus").val() + "']").attr("style", "color:black");
			search(1, {
				followupFlag : $("#followupStatus").val()
			});
		}

		// 添加回车监听事件
		$('input').keypress(function(e) {
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});

		$("#idCard").keyup(function() {
			var idCardValue = $("#idCard").val();
			$("#idCard").attr("value", idCardValue.toUpperCase());
		});

		$("#per_search_btn").click(function(e) {
			e.preventDefault();
			$(".to-followup-link").removeAttr("style");
			$("#followupStatus").val("");
			search(1);
			getToFullowupCount();
		});

		$("#followup-export-btn").click(function(e) {
			e.preventDefault();
			exportList();
		});
		$("#plan-export-btn").click(function(e) {
			e.preventDefault();
			exportPlanList();
		});
		$("#person-export-btn").click(function(e) {
			e.preventDefault();
            exportPersonList();
		});

		$("#cdm-manage-input-btn").on("click", addCard);
		// 查看管理卡信息
		$("#diseaseInfo").on("click", ".report-link", viewCard);
		$("#diseaseInfo").on("click", ".followup-link", viewFollowup);
		$("#health-card-search-toggle-btn").on("click", toggle);
		$("#dm-followup-links").on("click", ".to-followup-link", changeToFullowup);
		/*$("select[multiple]").each(function() {
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择患病类型',
				selectedList : 13
			});
		});*/
		getToFullowupCount();
		$("#check-submit-btn").on("click", function () {
			StartRead();
		});
	});

	function StartRead()//开始读卡
	{
		if (GT2ICROCX.GetState() == 0){
			GT2ICROCX.ReadCard()
		}

		//GT2ICROCX.ReadCard() //循环读卡

		$("#idcard").val(GT2ICROCX.CardNo);
	}

	function getToFullowupCount() {
		$.getJsonByUrl({
			url : "/cdm/standardization/followup/tofollowupcount",
			callback : function(data) {
				$("#expire-to-followup").text(data.expireCount);
				$("#today-to-followup").text(data.todayCount);
				$("#week-followup").text(data.thisWeekCount);
				$("#month-to-followup").text(data.thisMonthCount);
				// result.put("todaycount", todayCount);
				// result.put("thisWeekcount", thisWeekCount);
				// result.put("thisMonthcount", thisMonthCount);
				// result.put("expirecount", expireCount);
			}
		});
	}
	function changeToFullowup() {
		$(".to-followup-link").removeAttr("style");
		var $this = $(this);
		$this.attr("style", "color:black");
		var flag = $this.data("followupflag");
		$("#followupStatus").val(flag);
		search(1, {
			followupFlag : flag
		});
	}

	function toggle() {
		$(this).toggleClass("ico-top");
		$(this).toggleClass("ico-bottom");
		$("#health-card-search-table").toggle();
	}
	function addCard(event) {
		event.preventDefault();
		$("#cdm-manage-list-box").hide();
		$("#cdm-manage-input-box").show();
		var loadHtmlByUrlOption = {
			url : "/cdm/standardization/input",
			insertDiv : "cdm-manage-input-box"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function viewCard(event) {
		$("#cdm-manage-list-box").hide();
		$("#cdm-manage-input-box").show();
		var loadHtmlByUrlOption = {
			url : "/cdm/standardization/view/" + $(this).data("disid"),
			insertDiv : "cdm-manage-input-box"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function viewFollowup(event) {
		event.preventDefault();
		$("#cdm-manage-list-box").hide();
		$("#cdm-manage-input-box").show();
		var followupStatus = $("#followupStatus").val();
		var loadHtmlByUrlOption = {
			url : "/cdm/standardization/followup/viewall",
			insertDiv : "cdm-manage-input-box",
			param : {
				id : $(this).data("disid"),
				followupStatus : followupStatus
			}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function isNumber(val) {
		if (val)
		{
			return val.match(/(\d+)|(^(\d+.\d+)$)/);
		}
		return true;
	}

	function checkAge() {
		var startAge = $("#startAge").val();
		if (!isNumber(startAge))
		{
			$("#startAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		var endAge = $("#endAge").val();
		if (!isNumber(endAge))
		{
			$("#endAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		if (startAge && endAge && Number(startAge) > Number(endAge))
		{
			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}

    function checkSelectedDisType() {
        var $form = $("#form_search");
        var followupCount = $form.find("input[name='followupCount']").val();
        var followupDateStart = $form.find("input[name='followupDateStart']").val();
        var followupDateEnd = $form.find("input[name='followupDateEnd']").val();

        if (followupCount || followupDateStart || followupDateEnd) {
            var selectedDisType = $form.find("#disTypeSelect").val();
            if (selectedDisType) {
                if ($.isArray(selectedDisType) && selectedDisType.length > 1) {
                	layui.use('layer', function() {
        				var layer = layui.layer;
        				layer.alert("查询随访时间和次数信息时只能选择一种患病类型！", {icon:0,title:'提示'});
        			});
                    return false;
                }
            } else {
            	layui.use('layer', function() {
    				var layer = layui.layer;
    				layer.alert("查询随访时间和次数时需要选择一种患病类型！", {icon:0,title:'提示'});
    			});
                return false;
            }
        }
        return true;
    }

	function search(indexPage, param) {
        if ((!checkAge())||(!checkSelectedDisType())) {
            return;
        }
		var p = {
			pageIndex : indexPage
		};
		if (param)
		{
			p = $.extend(p, param);
		}
		var searchObj = {
			url : "/cdm/standardization/followup/listresult",
			insertDiv : "diseaseInfo",
			param : p
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}

	function exportList() {

		//msgUtil.alert("开发中...");

		//return;

		var selectedDisType=$("#form_search #disTypeSelect").val();

		if(selectedDisType){
			if($.isArray(selectedDisType)&&selectedDisType.length>1){
				layui.use('layer', function() {
    				var layer = layui.layer;
    				layer.alert("导出时只能选择一种患病类型！", {icon:0,title:'提示'});
    			});
				return;
			}
		}else {
			layui.use('layer', function() {
				var layer = layui.layer;
				layer.alert("请选择一种患病类型！", {icon:0,title:'提示'});
			});
			return;
		}

		var option={
				url:"/cdm/standardization/followup/excel",
				param:{}
		};
		$("#form_search").exportListExcel(option);

	}
	
	function exportPlanList() {
		var followupFlag = $("#form_search .to-followup-link[style='color:black']").data("followupflag");
		if( "4" == followupFlag){
			layui.use('layer', function() {
				var layer = layui.layer;
				layer.alert("不可导出已过期的随访计划！", {icon:0,title:'提示'});
			});
			return;
		}
		var option={
				url:"/cdm/standardization/followup/excelPlan",
				param:{}
		};
		$("#form_search").exportListExcel(option);
	}

	function exportPersonList() {
        var selectedDisType=$("#form_search #disTypeSelect").val();

        if(selectedDisType){
            if($.isArray(selectedDisType)&&selectedDisType.length>1){
            	layui.use('layer', function() {
    				var layer = layui.layer;
    				layer.alert("导出时只能选择一种患病类型！", {icon:0,title:'提示'});
    			});
                return;
            }
        }else{
        	layui.use('layer', function() {
				var layer = layui.layer;
				layer.alert("请选择一种患病类型！", {icon:0,title:'提示'});
			});
            return;
        }

        var option={
				url:"/cdm/standardization/followup/excelPerson",
            param:{}
        };
        $("#form_search").exportListExcel(option);
	}

	return {
		search : search,
		showList : showList
	};
})();