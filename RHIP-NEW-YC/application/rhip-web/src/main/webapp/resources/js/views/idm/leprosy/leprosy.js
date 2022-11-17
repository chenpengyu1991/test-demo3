var leprosyIndex = (function() {
	$(function() {
        $(".thirdMenu a").click(function(){
            //以下代码为：主内容区二级菜单切换显示定位的问题
            var idString = $(this).parent().parent().attr("id");
            $("#"+idString).find(".active").removeClass("active");
            $(this).parent().addClass("active");
        });



	});
    
    $("#caseId").click(function() {
    	loadSearchPage('/idm/leprosy/case/search', 'case');
    	showDiv('case');
    	hideDiv('contact');
    	hideDiv('followup');
    });
    
    $("#contactId").click(function() {
    	loadSearchPage('/idm/leprosy/contact/search', 'contact');
    	showDiv('contact');
    	hideDiv('case');
    	hideDiv('followup');
    });

    $("#followupId").click(function() {
    	loadSearchPage('/idm/leprosy/followup/search', 'followup');
    	showDiv('followup');
    	hideDiv('case');
    	hideDiv('contact');
    });
    
    $("#contactStatisticsId").click(function() {
    	loadSearchPage('/idm/leprosy/statistics/index', 'contactStatistics');
    	showDiv('contactStatistics');
    	hideDiv('followupStatistics');
    });
    
    $("#followupStatisticsId").click(function() {
    	loadSearchPage('/idm/leprosy/statistics/index', 'followupStatistics');
    	showDiv('followupStatistics');
    	hideDiv('contactStatistics');
    });
    
    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };


    function showDiv(id) {
    	document.getElementById(id + 'Page').innerHTML = "";
    	document.getElementById(id + 'Page').style.display = "";
    }
    
    function hideDiv(id) {
    	document.getElementById(id + 'Page').innerHTML = "";
    }
    
    function loadSearchPage(url, id) {
    	$.loadHtmlByUrl({
			url : url,
//            wait : true,
			insertDiv :id + 'Page'
		});
    }
    
    return {
        toggle:toggle
    };

})();
