define(function(){
	function load(){
		$(function(){
			//分页绑定函数
			pageUtil.bind("orgResultDiv",search);
			search(1);
			$("#btnSearch").click(function() {
	           search(1);
	        });
			
	        $("#btnSearch").onEnter(search, 1);
	        
	        $("#organizationSearchSpanId").click(function(){
				toggle(this,'searchTable');
			});
	        
	        $("#orgSearchForm").onEnter(search, 1);
		});
	}
	
	function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/lhhospitalInfo/organizationList",
            insertDiv : "orgResultDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function() {
//            	为hospitalInfo_records中a的添加click事件
            	initLinkClick('addOrg',addOrg, {organCode:"data-recordId"});
            }
        };
        $("#orgSearchForm").submitFormLoadHtml(searchObj);
    };	

    function addOrg(organCode){
		$("#searchDiv").hide();
		var option = {
				url : "/lhhospitalInfo/addOrg",
				insertDiv : "hospitalInfoDiv",
				param :{
					organCode : organCode,
					operation:'3'
				}
		};
		$.loadHtmlByUrl(option);
		$.removeDialog ("popuOrgDialog");
	}
	return {
		load : load
	};
});
