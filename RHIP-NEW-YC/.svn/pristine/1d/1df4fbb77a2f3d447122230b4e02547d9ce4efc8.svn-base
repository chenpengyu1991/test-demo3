var childRecordIndex = (function() {
	var validate=null;
    $(function() {
    });

    function viewChildExams(babyCardNo) {
        $('#childRecordContent').empty();
        var examineAgeGroup = $("#examineAgeGroup").val();
        $.loadHtmlByUrl({
            url: '/childHealthExamine/examList',
            insertDiv: 'childRecordContent',
            param: {
                examineAgeGroup: examineAgeGroup,
                babyCardNo: babyCardNo
            }
        })
    }


	return {
        viewChildExams:viewChildExams
	};
})();



