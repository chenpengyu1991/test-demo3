var contineRabiesPage = (function() {
	// 点击保存按钮
	$(function() {
		$("#injectVaccineBtn").click(function(e) {
			e.preventDefault();
			showInject();
		});

		$("#injectGrayBtn").click(function(e) {
			e.preventDefault();
			showInjectGray();
		});
		
		fillVaccineAdvise($('#vaccineTypeFlag').val());
	});

	// 获取删除或修改的URL
	function opUrl(type, op) {
		if (type == "1") {
			return "/ph/rabies/" + op;
		} else if (type == "2") {
			return "/ph/hepatitis/" + op;
		} else if (type == "3") {
			return "/ph/influenza/" + op;
		} else if (type == "4") {
			return "/ph/pneumonia/" + op;
		}
	}

    function opDivId(type) {
        if (type == "1") {
            return "vaccineRabiesDivId";
        } else if (type == "2") {
            return "vaccineHepatitisDivId";
        } else if (type == "3") {
            return "vaccineInfluenzaDivId";
        } else if (type == "4") {
            return "vaccinePneumoniaDivId";
        }
    }
	function showInject() {
		var inUrl = opUrl($("#vaccineType").val(), "injectOne");
		$.loadHtmlByUrl({
			url : inUrl,
			insertDiv : "continueRabies",
			param : {
				ehrId : $("#ehrId").val()
			}
		});
	}

	function showInjectGray() {
		$.loadHtmlByUrl({
			url : "/ph/rabies/injectGray",
			insertDiv : "continueRabies",
			param : {
				ehrId : $("#ehrId").val()
			}
		});
	}

	function deleteVaccine(id,ehrId) {
		var deleteUrl = opUrl($("#vaccineType").val(), "deleteVaccine");
		var index = layer.confirm("你确定要删除此接种信息", {icon:2, title:'确认提示'}, function() {
			$.getJsonByUrl({
				url : deleteUrl,
				param : {
					id : id,
					ehrId:$("#ehrId").val()
				},
				callback : function(data) {
					if (data == "1") {
						layui.use('layer', function() {
		        			var layer = layui.layer;
		        			layer.alert("删除成功！", {icon:0,title:'提示'});
		           		});
                        $.loadHtmlByUrl({
                            url : opUrl($("#vaccineType").val(), "searchVaccine"),
                            param : {
                                ehrId : $("#ehrId").val(),
                                operate: '2'
                            },
                            insertDiv : opDivId($("#vaccineType").val())
                        });
						return;
					}
					layui.use('layer', function() {
	        			var layer = layui.layer;
	        			layer.alert("删除失败！", {icon:0,title:'提示'});
	           		});
				}
			});

			layer.close(index);
		});
	}

//	function getHertDetail(personId){
//		$.getJsonByUrl({
//			url : "/hospital/records/flush/rabies",
//			param : {
//				personId : personId,
//				ehrId:$("#ehrId").val()
//			},
//			callback : function(data) {
//				$("#injectPattern0").hide();
//				$("#injectPattern1").hide();
//				$("#injectPattern2").hide();
//				$("#injectPattern3").hide();
//				$("#injectPattern4").hide();
//				$("#injectPattern5").hide();
//				$("#preOpsDateTxt").val("");
//				var id = "#injectPattern" + data.opsDateType;
//				$(id).show();
//				if(data.opsDateType != 0){
//					$("#preOpsDateTxt").val(data.preOpsDate);
//				}
//			}
//		});
//	}
	/**
	 * 疫苗注射情况提示
	 */
	function fillVaccineAdvise(vaccineType){
		if(!isEmpty(vaccineType)){
			$("[id^='injectPattern']").hide();
			var id = "#injectPattern" + vaccineType;
			$('#vacciantionFlag').val(vaccineType);//本次事件的性质,0、1、5表示重新接种，其他表示加强接种。
		    $("#flagMgmtId").val(vaccineType);
			$(id).show();	
		}
	}
	
	return {
		deleteVaccine : deleteVaccine
	};
})();