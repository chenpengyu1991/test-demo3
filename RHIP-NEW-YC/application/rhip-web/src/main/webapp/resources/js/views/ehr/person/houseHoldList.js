/*
var houseHoldPagination = (function () {
    $(function () {
        pageUtil.bind("houseDataList",search);
        $("#houseHoldForm").onEnter(function() {
            search(1);
        });
        $("#houseHoldList").click(function () {
            search(1);
        });
        search(1);
    });


    function saveCover() {
        var vaillagecode = $("#vaillagecode option:selected").val();
        var houseHoldName = document.getElementsByName("houseHoldName");
        if (!houseHoldName) {
            layer.alert("请填写小区名称！");
        } else {
            var option = {
                url: contextPath + "/houseHold/saveAddHouseHold",
                param: {
                    vaillagecode: vaillagecode
                },
            };
            $("#AddhouseHoldForm").formPost(option);
        }
        if (houseHoldName) {
            layer.alert("保存成功！");
        }
        cancelCover();
    };


    function search(indexPage) {
        var option = {
            url: "/houseHold/List",
            insertDiv: "houseDataList",
            param: {
                indexPage: indexPage
            }
        };
        $("#houseHoldForm").submitFormLoadHtml(option);
    };

    function houseHoldAdd() {
        var houseHoldAdd = {
            id: "d1",
            url: "/houseHold/addHouseHold",
            height: 200,
            width: 400,
            title: "新增小区",
            param: {
            }
        };
        $.dialog(houseHoldAdd);
    };
    function cancelCover() {
        $.removeDialog("d1");
        search(1);
    }


    function houseModify(itemCode) {
        var housemodify = {
            id: "d2",
            url: "/houseHold/modifyHouseHold",
            height: 150,
            width: 300,
            title: "修改小区",
            param: {
                itemCode: itemCode
            }
        };
        $.dialog(housemodify);
    };
    function cancelmodify() {
        $.removeDialog("d2");
        search(1);
    }

    function modifysave(itemCode) {
        var modifysave = {
            url: "/houseHold/modifysave",
            param: {
                itemCode: itemCode
            }
        };
        $("#modifyhouseHoldForm").formPost(modifysave);
        layer.alert("修改成功！");
    }


    function houseDelete(itemCode) {
        var deleteHouse = {
            url: "/houseHold/deleteHouseHold",
            param: {
                itemCode: itemCode
            }
        };
        $("#modifyhouseHoldForm").formPost(deleteHouse);
        layer.alert("删除成功！");
        reloadPage()
    }

    function reloadPage() {
        var t = setTimeout(function () {
            search(1);
        }, 500);
    }

    return {
        search:search,
        saveCover: saveCover,
        cancelCover: cancelCover,
        search: search,
        houseHoldAdd: houseHoldAdd,
        houseModify: houseModify,
        modifysave: modifysave,
        cancelmodify: cancelmodify,
        houseDelete: houseDelete
    };
})();
*/
