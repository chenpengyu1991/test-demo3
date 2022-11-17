var vaccineAddH = (function() {
	// 点击查询按钮
	$(function() {
		$("#vaccineConfirm").click(function(e) {
            e.preventDefault();
            var vaccineType = $("#vaccineTypeC").val();
			vaccineAdd(vaccineType);
		});
	});
	// 显示查询结果
	function vaccineAdd(vaccineType) {
        layer.closeAll();
        if (vaccineType == 'rabies') {
            $.post(contextPath+'/ph/rabies/select',
                function(ret){
                    layui.use(['layer'], function() {
                        var layer = layui.layer
                        layer.open({
                            type: 1,
                            id:'rabiesSelectDialog',
                            area: ['685px', '510px'],
                            title:'选择狂犬疫苗接种类型',
                            content: ret
                        });
                    });
                }
            );
		} else {
            $("#vaccineDivIdDetail").show();
            $("#vaccineDivIdSearch").hide();
            /*$.post(contextPath+"/ph/" + vaccineType + "/add",
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
                url: "/ph/" + vaccineType + "/add",
                insertDiv: "vaccineDivIdDetail",
                param: {

                }
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	}

	function removeDialog() {
        layer.closeAll();
	}

	return {
		removeDialog : removeDialog
	};
})();