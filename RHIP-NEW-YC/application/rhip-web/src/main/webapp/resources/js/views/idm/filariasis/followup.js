var filIndex = (function() {
    var validate=null;
	$(function() {
        toggleOther('lymphatic','lymphaticPart1',1);
        toggleOther('lymphatic','lymphaticPart2',1);
        toggleOtherCK('supervisorContent','supervisorOther',99);
        enableChangeConfirm();
        displayPaAddress();

        $("#addEfcList").click(function(e) {
            e.preventDefault();
            var lymphedema = $("#lymphedema").val();
            var chyluria = $("#chyluria").val();

            $.post(contextPath+'/idm/filariasis/standard/popupLc',
                {
                    total: lymphedema + chyluria
                },
                function(ret){
                    layer.open({
                        type: 1,
                        id:'lcDialog',
                        area: ['750px', '350px'],
                        title:"自我照料和医生建议",
                        content: ret
                    });
                });
        });
	});

    function displayPaAddress() {
        $("select[name='pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }


})();
