var hmVerifySearch = (function() {
	var validate = $("#searchForm").easyValidate();
	$(function() { 
		    $("#inputExamYear").val(new Date().getFullYear());
            $("#searchForm").onEnter(search, 1);
            $("#btnSearch").click(function() {
                search(1);
            });
            $("#btnConfirm").click(function() {
            	confirmPerson();
            });
            $("#btnReflash").click(function() {
            	reflashVerifyList();
            });
            $("#btnConfirmAll").click(function() {
            	confirmAll();
            });
            $("#btnDownExcel").click(function() {
            	downExcel();
            });
            $("#btnCancelConfirm").click(function() {
            	cancelConfirmPerson();
            });
        init('organCode','B1,B2',['0']);//社区卫生服务站

        search(1);
	});

    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
    function init(orgId,orgType,unSelectType){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectTreeFun
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectBoxFun
        };

        var hospitalCode=$("#" + orgId);
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }
    /**
     * 机构下拉树回调
     * 设置当前选择机构的类型
     */
    function selectTreeFun(data){
        $('#selectCodeType').val(data.type);
    }
    /**
     * 机构自动检索回调
     * 设置当前选择机构的类型
     */
    function selectBoxFun(data){
        $('#selectCodeType').val(data.attr('genreCode'));
    }


    function confirmAll() {
    	var index = layer.confirm("确定要对当前所有符合条件的人员核实确认吗？", {icon:1, title:'确认提示'}, function(){
//			$("#btnConfirmAllLabel").html("核实确认中，请稍等...");
//			$("#btnConfirmAll").click(function() {
//
//			});
			var searchObj = {
				url : "/hm/verify/confirmAll",
				callback : confirmAllCallback,
                wait:true
			};
			$("#searchForm").submitFormGetJson(searchObj);
			layer.close(index);
		});
	}
	
	function confirmAllCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		$("#btnConfirmAllLabel").html("全部核实确认");
		$("#btnConfirmAll").click(function() {
			confirmAll();
        });
		if (data.success) {
			search(1);
		}
	}
	
	function downExcel() {
		/*
		var searchObj = {
			url : "/hm/verify/downExcel",
			insertDiv : "excelDownDiv"
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
		 */
		location.href = contextPath + "/hm/verify/downExcel";
	}
	
	function downExcelCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
	}
	
	function reflashVerifyList() {
		$("#btnReflashLabel").html("更新中，请稍等...");
		$("#btnReflash").click(function() {});
		var params = {
				url : "/hm/verify/reflashVerify",
				callback : reflashVerifyCallback,
				wait : true
		};
		$.getJsonByUrl(params);
	}
	
	function reflashVerifyCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		$("#btnReflashLabel").html("更新名单");
		$("#btnReflash").click(function() {
        	reflashVerifyList();
        });
		if (data.success) {
			search(1);
		}
	}
	
	function confirmPerson() {
		var personIds = "";
		$("input:checkbox[chkRef='personId']:checked").each(function(index) {
			if (index>0)  personIds += ",";
			personIds += $(this).val();
		});
		if (personIds.length==0) {
			showError("至少选择一个人");
			return;
		}
		var index = layer.confirm("确定要对选择的人员核实确认吗？", {icon:1, title:'确认提示'}, function() {
			var params = {
					url : "/hm/verify/confirm",
					callback : confirmCallback,
					param : {
						personIds : personIds
					}
			};
			$.getJsonByUrl(params);
			layer.close(index);
		});
	}
	
	function cancelConfirmPerson() {
		var personIds = "";
		$("input:checkbox[chkRef='personId']:checked").each(function(index) {
			if (index>0)  personIds += ",";
			personIds += $(this).val();
		});
		if (personIds.length==0) {
			showError("至少选择一个人");
			return;
		}
		var index = layer.confirm("确定要对选择的人员取消核实吗？", {icon:1, title:'确认提示'}, function() {
			var params = {
					url : "/hm/verify/cancelConfirm",
					callback : confirmCallback,
					param : {
						personIds : personIds
					}
			};
			$.getJsonByUrl(params);
			layer.close(index);
		});
	}
	
	function showError(msg) {
		layer.alert(msg, {icon:0,title:'提示'});
	}
	
	function confirmCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.success) {
			search($("#currentPage").val());
		}
	}

	function search(indexPage) { 
		if (validate.validateForm()) {
			var beginAge = $("#beginAge").val();
			var endAge = $("#endAge").val();
			if (($.isEmpty(beginAge) && !$.isEmpty(endAge))
					|| (!$.isEmpty(beginAge) && $.isEmpty(endAge))) {
				layer.alert("年龄区间不能只填写一个值！", {icon:0,title:'提示'});
				return;
			}
			
			if (Number(beginAge) > Number(endAge)) {
				layer.alert("后置年龄不能小于前置年龄！", {icon:0,title:'提示'});
				return;
			}
			var searchObj = {
				url : "/hm/verify/search",
				insertDiv : "verifyListDiv",
				param : {
					indexPage : indexPage
				}
			};
			$("#searchForm").submitFormLoadHtml(searchObj);
		}
	};

	return {
		search : search
	};
})();