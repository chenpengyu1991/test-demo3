var healthCheckEdit = (function() {
	var validate=null;
	$(function() {
		validate = $("#healthCheckForm").easyValidate();
        toggleOtherCK('diseaseType','diseaseOtherId','99');
//		toggleOtherCK('mhmEmergency.disposerReason','MH00030Id','99');
//        toggleOther('bringIntoFlag', 'mgntPart', 1);
        toggleOtherMgnt('bringIntoFlag', 1);
        toggleOtherSC('bringIntoMode', 'bringIntoModeBase', 2);
        toggleOther('challengedFlag', 'challenged', 1);
        toggleOther('effectFlag', 'ref', 1);
        toggleLocalAddress('floatPopulation', 'localPart', 1);
        toggerAddress();
        var idCard = $('#idCard').val();
        $.Placeholder.init({query:"#idCard",callback:function(element){
            queryPerson($(element).val());
        }});
        displayPaAddress();
        displayHrAddress();
        changeFreeFlag;
        mhmCommon.addIcd10AutoComplete("mhmIcd10CodeId");
        if($.isEmpty($("#birthdate").val())&&!$.isEmpty($("#idCard").val())){
        	$("#birthdate").val(IC.getBirthday($("#idCard").val()));
        }
	});
	
	function toggerAddress(){
        var value=$('input[name="floatPopulation"]:checked').val();
        if('1' == value){
            changeAddress("1");
            $('#br').show();
        }else if('2' == value) {
            changeAddress("2");
            $('#br').hide();
        }
        /*toggleOther('floatPopulation','pavillage_address','1');
        toggleOther('floatPopulation','patown_address','1');*/
        displayPaAddress();
    }
    //提交钱验证的内容
    function customValidate(){
        var idCard = $('#idCard').val();
        if(idCard == '输入身份证获取个人信息'){
            $('#idCard').val('');
        }
    }
    /*function displayPaAddress() {
        $("select[name='pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }*/
    function displayHrAddress(){

        var town = $("select[name='hrtownShip'] option:selected").text();
        var street = $("select[name='hrstreet'] option:selected").text();
        var village = $("select[name='hrGroup'] option:selected").text();
        if(!$.isEmpty($("select[name='hrGroup'] option:selected").val())) {
            $("#hrhouseNumber").removeAttr("reg");
            $("#hrhouseNumber").removeClass("lose");
        }
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择')
            result = result + street;
        if (village != '请选择') {
            result = result + village;
        }
        $("#tempHrValue").text(result);
    
    }
    
    function displayPaAddress() {
        var town = $("select[name='patownShip'] option:selected").text();
        var street = $("select[name='pastreet'] option:selected").text();
        var village = $("select[name='paGroup'] option:selected").text();
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择')
            result = result + street;
        if (village != '请选择') {
            result = result + village;
        }
        $("#tempPaValue").text(result);
    }
    function queryPerson() {
    	var idCard=$("#idCard").val();
    	if (validate.validate("idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                        }else{
                            setIcData(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
    };
    function changeAddress(type){
        if(type=="1"){
        	toggleLocalAddress('floatPopulation', 'localPart', 1);
        	 $("#pavillage_address").removeAttr("disabled");
             $("#hrvillage_address").removeAttr("disabled");
             $("#pastreet_address").removeAttr("disabled");
             $("#hrStreet_address").removeAttr("disabled");
             $('#patown_address').removeAttr("disabled");
             $('#hrtown_address').removeAttr("disabled");
             $("#tempPaValue").show();
             $("#tempHrValue").show();
             $('#spanPaNumber').text("门牌号");
             $('#spanHrNumber').text("门牌号");
             $('#pahouseNumber').attr({"style":"width:180px"});
             $('#hrhouseNumber').attr({"style":"width:180px"});
        }else if(type=="2"){
        	$("#pavillage_address").attr("disabled", "disabled");
            $("#hrvillage_address").attr("disabled", "disabled");
            $("#pastreet_address").attr("disabled", "disabled");
            $("#hrStreet_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
            $("#hrtown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $("#tempHrValue").hide();
            $('#spanPaNumber').text("详细地址");
            $('#spanHrNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
            $('#hrhouseNumber').attr({'style':'width:90%'});
        }
    }
    /*
     * 根据健康档案设置患者基本信息
     * */
    function setPersonData(data){
            $('#healthCheckName').val(data.Name);
        if(!$.isEmpty(data.Logoff)){
            $('#logoffIdd').val(data.Logoff);
        }
        var gender;
        if($.isEmpty(data.Gender)){
            gender = IC.getGender(data.Idcard);
        }else{
            gender = data.Gender;
        }
        if(!$.isEmpty(data.PhoneNumber)){
            $('#familyPhone').val(data.PhoneNumber);
        }
        $('input[type=radio][name="gender"][value=' + gender + ']').attr("checked",true);

        if(!$.isEmpty(data.UnitName)){
            $('#unitNameId').val(data.UnitName);
        }
        if(!$.isEmpty(data.Occupation)){
            $('#occupationId').val(data.Occupation);
        }
        /*if(!$.isEmpty(data.PatownShip)){//现住址
            $('#patown_address').val(data.PatownShip);
            var idd = $("#patown_address").attr("idd").replace('townId', '');
            orgUtil.getVillageOpting(idd,"",data.Pastreet);
            if(!$.isEmpty(data.Pastreet)){
                $('#pavillage_address').val(data.Pastreet);
            }
        }
        if(!$.isEmpty(data.PahouseNumber)){
            $('#pahouseNumber').val(data.PahouseNumber);
        }*/
        toggleOtherSC('occupation','spanOccupationOther','CV020120299');
        if(!$.isEmpty(data.FloatPopulation) && data.FloatPopulation=="1"){
            $('input[name="floatPopulation"][value="1"]').attr("checked",true);
        }else{
            $('input[name="floatPopulation"][value="1"]').attr("checked",false);
        }
        toggerAddress();
        var iddStreet;
        if(data.PatownShip!=null){
            $("#patown_addresss").val(data.PatownShip);
            iddStreet=$("#patown_addresss").attr("idd").replace('townId', '');
        }
        if(!$.isEmpty(data.Nation)){
            $('#nationId').val(data.Nation);
        }
        if(!$.isEmpty(data.Education)){
            $('#educationId').val(data.Education);
        }
        var idCardBirthDay = IC.getBirthday($("#idCard").val());
        $("#birthdate").val(idCardBirthDay);
        orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
    }

    /*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
    function setIcData(idCard){
        var gender = IC.getGender(idCard);
        if(!$.isEmpty(gender)){
            $('#gender').val(gender);
        }
    }

    function toggleOtherMgnt(rName, eqValue){
        toggleOther('bringIntoFlag', 'mgntPart', 1);
        var raValue = $('input[name="' + rName + '"]:visible:checked').val();
        if (raValue == eqValue)
        {
            $("#save1").show();
            $("#save2").hide();
        }else{
            $("#save1").hide();
            $("#save2").show();
        }
    }

    function toggleLocalAddress(radioName, otherId, code)
    {
        var raValue = $('input[name="' + radioName + '"]:visible:checked').val();
        if (raValue == code)
        {
            $("#" + otherId).show();
            $("#" + otherId).find("input").each(function()
            {
                $(this).show();
            });
        } else
        {
            $("#" + otherId).hide();
        }
    }

    function changeFreeFlag(){
        var raValue = $('input[name="freeFlag"]:checked').val();
        if(1 == raValue){
            $("#stateEconomyId").val(1);
        }
    }
	
 	return {
        toggleOtherMgnt:toggleOtherMgnt,
        toggleLocalAddress:toggleLocalAddress,
        changeFreeFlag:changeFreeFlag,
        displayPaAddress:displayPaAddress,
        displayHrAddress:displayHrAddress,
        toggerAddress:toggerAddress,
        queryPerson:queryPerson
	};
})();