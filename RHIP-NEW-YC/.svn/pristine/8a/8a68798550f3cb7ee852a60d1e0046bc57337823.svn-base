/**
 * Created with IntelliJ IDEA.
 * User: mindust
 * Date: 12-12-5
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */

var ehrBrowserBasic = (function() {

    $(function() {

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
//        $("#basic_cover").empty();
//        $("#basic_info").empty();
//        $("#basic_physical_examination").empty();
        $("#basic_cover").html("");
        $("#basic_info").html("");
        $("#basic_physical_examination").html("");
    };

    return {
    };
})();
