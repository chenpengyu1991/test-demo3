var hmStudentExamBase = (function() {
	/**
	 * 根据学校类型显示学校列表
	 */
	function refreshSchool(type){
		$.getJsonByUrl({
			url : contextPath + "/hm/studentExam/schoollist",
			checkRepeat : false,
			callback : function(data)
			{
				// 删除option
				var i = 0;
				while ($("select[name='schoolCode'] option").length > 0 && i <= $("select[name='schoolCode'] option").length)
				{
					$("select[name='schoolCode'] option:last").remove();
					i = 0;
				}
				if (data != "empty")
				{
					$("select[name='schoolCode']").append("<option value=\"\">请选择</option>");
					$("select[name='schoolCode']").append(data);
				} else
				{
					$("select[name='schoolCode']").append("<option value=\"\">请选择</option>");
				}
			},
			param : {
				type : type
			}
		});		
	}
	return {
		refreshSchool:refreshSchool
	};
})();