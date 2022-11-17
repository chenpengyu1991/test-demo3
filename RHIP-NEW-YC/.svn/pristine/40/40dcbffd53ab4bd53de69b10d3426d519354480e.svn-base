var hmStudentExamReport = (function() {
	$(function() {
		var selectSchools = $("input:checkbox[name='schoolCode']");
		var selectGrades = $("input:checkbox[name='gradeCode']");
		$("label[name='gradeName']").each(function() {
			var school = $(this).attr("school");
			var grade = $(this).attr("grade");
			var schoolChecked = selectSchools.filter("[value='" + school +"']");
			var gradeChecked = selectGrades.filter("[value='" + grade +"']");
			if (schoolChecked) {
				$(this).text(schoolChecked.parent().text());
				$(this).attr("title", schoolChecked.parent().text());
			}
			if (gradeChecked) {
				var schoolName = $(this).html() + gradeChecked.parent().text();
				$(this).text(schoolName);
				$(this).attr("title", schoolName);
			}
		});
	});

	return {
		
	};
})();