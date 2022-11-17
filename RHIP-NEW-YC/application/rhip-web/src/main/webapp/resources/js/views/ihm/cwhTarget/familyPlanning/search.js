var fpSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#fpSearchForm").easyValidate();
    	$("#fpSearchForm").onEnter(search, 1);
        $("#fpBtnSearch").click(function(e) {
			e.preventDefault();
			search(1);
        });
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
			changeRangeType();
        });
        changeOrgType();
        changeRangeType();
    }

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $("#queryPath").val(),
            insertDiv : "fpDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#fpPageIndex").val(pageIndex);
            }
        };
        $("#fpSearchForm").submitFormLoadHtml(searchObj);
    };	
    
    function childBearingDetail(id){
		$.post(
			contextPath+'/ihm/familyPlanning/childBearingDetail',
			{ id:id},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'childBearingDialog',
						area: ['950px', '450px'],
						title:'育龄妇女登记信息',
						content: ret
					});
				});
			}
			);
    }
    
    function premaritalHealthDetail(id){
		$.post(
			contextPath+'/ihm/familyPlanning/premaritalHealthDetail',
			{ id:id},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'premaritalHealthDialog',
						area: ['1000px', '500px'],
						title:'男女婚检信息',
						content: ret
					});
				});
			}
		);
    };
    
    function womanDiseaseDetail(id){
        var dialog = {
				url : "/ihm/familyPlanning/womanDiseaseDetail",
				height : 500,
				width : 1000,
				title : "妇女病筛查记录",
				param : {"id":id}
			};
		$.dialog(dialog);
    };
    
    function changeRangeType(){
		$('input[name="yearType"]:eq(0)').attr("checked",'checked'); 
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
		}
	}    

	function getCurrentOrgCode(index){
		$('#gbCode').val($('#town' + index).val());
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
	
	return {
		search:search,
		childBearingDetail:childBearingDetail,
		premaritalHealthDetail:premaritalHealthDetail,
		womanDiseaseDetail:womanDiseaseDetail
	};
})();



