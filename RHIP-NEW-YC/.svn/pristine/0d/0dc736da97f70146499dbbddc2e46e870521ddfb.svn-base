var choosepatient = (function() {
	$(function() { 	
        $("#patientBtnSearch").click(function() {
        	search();
        });
        $("#patientSearchForm").onEnter(search, 1);
        search();
	});
	/*选择患者画面查询*/
	function search(pageIndex) {
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/idm/malaria/standard/patientlist",
			insertDiv : 'patientResultDiv',
			param : {
				pageIndex : pageIndex
			},
//            wait : true,
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
		};
		$("#patientSearchForm").submitFormLoadHtml(searchObj);
	};
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	/*选择患者*/
	function rowclick(obj){
		var idmId = $(obj).attr('id');
		$('input[name="selectPatient"][value="' + idmId + '"]').attr("checked",true);
		$('#idmId').val(idmId);
	}
	
	/*确认选择患者*/
	function chooseOk(){
        var idmId = $('#idmId').val();
        if($.isEmpty(idmId)){
        	layer.alert("请选择患者！", {icon:0,title:'提示'});
        	return;
        }
        $('#patientIdmId').val(idmId);
    	fgrestdrugreg.getPatient();
        //更新父页面信息
        idmCommon.closePopUp('chooseDialog');
	}
	return {
        search:search,
		toggle:toggle,
		rowclick:rowclick,
		chooseOk:chooseOk
	};
})();