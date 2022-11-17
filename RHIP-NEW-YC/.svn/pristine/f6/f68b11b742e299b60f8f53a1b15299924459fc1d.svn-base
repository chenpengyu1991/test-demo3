var phyExamUtil = (function() {
	
	$(function(){
		$("#relatedIden").on("click" ,function(){
	    	queryIdentifications();
	    });
	});
	
	/**
	 * 三个体检通用
     * 弹出体质辨识画面
     */
    function addEch(id, personId){
    	debugger;
    	if(!personId){
    		personId =$("#personId").val();
    	}
        $.post(contextPath+'/ech/manage/report/init', {
	        	personId: personId,
	            id:id,
	            editflag:'edit',
	            sourceFlag:'2'
			},
			function(ret) {
			  layer.open({
				  type: 1,
				  id:'echDialog',
				  area: ['1000px', '650px'],
				  title:"老年人中医药健康管理服务记录表",
				  content: ret,
    			  success: function(layero, index){
				    $('#iden_index').val(index);
				  }
			  });
		});
    }
    
    /**
     * 三个体检通用
     * 获取体质辨识列表
     */
    function queryIdentifications(){
        var personId =$("#personId").val();
        var identificationId =$("#identificationId").val();
        $.post(contextPath+'/personRecord/queryIdentifications', {
	        	personId: personId,
	            identificationId:identificationId
			},
			function(ret) {
			  layer.open({
				  type: 1,
				  id:'identificationDialog',
				  area: ['1100px', '300px'],
				  title:"体质辨识",
				  content: ret,
    			  success: function(layero, index){
  				    $('#idensIndex').val(index);
  				  }
			  });
		});
    }
    return {
        addEch:addEch
    };
})();