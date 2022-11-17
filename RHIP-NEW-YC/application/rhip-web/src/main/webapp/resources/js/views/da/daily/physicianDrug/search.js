var physicianSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#physicianDrugSearchForm").easyValidate();
        $("#physicianBtnSearch").click(function(e) {
            e.preventDefault();
           search(1);
        });
        $("#physicianDrugSearch").onEnter(search, 1);
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
            url : "/da/daily/physicianDrug/list",
            insertDiv : "physicianDrugResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#physicianDrugSearchForm").submitFormLoadHtml(searchObj);
    };	
  
    function returnSearch(pageIndex){
        var pageIndex = $('#pageIndex').val();
        search(pageIndex);
        $("#physicianDrugDetailDiv").empty();
        $("#top_all").show();
    }
    
    /**
     * 用药排名详细
     * hospitalCode：机构编码
     * drugMedicareCode：药品医保编码
     */
    function medicationRanking(hospitalCode,drugMedicareCode){
    	var prescribeDateBegin = $('#prescribeDateBegin').val();//监控开始时间
    	var prescribeDateEnd = $('#prescribeDateEnd').val();//监控结束时间
    	var patientType = $('#patientType').val();//患者类型：门诊/住院
    	
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/da/daily/physicianDrug/medicationRanking",
            insertDiv :"physicianDrugDetailDiv",
            param : {
            	hospitalCode:hospitalCode,
            	drugCode:drugMedicareCode,
            	prescribeDateBegin:prescribeDateBegin,
            	prescribeDateEnd:prescribeDateEnd,
            	patientType:patientType},
            wait:true
        });
        $("#physicianDrugDetailDiv").show();    	
    }
    
	return {
		search:search,
		returnSearch:returnSearch,
		medicationRanking:medicationRanking
	};
})();



