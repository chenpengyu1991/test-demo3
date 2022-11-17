var ehrbrowserServiceIndex = (function() {
	var medicalindex_url = contextPath+"/ehrbrowser/service/result";
	var indexDataRangeForm="data-range-form";
	$(function() {
		//时间段切换
		search(1, medicalindex_url, indexDataRangeForm,"medical_index_content");
		//更多
		$("#medical_index_content").on("click", ".index_medical_more_btn",function(event){
			event.preventDefault(); 
			var personId=$("#ehrbrowser_person_id_input").val();
			//alert(personId);
			var dialogObj = {
					url :  $(this).attr("href"),
					title:$(this).attr("title"),
					param : {
						personId:personId
					}
				};
			$.dialog(dialogObj);
		});
		
		
		//检验报告单
		$("#medical_index_content").on("click", ".exam_report_btn",function(event){
			event.preventDefault();
			openExamReport($(this),null);
		});
		//检查报告单
		$("#medical_index_content").on("click", ".study_report_btn",function(event){
			event.preventDefault();
			openStudyReport($(this),null);
		});
		//临床图表
		$("#medical_index_content").on("click", ".inhos_chart_btn",function(event){
			event.preventDefault();
			openDrugInpatientChart($(this),null);
		});
		//处方
		$("#medical_index_content").on("click", ".drug_report_btn",function(event){
			event.preventDefault();
			openDrugReport($(this),null);
		});
		
		//默认显示
		//$(".daterange-radio:first").click();
		
	});
	
	function search(indexPage, url, form, target) {
		
		$("#" + form).submitFormLoadHtml({
			url :  url,
			insertDiv :target,
			param : {
				indexPage : indexPage,
				personId:$("#ehrbrowser_person_id_input").val()
			}
		});
	}
	

	//检验报告单
	function openExamReport($this,param){
		openReport($this,param,600,500);
	}
	//检查报告单
	function openStudyReport($this,param){
		openReport($this,param,600,500);
	}
	//处方
	function openDrugReport($this,param){
		openReport($this,param,650,500);
	}
	//临床图表
	function openDrugInpatientChart($this,param){
		openReport($this,param,800,630);
	}
	
	
	function openReport($this,param,width,height){
		var dialogObj = {
				url :  $this.attr("href"),
				title :$this.attr("title")||$this.text(),
				};
		if(param){
			dialogObj.param=param;
		}
		if(width){
			dialogObj.width=width;
		}
		if(height){
			dialogObj.height=height;
		}
		$.dialog(dialogObj);
		return false;
	}
	
	function initCollspse(parentId){
		  $("#"+parentId+" .f-collspse-btn").on("click",function(){
	            var $this=$(this);
	            var  btnId=$this.attr("id");
	            if(btnId){
	                var $targetId=$("#"+parentId+" #"+btnId.replace("-btn-","-target-"));
	                if($targetId.hasClass("f-collapse-in")){
	                	$("#"+parentId+" .f-collapse-in").removeClass("f-collapse-in");
	                }else{
	                	$("#"+parentId+" .f-collapse-in").removeClass("f-collapse-in");
	                	$targetId.addClass("f-collapse-in");
	                };
	            }
	        });
	}
	
	return{
		openReportByA:openReport,
		openExamReport:openExamReport,
		openStudyReport:openStudyReport,
		openDrugReport:openDrugReport,
		openDrugInpatientChart:openDrugInpatientChart,
		initCollspse:initCollspse
	};
	
})();

