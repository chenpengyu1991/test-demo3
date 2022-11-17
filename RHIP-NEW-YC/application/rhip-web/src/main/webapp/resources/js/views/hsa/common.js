var HsaCommon = (function() {
	var ex = {};

	/**
	 * 
	 */
	ex.toggle = toggle;
	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}

	/**
	 * 
	 */
	ex.initSelect = initSelect;
	function initSelect(firstSelect, secondSelect, dataUrl) {
		var $townSelect = $(firstSelect);
		$.getJsonByUrl({
			url : dataUrl,
			callback : function(data) {
				var items = data;
				var secondQuery = secondSelect;
				// console.log(data);
				$townSelect.on("change", function(e) {
					setOrgSelect(items, $(this).val(), secondQuery);
					showSelectTip(secondQuery);
				});
			}
		});
	}

	/**
	 * 
	 */
	ex.makeFormViewOnly = makeFormViewOnly;
	function makeFormViewOnly($form) {
		if ($form)
		{
			$form.find("input,textarea").prop("readonly", true);
			$form.find("input[type='checkbox']").prop("disabled", true);
			$form.find("input[type='radio']").prop("disabled", true);
			$form.find("select").prop("disabled", true);
			$form.find(".required").removeClass("required");
		}
	}

	/**
	 * 
	 */
	ex.checkFromToDate = checkFromToDate;
	function checkFromToDate(fromSelector, toSelector) {
		var reportCreateStartDate = $(fromSelector).val();
		var reportCreateEndDate = $(toSelector).val();
		if (reportCreateStartDate && reportCreateEndDate && new Date(reportCreateStartDate) > new Date(reportCreateEndDate))
		{
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}

	function setOrgSelect(orgs, key, orgSelectId) {
		var $orgSelect = $(orgSelectId);
		var seletedValue = $orgSelect.attr("data-value");
		$orgSelect.empty();
		$orgSelect.append("<option value='' >请选择</option>");
		if (key)
		{
			var data = orgs[key];
			$orgSelect.attr("title", "");
			if (data)
			{
				$.each(data, function(index, item) {
					if (0 === index)
					{
						$orgSelect.attr("title", item.value);
					}
					$orgSelect.append("<option title=" + item.value + " value='" + item.key + "'  >" + item.value + "</option>");
				});
				$orgSelect.show();
			}
		}
		if (seletedValue)
		{
			$orgSelect.val([ seletedValue ]);
		}
	}

	function showSelectTip(selectId) {
		var $target = $(selectId);
		$target.on("change", function() {
			var value = $target.find('option:selected').text() || "";
			$target.attr("title", value);
		});
	}

	return ex;
})();