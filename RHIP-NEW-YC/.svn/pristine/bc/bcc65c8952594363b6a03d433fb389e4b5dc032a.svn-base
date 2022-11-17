var childHealth = (function () {
    var validate = null;
    $(function () {
        validate = $("#searchForm").easyValidate();
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
                e.preventDefault();
            search(1);
        });
        search(1);
        init('orgCode', 'B1,B2', []);//社区卫生服务站
        $("#ehr-person-export-btn").click(function () {
            exportList();
        });
        $("#gjBtn").click(function(e) {
            e.preventDefault();
            controlAdvanceSearchSection($(this));
        });
        /*     $("#childLink").on("click", function(event)
             {

                 alert(1);
                 var childLink = {
                     url : contextPath + "/childHealth/childHealthindex",
                     height : 650,
                     width : 1000,
                     title : "儿童记录管理",
                     close : refresh
                 };
                 $.dialog(childLink);
             });*/
    });


    function record(babyCard, idcard) {
        if (babyCard == "") {
            babyCard = 'babyCard';
        }
        if (idcard == "") {
            idcard = 'idcard';
        }

        $.post(contextPath + "/childHealth/childHealthindex/" + babyCard + "/" + idcard,
            function (ret) {
                layui.use(['layer'], function () {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id: 'childHealthdialog',
                        area: ['1000px', '700px'],
                        title: '儿童记录管理',
                        content: ret
                    });
                });
            }
        );
    };

    function search(pageIndex) {
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var searchType = $("#searchType").val();
        var url = '/childHealth/list';
        pageIndex = ($.isEmpty(pageIndex) ? 1 : pageIndex);
        var searchObj = {
            url: url,
            insertDiv: "childListDiv",
            param: {
                pageIndex: pageIndex
            },
            callback: function (data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };

    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
    function init(orgId, orgType, unSelectType) {
        //机构下拉树设置
        var option = {
            url: "/mdmOrganization/organationTree",
            unSelecteType: unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param: {organType: orgType},  //查询机构类型,逗号分割
            selectFun: selectTreeFun
        };
        //机构自动检索设置
        var opb = {
            url: "/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param: {organType: orgType},  //查询机构类型,逗号分割
            selectFun: selectBoxFun
        };

        var hospitalCode = $("#" + orgId);
        if (hospitalCode.length > 0) {
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }

    function exportList() {
        var option = {
            url: "/childHealth/export",
            param: {}
        };
        $("#searchForm").exportListExcel(option);
    }

    /**
     * 机构下拉树回调
     * 设置当前选择机构的类型
     */
    function selectTreeFun(data) {
        $('#selectCodeType').val(data.type);
    }

    /**
     * 机构自动检索回调
     * 设置当前选择机构的类型
     */
    function selectBoxFun(data) {
        $('#selectCodeType').val(data.attr('genreCode'));
    }


    $("#chrepeattable").on("click", ".childLink", function (event) {
        // alert(this);
        //event.preventDefault();
        var $this = $(this);
        var dialogObj = {
            url: $this.attr("href"),
            height: 654,
            width: 1000
        };
        $.dialog(dialogObj);
        //return false;
    });

    function follow(babyCardNo) {
        $('#childRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/childFamilyVisit/list1',
            insertDiv: 'childRecordContent',
            param: {
                babyCardNo: babyCardNo
            }
        })
    }

    function viewChildExams(babyCardNo, examineAgeGroup) {
        $('#childRecordContent').empty();
        $('.toolbar').empty();
        $.loadHtmlByUrl({
            url: '/childHealth/examList',
            insertDiv: 'childRecordContent',
            param: {
                examineAgeGroup: examineAgeGroup,
                babyCardNo: babyCardNo
            }

        })
    }

    function view(examId) {
        $('#childRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/childHealthExamine/viewExam',
            insertDiv: 'childRecordContent',
            param: {
                examId: examId
            }

        })
    }

    function viewNeonatalVisi1t(id) {

        $('#childRecordContent').empty();
        $.loadHtmlByUrl({
            url: '/childFamilyVisit/view1',
            insertDiv: 'childRecordContent',
            param: {
                id: id
            }
        })
    }


    return {
        search: search,
        record: record,
        viewChildExams: viewChildExams,
        follow: follow,
        view: view,
        viewNeonatalVisi1t: viewNeonatalVisi1t
    };
})();



