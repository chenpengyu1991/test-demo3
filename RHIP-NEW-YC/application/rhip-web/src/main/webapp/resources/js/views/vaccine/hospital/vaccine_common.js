var vaccine_common = (function() {
	 //读卡确认
    $("#button_read").click(function() {
    	readCard.checkIdcard(readCardBack);
    });
    
    function  readCardBack(idcard){
    	$("#idCardTxt").val(idcard);
    	$("#idCardTxt").blur();
    }
})();