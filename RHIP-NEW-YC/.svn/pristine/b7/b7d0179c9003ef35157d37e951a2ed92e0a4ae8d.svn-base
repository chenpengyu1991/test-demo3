var womenHealth = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
        });
        search(1);
        init('orgCode','B1,B2',[]);//社区卫生服务站
        $("#ehr-person-export-btn").click(function() {
            exportList();
        });

        $("#gjBtn").click(function(e) {
            e.preventDefault();
            controlAdvanceSearchSection($(this));
        });
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var searchType = $("#searchType").val();
        var url = '/wonmenHealth/list';
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : url,
            insertDiv : "womenListDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };
    
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
    function exportList() {
        var option={
            url:"/wonmenHealth/export",
            param:{}
        };
        $("#searchForm").exportListExcel(option);
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


    function record(idcard) {
        /*var childLink = {
            id:"wonmenHealth",
            url :"/wonmenHealth/wonmanVisitList/"+idcard,
            height : 650,
            width : 1000,
            title : "孕产妇随访记录管理"
        };
        $.dialog(childLink);*/



	$.post(contextPath+"/wonmenHealth/wonmanVisitList/"+idcard,
		function(ret) {
    	layui.use(['layer'], function() {
    		  var layer = layui.layer
    		  layer.open({
    			  type: 1,
    			  id:'wonmenHealth',
    			  area: ['1000px', '700px'],
    			  title:'孕产妇随访记录管理',
    			  content: ret
    		  });
    		});
    	});
    };
    
    function follow(idCard) {
        $('#wonmenRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/wonmenHealth/fisrt/list',
            insertDiv: 'wonmenRecordContent',
            param: {
                idCard: idCard
            }
        })
    }
    function follow1(idCard) {
        $('#wonmenRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/wonmenHealth/other/list',
            insertDiv: 'wonmenRecordContent',
            param: {
                idCard: idCard
            }
        })
    }
    function delivery1(personId){
        var loadHtmlByUrlOption = {
            url: "/ehr/delivery/delivery",
            param : {personId:personId,type:'dialogView'},
            insertDiv: "wonmenRecordContent",
            callback:function () {
                $('#womenhide').hide();
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
    function follow2(idCard) {
        $('#wonmenRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/wonmenHealth/delivery',
            insertDiv: 'wonmenRecordContent',
            param: {
                idCard: idCard
            }
        })
    }
    function follow3(idCard) {
        $('#wonmenRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/wonmenHealth/woman/postnatalFollowup/list',
            insertDiv: 'wonmenRecordContent',
            param: {
                idCard: idCard
            }
        })
    }
    function follow4(idCard) {
        $('#wonmenRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/wonmenHealth/woman/postpartum/list',
            insertDiv: 'wonmenRecordContent',
            param: {
                idCard: idCard
            }
        })
    }
    function viewPrenatalFollowup(prenatalId){
        $('#wonmenRecordContent').empty();
        var loadHtmlByUrlOption = {
            url: "/wonmenHealth/fisrt/view",
            insertDiv: "wonmenRecordContent",
            param: {
                prenatalId: prenatalId
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
    function viewPrenatalFollowup1(prenatalId){
        $('#wonmenRecordContent').empty();
        var loadHtmlByUrlOption = {
            url: "/wonmenHealth/other/view",
            insertDiv: "wonmenRecordContent",
            param: {
                prenatalId: prenatalId
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function getPostnatalFollowup(id){
        var loadHtmlByUrlOption = {
            url: "/ehrbrowser/health/postnatalFollowup",
            param : {id:id,type:'dialogView'},
            insertDiv: "wonmenRecordContent",
            callback:function () {
                $('#womenhide').hide();
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
    function postpartum1(id){
        var loadHtmlByUrlOption = {
            url: "/ihm/postpartum",
            param : {personId:id,type:'dialogView'},
            insertDiv: "wonmenRecordContent",
            callback:function () {
                $('#womenhide').hide();
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
	return {
		search:search,
        record:record,
        follow:follow,
        follow1:follow1,
        follow2:follow2,
        follow3:follow3,
        follow4:follow4,
        delivery1:delivery1,
        getPostnatalFollowup:getPostnatalFollowup,
        viewPrenatalFollowup:viewPrenatalFollowup,
        viewPrenatalFollowup1:viewPrenatalFollowup1,
        postpartum1:postpartum1
	};
})();



