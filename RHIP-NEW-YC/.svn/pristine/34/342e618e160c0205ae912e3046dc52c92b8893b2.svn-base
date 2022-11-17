define(function(){
	function load() {
		$(function() {
			initOrganTree("destDeptCode");
			initOrganTree("referralHospitalCode");
			$("#searchForm").onEnter(search, 1);
			$("#searchBtn").click(function() {
				search(1);
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
	}
	function initOrganTree(selectId, callbackFun) {
		var treeOpt = {
			url: "/mdmOrganization/organationTree",
			unSelecteType:['0'],
			param : {
				organType : "A1,B1,B2,R2"
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
				organType : "A1,B1,B2,R2"
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
		if (indexPage == null) {
			indexPage = $("#indexPage").val();
		}
		var searchOption = {
			url : "/dref/list",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		}
		$("#searchForm").submitFormLoadHtml(searchOption);
	}

	function edit(id, type) {
		var param = {
			id : id,
			drefType : type
		}
		baseLayoutLoad.pushMainContent("/dref/edit", param);
	}

	function del(id) {
		var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/dref/delete",
				param : {
					id : id
				},
				callback : (function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert(result.message, {icon:0,title:'提示'});
					});
					if (result.success) {
						search();
					}
				})
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}

	function detail(id) {
		var param = {
			id : id
		}
		baseLayoutLoad.pushMainContent("/dref/view", param);
	}

	return {
		search : search,
		edit : edit,
		del : del,
		detail : detail,
		initOrganTree : initOrganTree,
		load: load
	}
})