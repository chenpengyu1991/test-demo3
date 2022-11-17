var promorionSearch = (function () {
    $(function () {
        $("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
        //健康教育宣传查询
        $("#form_search").onEnter(search, 1);
        $("#healthPromorionSearchId").click(function () {
            search(1);
        });
        $("#activeAdd").click(function () {
            add('', '3')
        });
        search(1);
        init();
    });

    function search(indexPage) {

        var submitDateBegin = new Date($("#createBeginTime").val());
        var submitDateEnd = new Date($("#createEndTime").val());

        if (!checkDate(submitDateBegin, submitDateEnd, "创建")) {
            return;
        }
        var searchObj = {
            url: "/he/promorion/list",
            insertDiv: "listDiv",
            param: {
                indexPage: indexPage
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
    };

    function checkDate(startDate, endDate, desp) {
        if (startDate && endDate && new Date(startDate) > new Date(endDate)) {
        	layer.alert(desp + "开始时间不能大于" + desp + "结束时间！", {icon:0,title:'提示'});
            return false;
        }
        return true;
    }

    function add(id, operatorType) {
        $("#mainSearchDiv").hide();
        var option = {
            url: "/he/promorion/add",
            insertDiv: "operationDiv",
            param: {
                id: id,
                operatorType: operatorType
            }
        };
        $.loadHtmlByUrl(option);
        $("#operationDiv").show();
    };

    function getPromorion(id) {
        var dialogParams = {
            id: "healthPromorionDpId",
            url: "/he/promorion/detail/" + id,
            height: 500,
            width: 850,
            title: "查看健康宣传"
        };
        $.dialog(dialogParams);
    };

    function publish(id) {
    	var index = layer.confirm("确认发布该记录？", {icon:1, title:'确认提示'}, function () {
            $.getJsonByUrl({
                url: "/he/promorion/status",
                param: {
                    id: id,
                    operation: "publish"
                },
                callback: function (data) {
                	var layer = layui.layer;
                    if (data == "1") {
                    	var index = layer.alert("发布成功！", {icon:0,title:'提示'}, function () {
                            search($("#currentPage").val())
                            layer.close(index);
                        });
                        return;
                    } else {
                    	var index = layer.alert("发布失败！", {icon:0,title:'提示'}, function () {
                            search($("#currentPage").val())
                            layer.close(index);
                        });
                    }
                }
            });
            layer.close(index);
        });
    };

    function unpublish(id) {
    	var index = layer.confirm("确认撤销该记录？", {icon:2, title:'确认提示'}, function () {
            $.getJsonByUrl({
                url: "/he/promorion/status",
                param: {
                    id: id,
                    operation: "unpublish"
                },
                callback: function (data) {
                	var layer = layui.layer;
                    if (data == "1") {
                    	var index = layer.alert("撤销成功！", {icon:0,title:'提示'}, function () {
                            search($("#currentPage").val())
                            layer.close(index);
                        });
                        return;
                    }
                    var index = layer.alert("撤销失败！", {icon:0,title:'提示'}, function () {
                        search($("#currentPage").val())
                        layer.close(index);
                    });
                }
            });
            layer.close(index);
        });
    };

    function deletePromorion(id) {
        if (id) {
        	var index = layer.confirm("删除服务信息，确认删除？", {icon:2, title:'确认提示'}, function () {
                var deleteDetail = {
                    url: "/he/promorion/delete",
                    param: {
                        id: id
                    },
                    callback: function (data) {
                    	var layer = layui.layer;
                        if (data == "1") {
                        	var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function () {
                                search($("#currentPage").val());
                                layer.close(index);
                            });
                            return;
                        }
                        var index = layer.alert("删除失败！", {icon:0,title:'提示'}, function () {
                            search($("#currentPage").val());
                            layer.close(index);
                        });
                    }
                };
                $.getJsonByUrl(deleteDetail);
                layer.close(index);
            });
        }
    }

    function init() {
        //机构下拉树设置
        var option = {
            url: "/mdmOrganization/organationTree",
            unSelecteType: ['0']  //不能选择：0是镇，B1是中心
        };
        //机构自动检索设置
        var opb = {
            url: "/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param: {organType: "B1,B2"}  //只查询B1（即所有站）
        };

        var hospitalCode = $("#organCode");
        if (hospitalCode.length > 0) {
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }

    return {
        search: search,
        add: add,
        getPromorion: getPromorion,
        publish: publish,
        unpublish: unpublish,
        deletePromorion: deletePromorion
    };
})();