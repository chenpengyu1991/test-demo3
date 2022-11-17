var ihmCommon = (function() {
	var validate = null;
    $(function() {
    	validate = $("#targetSearchForm").easyValidate();
        $("#targetBtnSearch").click(function(e) {
           e.preventDefault();
           search(1);
        });
        $("#targetBtnSearch").onEnter(search, 1);
        initForm();
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
		if(isEmpty(yearType)){
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
	function changeOrgType(){
		var genreCode = $('#genreCode').val();
		if(genreCode == 'A100'){
			$('#byHospital').show();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(0);
		}else if(genreCode == 'B100'){
			$('#byHospital').hide();
			$('#byCentre').show();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(1);
		}else if(genreCode == 'B200'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').show();
			$('#byTown').hide();
			getCurrentOrgCode(2);
		}else if(genreCode == '0'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').show();
			getCurrentOrgCode(3);
		}else if(genreCode == '46714114-9'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(3);
		}
	}    

	function getCurrentOrgCode(index){
		$('#gbCode').val($('#town' + index).val());
		if(index==0){
			$('#superOrganCode').val($('#organCode' + index).val());
		}else if(index == '46714114-9'){
			$('#superOrganCode').val($('#genreCode').val());
			$('#genreCode').val('R2');
		}else if(index != 3){
			$('#superOrganCode').val($('#centre' + index).val());	
			$('#organCode').val($('#station' + index).val());
		}else{
			$('#superOrganCode').val("");	
			$('#organCode').val("");
		}
	}
    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}  
    	changeOrgType();
    	changeRangeType();
        pageIndex = (isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $('#searchUrl').val(),
            insertDiv : "resultDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
                scrollYFun($('#searchUrl').val());
            }
        };
        $("#targetSearchForm").submitFormLoadHtml(searchObj);
    };

    /**
     * 是否出现滚动条对列表宽度影响
     */
    function scrollYFun(url) {
        switch (url) {
            case "/ihm/medical/inpatientlist":
                scrollYFunDetail("ihmpatientlisttable");
                break;
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

	function showChartJsp(){
		$("#chartDivId").empty();
		$("#searchDivId").empty();
		var loadHtml={
			url: "/healthRecord/read/search",
			insertDiv:"chartDivId",
			param:{
				fromHome:true
			}
		};
		$.loadHtmlByUrl(loadHtml);
	}

	return {
		changeOrgType:changeOrgType,
		changeRangeType:changeRangeType,
		search:search,
		showChartJsp:showChartJsp
	};
})();



