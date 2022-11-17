var brwHealthFrailChildFollow = (function(){
	$(function(){
		getFrailChildFollow($(".frailChildFollowup:first").val());
	});
	
	function getFrailChildFollow(id){
		var loadByUrl = {
			url : "/childrenHealthCare/frailChildFollowup",
			insertDiv : "frailChildFollowupDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getFrailChildFollow : getFrailChildFollow
	};
})();