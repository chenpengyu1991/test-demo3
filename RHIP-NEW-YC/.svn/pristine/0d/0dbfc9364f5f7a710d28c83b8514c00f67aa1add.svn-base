/**
 * Created by jingqiu on 17-3-24.
 */
var childInfo = (function () {
    var validation;
    $(function () {
        validation = $('#childInfoForm').easyValidate();
        $('#cancelChildInfoBtn').click(function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                $('#child-exam-input-box').empty();
                $('#child-exam-input-box').hide();
                $('#child-exam-list-box').show();
            });

        });
        $('#showExamineFormBtn').click(function () {
            showExamForm();
        });
        $("#homeVillage_address").change(displayHrAddress);
        var examineAgeGroup = $("#examineAgeGroup").val();

        $('#babyCardNo').blur(function () {
            if ($("#text_personId").val()){
                return;
            }
            var babyCardNo = $(this).val();
            getChildInfo('babyCard', babyCardNo);
        })

        var oldIdCard = null;
        $('#idCard').blur(function () {
            if ($("#text_personId").val()){
                return;
            }
            var idCard = $(this).val();
            if (idCard) {
                idCard = $.trim(idCard);
            }
            if (oldIdCard != idCard && idCard != '') {
                oldIdCard = idCard;
                getChildInfo('idCard', idCard);
            }
        })
    });

    function showExamForm() {
        var result = validation.validateForm();
        if (!result) {
            return;
        }

        if($.isEmpty($("#text_personId").val())) {
        	layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
            return;
        }

        var examAge = $('#cPhysicalExamAge').val();
        /*if (examAge != '满月' && examAge != '3月龄'){
            if ($.isEmpty($('#idCard').val())) {
                layer.alert("请填写身份证号");
                return;
            }
        }*/
        var idCard = $("#idCard").val();
        var babyCardNo = $("#babyCardNo").val();
        $('#childInfoForm').submitFormLoadHtml({
            url: '/childHealthExamine/showExamineForm',
            insertDiv: 'child-exam-input-box',
            param: {
                examineAgeGroup: $('#examineAgeGroup').val(),
                idCard: idCard,
                babyCardNo: babyCardNo
            }
        });
    }

    function displayHrAddress() {
        var town = $("#homeTown_address option:selected").text();
        var street = $("#homeStreet_address option:selected").text();
        var village = $("#homeVillage_address option:selected").text();
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择') {
            result = result + street;
        }
        if (village != '请选择')
            result = result + village;
        $("#tempHrValue").text(result);
        $("#orgHrName").val(result);
    }

    function getChildInfo(cardType, cardNo) {
        var idCard, babyCardNo;
        if (cardType == 'idCard') {
            idCard = cardNo;
        } else {
            babyCardNo = cardNo;
        }
        $.getJsonByUrl({
            url: '/childHealthExamine/getChildInfo',
            param: {
                idCard: idCard,
                babyCardNo: babyCardNo
            },
            wait: true,
            callback: function (data) {
                if (data) {
                    if ($.isEmpty(data.healthFileNo)) {
                    	layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
                    }
                    /*$("input[id=name]").attr("disabled",true);*/
                    $("#text_personId").val(data.id);
                    $('#name').val(data.name);
                    $('#childInfoForm #genderCode').val(data.gender);
                    $('#babyCardNo').val(data.babyCardNo);
                    //$('#birthday').val(data.birthday);
                    if (data.babyCardNo != null) {
                        $("input[id='babyCardNo']").val(data.babyCardNo);
                        $("input[id=babyCardNo]").attr("disabled", true);
                    }
                    if (data.idCard != null) {
                        if (validation.validate("idCard")) {
                            var birthdays = data.idCard.substr(6, 8);
                            $("input[name='birthday']").val(birthdays.substr(0, 4) + "/" + birthdays.substr(4, 2) + "/" + birthdays.substr(6, 2));
                        }
                        $("input[id=idCard]").attr("disabled", true);
                    }
                    if (data.birthday != null && data.idCard == null) {
                        $("input[name='birthday']").val(data.birthday);
                    }
                    $('#idCard').val(data.idCard);
                    $("#idCard").attr("readonly","readonly");
                    $('#telNumber').val(data.telNumber);
                    //地址
                    $('#homeTown_address').val(data.patownShip);
                    var iddStreet = $("#homeTown_address").attr("idd").replace('townId', '');
                    orgUtil.getStreetOpting(iddStreet, data.pastreet, '', null);
                    $('#text_pahouseNumber').val(data.pahouseNumber);
                    var examineAgeGroup = $("#examineAgeGroup").val();
                    if (!data.idCard && examineAgeGroup != 1 ){
                    	layer.alert("请先更新此人员健康档案中的身份证信息！", {icon:0,title:'提示'});
                    }
                    setTimeout(function () {
                        var tempHrValue = '';
                        tempHrValue += $('#homeTown_address :selected').text();
                        tempHrValue += $('#homeStreet_address :selected').text();
                        //tempHrValue += $('#homeVillage_address :selected').text();
                        $('#tempHrValue').text(tempHrValue);
                    }, 500);
                } else {
                	layer.alert("此人员尚未建档，请先给此人员创建健康档案！");
                    if (idCard != null) {
                        if (validation.validate("idCard")) {
                            var birthdays = idCard.substr(6, 8);
                            $("input[name='birthday']").val(birthdays.substr(0, 4) + "/" + birthdays.substr(4, 2) + "/" + birthdays.substr(6, 2));
                        }
                    }
                }
            }
        })
    }

    return {
        displayHrAddress: displayHrAddress
    }
})();