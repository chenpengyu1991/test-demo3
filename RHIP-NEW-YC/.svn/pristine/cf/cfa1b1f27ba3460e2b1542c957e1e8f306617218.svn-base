define(function(){
	var validate = null;
	function load() {
		$(function () {
			 toggleOtherCK('nerveSymptom','pupilException','513');
            toggleOtherCK('previousHistory','previousHistoryOther','99');
            toggleOtherCK('foodHistory','foodHistoryOther','99');
            validate = $("#report-input-form").easyValidate();

            $.Placeholder.init({query: "#idCardTemp", callback: function (element) {
                queryPerson($(element).val(), validate);
            }});

            $("#report-input-save-btn").on("click", save);
            
        	$("select").not("select[multiple]").multiselect({
    			multiple: false,
    			header : false,
    			noneSelectedText: "",
    			selectedList: 1
    		});

            var from  = $("#from").val();
            if('csws' != from){
                /*$.alerts.confirm("是否采样?", "确认提示", function(r){
                    if(r){
                        $("#fdm-report-card-main").show();
                        setResult(false);
                    }else{
                        setResult(true);
                        $("#fdm-report-card-message").show();
                    }
                });*/
                
                layui.use('layer', function(){
					var layer = layui.layer;
					layer.confirm('是否采样?', {icon:1, title:'确认提示'}, function(r){
						if(r){
	                        $("#fdm-report-card-main").show();
	                        setResult(false);
	                    }else{
	                        setResult(true);
	                        $("#fdm-report-card-message").show();
	                    }
					});
				});
            }else{
                $("#fdm-report-card-main").show();
                setResult(false);
            }
            toggerAddress();
            displayPaAddress();
	    });
	}

	function setResult(success) {
        var value = -1;
        if (success) {
            value = 1;
        }
        $("#report-input-form #report-result").val(value);
    }

    function save(event) {
    	event.preventDefault();
        var from  = $("#from").val();
    	
    	if($("#fdm-report-card-main").is(":hidden")){
    		layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("无需报卡，请关闭报卡界面！", {icon:0,title:'提示'});
    		});
			return;
		}

        customValidate();

        // validate
        var result = validate.validateForm();

         if (!result) {
    	     return;
         }
      
        $("#report-input-form").submitFormGetJson({
            url: "/fdm/reportCard/reportSave",
            callback: function (data) {
                setResult(true);
                if("csws" == from){
                    $("#report-input-save-btn").hide();
                }
                layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("报卡上报成功！", {icon:0,title:'提示'});
	    		});
            }
        });
    }

    function queryPerson(idCard, validate) {
        if (validate.validate("idcard")) {
            $.getJsonByUrl({
                url: "/idm/report/queryPerson",
                wait: true,
                callback: function (data) {
                    if (!$.isEmpty(data)) {
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
        if ($.isEmpty(data.Birthday)) {
            var birthday = IC.getBirthday(data.Idcard);
            $("input[name='birthday']").val(birthday);
        } else {
            $("input[name='birthday']").val(data.Birthday);
        }
        var gender;
        if ($.isEmpty(data.Gender)) {
            gender = IC.getGender(data.Idcard);
        } else {
            gender = data.Gender;
        }
        $("input[name='gender'][value='" + gender + "']").attr("checked", true);
        $("input[name='floatPopulation'][value='" + data.FloatPopulation + "']").attr("checked", true);
        $("input[name='phoneNumber']").val(data.PhoneNumber);
        $("select[name='infectedpersonOccupation']").val(data.Occupation);
        toggleOtherSC('infectedpersonOccupation', 'spanOccupationOther', 'CV020120299');

        if (!$.isEmpty(data.PatownShip)) {//现住址
            $('#patown_address').val(data.PatownShip);
            $("#patown_address").multiselect('refresh');
            var idd = $("#patown_address").attr("idd").replace('townId', '');
            getVillageOpting(idd, "", data.Pastreet);
            if (!$.isEmpty(data.Pastreet)) {
                $('#pavillage_address').val(data.Pastreet);
            }
        }
        if (!$.isEmpty(data.PahouseNumber)) {
            $('#pahouseNumber').val(data.PahouseNumber);
        }
        toggerAddress();

    }

    /*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
    function setIcData(idCard) {
        var gender = IC.getGender(idCard);
        if (!$.isEmpty(gender)) {
            $('#gender').val(gender);
        }
        var birthday = IC.getBirthday(idCard);
        if (!$.isEmpty(birthday)) {
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
        if (type == "1") {
            $("#pa-address-select").attr("class", "");
            $("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
            $('#pahouseNumber').attr({"style": "width:180px"});
        } else {
            $("#pa-address-select").attr("class", "hide");
            //$("#pa-address-select").find("select").attr("disabled", "disabled").hide();
            $("#tempPaValue").hide();
            $('#spanPaNumber').text("详细地址");
            $('#pahouseNumber').attr({'style': 'width:90%'});
        }
    }

    function displayPaAddress() {
        $("select[name='pastreet']").on("change villageChange", function () {
            $(this).multiselect('refresh');
            var prefix = $("select[name='patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            if ($.isEmpty($('input:radio[name="floatPopulation"]:checked').val())) {
                $("#tempPaValue").text("");
            } else {
                $("#tempPaValue").text(prefix);
            }
        });
        if ($.isEmpty($('input:radio[name="floatPopulation"]:checked').val())) {
            $("#tempPaValue").hide();
        }
    }

    function customValidate(){
        var idCard = $('#idCardTemp').val();
        if(idCard == '输入身份证获取人员信息'){
            $('#idCardTemp').val('');
        }
    }
	return {
		load: load
	};
})