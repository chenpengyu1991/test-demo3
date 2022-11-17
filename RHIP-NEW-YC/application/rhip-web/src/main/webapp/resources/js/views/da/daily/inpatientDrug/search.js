var inpatientDrugSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#inpatientDrugSearchForm").easyValidate();
        $("#inpatientBtnSearch").click(function() {
           search(1);
        });
        $("#inpatientDrugSearch").onEnter(search, 1);
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
            url : "/da/daily/inpatientDrug/list",
            insertDiv : "inpatientDrugResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#inpatientDrugSearchForm").submitFormLoadHtml(searchObj);
    };	
 
        /**
     * 药品详细查询
     */
    function drugSearch(hospitalCode,drugCostSum){
    	var prescribeDateBegin = $('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#prescribeDateEnd').val();
    	var patientType = $('#patientType').val();
    	
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/daily/inpatientDrug/drugsearch",
            insertDiv :"inpatientDrugDetailDiv",
            param : {
            	hospitalCode:hospitalCode,
            	detailType:"1",//1:药品费用详细，2：总费用详细
            	prescribeDateBegin:prescribeDateBegin,
            	prescribeDateEnd:prescribeDateEnd,
            	patientType:patientType,
            	drugCostSum:drugCostSum},
            wait:true
        });
        $("#inpatientDrugDetailDiv").show();        	
    }
    /**
     * 费用详细查询
     * hospitalCode:机构code
     * totalCostSum：药品费用合计
     */
    function itemSearch(hospitalCode,totalCostSum){
    	var prescribeDateBegin = $('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#prescribeDateEnd').val();
    	var patientType = $('#patientType').val();
    	
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/daily/inpatientDrug/itemsearch",
            insertDiv :"inpatientDrugDetailDiv",
            param : {
            	hospitalCode:hospitalCode,
            	prescribeDateBegin:prescribeDateBegin,
            	prescribeDateEnd:prescribeDateEnd,
            	patientType:patientType,
            	totalCostSum:totalCostSum},
            wait:true
        });
        $("#inpatientDrugDetailDiv").show();        	
    }    
    function returnSearch(pageIndex){
        var pageIndex = $('#pageIndex').val();
        search(pageIndex);
        $("#inpatientDrugDetailDiv").empty();
        $("#top_all").show();
    }
	return {
		search:search,
		returnSearch:returnSearch,
		drugSearch:drugSearch,
		itemSearch:itemSearch
	};
})();



