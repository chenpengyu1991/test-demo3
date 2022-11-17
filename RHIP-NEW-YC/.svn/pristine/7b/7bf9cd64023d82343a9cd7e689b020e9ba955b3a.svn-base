var echChildrenSearch = (function() {
	var validate = null;
	$(function() {
		validate = $("#searchForm").easyValidate();
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
				/*layer.alert("根据提示正确填写");*/
			}
		});
		$("#searchForm").onEnter(search, 1);
		init('organCode','B100,B200',[]);//社区卫生服务站
		manageSearch(1);
	});

	function manageSearch(pageIndex) {
    pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/ech/children/list",
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
      $("#maindetailDiv").hide();
        manageSearch();
        $("#echSearchId").show();
    }
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
    /**
     * 初始化记录表页面
     */
	function initReport(personId,editflag){
		$("#echSearchId").hide();
		$.loadHtmlByUrl({
			url : '/ech/children/report',
			insertDiv :"maindetailDiv",
            param : {
            	examFlag:editflag,
            	examRecordId:personId
            },
            callback:function(){

            }
		});
		$("#maindetailDiv").show();
	}

    /**
     * 删除记录
     */
    function delReport(reportId){
        $("#echSearchId").hide();
        $.loadHtmlByUrl({
            url : '/ech/children/delReport',
            insertDiv :"maindetailDiv",
            param : {
                reportId:reportId
            },
            callback: function (data) {
                if(1 == data){
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
            				layer.close(index);
            				returnSearch();
            			});
            		});
                }
            }
        });
    }

  function returnSearch() {
    	layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm("确认离开？", {icon:1, title:'确认提示'}, function() {
				layer.close(index);
				search();
			});
		});
     /* msgUtil.backConfirm(function () {
        search();
      });*/
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
	return {
		manageSearch : manageSearch,
		returnSearch:returnSearch,
		toggle : toggle,
		initReport:initReport,
        delReport:delReport,
		search:search
	}
})();