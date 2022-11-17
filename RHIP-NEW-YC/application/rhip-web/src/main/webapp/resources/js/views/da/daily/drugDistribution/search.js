var drugDistributionSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#drugDistributionSearchForm").easyValidate();
        $("#drugDistributionBtnSearch").click(function(e) {
            e.preventDefault();
           search(1);
        });
        
        $("#drugDistributionResultDiv").on("click", ".storage-in-link",detailSearch);
        $("#drugDistributionResultDiv").on("click", ".storage-link",detailSearch);
        $("#drugDistributionResultDiv").on("click", ".pharmacy-link",detailSearch);
        $("#drugDistributionResultDiv").on("click", ".clinic-link",detailSearch);
        $("#drugDistributionSearch").onEnter(search, 1);
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
            url : "/da/daily/drugDistribution/list",
            insertDiv : "drugDistributionResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#mainPageIndex").val(pageIndex);
            }
        };
        $("#drugDistributionSearchForm").submitFormLoadHtml(searchObj);
    };	
    
    /**
     * 药品入库详细查询
     * type：类型，药库入库、药库库存、药房库存、科室库存
     */
    function detailSearch(type){
    	var type = $(this).data('type');
    	var firstDt = $('#beginDt').val();
    	var lastDt = $('#endDt').val();
    	var organCode = $(this).data('organCode');
    	var medicareCode = $(this).data('medicareCode');
    	var genericName = $(this).data('genericName');
    	var urlString = "/da/daily/drugDistribution/";
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/daily/drugDistribution/detailSearch",
            insertDiv :"drugDistributionDetailDiv",
            param : {
            	hospitalCode:organCode,
            	medicareCode:medicareCode,
            	genericName:genericName,
            	firstDt:firstDt,
            	lastDt:lastDt,
            	type:type},
            wait:true
        });
        $("#drugDistributionDetailDiv").show();        	
    }
    function returnSearch(pageIndex){
        var pageIndex = $('#mainPageIndex').val();
        search(pageIndex);
        $("#drugDistributionDetailDiv").empty();
        $("#top_all").show();
    }
	return {
		search:search,
		detailSearch:detailSearch,
		returnSearch:returnSearch
	};
})();



