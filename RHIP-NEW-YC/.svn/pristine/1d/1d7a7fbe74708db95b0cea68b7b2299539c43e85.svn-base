var performanceSearch = (function() {
	$(function() {
        validate = $("#performanceSearchForm").easyValidate();
        $("#performanceSearchForm").onEnter(search, 1);
        $('#rangeType').on("change",function(){
            changeRangeType();
        });
        $("#searchBtn").click(function() {
        	if ($('#disease').val() == 'disease') { // 前十种疾病统计
        		searchDisease();
        	} else {
	           search(1);
        	}
        });
        changeRangeType();
	});

	function search(pageIndex) {
        changeRangeType();
        if($("#rangeType").val() == 4){
            validate.addCheckElement('beginDate4',{"required":"true"});
            validate.addCheckElement('endDate4',{"required":"true"});
        }else{
            validate.removeCheckElement('beginDate4');
            validate.removeCheckElement('endDate4');
        }
        var result=validate.validateForm();
        if(!result){
            return;
        }
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $('#searchUrl').val(),
            insertDiv : "resultDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#performanceSearchForm").submitFormLoadHtml(searchObj);
    };

    function changeRangeType(){
		var yearType = $('input[name="yearType"]:checked').val();
		if($.isEmpty(yearType)){
			$('input[name="yearType"]:eq(0)').attr("checked",'checked'); 
		}
        var rangeType = $('#rangeType').val();
        if(rangeType == '1'){
            $('#byMonth').show();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '2'){
            $('#byMonth').hide();
            $('#byQuarter').show();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '3'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').show();
            $('#byRange').hide();
        }else if(rangeType == '4'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').show();
            $('#beginDate').val($('#beginDate4').val());
            $('#endDate').val($('#endDate4').val());
        }
    }
     function searchDisease(){
     	 changeRangeType();
        if($("#rangeType").val() == 4){
            validate.addCheckElement('beginDate4',{"required":"true"});
            validate.addCheckElement('endDate4',{"required":"true"});
        }else{
            validate.removeCheckElement('beginDate4');
            validate.removeCheckElement('endDate4');
        }
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
    	  var searchObj = {
            url : "/report/rpDiseases/view",
            insertDiv : "resultDiv"
           
        };
        $("#performanceSearchForm").submitFormLoadHtml(searchObj);
			
	}
	return {
	};
})();