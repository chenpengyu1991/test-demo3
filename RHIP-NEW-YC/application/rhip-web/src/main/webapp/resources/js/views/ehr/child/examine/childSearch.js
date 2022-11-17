/**
 * Created by jingqiu on 17-3-23.
 */
var childSearch = (function() {
    var examineAgeGroup;
    $(function () {
        examineAgeGroup = $('#examineAgeGroup').val()
        organSelect.initOrg('organCode');
        search(1);
        $('#newChildExamBtn').click(function() {
            $('#child-exam-list-box').hide();
            $('#child-exam-input-box').show();
            $.loadHtmlByUrl({
                url: '/childHealthExamine/editExam',
                insertDiv: 'child-exam-input-box',
                param: {
                    examineAgeGroup: examineAgeGroup
                }
            })
        });
        $('#child_search_btn').click(function(e) {
                e.preventDefault();
            search(1);
        });
        $('#child-exam-search-toggle-btn').click(function() {
            $(this).toggleClass("ico-top");
            $(this).toggleClass("ico-bottom");
            $("#child-health-exam-search-table").toggle();
        })
    });

    function search(index) {
        $('#childSearchForm').submitFormLoadHtml({
            url: '/childHealthExamine/childSearch',
            insertDiv: 'childListDiv',
            param : {
                indexPage : index,
                examineAgeGroup : examineAgeGroup
            }
        })
    }

    return {
        examineAgeGroup: examineAgeGroup,
        search: search
    }
})();