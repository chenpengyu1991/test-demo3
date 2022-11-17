define(function() {
	var validate=null;
    function load(){
        $(function () {
        	//分页绑定函数
			pageUtil.bind("unusualResultDiv",search);
            validate = $("#unusualSearchForm").easyValidate();
            $("#unusualBtnSearch").click(function () {
                search(1);
            });
            $("#unusualSearch").onEnter(search, 1);
//        search(1);
            init();
            $("#ldaUnusualSearchReturn").click(function () {
                returnSearch();
            });
        });
    }
	function init(){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:['0']  //不能选择：0是镇，B1是中心
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:"A1,B1,B2"}  //只查询B1（即所有站）
        };

        var hospitalCode=$("#hospitalCode");
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }
    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/lda/largeDataAnalysis/searchUnusual/list",
            insertDiv : "unusualResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
                initLinkClick('ldaUnusualDetailId',prescription, {ehrId:"data-ehrid",recordNumber:"data-recordnumber"});
            }
        };
        $("#unusualSearchForm").submitFormLoadHtml(searchObj);
    };

    function returnSearch(pageIndex){
        var pageIndex = $('#pageIndex').val();
        search(pageIndex);
        $("#unusualDetailDiv").empty();
        $("#top_all").show();
    }

    function monitorValueChange(monitorIndex){
    	$("select[name='monitorValue']").empty();
    	if(monitorIndex=='1'){
    		$("select[name='monitorValue']").append("<option value=\"300\">大于300</option>");
    	}else if(monitorIndex=='2'){
    		$("select[name='monitorValue']").append("<option value=\"10\">大于10</option>");
    	}else if(monitorIndex=='3'){
    		$("select[name='monitorValue']").append("<option value=\"5\">大于5</option>");
    	}else if(monitorIndex=='4'){
    		$("select[name='monitorValue']").append("<option value=\"5\">大于5</option>");
    	}
    }

    /**
     * 获取处方详细
     */
    function prescription(ehrId,recordNumber){
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/daily/unusual/prescription",
            insertDiv :"unusualDetailDiv",
            param : {ehrId:ehrId,recordNumber:recordNumber},
            wait:true
        });
        $("#unusualDetailDiv").show();
    }

	return {
        load:load,
		search:search,
		returnSearch:returnSearch,
		monitorValueChange:monitorValueChange,
		prescription:prescription
	};
});



