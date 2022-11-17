var echManageSearch = (function() {
	var validate = null;
	$(function() {
		validate = $("#searchForm").easyValidate();
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

		$("#searchButton").click(function(e) {
			e.preventDefault();
			var result = validate.validateForm();
			if (result) {
				manageSearch(1);
			} else {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("根据提示正确填写！", {icon:0,title:'提示'});
        		});
			}
		});
		$("#searchForm").onEnter(search, 1);
		init('organCode','B100,B200',[]);//社区卫生服务站
		manageSearch(1);

        $("#tzbs-export-btn").click(function (e) {
            e.preventDefault();
        	exportList();
        });
        // 查看所有体质辨识
		$("#mainResultDiv").on("click", ".phy-link", personEchList);
		$("#mainResultDiv").on("click", ".add-link", add);

	});

	function personEchList(event){
		event.preventDefault();
		var personId=$(this).data("personid");
		if(!personId){
			return;
		}
		$("#ech-manage-list-box").hide();
		$("#ech-manage-input-box").show();
		var loadHtmlByUrlOption = {
			url : "/ech/manage/perEchList",
			insertDiv : "ech-manage-input-box",
			param:{personId:personId}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	function manageSearch(pageIndex) {
		pageIndex = ($.isEmpty(pageIndex)?$('#pageIndex').val():pageIndex);	
		var searchObj = {
			url : "/ech/manage/list",
			insertDiv : "mainResultDiv",
			param : {
				indexPage : pageIndex
			},
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}
    function search(){
        disableChangeConfirm();
        $("#maindetailDiv").empty();
        manageSearch();
        $("#ech-manage-list-box").show();
    }
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
//    /**
//     * 初始化记录表页面
//     */
//	function initReport(personId,editflag){
//		$("#echSearchId").hide();
//		$.loadHtmlByUrl({
//			url : '/ech/manage/report/init',
//			insertDiv :"maindetailDiv",
//            param : {
//            	examRecordId:personId,
//            	editflag:editflag,
//            	sourceFlag:'1'
//            }
//		});
//		$("#maindetailDiv").show();		
//	}
    function returnSearch(){
        if(contentChanged){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			var index = layer.confirm("确认离开？", {icon:1, title:'确认提示'}, function() {
    				layer.close(index);
    				search();
    			});
    		});
        	/*msgUtil.backConfirm(function(){
				search();
			});*/        	
        }else{
        	search();
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

    function exportList() {
        var pageNum = $('#pageIndex').val();debugger;
        var option = {
            url: "/ech/manage/excel",
            param : {
                indexPage : pageNum
            }
        };
        $("#searchForm").exportListExcel(option);

    }
    
	function add(event){
		var type = $(this).data("type");
		var personId = $(this).data("personid");
		
		if (!personId){
			return;
		}
		$("#ech-manage-list-box").hide();
		$("#ech-manage-input-box").show();
		
		var loadHtmlByUrlOption = {
			url: "/ech/manage/report/init",
			insertDiv: "ech-manage-input-box",
			param: {personId:personId, editflag: type, sourceFlag:"1", isInfo:1}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	return {
		manageSearch : manageSearch,
		returnSearch:returnSearch,
		toggle : toggle
	}
})();