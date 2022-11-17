var physicalExamGrid = (function(){
	$(function() {
		$(".hm_exam_btn").on("click",viewHm );
    });

    /**
     * 老年人体检
     */
    function viewHm(){
        var physicalExamCode = $(this).data("physicalexamcode");
        var personId = $(this).data("personId");
        /*$.dialog({
            url : contextPath + "/hm/manage/view",
            title : "老年人体检",
            height : 600,
            width : 950,
            param :{
            	personId: personId,
        		physicalExamRecordId: "",
        		physicalExamCode:physicalExamCode,
        		status:"2"
            }
        });*/
        $.post(contextPath + "/hm/manage/view", {
        	personId: personId,
    		physicalExamRecordId: "",
    		physicalExamCode:physicalExamCode,
    		status:"2"
        }, function(ret){
    		layui.use(['layer'], function() {
    			var layer = layui.layer
    			layer.open({
    				type: 1,
    				id:'hmPhysicalExam',
    				area: ['950px', '600px'],
    				title: '老年人体检',
    				content: ret
    			});
    		});
    	});
    }


	return {
	};
})();