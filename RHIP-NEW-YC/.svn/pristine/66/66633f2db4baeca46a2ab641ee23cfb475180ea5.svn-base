/**
 * Created by haiyingjiang on 15/8/24.
 */
var interactionSearch = (function(){
    $(function() {
        $("#searchIneractionId").click(function(){
            search(1);
        });
        search(1);
        
        $("#toZx").click(function() {
        	$('#messageForm').slideToggle();
        	$("#interactionForm span").html("");
		});
    });

    function search(indexPage) {
        var option = {
            url: contextPath + "/interactionShow/list",
            insertDiv: "listInteractionDivId",
            wait: true,
            param: {
                indexPage: indexPage
            }
        };
        $("#interactionSearch").submitFormLoadHtml(option);
    };
    
    return {
        search: search
    }

})();