var havCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
        	idCard.queryPerson($(element).val());
        }});
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
        toggleOther('infectionSourceRoute.familyFever','feverPlasmodium',1);
        toggleOther('infectionSourceRoute.strangerLive','strangerLive1',1);
        toggleOther('infectionSourceRoute.outHistory','outHistory',1);
        toggleOther('pastHistory.isOut','inAguePlace',2);
        toggleOther('pastHistory.isOut','outAguePlace',1);
        toggleOther('attackCondition.isOverseas','foreignAddr1',1);
        toggleOther('attackCondition.isOverseas','pathogenesisPlace1',2);
        toggleOther('attackCondition.complication','complicationName1',1);
        toggleOther('otherCondition.resistenceAgue','agueIdea',1);
        caseEdit.toggerAddress();
    });

    /*隐藏、显示地址*/
//    function toggerAddress(){
//        var value=$('input[name="generalCondition.addrType"]:checked').val();
//
//        if('1' == value){
//            $("#pavillage_address").removeAttr("disabled");
//            $("#hrvillage_address").removeAttr("disabled");
//            $('#patown_address').removeAttr("disabled");
//            $('#hrtown_address').removeAttr("disabled");
//            $('#spanPaNumber').text("门牌号");
//            $('#spanHrNumber').text("门牌号");
//            $('#pahouseNumber').attr({"style":"width:180px"});
//            $('#hrhouseNumber').attr({"style":"width:180px"});
//        }else{
//            $("#pavillage_address").attr("disabled", "disabled");
//            $("#hrvillage_address").attr("disabled", "disabled");
//            $("#patown_address").attr("disabled", "disabled");
//            $("#hrtown_address").attr("disabled", "disabled");
//            $('#spanPaNumber').text("详细地址");
//            $('#spanHrNumber').text("详细地址");
//            $('#pahouseNumber').attr({'style':'width:90%'});
//            $('#hrhouseNumber').attr({'style':'width:90%'});
//        }
//        toggleOther('generalCondition.addrType','pavillage_address','1');
//        toggleOther('generalCondition.addrType','patown_address','1');
//    }

    return {
    };
})();


