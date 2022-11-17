var censusSearch= (function() {

    $(function() {
        validate = $("#targetSearchForm").easyValidate();
        search(1);
        $("#btnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });
        $("#btnSearch").onEnter(search, 1);

        initForm();

        $("#ehr-person-export-btn").on("click", function(event) {
        	event.preventDefault();
            $("#resultDiv").exportExcel("慢病工作统计");
        });
    });

    function initForm(){
        $('#centre1').on("change",function(){
            $('#superOrganCode').val(this.value);
        });
        $('#town1').on("change",function(){
            $('#gbCode').val(this.value);
        });
        $('#centre2').on("change",function(){
            $('#superOrganCode').val(this.value);
        });
        $('#town2').on("change",function(){
            $('#gbCode').val(this.value);
        });
        $('#station2').on("change",function(){
            $('#organCode').val(this.value);
        });
        $('#genreCode').on("change",function(){
            changeOrgType();
        });
        $('#rangeType').on("change",function(){
            changeRangeType();
        });
        changeOrgType();
        changeRangeType();
    }
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
            $('#beginTime').val('');
			$('#endTime').val('');
        }else if(rangeType == '2'){
            $('#byMonth').hide();
            $('#byQuarter').show();
            $('#byYear').hide();
            $('#byRange').hide();
            $('#beginTime').val('');
			$('#endTime').val('');
        }else if(rangeType == '3'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').show();
            $('#byRange').hide();
            $('#beginTime').val('');
			$('#endTime').val('');
        }else if(rangeType == '4'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').show();
            $('#beginTime').val($('#beginDate4').val());
			$('#endTime').val($('#endDate4').val());
        }
    }
    function changeOrgType(){
        var genreCode = $('#genreCode').val();
        if(genreCode == '1'){
			$('.org_td').show();
			$('.add_td').hide();
		}else if(genreCode == '2'){
			$('.org_td').hide();
			$('.add_td').show();
		}
    }

    function search(pageIndex) {
        var result=validate.validateForm();
        if(!result){
            return;
        }
        changeOrgType();
        changeRangeType();
        
        var rangeType = $('#rangeType').val();
	    if(rangeType == '4'){
	        var sDate = new Date(Date.parse($('#beginTime').val()));
	        var eDate = new Date(Date.parse($('#endTime').val()));
	        
	        if(sDate.getFullYear() != eDate.getFullYear()){
	        	layer.alert("不允许跨年查询！", {icon:0,title:'提示'});
	        	 return;
	        }
	    }
        var searchObj = {
            url : "/cdm/standardization/phyExamination/phyCensus/list",
            insertDiv : "resultDiv",
            param : {
                indexPage : 1
            },
            callback : function(data) {
            }
        };
        $("#targetSearchForm").submitFormLoadHtml(searchObj);
    };


    function getNumVal(inputVal) {
        var val = $("#" + inputVal).val();
        var result = val.split(",");
        for(var i = 0; i<result.length; i++){
            if (isNaN(result[i])) {
                result[i] = 0;
            }
            result[i] = parseInt(result[i]);
        }
        return result;
    }

    /**
     * 图表表格切换
     */

    function changeEcharts(val){
        if (val == 1){
            $("#resultDiv").hide();
            $("#resultEchartsDiv").show();
        } else{
            $("#resultDiv").show();
            $("#resultEchartsDiv").hide();
        }
    }

    function scrollYFunDetail(id) {
        var tableId = id+"Div";
        var mainId = id+"TopDiv";
        var obj=document.getElementById(tableId);
        if(obj == null){
            return;
        }
        if(obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight){
            document.getElementById(mainId).setAttribute("class","paddingright17");
        }else{
            document.getElementById(mainId).removeAttribute("class");
        }
    }

    return {
        load:load,
        changeOrgType:changeOrgType,
        search:search
    };
})();
