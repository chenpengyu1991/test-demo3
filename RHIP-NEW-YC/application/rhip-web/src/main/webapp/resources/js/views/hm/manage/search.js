var hmManageSearch = (function() {
	$(function() {
		var validate = $("#searchForm").easyValidate();

		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

		$("#searchButton").click(function(e) {
			e.preventDefault();
			var result = validate.validateForm();
			if (result) {
				search(1);
			} else {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("根据提示正确填写！", {icon:0,title:'提示'});
        		});
				/*msgUtil.alert("根据提示正确填写");*/
			}
		});
		$("#searchForm").onEnter(search, 1);
		init('organCode','B1,B2',[]);//社区卫生服务站
		search(1);
		$("#btnReflash").click(function(e) {
			e.preventDefault();
			reflashVerifyList();
		});

		$("#reportListDiv").on("click", ".add-link", add);
		
		$("#ehr-person-export-btn").click(function(e) {
			e.preventDefault();
			var result = validate.validateForm();
			if (result) {
				exportList();
			} else {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("根据提示正确填写！", {icon:0,title:'提示'});
        		});
				/*msgUtil.alert("根据提示正确填写");*/
			}
		});
	});

	function exportList() {
		var option={
			url:"/hm/manage/personRecord/export",
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
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.alert(data.message, {icon:0,title:'提示'});
		});
		/*msgUtil.alert(data.message);*/
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
			url : "/hm/manage/search",
			insertDiv : "reportListDiv",
			param : {
				indexPage : index
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}

	function add(event){
		event.preventDefault();
		var personId=$(this).data("personid");
		if (!personId){
			return;
		}
		$("#hm-manage-list-box").hide();
		$("#hm-manage-input-box").show();
		
		var loadHtmlByUrlOption = {
			url: "/hm/manage/edit",
			insertDiv: "hm-manage-input-box",
			param: {personId: personId, isInfo:1}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
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