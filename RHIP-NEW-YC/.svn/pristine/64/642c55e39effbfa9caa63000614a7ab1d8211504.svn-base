var otherquestion = (function(){
	$(function(){
		getPreFollowUpDetail($(".otherQuestions:first").val());
	});
	
	function getPreFollowUpDetail(id){
		var loadByUrl = {
			url : "/cdm/highRisk135/otherQuestion/edit",
			insertDiv : "otherQuestionsDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	var card;
    function save(idNo){
    	card = idNo;
    	alert(card);
    }
        function editNewQuestion(meNumber){
            var loadByUrl = {
                url : "/cdm/highRisk135/otherQuestion/newEdit",
                insertDiv : "questionEdit",
                param : {
                    meNumber : meNumber
                }
            };
            $.loadHtmlByUrl(loadByUrl);
        }



	
	return {
		getPreFollowUpDetail : getPreFollowUpDetail,
		save:save,
        editNewQuestion:editNewQuestion
	};
})();