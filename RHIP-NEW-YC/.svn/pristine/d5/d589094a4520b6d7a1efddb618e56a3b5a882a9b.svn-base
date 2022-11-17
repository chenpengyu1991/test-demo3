var loadManagePlan = (function() {
				$(function() {
					validate = $("#followUpPlanForm").easyValidate();
				});
			function managePlanMenu(year) {
				$("#followUpPlanForm")
						.submitFormGetJson(
								{
									url : "/cdm/highrisk/loadManagePlan",
									param : {
										year : year
									},
									callback : function(data) {
										var year = $("#followYear").val();
										$("#gradation").empty();
										if ($.isEmpty(year)) {
											$("#gradation")
													.append(
															"<option value='' disabled='disabled'>请选择年度！</option>");
										} else if (data == "notExist") {
											$("#gradation")
													.append(
															"<option value='' disabled='disabled'>该年度无管理计划请先建立！</option>");
										} else if ($.isEmpty(data)) {
											$("#gradation")
													.append(
															"<option value='' disabled='disabled'>该阶段随访记录已制定完成！</option>");
										} else {
											for (var i = 0; i < data.length; i++) {
												$("#gradation").append(
														"<option value='"
																+ data[i]
																+ "'>" + year
																+ "年"
																+ "&nbsp;"
																+ "第" + data[i]
																+ "阶段"
																+ "&nbsp;"
																+ "</option>");
											}
										}
									}
								});
			}
			return {
				load : load,
				managePlanMenu : managePlanMenu
			};
		})();