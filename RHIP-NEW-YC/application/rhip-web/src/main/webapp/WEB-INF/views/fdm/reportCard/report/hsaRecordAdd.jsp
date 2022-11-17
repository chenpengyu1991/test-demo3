<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<div class="toolbar">
    <input type="hidden" id="from" value="${from}">
    <input type="hidden" id="addFrom" value="${addFrom}">
    <input type="hidden" id="isHealthCertPerson" value="${isHealthCertPerson}">
    <c:if test="${from eq 'csws'}">
        <a href="javascript:void(0)" id="report-hsa-back-btn"><b class="fanhui">返回</b></a>
        <a href="javascript:void(0)" id="report-input-save-btn"><b class="tijiao">提交</b></a>
    </c:if>
</div>
<div class="hide"   id="fdm-report-card-message">
    无需报卡，请关闭报卡界面！
</div>
<div class="hide"  id="fdm-report-card-main">
    <jsp:include page="input.jsp"></jsp:include>
</div>
<script type="text/javascript">

    var checkSubmitFlg = false;

    function checkSubmit(){

        if(checkSubmitFlg ==true){ return false; //当表单被提交过一次后checkSubmitFlg将变为true,根据判断将无法进行提交。

        }
        checkSubmitFlg=true;
        return true;
    }
    var validate = null;
    !(function () {

        $(function () {
            toggleOtherCK('nerveSymptom','pupilException','513');
            toggleOtherCK('previousHistory','previousHistoryOther','99');
            toggleOtherSC('foodHistory','foodHistoryOther','99');
            validate = $("#report-input-form").easyValidate();

            $.Placeholder.init({query: "#idCardTemp", callback: function (element) {
                    queryPerson($(element).val(), validate);
                }});

            $("#report-input-save-btn").on("click", save);
            $("#report-hsa-back-btn").on("click", back);
            var addFrom  = $("#addFrom").val();
            if('rcxc' == addFrom){
                $("#hsa-record-reportCard-add select").not("select[multiple]").multiselect({
                    multiple: false,
                    header : false,
                    noneSelectedText: "",
                    selectedList: 1
                });
            }else if('bgdj' == addFrom){
                $("#hsa-record-card-add select").not("select[multiple]").multiselect({
                    multiple: false,
                    header : false,
                    noneSelectedText: "",
                    selectedList: 1
                });
            }


            var from  = $("#from").val();
            if('csws' != from){

                var confirmMsg = "<span style='color:red'>是否采样?</span>";
                if ($("#isHealthCertPerson").val() == '1') {
                    confirmMsg = "<span style='color:red'>该患者为食品行业从业人员，请务必进行肛拭子标本采集送检！</span><br />" + confirmMsg;
                }
                $.alerts.confirm(confirmMsg, "确认提示", function(r){
                    if(r){
                        $("#fdm-report-card-main").show();
                        setResult(false);
                    }else{
                        setResult(true);
                        $("#fdm-report-card-message").show();
                    }
                });
            }else{
                $("#fdm-report-card-main").show();
                setResult(false);
            }
            $('input[name="intestinalInfection"][value="202"]').on('click',function(){
                if($(this).is(":checked")) {
                    $('input[name="laxSymptom"][value="1"]').attr("checked",false);
                }
            });

            $('input[name="laxSymptom"][value="1"]').on('click',function(){
                if($(this).is(":checked")) {
                    $('input[name="intestinalInfection"][value="202"]').attr("checked",false);
                }
            });
            $('input[name="laxSymptom"]').on('click',function(){
                var length = $('input[name="laxSymptom"]:checked').length
                if (length > 1) {
                    $(this).attr("checked",false);
                    layer.alert("只可以选择一项！", {icon:0,title:'提示'});
                }
            });
            toggerAddress();
            displayPaAddress();
        });

        function setResult(success) {
            var value = -1;
            if (success) {
                value = 1;
            }
            $("#report-input-form #report-result").val(value);
        }

        function save(event) {

            var from  = $("#from").val();

            if($("#fdm-report-card-main").is(":hidden")){
            	layer.alert("无需报卡，请关闭报卡界面！", {icon:0,title:'提示'});
                return;
            }
            //该控件被隐藏，所以需要添加validate
            $("select[name='infectedpersonOccupation']").data('validate',true);
            $("select[name='address1']").data('validate',true);
            $("select[name='foodHistory']").data('validate',true);
            $("select[name='pack1']").data('validate',true);
            // 呕吐勾选时,必须填写次数
            var emesis = $('input[name="wholeBody"][value="102"]').is(":checked");
            if (emesis) {
                $("#emesisNum").attr('reg','{"required":"true","regex":"number"}');
            }
            var fever = $('input[name="intestinalInfection"][value="209"]').is(":checked");
            if (fever) {
                $("#feverTemp").attr('reg','{"required":"true","regex":"number","min":37.5,"max":45}');
            }
            customValidate();
            validate = $("#report-input-form").easyValidate();
            // validate
            var result = validate.validateForm();

            if (!result) {
                return;
            }
            if(!checkSubmit()){
            	layer.alert("请不要重复提交报卡信息！", {icon:0,title:'提示'});
                return;
            }
            //提交时自动处理出生日期
            var idCard=$("#idCardTemp").val();
            setIcData(idCard);
            $("#report-input-form").submitFormGetJson({
                url: "/fdm/reportCard/reportSave",
                callback: function (data) {
                    setResult(true);
                    if("csws" == from){
                        $("#report-input-save-btn").hide();
                    }
                    if (data.success) {
                        var context=$("#dieaseNo").text();
                        $("#dieaseNo").text(context+data.num_2);
                        $("#dieaseNo").css('font-weight','bolder');
                        $("#dieaseNo").css('color','red');
                        $("#ybbh").text(context+data.num_2);
                        $("#ybbh").css('font-weight','bolder');
                        $("#ybbh").css('color','red');
                    }
                    layer.alert(data.message, {icon:0,title:'提示'});
                    //msgUtil.alert("报卡上报成功！");
                }
            });
        }

        function back(){
            var addFrom  = $("#addFrom").val();
            if('rcxc' == addFrom){
                $("#hsa-record-input-add").show();
                $("#hsa-record-reportCard-add").empty();
            }else if('bgdj' == addFrom){
                $("#hsa-report-record-input-content").show();
                $("#hsa-record-card-add").empty();
            }


        }

        function queryPerson(idCard, validate) {
            if (validate.validate("idcard")) {
                $.getJsonByUrl({
                    url: "/idm/report/queryPerson",
                    wait: true,
                    callback: function (data) {
                        if (!isEmpty(data)) {
                            if (data.flag) {
                                setPersonData(data);
                            } else {
                                setIcData(data.Idcard);
                            }
                        }
                    },
                    param: {idCard: idCard}
                });
            }
        }

        /**
         * 根据身份证获取信息
         */
        function setPersonData(data) {
            $("input[name='idcard']").val(data.Idcard);
            $("input[name='name']").val(data.Name);
            if (isEmpty(data.Birthday)) {
                var birthday = IC.getBirthday(data.Idcard);
                $("input[name='birthday']").val(birthday);
            } else {
                $("input[name='birthday']").val(data.Birthday);
            }
            var gender;
            if (isEmpty(data.Gender)) {
                gender = IC.getGender(data.Idcard);
            } else {
                gender = data.Gender;
            }
            $("input[name='gender'][value='" + gender + "']").attr("checked", true);
            $("input[name='floatPopulation'][value='" + data.FloatPopulation + "']").attr("checked", true);
            $("input[name='phoneNumber']").val(data.PhoneNumber);
            $("select[name='infectedpersonOccupation']").val(data.Occupation);
            toggleOtherSC('infectedpersonOccupation', 'spanOccupationOther', 'CV020120299');
            // if (!isEmpty(data.PatownShip)) {//现住址
            //    $('#patown_address').val(data.PatownShip);
            //    $("#patown_address").multiselect('refresh');
            //     var idd = $("#patown_address").attr("idd").replace('townId', '');
            //     getVillageOpting(idd, "", data.Pastreet);
            //     if (!isEmpty(data.Pastreet)) {
            //         $('#pavillage_address').val(data.Pastreet);
            //     }
            // }
            if (!isEmpty(data.PahouseNumber)) {
                $('#pahouseNumber').val(data.PaAddress);
            }
            toggerAddress();

        }

        /*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
        function setIcData(idCard) {
            var gender = IC.getGender(idCard);
            if (!isEmpty(gender)) {
                $('#gender').val(gender);
            }
            var birthday = IC.getBirthday(idCard);
            if (!isEmpty(birthday)) {
                $('#birthday').val(birthday);
            }
        }

        /*隐藏、显示地址*/
        function toggerAddress() {
            $("input[name='floatPopulation']").on("click", function () {
                if ("1" == $(this).val()) {
                    changeAddress("1");
                } else {
                    changeAddress("2");
                }
            });
            displayPaAddress();
        }

        function changeAddress(type) {
            /*  if (type == "1") {
                 //该控件被隐藏，所以需要添加validate
                 $("select[name='patownShip']").data('validate',true);
                 $("select[name='pastreet']").data('validate',true);

                 $("#pa-address-select").attr("class", "");
                 $("#tempPaValue").show();
                 $('#spanPaNumber').text("门牌号");
                 $('#pahouseNumber').attr({"style": "width:180px"});
             } else { */
            //该控件被隐藏，所以需要添加validate
            $("select[name='patownShip']").data('validate',false);
            $("select[name='pastreet']").data('validate',false);
            $("#pa-address-select").attr("class", "hide");
            //$("#pa-address-select").find("select").attr("disabled", "disabled").hide();
            $("#tempPaValue").hide();
            $('#spanPaNumber').text("详细地址");
            $('#pahouseNumber').attr({'style': 'width:90%'});
            // }
        }

        function displayPaAddress() {
            $("select[name='pastreet']").on("change villageChange", function () {
                $(this).multiselect('refresh');
                var prefix = $("select[name='patownShip']").find("option[value!='']:selected").text();
                prefix += $(this).find("option[value!='']:selected").text();
                if (isEmpty($('input:radio[name="floatPopulation"]:checked').val())) {
                    $("#tempPaValue").text("");
                } else {
                    $("#tempPaValue").text(prefix);
                }
            });
            if (isEmpty($('input:radio[name="floatPopulation"]:checked').val())) {
                $("#tempPaValue").hide();
            }
        }

        function customValidate(){
            var idCard = $('#idCardTemp').val();
            if(idCard == '输入身份证获取人员信息'){
                $('#idCardTemp').val('');
            }
        }
    })();

    //切换发热选项
    function changeHot(){
        var hasHot=false;
        $('input[name="intestinalInfection"]:checked').each(function(){
            alert($(this).val());
            //如果选择了209发热
            if($(this).val()==209){
                hasHot=true;
                $("#feverTemp").attr('reg','{"maxlength":"4","required":"true","min":"37.5","scale":"1","regex":"number"}');
                $("#feverTemp").removeAttr("disabled");
            }
        });
        //未选择发热则移除校验
        if(!hasHot){
            $("#feverTemp").removeAttr("reg");
            validate.removeCheckElement("feverTemp");
            $("#feverTemp").attr("disabled",'true');
        }
    }
    //填写可疑食物以后，暴露信息必须勾选，可多选
    function foodBlur(){
        var food1=$("#food1").val();
        var food2=$("#food1").val();
        if(food1!=''||food2!=''){
            $('input[name="foodHistory"]').each(function(){
                $(this).attr('reg','{"required":"true"}');
            });
        }else{
            $('input[name="foodHistory"]').each(function(){
                $(this).removeAttr("reg");
            });
            validate.removeCheckElement("foodHistory");
        }
    }

    function emesisNumBlur() {
        var emesis = $('input[name="wholeBody"][value="102"]').is(":checked");
        if (emesis) {
            $("#emesisNum").attr('reg','{"required":"true","regex":"number"}');
        }
    }
</script>