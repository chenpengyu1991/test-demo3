var epSamplingEdit = (function() {
	var validate
	$(function() {
		validate = $("#editForm").easyValidate();
		$("#save").click(function() {
			if (validate.validateForm()) {
				//check village duplication
				var villages = $("#villageTable select");
				for (var i = 0; i < villages.length - 1; i++) {
					for (var j = i + 1; j < villages.length; j++) {
						if ($(villages[i]).val() == $(villages[j]).val()) {
							layer.alert("有重复选择的村，请重新确认。", {icon:0,title:'提示'});return;
						}
					}
				}
				var option = {
					url: "/ep/iodate/saveSamplingRecord",
					wait : true,
					callback: submitCallback
				}
				$("#editForm").submitFormGetJson(option);
			}
		});
		$("#samplingTown").change(function() {
			var option = {
				url : "/ep/iodate/getVillages",
				param : {
					gbCode : $("#samplingTown").val()
				},
				callback : (function(tr) {
					$("#villageTable").empty();
					$("#villageTable").append(tr.replace(new RegExp("index", "g"), 0));
					$("#villageRow").empty();
					$("#villageRow").append(tr);
					$("#villageCount").val(1);
					validate = $("#editForm").easyValidate();
				})
			}
			$.getJsonByUrl(option);
		});
	});

	function submitCallback(result) {
		layer.alert(result.message, {icon:0,title:'提示'}, function(index){
			if (result.success) {
				$.removeDialog("editSamplingDialog");
				epSamplingSearch.search($("#indexPage").val());
			}
			layer.closeAll();
		});
	}

	function addRecord() {
		var tr = "<tr>" + $("#villageRow tr").html() + "</tr>"
		var count = $("#villageCount").val();
		tr = tr.replace(new RegExp("index", "g"), count);
		$("#villageCount").val(count * 1 + 1);
		$("#villageTable").append(tr);
		validate = $("#editForm").easyValidate();
	}

	function deleteRecord(obj) {
		if ($("#villageTable tr").length == 1) {
			addRecord();
		}
		$(obj).closest("tr").remove();
	}

	return {
		addRecord : addRecord,
		deleteRecord : deleteRecord
	}
})();