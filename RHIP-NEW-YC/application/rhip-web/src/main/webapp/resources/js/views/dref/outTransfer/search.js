var outTransferSearch = (function() {
	$(function() {
        var validate=null;
		$("#searchForm").onEnter(search, 1);
		$("#searchBtn").click(function() {
			search(1);
		});
        $("#otExportBtn").click(function() {
            otExport();
		});
		search(1);
		$("#addBtn").click(function() {
			$("#menubox").show();
			$(document).on("click", clickSomeWhereListener);
		});
		function clickSomeWhereListener(e) {
			if (e.target.id != "addBtn") {
				$("#menubox").hide();
				$(document).off("click", clickSomeWhereListener);
			}
		}
		$("#menubox li a").click(function() {
			var type = $(this).data("type");
			edit("", type);
		});
	});

	function initOrganTree(selectId, callbackFun) {
		var treeOpt = {
			url: "/mdmOrganization/organationTree",
			unSelecteType:['0'],
			param : {
				organType : "A100,B100,B200,R2"
			},
			selectFun : callbackFun
		};
		var opb = {
			url: "/mdmOrganization/organationSelect",
			feild: {
				value: "organCode",
				lable: "organName"
			},
			param : {
				organType : "A100,B100,B200,R2"
			},
			selectFun : callbackFun
		};
		var organTree = $("#" + selectId);
		if (organTree.length > 0) {
			organTree.selectBox(opb);
			organTree.initTreeSelect(treeOpt);
		}
	}

	function search(indexPage) {
        validate = $("#searchForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
		if (indexPage == null) {
			indexPage = $("#indexPage").val();
		}
		var searchOption = {
			url : "/outTransfer/list",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		}
		$("#searchForm").submitFormLoadHtml(searchOption);
	}

    function otExport() {
        var params = $('#searchForm').formSerialize();
        params = decodeURIComponent(params,true);
        location.href = contextPath + "/outTransfer/downOTExcel?" + params;
    }

	function initEdit(id) {
        $("#searchDiv").hide();
        var searchObj = {
            url : "/outTransfer/initEdit",
            insertDiv : "detailDiv",
            param : {
                id : id
            },
            wait:true,
            callback : function(data) {
//                $("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
	}

    function view(id) {
        $("#searchDiv").hide();
        var searchObj = {
            url : "/outTransfer/view",
            insertDiv : "detailDiv",
            param : {
                id : id
            },
            wait:true,
            callback : function(data) {
//                $("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    }

	return {
		search : search,
        initEdit : initEdit,
        view : view,
        otExport : otExport,
		initOrganTree : initOrganTree
	}
})();