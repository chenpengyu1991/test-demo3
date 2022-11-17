/**
 * Created by haiyingjiang on 15/8/24.
 */
var medicineSearch = (function(){
    $(function() {
    	$('#commonName').bind('keypress', function (event) {
            if (event.keyCode == "13") {
            	search(1);
            }
        });
        $("#medicineSearchForm").onEnter(function () {
            search(1);
        });
        $("#searchMedicineId").click(function(){
            search(1);
        });
        search(1);
        initLinkClick('title',title, {id:"data-code"});
        
        $(".select_showbox").click(function() {$(".select_option").show();})
        $("body").bind("click",function(evt){
			if(evt.target!=$('.select_showbox').get(0)) {
			$('.select_option').hide();
			}
		}); 
        $(".select_option li").click(function() {
        	$(".select_showbox").text($(this).text());
        	$("#categoryNameOne").val($(this).attr('val'));
        	$(".select_option li").removeClass("selected");
        	$(this).addClass("selected");
        	$(".select_option").hide();
        })
        
    });

    function search(indexPage) {
        var option = {
            url: contextPath + "/infoShow/medicineList",
            insertDiv: "listMedicineDivId",
            wait: true,
            param: {
                indexPage: indexPage
            }
        };
        $("#medicineSearchForm").submitFormLoadHtml(option);
    };
    
    function title(id) {
		window.location.href = contextPath+ "/infoShow/infoList?code="+id+"&indexPage=1";
	}
    
    return {
        search: search
    }

})();