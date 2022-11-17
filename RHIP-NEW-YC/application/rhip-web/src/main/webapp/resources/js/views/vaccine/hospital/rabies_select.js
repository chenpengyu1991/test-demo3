var rabiesSelect = (function() {
	$(function() {
		$("#rabiesConfirm").click(function(e) {
            e.preventDefault();
			var rabiesType = $("#rabiesType").val();
			addRabies(rabiesType);
		});
	});
	function addRabies(rabiesType) {
	    $("#vaccineDivIdDetail").show();
	    $("#vaccineDivIdSearch").hide();
        layer.closeAll();
        /*$.post(contextPath+"/ph/rabies/add/"+ rabiesType,
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:'addDialog',
                        area: ['980px', '550px'],
                        title:'新增个人预防接种信息',
                        content: ret
                    });
                });
            }
        );*/
        var loadHtmlByUrlOption = {
            url: "/ph/rabies/add/"+ rabiesType,
            insertDiv: "vaccineDivIdDetail",
            param: {

            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function removeDialog() {
        layer.closeAll();
	}

	return {
		removeDialog : removeDialog
	};
})();