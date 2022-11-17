var ehrbrowserBase = (function() {
    var serviceType="brwservice";
	$(function(){
        // healthHistory();
		$("#lifeEvent").on("click", lifeEvent);
        $("#ehrbrw-hbp-chart-btn").on("click",openHbpChart);
        $("#ehrbrw-di-chart-btn").on("click",openDiChart);
        $(".person-merge-link-btn").on("click", openPersonMerge);
	});
	
	 function openPersonMerge(){
		 debugger;
        var $this = $(this);
        var personId=$this.data("personId");
        var url = "/ehrbrowser/index/" + personId;
        $.removeDialog('regionRecord');
        var dialogObj = {
            url : url,
            height : 654,
            width : 1000,
            id:'regionRecord'
        };
        $.dialog(dialogObj);
    }


    /**
     * 加载既往史-疾病史
     */
    function healthHistory(){
        var healthHistoryObj = {
            url : contextPath + "/ehrbrowser/basic/healthHistory",
            param : {
                personId : $("#ehrbrowser_person_id_input").val(),
                historyType:'disease'
            },
            // insertDiv : "healthHistoryContent"
        };
        $.loadHtmlByUrl(healthHistoryObj);
    }

	function lifeEvent(event){
        event.preventDefault();
        var $this = $(this);
        var type=$this.data("ehrType");
        if(type==serviceType){
            if(ehrbrowserIndex&& $.isFunction(ehrbrowserIndex.checkIdcard)){
                ehrbrowserIndex.checkIdcard(openLifeEvent);
            }
        }else{
            openLifeEvent("");
        }
	}

    function openLifeEvent(idcard){
        var lifeEventObj = {
            url : contextPath + "/ehrbrowser/basic/lifeEventDialog",
            param : {
                personId : $("#ehrbrowser_person_id_input").val(),
                idcard:idcard
            },
            insertDiv : "content"
        };
        $.loadHtmlByUrl(lifeEventObj);
    }

    function openHbpChart(event){
    	event.preventDefault();
        $.loadHtmlByUrl({
            url : contextPath + "/ehrbrowser/hbpchart",
            param : {
                personId : $("#ehrbrowser_person_id_input").val()
            },
            insertDiv : "content"
        });
    }

    function openDiChart(event){
    	event.preventDefault();
        $.loadHtmlByUrl({
            url : contextPath + "/ehrbrowser/dichart",
            param : {
                personId : $("#ehrbrowser_person_id_input").val()
            },
            insertDiv : "content"
        });
    }
	
    return {
    	openHbpChart:openHbpChart,
    	openDiChart:openDiChart,
    	lifeEvent:lifeEvent
    }
})();