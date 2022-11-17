/**
 * Created by jingqiu on 17-3-24.
 */
var childList = (function() {
    $(function () {
        examineAgeGroup = $('#examineAgeGroup').val()
        // $('#childListTable').on('click', '.child_view', function() {
        //     var babyCardNo ='';
        //     babyCardNo = $(this).data('babyCardNo');
        //     viewChildExams(babyCardNo);
        // });
        // $('#childListTable').on('click', '.child_add', function() {
        //     var babyCardNo ='';
        //     babyCardNo = $(this).data('babyCardNo');
        //     editChildExam(babyCardNo);
        // });
    });

    function viewChildExams(babyCardNo) {
        $('#child-exam-list-box').hide();
        $('#child-exam-input-box').show();
        var examineAgeGroup = $('#examineAgeGroup').val();
        $.loadHtmlByUrl({
            url: '/childHealthExamine/examList',
            insertDiv: 'child-exam-input-box',
            param: {
                examineAgeGroup: examineAgeGroup,
                babyCardNo: babyCardNo
            }
        })
    }

    function editChildExam(babyCardNo, examId) {
        $('#child-exam-list-box').hide();
        $('#child-exam-input-box').show();
        var examineAgeGroup = $('#examineAgeGroup').val();
        $.loadHtmlByUrl({
            url: '/childHealthExamine/editExam',
            insertDiv: 'child-exam-input-box',
            param: {
                examineAgeGroup: examineAgeGroup,
                babyCardNo: babyCardNo,
                examId: examId
            }
        })
    }
    function editChildExamSix(idCard, examId) {
        $('#child-exam-list-box').hide();
        $('#child-exam-input-box').show();
        var examineAgeGroup = $('#examineAgeGroup').val();
        $.loadHtmlByUrl({
            url: '/childHealthExamine/editExam',
            insertDiv: 'child-exam-input-box',
            param: {
                examineAgeGroup: examineAgeGroup,
                idCard: idCard,
                examId: examId
            }
        })
    }

    return {
        viewChildExams: viewChildExams,
        editChildExam: editChildExam,
        editChildExamSix:editChildExamSix
    }
})();