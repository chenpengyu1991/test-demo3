var brwHealthTwotoFivevisit = (function(){
	$(function(){
        /*getsSfrqList($(".Ycfbh:first").val());*/
        getTwotoFivevisitDetail($(".WhYcfbjCqsf:first").val());
	});
	
	function getTwotoFivevisitDetail(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/twoToFivevisitDetail",
			insertDiv : "WhYcfbjCqsfDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}

    function getsSfrqList(ycfbh){
        $.each($("#dateTbl tr"), function(i){
        	this.style.display = 'none';
        });
        var btns = $('.'+ycfbh);
        btns.each(function(i, btn) {
            btn.style.display = null;
        });
    }
	
	return {
        getTwotoFivevisitDetail : getTwotoFivevisitDetail
       /* getsSfrqList:getsSfrqList*/
	};
})();