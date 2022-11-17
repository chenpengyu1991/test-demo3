var loadStageMenu = (function() {
				$(function() {
					validate = $("#managePlanForm").easyValidate();
				});
			function managePlan(year) {
				$("#managePlanForm")
						.submitFormGetJson(
								{
									url : "/cdm/highrisk/loadStageMenu",
									param : {
										year : year
									},
									callback : function(data) {
										var year = $("#year").val();
										$("#gradation").empty();
										if ($.isEmpty(data)) {
											$("#gradation")
													.append(
															"<option value='' disabled='disabled'>该年度管理计划已制定完成！</option>");
										} else if ($.isEmpty(year)) {
											$("#gradation")
													.append(
															"<option value='' disabled='disabled'>请选择年度！</option>");
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
				load : load ,
				managePlan : managePlan
			};
		})();