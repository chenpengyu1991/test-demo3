var statistics = (function() {
    var option;
    var sameTag;
	$(function() {
        option = $("#patownShip option");
        selectTag("suspect");
        $("#statisticsSearchForm").onEnter(search, 1);
        
        $("#tbStatisticsId").click(function(e) {
            e.preventDefault();
        	search(1);
        });
	});

    function selectTag(tagName){
        if( $("#selectedTagST").val() == tagName){
            sameTag = 1;
        }else{
            sameTag = 0;
        }
        $("#selectedTagST").val(tagName);
        search(1);
    }

    function getOrgCode() {
        var organCode = $("#searchStation").val();
        if ($.isEmpty(organCode)) {
            organCode = $("#searchCenter").val();
        }
        if ($.isEmpty(organCode)) {
            organCode = $("#searchTown").val();
        }
        return organCode;
    }

	function search(pageIndex) {
        $("#searchOrganCode").val(getOrgCode());
        var selectedTag =  $("#selectedTagST").val();
        var url = '';
        var selectedUnit = $("#patownShip").val();
        if('transfer' == selectedTag){
            url = "/idm/tb/statistics/transfer/list";
            controlUnit(1, selectedUnit);
            $("#title1").show();
            $("#title2").hide();
            $("#title3").hide();
            $("#title4").show();
            $("#title5").hide();

        }
        if('suspect' == selectedTag){
            url = "/idm/tb/statistics/suspect/list";
            controlUnit(1, selectedUnit);
            $("#title1").show();
            $("#title2").hide();
            $("#title3").hide();
            $("#title4").show();
            $("#title5").hide();
        }
        if('mgnt' == selectedTag){
            url = "/idm/tb/statistics/mgnt/list";
            controlUnit(0, selectedUnit);
            $("#title1").show();
            $("#title2").hide();
            $("#title3").hide();
            $("#title4").hide();
            $("#title5").show();
            $("#title5").find("select").removeAttr("disabled").show();
        }
        if('cc' == selectedTag){
            url = "/idm/tb/statistics/cc/list";
            controlUnit(0, selectedUnit);
            $("#title2").show();
            $("#title1").hide();
            $("#title3").show();
            $("#title4").hide();
            $("#title5").show();
            $("#title5").find("select").removeAttr("disabled").show();
        }
		var searchObj = {
				url : url,
				insertDiv : "resultListDiv",
//                wait : true,
				param : {
                    pageIndex : pageIndex,
                    tag : selectedTag
				},
            callback: function(){sameTag = 1;}
			};
			$("#statisticsSearchForm").submitFormLoadHtml(searchObj);
	};

    //社区中心用户、统计筛查登记和转诊时，查询条件不可选择选择站。
    function controlUnit(onlySqzx, selectedUnit){
        if($("#isSqzx").val() != 1){
            return;
        }
//        var option = $("#patownShip option");
        if("1" == onlySqzx){
            $("#patownShip option").remove();
            var SQZXOrgCode = $("#SQZXOrgCode").val();
            var SQZXOrgName = $("#SQZXOrgName").val();
            $("#patownShip").append('<option value="'+ SQZXOrgCode +'">' + SQZXOrgName + '</option>');
        }else{
            $("#patownShip option").remove();
//            $("#patownShip").options(option);
            $("#patownShip").append('<option value="">' + "请选择" + '</option>');
            for(var i = 0 ; i < option.length; i++){
                $("#patownShip").append('<option value="'+ option[i].value +'">' + option[i].text + '</option>');
            }
            if(sameTag == 1){
                $("#patownShip").val(selectedUnit);
            }
        }
    }

    function downLoad(){
//        location.href = contextPath + "/idm/tb/statistics/downTransferExcel";
        var url = '';
        var selectedTag = $("#selectedTagST").val();
        if('suspect' == selectedTag){
            url = '/downSuspectExcel';
        }
        if('transfer' == selectedTag){
            url = '/downTransferExcel';
        }
        if('mgnt' == selectedTag){
            url = '/downMgntExcel';
        }
        if('cc' == selectedTag){
            url = '/downCcExcel';
        }
//        location.href = contextPath + "/idm/tb/statistics/downTransferExcel?" + $('#statisticsSearchForm').formSerialize();
        location.href = contextPath + "/idm/tb/statistics"+url+"?" + $('#statisticsSearchForm').formSerialize();
    }
	
	return {
        search : search,
        selectTag : selectTag,
        downLoad : downLoad
	};
})();
