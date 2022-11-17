var employeesSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
                e.preventDefault();
           search(1);
        });
        search(1);
        $('#followup-add-btn').click(function() {
            $('#child-exam-list-box').hide();
            $('#child-exam-input-box').show();
            $.loadHtmlByUrl({
                url: '/employees/add',
                insertDiv: 'child-exam-input-box',
                param: {
                    pageIndex: $('#pageIndex').val()
                }
            })
        });
        $('#addHealthCard').click(function() {
        	if($("input[name='checked']:checked").length==0){
        		layer.alert("请选择要生成健康证的人员！", {icon:0,title:'提示'});
        		return;
        	}
        	if($("input[name='checked']:checked").length>6){
        		layer.alert("生成健康证的人员不能大于6人！", {icon:0,title:'提示'});
        		return;
        	}
            $('#child-exam-list-box').hide();
            $('#child-exam-input-box').show();
            var idStr=",";
           $("input[name='checked']:checked").each(function(){
        	   idStr+=$(this).val()+",";
        	   
        	   
           });
            $.loadHtmlByUrl({
                url: '/employees/addHealthCard',
                insertDiv: 'child-exam-input-box',
                param: {
                	idStr:idStr,
                    pageIndex: $('#pageIndex').val()
                }
            })
        });
        init('organCode','B1,B2',[]);//社区卫生服务站
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var searchType = $("#searchType").val();
        var url = '/employees/list';
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : url,
            insertDiv : "employeesListDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };

    
    function viewNeonatalVisit(id){
        $('#child-exam-list-box').hide();
        $('#child-exam-input-box').show();
        $.loadHtmlByUrl({
            url: '/employees/view',
            insertDiv: 'child-exam-input-box',
            param: {
                id:id
            }
        })
    }

    function editViewNeonatalVisit(id){
        $('#child-exam-list-box').hide();
        $('#child-exam-input-box').show();
        $.loadHtmlByUrl({
            url: '/employees/add',
            insertDiv: 'child-exam-input-box',
            param: {
            	id:id
            }
        })
    }
    function deleteViewNeonatalVisit(id){
    	var index = layer.confirm("确定要删除吗？", {icon:2, title:'确认提示'}, function(){
			$.getJsonByUrl({
				url:"/employees/delete",
				param:{
					id:id
				},
				callback:function(data){
					var layer = layui.layer;
					if(data == "删除成功!"){
						var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
							$("#btnSearch").click();
							layer.close(index);
						});
					}else{
						layer.alert("删除失败！", {icon:0,title:'提示'});
					}
				}
			});
			layer.close(index);
		});
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
		search:search,
        viewNeonatalVisit:viewNeonatalVisit,
        editViewNeonatalVisit:editViewNeonatalVisit,
        deleteViewNeonatalVisit:deleteViewNeonatalVisit
	};
})();



