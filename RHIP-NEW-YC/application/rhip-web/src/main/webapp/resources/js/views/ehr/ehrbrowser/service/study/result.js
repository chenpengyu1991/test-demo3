/**
 * Created by f on 2019/11/7.
 */
var studyResult=(function(){
    $(function() {
        //检查报告单
        	$(".study_report_btn").each(function(){
               $(this).on("click",function(event) {
                   debugger;
                   ehrbrowserServiceIndex.openStudyReport($(this), null);
               });
         });
    });
    return {

    };
})();