var hmFissureSealantReport = (function() {
	$(function() { 
		var selectSchools = $("input:checkbox[name='schoolCode']:checked");
		$("label[name='schoolName']").each(function() {
			var school = $(this).attr("school");
			var schoolChecked = selectSchools.filter("[value='" + school +"']");
			if (schoolChecked) {
				$(this).html(schoolChecked.parent().text());
				$(this).attr("title", schoolChecked.parent().text());
			}
		});
	});

	return {
		
	};
})();