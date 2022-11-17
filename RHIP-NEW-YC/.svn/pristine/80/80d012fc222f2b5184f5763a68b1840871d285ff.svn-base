/**
 * Created with IntelliJ IDEA.
 * User: mindust
 * Date: 12-12-5
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */

var ehrBrowserBasic = (function() {

    $(function() {/*

        $("#basic_cover_a").click(function(){
            contentReset();
            selectTag('basic_cover',this);
            loadBasicHtml("cover","basic_cover");
        });

        $("#basic_info_a").click(function(){
            contentReset();
            selectTag('basic_info',this);
            loadBasicHtml("info","basic_info");
        });

        $("#basic_physical_examination_a").click(function(){
            contentReset();
            selectTag('basic_physical_examination',this);
            loadBasicHtml("physicalExamination","basic_physical_examination");
        });
        // $("#basic_child_fimaly_interview_a").click(function(){
        //     contentReset();
        //     selectTag('basic_child_fimaly_interview',this);
        //     loadBasicHtml("childFimalyInterview","basic_child_fimaly_interview");
        // });

        $("#basic_reception_status_a").click(function(){
            contentReset();
            selectTag('basic_reception_status',this);
            loadBasicHtml("getReceptionDate","basic_reception_status");
        });

        $("#basic_consultation_status_a").click(function(){
            contentReset();
            selectTag('basic_consultation_view',this);
            loadBasicHtml("consultation","basic_consultation_view");
        });

        $("#basic_referral_status_a").click(function(){
            contentReset();
            selectTag('referral_info',this);
            loadBasicHtml("referralInfo","referral_info");
        });

	 */
        loadBasicHtml("cover","basic_cover");
   });

    /**
     *
     */
    function loadBasicHtml(moduleName, divId){

        $.loadHtmlByUrl({
            url : contextPath + "/ehrbrowser/basic/"+moduleName,
            insertDiv :divId,
            param:{
                personId: $("#ehrbrowser_person_id_input").val()
            }
        });
    };

    function contentReset() {
        $("#basic_cover").html("");
        $("#basic_info").html("");
        $("#basic_physical_examination").html("");
        $("#basic_reception_status").html("");
        $("#basic_consultation_view").html("");
        $("#referral_info").html("");
    };

    return {
    	loadBasicHtml:loadBasicHtml
    };
})();
