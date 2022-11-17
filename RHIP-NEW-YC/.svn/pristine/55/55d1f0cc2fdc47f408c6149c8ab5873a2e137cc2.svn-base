var womanSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
        });
        search(1);
        $("#pFPAddButId").on("click", function() {
            getDelivery("");
        });
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : '/ehr/delivery/search',
            insertDiv : 'womanListDiv',
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    }



    function delivery(personId){
        $("#delivSearchDivId").hide();
        $("#delivDetailDiv").show();
        var loadHtmlByUrlOption = {
            url: "/ehr/delivery/delivery",
            param : {personId:personId},
            insertDiv: "delivDetailDiv"
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }



    function getDelivery(deliveryId){
        $("#delivSearchDivId").hide();
        $("#delivDetailDiv").show();
        var loadHtmlByUrlOption = {
            url: "/ehr/delivery/add",
            insertDiv: "delivDetailDiv",
            param: {
                deliveryId: deliveryId
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function delDelivery(deliveryId) {
		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/ehr/delivery/delete",
					param:{
                    	deliveryId:deliveryId
               		},
					callback : function(data) {
						if (data == "success") {
							layer.close(index);
							search($("#currentPage").val());
							layer.alert("删除成功！", {icon:0,title:'提示'});
						} else {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
    }

	return {
		search:search,
        delivery:delivery,
        getDelivery:getDelivery,
        delDelivery:delDelivery
	};
})();



