var brwHbpPlanInfo = (function() {
	$(function() {
//		  var validate = $("#hbpPlanForm").easyValidate();
//		  planInfoTab.setHbpValidate(validate);
		 $("#txtSbp").change(doBindValue);
		 $("#txtDbp").change(doBindValue);
		 $("#tableLinstener").find(".level1").change(doBindValue);
		 $("#tableLinstener").find(".level2").change(doBindValue);
		 $("#tableLinstener").find(".level3").change(doBindValue);
		 $("#hbpYear").val(new Date().getFullYear());
		 $("#createHbpDate").val(new Date().pattern("yyyy/MM/dd"));
		  $("input[name='radioRbgLevel']").attr("disabled","disabled");
		  $("input[name='radioWx']").attr("disabled","disabled");
		  $("input[name='radioDiseLevel']").attr("disabled","disabled");
		  $("#personHbpName").val($("#hiddenPersonName").val());
	
	});
	
	function doBindValue(){
	  var ssyLevel=null;
 	  var szyLevel=null;
	  txtSbpValue = $.trim($("#txtSbp").val());
	  txtDbpValue = $.trim($("#txtDbp").val());
	  //根据血压给高血压分级赋值并且给相应的hidden赋值
	  if(txtSbpValue>=160 && txtSbpValue <=179)
		  ssyLevel=2;
	  else if(txtSbpValue >= 180)
		  ssyLevel=3;
	  else
		  ssyLevel=1;
	  if(txtDbpValue>=100 && txtDbpValue<=109)
		  szyLevel=2;
	  else if(txtDbpValue>=110)
		  szyLevel=3;
	  else
		  ssyLevel=1;
	  if(txtSbpValue=="" || txtDbpValue==""){
		  $("input[name='radioRbgLevel']").val([1]);
		  $("#radioRbgLevelHidden").val([1]);
	  }else{
	  	  $("input[name='radioRbgLevel']").val([ssyLevel>szyLevel?ssyLevel:szyLevel]);
	  	  $("#radioRbgLevelHidden").val(ssyLevel>szyLevel?ssyLevel:szyLevel);
	  }
		level1Total=$("#tableLinstener").find(".level1:checked").length;
		level2Total=$("#tableLinstener").find(".level2:checked").length;
		level3Total=$("#tableLinstener").find(".level3:checked").length;
		//根据心血管疾病的选择项目给心血管疾病等级赋值并且给相应的hidden赋值
		if(level1Total==0 && level2Total==0 && level3Total==0){
			$("input[name='radioDiseLevel']").val([2]);
			$("#radioDiseLevelHidden").val([2]);
		}
		if(level1Total>0){
			$("input[name='radioDiseLevel']").val([2]);
			$("#radioDiseLevelHidden").val([2]);
		}
		if(level2Total>0){
			$("input[name='radioDiseLevel']").val([3]);
			$("#radioDiseLevelHidden").val([3]);
		}
		if(level3Total>0){
			$("input[name='radioDiseLevel']").val([4]);
			$("#radioDiseLevelHidden").val([4]);
		}
		
		//根据根据心血管疾病的选择项目和高血压分级给高血压危险分层赋值并且给相应的hidden赋值
		if($('input:radio[name="radioRbgLevel"]:checked').val()==1){
			if(level1Total==0){
				$("input[name='radioWx']").val([1]);
				$("#radioWxHidden").val([1]);
			}
			if(level1Total>=1 && level1Total<=2){
				$("input[name='radioWx']").val([2]);
				$("#radioWxHidden").val([2]);
			}
			if(level1Total>=3){
				$("input[name='radioWx']").val([3]);
				$("#radioWxHidden").val([3]);
			}
			if(level2Total>0){
				$("input[name='radioWx']").val([3]);
				$("#radioWxHidden").val([3]);
			}
			if(level3Total>0){
				$("input[name='radioWx']").val([4]);
				$("#radioWxHidden").val([4]);
			}
		}else if($('input:radio[name="radioRbgLevel"]:checked').val()==2){
			if(level1Total==0){
				$("input[name='radioWx']").val([2]);
				$("#radioWxHidden").val([2]);
			}
			if(level1Total>=1 && level1Total<=2){
				$("input[name='radioWx']").val([2]);
				$("#radioWxHidden").val([2]);
			}
			if(level1Total>=3){
				$("input[name='radioWx']").val([3]);
				$("#radioWxHidden").val([3]);
			}
			if(level2Total>0){
				$("input[name='radioWx']").val([3]);
				$("#radioWxHidden").val([3]);
			}
			if(level3Total>0){
				$("input[name='radioWx']").val([4]);
				$("#radioWxHidden").val([4]);
			}
		}else if($('input:radio[name="radioRbgLevel"]:checked').val()==3){
			if(level1Total==0){
				$("input[name='radioWx']").val([3]);
				$("#radioWxHidden").val([3]);
			}
			if(level1Total>=1 && level1Total<=2){
				$("input[name='radioWx']").val([4]);
				$("#radioWxHidden").val([4]);
			}
			if(level1Total>=3){
				$("input[name='radioWx']").val([4]);
				$("#radioWxHidden").val([4]);
			}
			if(level2Total>0){
				$("input[name='radioWx']").val([4]);
				$("#radioWxHidden").val([4]);
			}
			if(level3Total>0){
				$("input[name='radioWx']").val([4]);
				$("#radioWxHidden").val([4]);
			}
		}
		//根据危险分层对每次随访次数赋值
		$("#annualVisitTimes").val($('input:radio[name="radioWx"]:checked').val()==1?'4':$('input:radio[name="radioWx"]:checked').val()==2?'6':'12');
	}
	return {
		doBindValue:doBindValue
	};
})();