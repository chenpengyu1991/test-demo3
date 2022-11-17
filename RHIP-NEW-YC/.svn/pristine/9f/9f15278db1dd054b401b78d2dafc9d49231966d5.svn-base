var standardIndex = (function() {
	$(function() { 	
        /*服药登记*/
        $("#drugRegId").click(function() {
        	$('#standardType').val(1);
            reload();
            loadSearch();
        });
        /*疫点处理*/        
        $("#epidemic").click(function() {
        	$('#standardType').val(2);
            reload();
            loadSearch();
        }); 
        /*访视记录*/        
        $("#interview").click(function() {
        	$('#standardType').val(3);
            reload();
            loadSearch();
        });         
        /*休根服药*/
        $("#restinPhase").click(function() {
        	$('#standardType').val(4);
            reload();
            loadSearch();
        });
        /*重点人群休止期督导服药*/        
        $("#keyPopulation").click(function() {
        	$('#standardType').val(5);
            reload();
            loadSearch();
        }); 
        /*主动病例侦查记录*/        
        $("#detectRecord").click(function() {
        	$('#standardType').val(6);
            reload();
            loadSearch();
        }); 
        $(".thirdMenu a").click(function(){
            $(".thirdMenu").find(".active").removeClass("active");
            $(this).parent().addClass("active");
        });        
        loadSearch();

	});
	/*加载查询*/
	function loadSearch() {
		var standardType = $('#standardType').val();
		standardType = $.isEmpty(standardType)?1:standardType;
		var loadHtmlByUrlOption = {
			url : "/idm/malaria/standard/search",
			param : {standardType:standardType},
			checkRepeat : true,
			insertDiv : "searchDiv",
			errorDiv: "",
//            wait : true,
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};	
	return {
	};

    function reload() {
        hideDiv("standard_detailDiv");
        hideDiv("standard_printDiv");
        showDiv("standard_top_all");
    }
    function showDiv(id) {
        document.getElementById(id).style.display = "";
    }

    function hideDiv(id) {
        document.getElementById(id).style.display = "none";
    }
})();