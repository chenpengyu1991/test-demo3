var bmiDetail = (function(){

    var cssStyle = '';
    var color = '';

    $(function() {
        $("#seeResultBtnId").click(seeResult);
        $("#resetingBtnId").click(function() {
            clear('bmiFormId');
            $(".test_result").hide();
        	$(".test_end").hide();
        });
    });

    function seeResult() {
    	if(!isEmpty($("#heightId").val()) && !isEmpty($("#weightId").val())) {
    		$(".test_result").show();
    		$(".test_end").show();
    	} else {
    		alert("请相应的输入正确数字！");
    	}
        var weight = $("#weightId").val();
        var height = $("#heightId").val()/100;
        var result = Math.round(weight/(Math.pow(height, 2))*10)/10;
        getMessage(result);
        $("#bmiResultTdId").html(result);
        $("#weigthStatusTdId").html(msg);
        $("#bmiResultTdId").css("color",color);
        $("#weigthStatusTdId").css("color",color);
    }

    function getMessage(result) {
        if(result < 18.5) {
            msg='偏瘦';
            color = '#00f';
        } else if(result >= 18.5 && result <= 23.9) {
            msg='正常';
            color = '#093';
        } else if(result > 23.9 && result < 26.9) {
            msg='偏胖';
            color = '#FC3';
        } else if(result >= 26.9 && result <= 29.9) {
            msg='肥胖';
            color = '#F00';
        } else if(result > 29.9) {
            msg='重度肥胖';
            color = '#000';
        }
    }
    
 // 判断是否为空
	function isEmpty(str) {
		if (null == str || "" == str) {
			return true;
		}
		return false;
	}
})();