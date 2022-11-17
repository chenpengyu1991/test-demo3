var filariasis = (function() {
    var validate=null;
	$(function() {
        registerIndex();
    });

    /*加载监测登记页面*/
    function registerIndex() {
        var length = $('#tagContent1').has('form').length;
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/idm/filariasis/register/search",
                param : null,
                checkRepeat : true,
                insertDiv : "tagContent1",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };
    /*加载个案调查页面*/
    function caseIndex() {
        var length = $('#tagContent2').has('form').length;
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/idm/filariasis/case/search",
                param : null,
                checkRepeat : true,
                insertDiv : "tagContent2",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };
    /*加载规范化管理页面*/
    function standardIndex() {
        var length = $('#tagContent3').has('form').length;
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/idm/filariasis/standard/index",
                param : null,
                checkRepeat : true,
                insertDiv : "tagContent3",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };
    /*加载统计报表加载页面*/
    function reportIndex() {
        var length = $('#tagContent4').has('form').length;
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/idm/filariasis/standard/reportIndex",
                param : null,
                checkRepeat : true,
                insertDiv : "tagContent4",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };

    return {
        registerIndex:registerIndex,
        caseIndex:caseIndex,
        standardIndex:standardIndex,
        reportIndex:reportIndex
    };

})();
