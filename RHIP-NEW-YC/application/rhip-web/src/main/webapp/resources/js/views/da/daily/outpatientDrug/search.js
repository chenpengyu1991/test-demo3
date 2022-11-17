var outpatientDrugSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#outpatientDrugSearchForm").easyValidate();
        $("#outpatientBtnSearch").click(function() {
           search(1);
        });
        $("#outpatientDrugSearch").onEnter(search, 1);
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
            url : "/da/daily/outpatientDrug/list",
            insertDiv : "outpatientDrugResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#outpatientDrugSearchForm").submitFormLoadHtml(searchObj);
    };	
  
    /**
     * 药品详细查询
     * hospitalCode:机构code
     * drugCostSum：药品费用合计
     */
    function drugSearch(hospitalCode,drugCostSum){
    	var prescribeDateBegin = $('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#prescribeDateEnd').val();
    	var patientType = $('#patientType').val();
    	
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/daily/outpatientDrug/drugsearch",
            insertDiv :"outpatientDrugDetailDiv",
            param : {
            	hospitalCode:hospitalCode,
            	prescribeDateBegin:prescribeDateBegin,
            	prescribeDateEnd:prescribeDateEnd,
            	patientType:patientType,
            	drugCostSum:drugCostSum},
            wait:true
        });
        $("#outpatientDrugDetailDiv").show();        	
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
            url : "/da/daily/outpatientDrug/itemsearch",
            insertDiv :"outpatientDrugDetailDiv",
            param : {
            	hospitalCode:hospitalCode,
            	prescribeDateBegin:prescribeDateBegin,
            	prescribeDateEnd:prescribeDateEnd,
            	patientType:patientType,
            	totalCostSum:totalCostSum},
            wait:true
        });
        $("#outpatientDrugDetailDiv").show();        	
    }
    
    function returnSearch(pageIndex){
        var pageIndex = $('#pageIndex').val();
        search(pageIndex);
        $("#outpatientDrugDetailDiv").empty();
        $("#top_all").show();
    }
	return {
		search:search,
		returnSearch:returnSearch,
		drugSearch:drugSearch,
		itemSearch:itemSearch
	};
})();



