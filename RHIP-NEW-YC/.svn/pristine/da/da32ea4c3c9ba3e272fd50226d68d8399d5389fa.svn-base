var register = (function() {
	
	$(function() {
    	validate = $("#tbFormRegister").easyValidate();
		$.Placeholder.init({query:"#idCard",callback:function(element){
			tbCommon.queryPerson($(element).val(), validate);
		}});
		
        toggleOtherCK('clinicalManifestations.originalSymptom','other','99');

        $("#registerBtnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });

        $("#registerSearch").onEnter(search, 1);
        search(1);

        idmCommon.toggerAddress();
        idmCommon.initAdress();
        $("#check-submit-btn").on("click", function () {
            StartRead();
            $("#idcard").val(GT2ICROCX.CardNo);
        });
        $("#check-submit-btn1").on("click", function () {
            StartRead();
            $("#idCard").val(GT2ICROCX.CardNo);
        });
	});
	
	function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }
    }

	function search(indexPage) {
		disableChangeConfirm();
		var searchObj = {
				url : "/idm/tb/confirmed/register/list",
				insertDiv : "listDivRegister",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
			$("#registerSearchForm").submitFormLoadHtml(searchObj);
	};
	
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
		$("#detailDivRegister").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allRegister").show();		
	}	
	
	return {
        search: search,
        searchTemp:searchTemp
	};
})();
$(document).ready(function () { 
	//按钮样式切换 
	/*$("#registerBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); */

});