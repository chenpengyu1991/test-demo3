var addFamily = (function() {
    $(function() {
        personIndex();
    });

    function personIndex() {
        $.loadHtmlByUrl({
            url : contextPath + "/family/person/lookUp",
            insertDiv : "memberDiv",
            param : null
        });
    }
})();