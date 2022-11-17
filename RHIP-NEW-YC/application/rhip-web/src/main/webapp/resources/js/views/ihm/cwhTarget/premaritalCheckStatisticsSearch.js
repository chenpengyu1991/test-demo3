var premaritalCheckStatisticsSearch = (function() {
	var validate=null;
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
    	$('#centre1').on("change",function(e){
			e.preventDefault();
			$('#superOrganCode').val(this.value);
        });
        $('#town1').on("change",function(e){
			e.preventDefault();
			$('#gbCode').val(this.value);
        });
        $('#centre2').on("change",function(e){
			e.preventDefault();
			$('#superOrganCode').val(this.value);
        });
        $('#town2').on("change",function(e){
			e.preventDefault();
			$('#gbCode').val(this.value);
        });
        $('#station2').on("change",function(e){
			e.preventDefault();
			$('#organCode').val(this.value);
        });
        $('#genreCode').on("change",function(e){
			e.preventDefault();
			changeOrgType();
        });
        $('#rangeType').on("change",function(e){
			e.preventDefault();
			$('input[name="yearType"]:eq(0)').attr("checked",'checked');
            changeRangeType();
        });
        $('input[name="yearType"]:eq(0)').attr("checked",'checked'); 
        changeOrgType();
        changeRangeType();
    }
	function changeRangeType(){
		//$('input[name="yearType"]:eq(0)').attr("checked",'checked'); 
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
		}else if(genreCode == 'G2'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            $('#orgTitle').hide();
            getCurrentOrgCode('G2');
        }
	}    

	function getCurrentOrgCode(index){
		$('#gbCode').val($('#town' + index).val());

        if('G2' == index){
            $('#orgG2').val("320003261"); //常熟市妇幼保健所
        }

		if(index==0){
			$('#superOrganCode').val($('#organCode' + index).val());
		}else if(index != 3){
			$('#superOrganCode').val($('#centre' + index).val());	
			$('#organCode').val($('#station' + index).val());
		}else{
			$('#superOrganCode').val("");	
			$('#organCode').val("");
		}
	}
    function search(pageIndex) {
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
    	changeOrgType();
        changeRangeType();
        var searchObj = {
        	url : $("#searchUrl").val(),
            insertDiv : "resultDiv"
        };
        $("#targetSearchForm").submitFormLoadHtml(searchObj);
    }
})();