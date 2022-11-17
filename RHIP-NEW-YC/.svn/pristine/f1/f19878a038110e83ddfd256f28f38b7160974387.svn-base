var casePrint = (function() {
	$(function() {
	});
    function print(type){
        var saveResult = caseEdit.caseSubmit(type);
        if(saveResult != false){
            var idI = $("#idI").val();
            var idmIdI = $("#idmIdI").val();
            var infectiousCodeI = $("#infectiousCodeI").val();

            var url = contextPath + "/idm/case/initPrint?id=" + idI + "&idmId=" + idmIdI + "&infectiousCode=" + infectiousCodeI ;
            util.printPage(url);
        }
    };
    function onlyPrint(){
        var idI = $("#idI").val();
        var idmIdI = $("#idmIdI").val();
        var infectiousCodeI = $("#infectiousCodeI").val();
        var url = contextPath + "/idm/case/initPrint?id=" + idI + "&idmId=" + idmIdI + "&infectiousCode=" + infectiousCodeI ;
        util.printPage(url);
    };

    return {
        print:print,
        onlyPrint: onlyPrint
    };

})();