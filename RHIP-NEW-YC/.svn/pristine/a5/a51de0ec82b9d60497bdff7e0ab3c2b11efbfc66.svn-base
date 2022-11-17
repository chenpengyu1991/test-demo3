var filReport  = (function() {
   /* var option;*/
    var sameTag;
    $(function() {
        selectTag("ch");
        $("#ch_search_btn").click(function(e) {
            e.preventDefault();
            var scFlag = $("#scFlag").val();
            if('1' == scFlag){
                selectTag("ch");
            }else{
                selectTag("ph");
            }

        });

        $("#ch_export_btn").click(function(e) {
            e.preventDefault();
            downLoad();
        });

    });

    function selectTag(tagName){
        if( $("#selectedTagST").val() == tagName){
            sameTag = 1;

        }else{
            sameTag = 0;

        }
        $("#selectedTagST").val(tagName);

        search(1);

    }
    function downLoad(){
        debugger;
        var selectedTag =  $("#selectedTagST").val();
        if('ch' == selectedTag){
            $("#scFlag").val('1');
            location.href = contextPath + "/idm/filariasis/standard/downLoadChReport"+"?" + $('#followUpSearchForm1').formSerialize();

        }
        if('ph' == selectedTag){
            $("#scFlag").val('2');
            location.href = contextPath + "/idm/filariasis/standard/downLoadPhReport"+"?" + $('#followUpSearchForm1').formSerialize();

        }

    }

    function search(pageIndex) {
        var selectedTag =  $("#selectedTagST").val();
        var url = '';
        /*var selectedUnit = $("#patownShip").val();*/
        if('ch' == selectedTag){
            $("#scFlag").val('1');
            url = "/idm/filariasis/standard/chReportList";
            $("#drugRegId").addClass("active");
            $("#interview").removeClass("active");
        }
        if('ph' == selectedTag){
            $("#scFlag").val('2');
            url = "/idm/filariasis/standard/phReportList";
            $("#drugRegId").removeClass("active");
            $("#interview").addClass("active");
        }
        var searchObj = {
            url : url,
            insertDiv : "ChReportListDiv",
//                wait : true,
            param : {
                pageIndex : pageIndex,
                tag : selectedTag
            },
            callback: function(){sameTag = 1;}
        };
        $("#followUpSearchForm1").submitFormLoadHtml(searchObj);
    };

    return {
        search:search,
        selectTag:selectTag,
        downLoad:downLoad
    };
})();
