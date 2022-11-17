var addressStatus = (function() {
	var validate = null;
	$(function() {
		validate = $("#sus-occ-dis-form").easyValidate();
		$("input[name='domicileType']").on("click", function() {
			if ("2" == $(this).val())
			{
				$("#hr-address-select").find("select").attr("disabled", "disabled").hide();
				$("#text_hrhouseNumber_prefix").hide();
			} else
			{
				$("#hr-address-select").find("select").removeAttr("disabled").show();
				$("#text_hrhouseNumber_prefix").show();
			}
		});
		// 地址变化
		$("select[name='pastreet']").on("change villageChange", function() {
			var prefix = $("select[name='pacounty']").find("option[value!='']:selected").text();
			var patownShip = $("select[name='patownShip']").find("option[value!='']:selected").text();
			prefix = prefix + patownShip;
			prefix += $(this).find("option[value!='']:selected").text();
			$("#text_pahouseNumber_prefix").text(prefix);
		});

		// 地址变化
		$("select[name='hrstreet']").on("change villageChange", function() {
			var prefix = $("select[name='hrtownShip']").find("option[value!='']:selected").text();
			var hrcounty = $("select[name='hrcounty']").find("option[value!='']:selected").text();
			prefix =  hrcounty + prefix;
			prefix += $(this).find("option[value!='']:selected").text();
			$("#text_hrhouseNumber_prefix").text(prefix);
		});
		$.Placeholder.init({
			query : "#idcard",
			callback : queryPerson
		});
	});
	function queryPerson(input) {
		var idCard = $("#idcard").val();
		if (idCard)
		{
			idCard = $.trim(idCard);
		}
		if (validate.validate("idcard"))
		{
			$.getJsonByUrl({
				url : "/hsa/inspRecord/sodp/loadPersonInfo",
				param : {
					"idcard" : idCard.toUpperCase()
				},
				wait : true,
				callback : function(data) {
					try
					{
						setPersonData(data);
					} catch (e)
					{

					}
				}
			});
		}
	}
	function setPersonData(data) {/*
		var idCard = $("#idcard").val();
		if (data)
		{
			$("#name").val(data.name);
			$("input[name='gender']").val([ data.gender ]);
			$("#age").val(data.age);
			$("#unitName").val(data.unitName);
			$("#unitPhoneNumber").val(data.unitPhone);
			$("input[name='domicileType']").val([ data.householdType ]);
			$("select[name='pacounty']").val(data.patownShip);
			$("select[name='hrcounty']").val(data.hrtownShip);
			var patownShipIdd = $("select[name='pacounty']").attr("idd");
			if (patownShipIdd)
				orgUtil.getVillageOpting(patownShipIdd.replace("townId", ""), "patownShip", data.pastreet);
			var hrtownShipIdd = $("select[name='hrcounty']").attr("idd");
			if (hrtownShipIdd)
				orgUtil.getVillageOpting(hrtownShipIdd.replace("townId", ""), "patownShip", data.hrstreet);
			$("input[name='pahouseNumber']").val(data.pahouseNumber);
			$("input[name='hrhouseNumber']").val(data.hrhouseNumber);
			$("#occupation_fordisplay").val([ data.occupation ]);
			if($("#occupation_fordisplay").val()){
				$("#occupation").val($("#occupation_fordisplay").find("option:selected").text());
			}
		} else
		{
			$("#name").val("");
			$("#age").val("");
			$("#unitName").val("");
			$("#unitPhoneNumber").val("");
			$('input[name="domicileType"]').val([ '1' ]);
			$("select[name='patownShip']").val("");
			$("select[name='hrtownShip']").val("");
			$("select[name='pastreet']").val("");
			$("select[name='hrstreet']").val("");
			$("#text_hrhouseNumber_prefix").text("");
			$("#text_pahouseNumber_prefix").text("");
			$("input[name='pahouseNumber']").val("");
			$("input[name='hrhouseNumber']").val("");
			$("#occupation").val("");
			try
			{
				var birthday = (IC.getBirthday(idCard)).substring(0, 4);
				// debugger;
				if (birthday)
				{
					var age = (new Date().getFullYear()) - parseInt(birthday, 10);
					$("#age").val(age);
				}
				$('input[name="gender"]').val([ IC.getGender(idCard) ]);
			} catch (e)
			{
				$('input[name="gender"]').val([ '' ]);
			}
		}
		$("input[name='domicileType']:checked").click();
	*/
        if(!$.isEmpty(data.name)){
            $('#name').val(data.name);
        }
        var gender;
        if($.isEmpty(data.gender)){
            gender = IC.getGender(data.Idcard);
        }else{
            gender = data.gender;
        }
        if(!$.isEmpty(data.phoneNumber)){
            $('#unitPhoneNumber').val(data.phoneNumber);
        }
        $('input[type=radio][name="gender"][value=' + gender + ']').attr("checked",true);

        if(!$.isEmpty(data.unitName)){
            $('#unitName').val(data.unitName);
        }
        if(!$.isEmpty(data.occupation)){
            $('#occupationId').val(data.occupation);
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
        if(!$.isEmpty(data.householdType) && data.householdType=="1"){
            $('input[name="domicileType"][value="1"]').attr("checked",true);
				$("#hr-address-select").find("select").removeAttr("disabled").show();
				$("#text_hrhouseNumber_prefix").show();
		
        }else{
            $('input[name="domicileType"][value="2"]').attr("checked",true);
            $("#hr-address-select").find("select").attr("disabled", "disabled").hide();
			$("#text_hrhouseNumber_prefix").hide();
        }
        toggerAddress();
        var iddStreet;var iddStreet2;
        if(data.patownShip!=null){
            $("#town_address").val(data.patownShip);
            iddStreet=$("#town_address").attr("idd").replace('townId', '');
        }
        if(data.hrtownShip!=null){
            $("#homeTown_address").val(data.hrtownShip);
            iddStreet2 = $("#homeTown_address").attr("idd").replace('townId', '');
        }
        if(!$.isEmpty(data.nation)){
            $('#nationId').val(data.nation);
        }
        if(!$.isEmpty(data.education)){
            $('#educationId').val(data.education);
        }
        orgUtil.getStreetOpting(iddStreet, data.pastreet, '', data.paGroup);
        setTimeout(function () {
            orgUtil.getStreetOpting(iddStreet2, data.hrstreet, '', data.hrGroup);
        }, 500);
	
	}
	 function toggerAddress(){
	        var value=$('input[name="domicileType"]:checked').val();
	        if('1' == value){
	            changeAddress("1");
	            $('#br').show();
	        }else if('2' == value) {
	            changeAddress("2");
	            $('#br').hide();
	        }
	        /*toggleOther('mhmBasicsInfo.floatPopulation','pavillage_address','1');
	        toggleOther('mhmBasicsInfo.floatPopulation','patown_address','1');*/
	        displayPaAddress();
	        displayHrAddress();
	    }
	 
	    function displayPaAddress() {
	    	var town = $("select[name='pacounty'] option:selected").text();
	        var street = $("select[name='patownShip'] option:selected").text();
	        var village = $("select[name='pastreet'] option:selected").text();
	        if(!$.isEmpty($("select[name='pastreet'] option:selected").val())) {
	            $("#text_pahouseNumber").removeAttr("reg");
	            $("#text_pahouseNumber").removeClass("lose");
	        }
	        var result = '';
	        if (town != '请选择')
	            result = town;
	        if (street != '请选择')
	            result = result + street;
	        if (village != '请选择') {
	            result = result + village;
	        }
	        $("#text_pahouseNumber_prefix").text(result);
	    }
	    function displayHrAddress() {
	        var town = $("select[name='hrcounty'] option:selected").text();
	        var street = $("select[name='hrtownShip'] option:selected").text();
	        var village = $("select[name='hrstreet'] option:selected").text();
	        if(!$.isEmpty($("select[name='hrstreet'] option:selected").val())) {
	            $("#text_hrhouseNumber").removeAttr("reg");
	            $("#text_hrhouseNumber").removeClass("lose");
	        }
	        var result = '';
	        if (town != '请选择')
	            result = town;
	        if (street != '请选择') {
	            result = result + street;
	        }
	        if (village != '请选择')
	            result = result + village;
	        $("#text_hrhouseNumber_prefix").text(result);

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

	 function changeAddress(type){
	        if(type=="1"){
	        	toggleLocalAddress('domicileType', 'localPart', 1);
	        	 $("#pavillage_address").removeAttr("disabled");
	             $("#homeVillage_address").removeAttr("disabled");
	             $("#pastreet_address").removeAttr("disabled");
	             $("#homeStreet_address").removeAttr("disabled");
	             $('#patown_address').removeAttr("disabled");
	             $('#homeTown_address').removeAttr("disabled");
	             $("#text_pahouseNumber_prefix").show();
	             $("#text_hrhouseNumber_prefix").show();
	             $('#spanPaNumber').text("门牌号");
	             $('#spanHrNumber').text("门牌号");
	             $('#pahouseNumber').attr({"style":"width:180px"});
	             $('#text_hrhouseNumber').attr({"style":"width:180px"});
	        }else if(type=="2"){
	        	$("#pavillage_address").attr("disabled", "disabled");
	            $("#homeVillage_address").attr("disabled", "disabled");
	            $("#pastreet_address").attr("disabled", "disabled");
	            $("#homeStreet_address").attr("disabled", "disabled");
	            $("#patown_address").attr("disabled", "disabled");
	            $("#homeTown_address").attr("disabled", "disabled");
	            $("#text_pahouseNumber_prefix").hide();
	            $("#text_hrhouseNumber_prefix").hide();
	            $('#spanPaNumber').text("详细地址");
	            $('#spanHrNumber').text("详细地址");
	            $('#pahouseNumber').attr({'style':'width:90%'});
	            $('#text_hrhouseNumber').attr({'style':'width:90%'});
	        }
	    }
	    
	return {
		queryPerson : queryPerson,
		setPersonData : setPersonData
	};
})();