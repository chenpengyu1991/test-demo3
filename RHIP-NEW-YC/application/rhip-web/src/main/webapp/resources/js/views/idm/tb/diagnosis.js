var diagnosis = (function() {
	
	$(function() { 
        $("#diagnosisBtnSearch").click(function(e) {
        	e.preventDefault();
        	search(1);
        });
        $("#check-submit-btn3").on("click", function (e) {
            e.preventDefault();
        	StartRead();
        });
        
        $("#diagnosisSearch").onEnter(search, 1);
        search(1);
	});
    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }
        $("#idcard3").val(GT2ICROCX.CardNo);
    }
	function search(indexPage) { 
		var searchObj = {
				url : "/idm/tb/treatment/diagnosis/list",
				insertDiv : "listDivDiagnosis",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
			$("#diagnosisSearchForm").submitFormLoadHtml(searchObj);
	}
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
		$("#detailDivDiagnosis").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allDiagnosis").show();		
	}
	
	function updatePlaceStatus(idmId,singleId){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("您确认此患者已到诊吗？", {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					 url : "/idm/tb/treatment/updatePlaceStatus",
	                 wait : true,
					 callback:function(data){
						 search($("#currentPage").val());
					 },
					 param:{
						 idmId: idmId,
						 singleId: singleId
						 }
				});
				layer.close(index);
			});
		});		
	}
	
	function updateDiagnosis(singleId){
		var result=$("#tbForm").easyValidate().validateForm();
    	if(!result){
    		return;
    	}
    	$("#tbForm").submitFormGetJson({
    		url : "/idm/tb/treatment/diagnosis/update",
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("诊断保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("诊断保存成功！", {icon:0,title:'提示'});
                    searchTemp(1);
                    return false;
                }
            }
		});
	}
	
	return {
        search: search,
        searchTemp: searchTemp,
        updateDiagnosis: updateDiagnosis,
        updatePlaceStatus: updatePlaceStatus
	};
})();
/*$(document).ready(function () { 
	//按钮样式切换 
	$("#diagnosisBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});*/