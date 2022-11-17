var healthCardList = (function () {
    $(function () {
        search(1);

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
        $("#ncp-manage-input-btn").on("click", addCard);
        // 查看
        $("#diseaseInfo").on("click", ".report-link", viewCard);
        //删除
        $("#diseaseInfo").on("click", ".delete-link", deleteCard);
        //编辑
        $("#diseaseInfo").on("click", ".update-link", updateCard);
        
        //伸缩查询form
        $("#health-card-search-toggle-btn").on("click", toggle);

        //多选初始化
        $("select[multiple]").each(function () {
            $(this).multiselect({
                header: false,
                noneSelectedText: '请选择人群分类',
                selectedList: 13
            });
        });

        $("#ncp-manage-export-btn").click(function () {
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
            url: "/ncp/healthManageCard/excel",
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
        $("#ncp-manage-list-box").hide();
        $("#ncp-manage-input-box").show();
        var loadHtmlByUrlOption = {
            url: "/ncp/healthManageCard/input",
            insertDiv: "ncp-manage-input-box",
            param : {
                dialogId:""//其他页面用参数
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function viewCard(event) {
        event.preventDefault();
        $("#ncp-manage-list-box").hide();
        $("#ncp-manage-input-box").show();
        var loadHtmlByUrlOption = {
            url: "/ncp/healthManageCard/view/" + $(this).data("disid"),
            insertDiv: "ncp-manage-input-box",
            param : {
                dialogId:""//其他页面用参数
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function deleteCard(event){
    	
    	
    	/*msgUtil.confirm("撤销管理卡将删除其相关的全部信息，确认撤销？", function() {
			$.getJsonByUrl({
				url:"/ncp/healthManageCard/delete/" + $(".delete-link").attr("data-disid"),
				callback:function(data){
					if (data == "success") {
						search(1);
						layer.alert("撤销成功！");
					} else if (data == "fail") {
						layer.alert("撤销失败！");
					}
				},
				param: {
				}
			});
		});*/
    	
    	layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('撤销管理卡将删除其相关的全部信息，确认撤销？', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/ncp/healthManageCard/delete/" + $(".delete-link").attr("data-disid"),
					callback : function(data){
						if(data == "success") {
							layer.alert("撤销成功！", {icon:0,title:'提示'}, function() {
								layer.closeAll();
								search(1);
							});
						} else if (data == "fail") {
							layer.alert("撤销失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
    }
    
    function updateCard(event) {
        event.preventDefault();
        $("#ncp-manage-list-box").hide();
        $("#ncp-manage-input-box").show();
        var loadHtmlByUrlOption = {
            url: "/ncp/healthManageCard/edit/" + $(this).data("disid"),
            insertDiv: "ncp-manage-input-box",
            param : {
                dialogId:""//其他页面用参数
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
    function selectMdmType(event) {
        event.preventDefault();
        var id = $(this).data("disid");
        var pageIndex = $("#currentPage").val();
        var dialogParams = {
            id : "rollbackDiv",
            url : "/cdm/standardization/rollback/selected/type",
            param : {
                id : id
            },
            height : 300,
            width : 600,
            title : "选择撤销病种"
        };
        $.dialog(dialogParams);
    }

    function refreshList(data) {
        if(data == true) {
            layer.alert("撤销成功！", {icon:0,title:'提示'}, function() {
                layer.closeAll();
                search(1);
            });
        } else if (data == "fail") {
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
        return true;
    }



    function search(indexPage) {
        if (!checkAge()) {
            return;
        }
        var searchObj = {
            url: "/ncp/healthManageCard/healthCardList",
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