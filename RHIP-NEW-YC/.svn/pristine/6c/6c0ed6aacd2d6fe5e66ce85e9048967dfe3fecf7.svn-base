var storageInSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#storageInSearchForm").easyValidate();
        $("#storageInBtnSearch").click(function(e) {
           e.preventDefault();
           search(1);
        });
        $("#storageInSearch").onEnter(search, 1);
        search(1); 
        init();
    });
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
            param:{organType:"B1,B2"}  //只查询B1（即所有站）
        };

        var hospitalCode=$("#organCode");
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
            url : "/da/drug/storageIn/list",
            insertDiv : "storageInResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#storageInSearchForm").submitFormLoadHtml(searchObj);
    };	

    /**
     * 药品入库详细查询
     * batchNo:批号
     */
    function detailSearch(batchNo){
    	var beginDt = $('#beginDt').val();
    	var endDt = $('#endDt').val();
    	
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/drug/storageIn/detail/search",
            insertDiv :"storageInDetailDiv",
            param : {
            	batchNo:batchNo,
            	beginDt:beginDt,
            	endDt:endDt},
            wait:true
        });
        $("#storageInDetailDiv").show();        	
    }
    
    function returnSearch(pageIndex){
        var pageIndex = $('#pageIndex').val();
        search(pageIndex);
        $("#storageInDetailDiv").empty();
        $("#top_all").show();
    }    
	return {
		search:search,
		detailSearch:detailSearch,
		returnSearch:returnSearch
	};
})();



