var pFOSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#pFOSearchDivId").easyValidate();
    	$("#pFOSearchDivId").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
        });
        search(1);
        $("#pFOAddButId").on("click", function() {
            getPrenatalFollowup("");
        });
        init('organCode','B1,B2',[]);//社区卫生服务站
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

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var searchType = $("#searchType").val();
        var url = '/prenatalFollowup/other/list';

        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : url,
            insertDiv : "pFOListDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#pFOSearchForm").submitFormLoadHtml(searchObj);
    };


    function getPrenatalFollowup(prenatalId){
        $("#pFOSearchDivId").hide();
        $("#pFODetailDiv").show();
        var loadHtmlByUrlOption = {
            url: "/prenatalFollowup/other/add",
            insertDiv: "pFODetailDiv",
            param: {
                prenatalId: prenatalId
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function viewPrenatalFollowup(prenatalId){
        $("#pFOSearchDivId").hide();
        $("#pFODetailDiv").show();
        var loadHtmlByUrlOption = {
            url: "/prenatalFollowup/other/view",
            insertDiv: "pFODetailDiv",
            param: {
                prenatalId: prenatalId
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function deletePrenatalFollowup(prenatalId){
    	var index = layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function() {
    		$.getJsonByUrl({
                url: "/prenatalFollowup/other/delete",
                callback:function(data){
                    if (data == "success") {
                        search($("#currentPage").val());
                        layui.use('layer', function() {
	            			var layer = layui.layer;
	            			layer.alert("删除成功！", {icon:0,title:'提示'});
	               		});
                    }else {
                        layui.use('layer', function() {
	            			var layer = layui.layer;
	            			layer.alert("删除失败！", {icon:0,title:'提示'});
	               		});
                    }
                },
                param:{
                    prenatalId:prenatalId
                }
            });

    		layer.close(index);
    	});
    }

    function checkDate(startDate,endDate,desp){
        if(startDate && endDate && new Date(startDate) > new Date(endDate)){
            layui.use('layer', function() {
    			var layer = layui.layer;
    			layer.alert(desp + "开始时间不能大于" + desp + "结束时间！", {icon:0,title:'提示'});
       		});
            return false;
        }
        return true;
    }

	return {
		search: search,
        getPrenatalFollowup: getPrenatalFollowup,
        deletePrenatalFollowup: deletePrenatalFollowup,
        viewPrenatalFollowup: viewPrenatalFollowup
	};
})();



