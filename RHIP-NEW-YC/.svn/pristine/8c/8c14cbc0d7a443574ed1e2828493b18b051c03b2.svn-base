var cdmStandardizationCancel= (function()
{
	$(function()
	{
		search(1);

		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

		/* 管理卡查询 */
		// $("#per_search_btn").onEnter(search, 1);
		// 添加回车监听事件
		$('input').keypress(function(e)
		{
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});

		$("#idCard").keyup(function()
		{
			var idCardValue = $("#idCard").val();
			$("#idCard").attr("value", idCardValue.toUpperCase());
		});

		$("#per_search_btn").click(function(e)
		{
			e.preventDefault();
			search(1);
		});
		// 查看管理卡信息
		$("#diseaseInfo").on("click", ".report-link", viewCard);
		$("#diseaseInfo").on("click", ".renew-link", selectMdmType);
		$("#health-card-search-toggle-btn").on("click", toggle);

		/*$("select[multiple]").each(function()
		{
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择患病类型',
				selectedList : 13
			});
		});*/

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

	function toggle()
	{
		$(this).toggleClass("ico-top");
		$(this).toggleClass("ico-bottom");
		$("#health-card-search-table").toggle();
	}

    function selectMdmType(event) {
        event.preventDefault();
        var id = $(this).data("disid");
        var pageIndex = $("#currentPage").val();
       /* var dialogParams = {
            id : "renewDiv",
            url : "/cdm/standardization/renew/selected/type",
            param : {
                id : id
            },
            height : 300,
            width : 600,
            title : "选择恢复病种"
        };
        $.dialog(dialogParams);*/
        $.post(contextPath+'/cdm/standardization/renew/selected/type',
        		{ id : id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'cdmRecoveryDialog',
        			  area: ['600px', '300px'],
        			  title:'选择恢复病种',
        			  content: ret
        		  });
        		});
        	});
    }

	function refreshList(data) {
		if (data == 't') {
			layer.alert("恢复成功！", {icon:0,title:'提示'});
			search(1);
		} else if (data == 'e') {
			layer.alert("此患者的慢病管理卡已经新建所以此管理卡不可以恢复！", {icon:0,title:'提示'});
        } else {
        	layer.alert("恢复失败！", {icon:0,title:'提示'});
		}
	}

	function viewCard(event)
	{
		event.preventDefault();
		$("#cdm-manage-list-box").hide();
		$("#cdm-manage-input-box").show();
		var loadHtmlByUrlOption = {
			url : "/cdm/standardization/view/" + $(this).data("disid"),
			insertDiv : "cdm-manage-input-box"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function checkAge()
	{
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
	function isNumber(val)
	{
		if (val)
		{
			return val.match(/(\d+)|(^(\d+.\d+)$)/);
		}
		return true;
	}

	function search(indexPage)
	{
		if (!checkAge())
		{
			return;
		}
		var searchObj = {
			url : "/cdm/standardization/cancelList",
			insertDiv : "diseaseInfo",
			param : {
				pageIndex : indexPage
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}

	return {
		search : search,
		showList : showList
	};
})();