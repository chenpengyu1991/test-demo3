var examDCSearch = (function() {
    $(function() {
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
        	e.preventDefault();
           search(1);
        });
        $("#initAdd").click(function(e) {
        	e.preventDefault();
            initEdit('add');
        });
        search(1);
    });

    function search(pageIndex) {
        $("#messageDiv").remove();
        $("#top_all").show();
        $("#detailDiv").hide();
        pageIndex = (isEmpty(pageIndex)?1:pageIndex);
        var personal = $("#personal").val();
        var searchObj = {
            url : '/dcConfig/check/exam/list',
            insertDiv : "resultDiv",
            param : {
                pageIndex : pageIndex,
                personal : personal
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };



    function initEdit(type, id) {
        var title = '';
        if("add" == type){
            title = '添加检验项';
        }else if("edit" == type){
            title = '修改检验项';
        }
        
        $.post(contextPath+'/dcConfig/check/exam/add', {
        	type:type,
        	id:id
    	},
    	function(ret) {
    	  layer.open({
    		  type: 1,
    		  id:'dcConfigDialog',
    		  area: ['450px', '220px'],
    		  title:title,
    		  content: ret
    	  });
    	});
    }

    function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
    
	return {
		search:search,
        initEdit:initEdit,
        toggle:toggle
	};
})();



