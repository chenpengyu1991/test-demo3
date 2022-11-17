var hmManageSearch = (function() {
	$(function() {
		var validate = $("#searchForm").easyValidate();
		$("#searchButton").click(function() {
			var result = validate.validateForm();
			if (result) {
				search(1);
			} else {
				layer.alert("根据提示正确填写！", {icon:0,title:'提示'});
			}
		});
		$("#searchForm").onEnter(search, 1);
		init('organCode','B1,B2',[]);//社区卫生服务站
		search(1);
		$("#btnReflash").click(function() {
			reflashVerifyList();
		});

		$("#ehr-person-export-btn").click(function() {
			var result = validate.validateForm();
			if (result) {
				exportList();
			} else {
				layer.alert("根据提示正确填写！", {icon:0,title:'提示'});
			}
		});
	});

	function exportList() {
		var option={
			url:"/hm/manage/personRecord/exportTable",
			param:{orgCode : $("#inputOrganCode").val()}
		};
		$("#searchForm").exportListExcel(option);
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
	function search(index) {
		var searchObj = {
			url : "/hm/manage/tableSearch",
			insertDiv : "reportListDiv",
			param : {
				indexPage : index
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	function showStatus(val){
		if(val==1){
			$("select[name=estimateStatus]").val("");
			$("select[name=healthGuideStatus]").val("");
			$("select[name=estimateStatus]").attr("disabled",true);
			$("select[name=healthGuideStatus]").attr("disabled",true);
		}else{
			$("select[name=estimateStatus]").removeAttr("disabled");
			$("select[name=healthGuideStatus]").removeAttr("disabled");
		}
	}
	
	return {
		search : search,
		toggle : toggle,
		showStatus:showStatus
	}
})();