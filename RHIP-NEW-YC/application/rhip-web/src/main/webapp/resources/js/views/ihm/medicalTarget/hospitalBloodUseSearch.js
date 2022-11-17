var hospitalBloodUseSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
           e.preventDefault();
           search(1);
        });
        $("#btnSearch").onEnter(search, 1);
        search(1);
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var url = $("#searchUrl").val();
        var searchObj = {
            url : url,
            insertDiv : "listDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };

    function viewHospitalBloodUse(id){
       /* var dialog = {
            url : "/medicalTarget/hbu/hospitalBloodUse/detail",
            param : {id:id},
            height : 550,
            width : 750,
            title : "用血信息" ,
            id :"dialog"
        };
        $.dialog(dialog);*/

		 $.post(contextPath+'/medicalTarget/hbu/hospitalBloodUse/detail',
        		{ id:id}, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'intoDialog',
        			  area: ['750px', '550px'],
        			  title:'用血信息',
        			  content: ret
        		  });
        		});
        	});

    }


	return {
		search:search,
		viewHospitalBloodUse:viewHospitalBloodUse
	};
})();



