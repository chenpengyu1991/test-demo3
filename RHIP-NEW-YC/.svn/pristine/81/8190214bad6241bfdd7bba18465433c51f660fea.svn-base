var healthCardList = (function () {
    $(function () {
        search(1);

        // 高级查询条件显示控制
        $("#perAdvanceSearchConditionBtn").click(function(e) {
            e.preventDefault();
            controlAdvanceSearchSection($(this));
        });

        //添加回车监听事件
        $('input').keypress(function (e) {
            var key = e.which;
            if (key == 13) {
                search(1);
            }
        });

        $("#idCard").keyup(function () {
            var idCardValue = $("#idCard").val();
            $("#idCard").attr("value", idCardValue.toUpperCase());
        });

        $("#per_search_btn").click(function (e) {
        	e.preventDefault();
            search(1);
        });
        //增加
        $("#cdm-manage-input-btn").on("click", addCard);
        // 查看
        $("#diseaseInfo").on("click", ".report-link", viewCard);
        //删除
        $("#diseaseInfo").on("click", ".delete-link", selectMdmType);
        //伸缩查询form
        $("#health-card-search-toggle-btn").on("click", toggle);

        //多选初始化
        /*$("select[multiple]").each(function () {
            $(this).multiselect({
                header: false,
                noneSelectedText: '请选择患病类型',
                selectedList: 13
            });
        });*/

        $("#cdm-manage-export-btn").click(function (e) {
        	e.preventDefault();
            exportList();
        });

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

    function exportList() {

        var option = {
            url: "/cdm/standardization/excel",
            param: {isCancel: false}
        };
        $("#form_search").exportListExcel(option);

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
            url: "/cdm/standardization/input",
            insertDiv: "cdm-manage-input-box"
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function viewCard(event) {
        event.preventDefault();
        $("#cdm-manage-list-box").hide();
        $("#cdm-manage-input-box").show();
        var loadHtmlByUrlOption = {
            url: "/cdm/standardization/view/" + $(this).data("disid"),
            insertDiv: "cdm-manage-input-box"
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function selectMdmType(event) {
        event.preventDefault();
        var id = $(this).data("disid");
        var pageIndex = $("#currentPage").val();
        /*var dialogParams = {
            id : "rollbackDiv",
            url : "/cdm/standardization/rollback/selected/type",
            param : {
                id : id
            },
            height : 300,
            width : 600,
            title : "选择撤销病种"
        };
        $.dialog(dialogParams);*/
        
        $.post(contextPath+'/cdm/standardization/rollback/selected/type',
        		{ id : id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'rollbackDiv',
        			  area: ['600px', '300px'],
        			  title:'选择撤销病种',
        			  content: ret
        		  });
        		});
        	});
    }

    function refreshList(data) {
        if (data == true) {
            var index = layer.alert("撤销成功！", {icon:0,title:'提示'}, function() {
                /*$.removeDialog("rollbackDiv");*/
                layer.closeAll();
                search(1);
            });
        } else {
        	layer.alert("撤销失败！", {icon:0,title:'提示'});
        }
    }

    function isNumber(val) {
        if (val) {
            return val.match(/(\d+)|(^(\d+.\d+)$)/);
        }
        return true;
    }

    function checkAge() {
    	layui.use('layer', function(){
			var layer = layui.layer;
			var startAge = $("#startAge").val();
			if (!isNumber(startAge)) {
				$("#startAge").val("");
				layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
				return false;
			}
			var endAge = $("#endAge").val();
			if (!isNumber(endAge)) {
				$("#endAge").val("");
				layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
				return false;
			}
			if (startAge && endAge && Number(startAge) > Number(endAge)) {
				layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
				return false;
			}
		});
        return true;
    }


    function checkSelectedDisType() {
        var $form = $("#form_search");
        var isManagedFlag = $form.find("input[name='isManagedFlag']:checked").val();
        var managedDateStart = $form.find("input[name='managedDateStart']").val();
        var managedDateEnd = $form.find("input[name='managedDateEnd']").val();

        if (isManagedFlag || managedDateEnd || managedDateStart) {
            var selectedDisType = $form.find("#disTypeSelect").val();
            layui.use('layer', function(){
				var layer = layui.layer;
				if (selectedDisType) {
					if ($.isArray(selectedDisType) && selectedDisType.length > 1) {
						layer.alert("查询管理状态和纳入管理时间时只能选择一种患病类型！", {icon:0,title:'提示'});
						return false;
					}
				} else {
					layer.alert("查询管理状态和纳入管理时间时需要选择一种患病类型！", {icon:0,title:'提示'});
					return false;
				}
			});
        }
        return true;
    }

    function search(indexPage) {
        if ((!checkAge())||(!checkSelectedDisType())) {
            return;
        }
        var managedDateStart = new Date($("#managedDateStart").val());
		var managedDateEnd = new Date($("#managedDateEnd").val());

		if (managedDateStart > managedDateEnd)
		{
			layui.use('layer', function(){
				var layer = layui.layer;
				
				layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			});
			return;
		}
		
        var searchObj = {
            url: "/cdm/standardization/healthCardList",
            insertDiv: "diseaseInfo",
            param: {
                pageIndex: indexPage
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
    }


    return {
        search: search
    };
})
    ();