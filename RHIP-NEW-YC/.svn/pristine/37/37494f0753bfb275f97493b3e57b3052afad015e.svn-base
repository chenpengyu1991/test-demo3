var pFPSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#pFPSearchDivId").easyValidate();
    	$("#pFPSearchDivId").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
        });
        search(1);
        $("#pFPAddButId").on("click", function() {
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
        var url = '/prenatalFollowup/fisrt/list';

        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : url,
            insertDiv : "pFPListDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#pFPSearchForm").submitFormLoadHtml(searchObj);
    };


    function getPrenatalFollowup(prenatalId){
        $("#pFPSearchDivId").hide();
        $("#pFPDetailDiv").show();
        var loadHtmlByUrlOption = {
            url: "/prenatalFollowup/fisrt/add",
            insertDiv: "pFPDetailDiv",
            param: {
                prenatalId: prenatalId
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function viewPrenatalFollowup(prenatalId){
        $("#pFPSearchDivId").hide();
        $("#pFPDetailDiv").show();
        var loadHtmlByUrlOption = {
            url: "/prenatalFollowup/fisrt/view",
            insertDiv: "pFPDetailDiv",
            param: {
                prenatalId: prenatalId
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function deletePrenatalFollowup(prenatalId){
		if (!prenatalId)
		{
			return;
		}
		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/prenatalFollowup/fisrt/delete",
					param:{
                    	prenatalId:prenatalId
               		},
					callback : function(data) {
						if (data == "success") {
							layer.close(index);
							search($("#currentPage").val());
							layer.alert("删除成功！", {icon:0,title:'提示'});
						} else {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
    }

	return {
		search: search,
        getPrenatalFollowup: getPrenatalFollowup,
        deletePrenatalFollowup: deletePrenatalFollowup,
        viewPrenatalFollowup: viewPrenatalFollowup
	};
})();



