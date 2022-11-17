var pamOrgSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#targetSearchForm").easyValidate();
        $("#targetBtnSearch").click(function(e) {
        	e.preventDefault();
           search(1);
        });
        $("#targetBtnSearch").onEnter(search, 1);
		$("#resultDiv").on("click", ".pop", function () {
                var $link = $(this);
                getDataAndOpen($link);
                });  
        initForm();
    });
    
    function getDataAndOpen($link){
        var $tds = $link.parentsUntil("tr").siblings();
        var thisData = [];
        var orgCode = "";
        var charType = "";
        $tds.each(function () {
            var $td = $(this);
            if ($td.data("isData")) {
                var level = $td.data("total-level");
                thisData[level] = $td.data("total");
            }
            if ($td.data("isOrgcode")) {
                orgCode = $td.data("orgcode");
            }
        });
        var title = "基本医疗效率指标";
        var categories = ['人均门急诊<br/>人次数', '人均出院<br/>病人床日数', '门急诊<br/>次均费用', '出院病人<br/>次均费用','药占比','门急诊点滴<br/>处方比例','平均处方费用'];
        $('#chart_title').data('chartData',title);
        $('#this_data').data('chartData',thisData);
        $('#categories').data('chartData',categories);
        $('#chart_orgcode').data('chartData',orgCode);
        $('#seriesname').data('chartData',getSeriesName());
        openDialog();    	
    }
    
    function getSeriesName(){
    	var rangeType = $('#resultRangeType').val();
    	var seriesname;
    	switch(rangeType){
    		 case "1"://按月
    		 	seriesname = $('#resultMonthDate').val();
    		 	break;
    		 case "2"://按季度
    		 	seriesname = $('#resultQuarterDate').val() + " 第" + $('#resultRangeQuarter').val() + " 季度";
    		 	break;
    		 case "3"://按年
    		 	seriesname = $('#resultYearDate').val() + ($('#resultYearType').val() == '1'?" 全年":$('#resultYearType').val() == '2'?" 上半年":" 下半年");
    		 	break;
    	}
    	return seriesname;
    }
    
    function openDialog() {
		/*var dialogObj = {
				url : contextPath + "/pam/organ/serviceCapacity/popChart",
				param : {rangeType:$('#resultRangeType').val()},
				width: 840,
                height: 500,
                modal: true,
                resizable: false,				
				title : "基本医疗效率指标"
		};
		$.dialog(dialogObj);*/
		
		$.post(contextPath + "/pam/organ/serviceCapacity/popChart",{rangeType:$('#resultRangeType').val()}, function(ret){
        		  layer.open({
        			  type: 1,
        			  id:'baseMedicalStatisticsDialog',
        			  area: ['900px', '520px'],
        			  title:"基本医疗效率指标",
        			  content: ret
        		  });
        	});
    }
        
    function initForm(){
    	$('#centre1').on("change",function(){
    		console.log(this.value);
            $('#organCode').val(this.value);
        });
        $('#town1').on("change",function(){
        	$('#superOrganCode').val("");
            $('#gbCode').val(this.value);
        });
        $('#centre2').on("change",function(){
            $('#superOrganCode').val(this.value);
        });
        $('#town2').on("change",function(){
        	$('#superOrganCode').val("");
            $('#gbCode').val(this.value);
        });
        $('#organCode0').on("change",function(){
            $('#organCode').val(this.value);
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
		if(rangeType == '1'){//按月
			$('#byMonth').show();
			$('#byQuarter').hide();
			$('#byYear').hide();
			$('#byRange').hide();
		}else if(rangeType == '2'){//按季度
			$('#byMonth').hide();
			$('#byQuarter').show();
			$('#byYear').hide();
			$('#byRange').hide();
		}else if(rangeType == '3'){//按年
			$('#byMonth').hide();
			$('#byQuarter').hide();
			$('#byYear').show();
			$('#byRange').hide();
		}
		changeRequired(rangeType);
	} 
	
	function changeRequired(type){
		if(type == '1'){//按月
	    	validate.removeCheckElement('yearDate');
	    	validate.removeCheckElement('quarterDate');
	        validate.addCheckElement('monthDate',{"required":"true"});
		}else if(type == '2'){//按季度
	    	validate.removeCheckElement('yearDate');
	    	validate.removeCheckElement('monthDate');
	        validate.addCheckElement('quarterDate',{"required":"true"});
		}else if(type == '3'){//按年
	    	validate.removeCheckElement('monthDate');
	    	validate.removeCheckElement('quarterDate');
	        validate.addCheckElement('yearDate',{"required":"true"});
		}		
	}
	function changeOrgType(){
		var genreCode = $('#genreCode').val();
		if(genreCode == 'A100'){
			$('#byHospital').show();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
			$('#orgTitle').show();
			getCurrentOrgCode(0);
		}else if(genreCode == 'B100'){
			$('#byHospital').hide();
			$('#byCentre').show();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(1);
			$('#orgTitle').show();
		}else if(genreCode == 'B200'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').show();
			$('#byTown').hide();
			$('#orgTitle').show();
			getCurrentOrgCode(2);
		}else if(genreCode == '0'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').show();
			$('#orgTitle').show();
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
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}  
    	changeOrgType();
    	changeRangeType();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $('#searchUrl').val(),
            insertDiv : "resultDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#targetSearchForm").submitFormLoadHtml(searchObj);
    };
    
    function viewDoctorDetail(orgCode,medicalCode) {
       /* var dialog = {
				url : "/pam/organ/viewDoctors",
				height : 500,
				width : 650,
				title : "查看抗菌药物使用医生信息",
				param : {"orgCode":orgCode,"medicalCode":medicalCode,"beginDateA":$("#beginDateA").val(),"endDateA":$("#endDateA").val()}
			};
		$.dialog(dialog);*/
		 $.post(contextPath+'/pam/organ/viewDoctors',
        		{"orgCode":orgCode,"medicalCode":medicalCode,"beginDateA":$("#beginDateA").val(),"endDateA":$("#endDateA").val()}, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'intoDialog',
        			  area: ['750px', '550px'],
        			  title:'查看抗菌药物使用医生信息',
        			  content: ret
        		  });
        		});
        	});
    };
    
	return {
		changeOrgType:changeOrgType,
		search:search,
		viewDoctorDetail:viewDoctorDetail
	};
})();



