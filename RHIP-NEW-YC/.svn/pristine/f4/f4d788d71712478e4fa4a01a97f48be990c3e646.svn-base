var drugPriceSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#drugPriceSearchForm").easyValidate();
        $("#drugPriceBtnSearch").click(function() {
           search(1);
        });
        $("#drugPriceSearch").onEnter(search, 1);

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
            url : "/da/daily/drugPrice/list",
            insertDiv : "drugPriceResultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#drugPriceSearchForm").submitFormLoadHtml(searchObj);
    };	
	return {
		search:search
	};
})();



