var assessment = (function() {
	$(function() {
		$("#saveValues").click(function(){
			if($("#agreement").is(':checked')){
				saveLcu();
				calculate();
			}else{
				layer.alert("请签署知情同意书！", {icon:0,title:'提示'});
			}
		});
		clickCalculateTotalValue();
		setDefaultValue();
	});
	function clickCalculateTotalValue(){
		$('input:checkbox').click(function(){
			totalLcuValue();
		});
	}
	function totalLcuValue(){
		var i=0;
		$('input[name="lcu"]:visible:checked').each(function(){
			var x=parseInt($(this).data('value'));
			i=i+x;
		});
		$("#total").attr("value",i);
	}
	function setDefaultValue(){
		var lcu = $("#lcu").val();
		var arr = lcu.indexOf(",")>0?lcu.split(","):lcu;
		for(var i=0;i<arr.length;i++){
			$("input[value="+arr[i]+"]").attr("checked","checked");
		}
		totalLcuValue();
		var consents = $("#consents").val();
		var signatureDate = $("#signatureDate").val();
		if(consents == '0'){
			$("#agreement").attr("checked","checked");
		}
		$("#assessDate").val(signatureDate);
	}
	function saveLcu(){
		if($("#agreement").is(':checked')){
			$("#consents").val($("#agreement").val());
		}else{
			$("#consents").val("");
		}
		var arrChk = '';
		$('input[name="lcu"]:visible:checked').each(function(){
			arrChk+=this.value + ',';
		});
		var arrayCheck = arrChk.substring(0, arrChk.length-1);
		var formulateDate = $("#assessDate").val();
		$("#signatureDate").val(formulateDate);
		$("#lcu").val(arrayCheck);
	}
	function calculate(){
		var i=0;
		$('input[name="lcu"]:visible:checked').each(function(){
			var x=parseInt($(this).data('value'));
			i=i+x;
		});
		$("#total").val(i);
		layer.alert("LCU值为："+$("#total").val(), {icon:0,title:'提示'});
		$("input[name='lcuLevel']").val(['1']);
		$("input[name='riskLevel']").val(['1']);
		if(i<150){
			$("input[name='lcuLevel']").val(['1']);
			$("input[name='riskLevel']").val(['2']);
			$("#twiceAYear").attr("checked",true);
		}else if(i>=300){
			$("input[name='lcuLevel']").val(['3']);
			$("input[name='riskLevel']").val(['3']);
			$("#fourTimesAYear").attr("checked",true);
		}else{
			$("input[name='lcuLevel']").val(['2']);
			$("input[name='riskLevel']").val(['2']);
			$("#twiceAYear").attr("checked",true);
		}
		$.removeDialog("assessmentDialog");
	}
	return {
		calculate:calculate
	};
})();