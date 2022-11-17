var reportCardList = (function()
{
	var lastPageIndex = 1;
	var errorMsg = {
		"0" : "报卡信息获取失败 ",
		"1" : "报卡信息获取失败 ",
		"3" : "糖尿病已经管理 ",
		"4" : "脑卒中已经管理 ",
		"5" : "冠心病已经管理 ",
		"6" : "肿瘤已经管理 ",
		"7" : "报卡已经管理,请刷新重试 "
	};
	
	 $("#check-submit-btn").on("click", function () {

			StartRead();
	});

	$(function()
	{

		// 添加回车监听事件
		$('input').keypress(function(e)
		{
			var key = e.which;
			if (key == 13)
			{
				searchReportList(1);
			}
		});

		$("#slideTable").on("click", function(event)
		{
			toggle(this, 'searchTable');
		});

		$("#reportCard_search_btn").on("click", function(event)
		{
			event.preventDefault();
			searchReportList(1);
		});

		$("#save-to-manage-btn").on("click", saveToMange);

		/*$("#disTypeSelect").multiselect({
			header : false,
			noneSelectedText : '请选择',
			selectedList : 4,
			minWidth : "auto"
		});*/

		$("#idCard").keyup(function()
		{
			var idCardValue = $("#idCard").val();
			$("#idCard").attr("value", idCardValue.toUpperCase());
		});
		
		$("#dm-report-manage-status").on("change",function(e){
			var v=$("#dm-report-manage-status").val();
			if(v!=7){
				$("#save-to-manage-no-btn").show();
				$("#save-to-manage-btn").hide();
			}else{
				$("#save-to-manage-no-btn").hide();
				$("#save-to-manage-btn").show();
			}
		});
		
		$("input[name='reportStatus']").on("click",function(){
			searchReportList(1);
		});
		
		// 查看报卡
		$("#list_datagrid").on("click", ".report-link", viewReport);

		//审核报卡
		$("#list_datagrid").on("click", ".app-report-link", appReport);
		
		
		searchReportList(1);

        $("#reportcard-list-export-btn").click(function() {
            exportList();
        });

	});
	
	
	
	
	function viewReport(event)
	{
		event.preventDefault();
		var $this=$(this);
		var personid =$this.data("personid");
		if(!personid){
			layer.alert("数据错误！", {icon:0,title:'提示'});
			return;
		}
		var url = "/cdm/reportcard/view/"+personid;
		var loadHtmlByUrlOption = {
			url : url,
			insertDiv : "input_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#input_view").show();
	}
	
	function appReport(event){
		event.preventDefault();
		var $this=$(this);
		var status =$this.data("selectedreportstatus");
		var personid =$this.data("personid");
		if(!personid){
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("数据错误！", {icon:0,title:'提示'});
			});
			/*msgUtil.alert("数据错误");*/
			return;
		}
		var url = "/cdm/reportcard/app/"+personid;
		if (status)
		{
			url += "/" + status;
		}
		var loadHtmlByUrlOption = {
			url : url,
			insertDiv : "input_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#input_view").show();
		// searchReportList();
	}

	function addTrHoverEvent(data)
	{
		var $table=$("#reportCard_table");
		var $trs=$table.find("tr");
		$trs.off('mousemove mouseout mouseleave mouseenter');
		$trs.on("click", function(event)
		{
			var $tr = $(this);
			var clazz = $tr.attr("id");
			$table.find("." + clazz).addClass("listtrselect");
		});

		$trs.hover(function()
		{
			//debugger;
			var $tr = $(this);
			var clazz = $tr.attr("id");
			$table.find("." + clazz).addClass("listtrhover");
		}, function()
		{
			var $tr = $(this);
			var clazz = $tr.attr("id");
			$table.find("." + clazz).removeClass("listtrhover");
		});
	}

	function isNumber(val){
		if(val){
			return val.match(/(\d+)|(^(\d+.\d+)$)/);
		}
		return true;
	}
	
	function checkAge(){
		var startAge=$("#startAge").val();
		if(!isNumber(startAge)){
			$("#startAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		var endAge=$("#endAge").val();
		if(!isNumber(endAge)){
			$("#endAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		if(startAge&&endAge&&Number(startAge) > Number(endAge)){
			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	function checkDate(){
		var reportCreateStartDate=$("#reportCreateStartDate").val();
		var reportCreateEndDate=$("#reportCreateEndDate").val();
		if(reportCreateStartDate&&reportCreateEndDate&&new Date(reportCreateStartDate)>new Date(reportCreateEndDate)){
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	
	// 查询报卡列表
	function searchReportList(indexPage)
	{
		if(!checkAge()){
			return;
		}
		if(!checkDate()){
			return;
		}
		var param = {
			pageIndex : indexPage
		};
		var submitFormLoadHtmlOption = {
			url : '/cdm/reportcard/list',
			param : param,
			insertDiv : 'list_datagrid',
			callback : addTrHoverEvent
		};
		lastPageIndex = indexPage;
		$("#form_search").submitFormLoadHtml(submitFormLoadHtmlOption);
	}
	function showList()
	{
		$("#list_view").show();
		$("#input_view").hide();
	}
	function showDetail()
	{
		$("#list_view").hide();
		$("#input_view").show();
	}
	function saveToMange(event)
	{
		var selectedTr = $("#reportCard_table").find("tr.listtrselect");
		if (selectedTr.length < 1)
		{
			layer.alert("请选中一行！", {icon:0,title:'提示'});
		} else
		{
			var selectedValue = selectedTr.find("input.selectedValue").val();
			var option = {
				url : "/cdm/standardization/manage",
				param : {
					personId : selectedValue
				},
				wait:true,
				callback : function(data)
				{
					if (data.constructor == Array && data.length > 0)
					{
						var tip = "";
						for ( var i = 0, size = data.length; i < size; i++)
						{
							tip += errorMsg[data[i]] + "\n";
						}
						layer.alert(tip, {icon:0,title:'提示'});
					} else
					{
						$("#list_view").hide();
						$("#manage_view").show();
						$("#manage_view").html(data);
					}
				}
			};
			$.getJsonByUrl(option);
		}
	}

    function exportList() {
        var option={
            url:"/cdm/reportcard/listExcel",
            param:{}
        };
        $("#form_search").exportListExcel(option);
    }

	function refresh()
	{
		searchReportList(lastPageIndex);
	}

	function toggle(obj, tableId)
	{
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	function StartRead()//开始读卡
	{
		if (GT2ICROCX.GetState() == 0){
			GT2ICROCX.ReadCard()
		}
		//GT2ICROCX.ReadCard() //循环读卡

		$("#idcard").val(GT2ICROCX.CardNo);
	}

	return {
		search : searchReportList,
		showList : showList,
		refresh : refresh,
		toggle : toggle
	};

})();