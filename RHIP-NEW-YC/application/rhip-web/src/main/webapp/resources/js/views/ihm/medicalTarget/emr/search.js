var emrSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#emrSearchForm").easyValidate();
    	$("#emrSearchForm").onEnter(emrSearch, 1);
        $("#emrBtnSearch").click(function(e) {
        	e.preventDefault();
        	emrSearch(1);
        });
        //initForm();
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

    function emrSearch(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $("#queryPath").val(),
            insertDiv : "emrDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#emrPageIndex").val(pageIndex);
            }
        };
        $("#emrSearchForm").submitFormLoadHtml(searchObj);
    };	
    
    function prescriptionDetail(ehrId,personId,recordNumber){
        /*var dialog = {
				url : "/ihm/emr/prescriptionDetail",
				height : 500,
				width : 650,
				title : "处方",
				param : {"ehrId":ehrId,"personId":personId,"recordNumber":recordNumber}
			};
		$.dialog(dialog);*/
		
		$.post(contextPath+"/ihm/emr/prescriptionDetail",{"ehrId":ehrId,"personId":personId,"recordNumber":recordNumber}, function(ret){
        		  layer.open({
        			  type: 1,
        			  id:'ihmPrescriptionDetailDialog',
        			  area: ['700px', '520px'],
        			  title:"处方",
        			  content: ret
        		  });
        	});
    };

	function outpatientDetail(ehrId,personId){
		/*var dialogObj = {
			url :  "/outpatient/detailReport/"+personId+"/"+ehrId,
			title : "门诊",
			height : 550,
			width : 650,
			param : {
			}
		};
		$.dialog(dialogObj);*/
		
		$.post(contextPath+"/outpatient/detailReport/"+personId+"/"+ehrId, function(ret){
  		  layer.open({
  			  type: 1,
  			  id:'ihmOutpatientDetailDialog',
  			  area: ['700px', '580px'],
  			  title:"门诊",
  			  content: ret
  		  });
  	});
	}

    function beHospitalDetail(id){
        /*var dialog = {
				url : "/ihm/emr/beHospitalDetail",
				height : 400,
				width : 700,
				title : "入院记录",
				param : {"id":id}
			};
		$.dialog(dialog);*/
		
		$.post(contextPath+"/ihm/emr/beHospitalDetail", {"id":id}, function(ret){
	  		  layer.open({
	  			  type: 1,
	  			  id:'beHospitalDetailDialog',
	  			  area: ['750px', '450px'],
	  			  title:"入院记录",
	  			  content: ret
	  		  });
		});
    }
    
    function loadDetailDialog(url, title, height, width){
		/*var detail = {
				url : url,
				id : "detailDialog",
				height : height,
				weight : 30,
				width : width,
				title : title
		};
		$.dialog(detail);*/
		
		$.post(contextPath+url, function(ret){
	  		  layer.open({
	  			  type: 1,
	  			  id:'detailDialog',
	  			  area: [width + 'px', height + 'px'],
	  			  title:title,
	  			  content: ret
	  		  });
		});
		
	};
	
	function inspectDetail(id,personId){
        /*var dialog = {
				url : "/ihm/emr/inspectDetail",
				height : 500,
				width : 650,
				title : "检查",
				param : {"id":id,"personId":personId}
			};
		$.dialog(dialog);*/
		
		$.post(contextPath+"/ihm/emr/inspectDetail", {"id":id,"personId":personId}, function(ret){
	  		  layer.open({
	  			  type: 1,
	  			  id:'inspectDetailDialog',
	  			  area: ['700px', '550px'],
	  			  title:"检查",
	  			  content: ret
	  		  });
		});
    };
    
    function examDetail(ehrId,personId,examinationNumber){
       /* var dialog = {
				url : "/ihm/emr/examDetail",
				height : 500,
				width : 650,
				title : "检验",
				param : {"ehrId":ehrId,"personId":personId,"examinationNumber":examinationNumber}
			};
		$.dialog(dialog);*/
		
		$.post(contextPath+"/ihm/emr/examDetail", {"ehrId":ehrId,"personId":personId,"examinationNumber":examinationNumber}, function(ret){
	  		  layer.open({
	  			  type: 1,
	  			  id:'examDetailDialog',
	  			  area: ['800px', '550px'],
	  			  title:"检验",
	  			  content: ret
	  		  });
		});
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
		if(genreCode == 'A1'){
			$('#byHospital').show();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(0);
		}else if(genreCode == 'B1'){
			$('#byHospital').hide();
			$('#byCentre').show();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(1);
		}else if(genreCode == 'B2'){
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
		emrSearch:emrSearch,
		outpatientDetail:outpatientDetail,
		prescriptionDetail:prescriptionDetail,
		beHospitalDetail:beHospitalDetail,
		loadDetailDialog:loadDetailDialog,
		inspectDetail:inspectDetail,
		examDetail:examDetail
	};
})();


var ehrbrowserServiceIndex = (function () {
    // 检验报告单
    function openExamReport($this, param) {
        openReport($this, param, 900, 500);
    }

    function openReport($this, param, width, height) {
        /*var dialogObj = {
            url: $this.attr("href"),
            title: $this.attr("title") || $this.text(),
        };
        if (param) {
            dialogObj.param = param;
        }
        if (width) {
            dialogObj.width = width;
        }
        if (height) {
            dialogObj.height = height;
        }
        $.dialog(dialogObj);*/
        
        var url = $this.attr("href");
        var title = $this.attr("title") || $this.text();
        var id = $this.attr("id");
        
        $.post(url, param, function(ret){
  		  layer.open({
  			  type: 1,
  			  id:id + 'examDetailDialog',
  			  area: [width + 'px', height + 'px'],
  			  title:title,
  			  content: ret
  		  });
  	});
        return false;
    }

    function initCollspse(parentId) {
        $("#" + parentId + " .f-collspse-btn").on("click", function () {
            var $this = $(this);
            var btnId = $this.attr("id");
            if (btnId) {
                var $targetId = $("#" + parentId + " #" + btnId.replace("-btn-", "-target-"));
                if ($targetId.hasClass("f-collapse-in")) {
                    $("#" + parentId + " .f-collapse-in").removeClass("f-collapse-in");
                } else {
                    $("#" + parentId + " .f-collapse-in").removeClass("f-collapse-in");
                    $targetId.addClass("f-collapse-in");
                }
                ;
            }
        });
    }

    return {
        openReportByA: openReport,
        openExamReport: openExamReport,
        initCollspse: initCollspse,
    };

})();
