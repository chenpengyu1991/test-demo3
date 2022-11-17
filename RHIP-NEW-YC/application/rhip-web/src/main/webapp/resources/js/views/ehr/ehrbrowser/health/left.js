var brwMcManage = (function () {
    $(function () {

//        initTree();

        $(".manageSelect").on("click", function () {
            var url = "/ehrbrowser/health/" + $(this).attr("id");
            var loadHtmlByUrlOption = {
                url: url,
                param: {
                    personId: $("#ehrbrowser_person_id_input").val(),
                    person_idcard:$("#ehrbrowser_person_idcard_input").val()
                },
                insertDiv: "content"
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        });

        $(".childExamSelect").on("click", function () {
            var url = "/ehrbrowser/health/childExamDetail";
            var loadHtmlByUrlOption = {
                url: url,
                param: {
                    examId: $(this).attr("id")
                },
                insertDiv: "content"
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        });

    });

    function initTree() {
        $("#healthTree").treeview({
            animated: "fast",
            collapsed: true,
            unique: true,
            persist: "location"
        });

        $("#healthTree").find("a").click(function () {
            $("#healthTree").find("span.active").removeClass("active");
            $(this).parent().addClass("active");
        });
    }
})();