var pharmacyCancelSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#pharmacyCancelSearchForm").easyValidate();
        $("#pharmacyCancelBtnSearch").click(function(e) {
           e.preventDefault();
           search(1);
        });
        $("#pharmacyCancelSearch").onEnter(search, 1);
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
            url : "/da/drug/pharmacyCancel/list",
            insertDiv : "pharmacyCancelResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#pharmacyCancelSearchForm").submitFormLoadHtml(searchObj);
    };	

    /**
     * 药品出库详细查询
     * batchNo:批号
     */
    function detailSearch(batchNo){
    	var beginDt = $('#beginDt').val();
    	var endDt = $('#endDt').val();
    	
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/drug/pharmacyCancel/detail/search",
            insertDiv :"pharmacyCancelDetailDiv",
            param : {
            	batchNo:batchNo,
            	beginDt:beginDt,
            	endDt:endDt},
            wait:true
        });
        $("#pharmacyCancelDetailDiv").show();        	
    }
    
    function returnSearch(pageIndex){
        var pageIndex = $('#pageIndex').val();
        search(pageIndex);
        $("#pharmacyCancelDetailDiv").empty();
        $("#top_all").show();
    }    
	return {
		search:search,
		detailSearch:detailSearch,
		returnSearch:returnSearch
	};
})();



