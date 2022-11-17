var promorionEdit = (function () {
    var ue;
    $(function () {
        if ($("#operatorType").val() != '1') {
            ue = UE.getEditor('editor');
            UE.getEditor('editor').focus();
        }

        //健康教育宣传保存
        $("#save-btn").click(save);
        $("#back-btn").click(returnSearch);

        if ($("#operatorType").val() == '1') {
            $("#save-btn").attr("hidden", "hidden");
        }

    });

    function save() {
        $("#promorionContent").val(ue.getContent());
        var validate = $("#healthPromorionForm").easyValidate();

        var result = validate.validateForm();
        if (!result) {
            return;
        }

        if (result) {
            $("#healthPromorionForm").submitFormGetJson({
                url: "/he/promorion/saveOrUpdate",
                callback: function (data) {
                    if (data.result) {
                    	layer.alert("健康宣传保存成功！", {icon:0,title:'提示'}, function (index) {
                            returnSearch();
                            layer.close(index);
                        });
                    } else {
                    	layer.alert("健康宣传保存失败！", {icon:0,title:'提示'});
                    }
                }
            });
        }
    }

    function returnSearch() {
        if (contentChanged) {
            msgUtil.backConfirm(function () {
                returnfunction();
            });
        } else {
            returnfunction();
        }
    }

    function returnfunction() {
        $("#operationDiv").empty();
        $("#mainSearchDiv").show();
        promorionSearch.search($("#currentPage").val());
    }

    return {};
})();