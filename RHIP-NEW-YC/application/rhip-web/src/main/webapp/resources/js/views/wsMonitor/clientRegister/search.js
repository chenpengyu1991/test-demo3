define(function() {
	var validate=null;
	function load() {
		$(function () {
			init();
			$("#clientInfoAddBut").click(function () {
				add();
			});
			$("#clientInfoSaveBut").click(function () {
				save();
			});
			$("#clientInfoBackBut").click(function () {
				back();
			});
			$("#clientInfoSearchBut").click(function () {
				search(1);
			});
			$("#clientInfoForm").onEnter(search, 1);
			search(1);
			var listDiv = $("#listDiv");
			listDiv.on("click", ".edit-link", add);
			listDiv.on("click", ".view-link", view);
			listDiv.on("click", ".delete-link", deleteClient);
			listDiv.on("click", ".change-link", changeOff);
		});
	}

			function init() {
				//机构下拉树设置
				var option={
					url:"/mdmOrganization/organationTree",
					unSelecteType:['0']  //不能选择：0是镇，B1是中心
				};
				//机构自动检索设置
				var opb = {
					url:"/mdmOrganization/organationSelect",
					feild: {
						value: "organCode",
						lable: "organName"
					},
					param:{organType:"A1,B1,B2"}  //只查询B1（即所有站）
				};

				var hospitalCode=$("#orgCode");
				if(hospitalCode.length>0){
					//初始化自动检索
					hospitalCode.selectBox(opb);
					//初始化下拉树
					hospitalCode.initTreeSelect(option);
				}
			}

			function add() {
				var id = $(this).attr("data-id");
				var pageIndex = $("#currentPage").val();
				//修改时
				if(id != ""){
					$.loadHtmlByUrl({
						url : "/wsMonitor/clientInfo/register/add",
						insertDiv :"detailDiv",
						param : {
							pageIndex : pageIndex,
							id : id
						}
					});
				}else{//新增时
					$.loadHtmlByUrl({
						url : "/wsMonitor/clientInfo/register/add",
						insertDiv :"detailDiv",
						param : {
							pageIndex : pageIndex
						}
					});
				}
				$("#clientInfoAddBut").hide();
				$("#clientInfoSaveBut").show();
				$("#clientInfoBackBut").show();
				$("#searchDiv").hide();
				$("#listDiv").hide();
				$("#detailDiv").show();
			}

			function save() {
				validate = $("#clientInfoAddForm").easyValidate();
				var result=validate.validateForm();
				if(!result){
					return;
				}
				var ids ="";
				$('input[name="check"]:checked').each(function(){
					ids += $(this).val() + ',';
				});
				ids = ids.substring(0, ids.lastIndexOf(','));
				if(ids.length==0){
					layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("请选择关联的服务端！", {icon:0,title:'提示'});
               		});
					return false;
				}
				$("#clientInfoAddForm").submitFormGetJson({
					url : "/wsMonitor/clientInfo/register/save",
					param : {
						serviceIds:ids
					},
					callback: function(data) {
						if(data.indexOf("success") > -1) {
							layui.use('layer', function() {
		            			var layer = layui.layer;
		            			layer.alert("保存成功！");
		               		});
							$("#clientInfoAddBut").show();
							$("#clientInfoSaveBut").hide();
							$("#clientInfoBackBut").hide();
							$("#searchDiv").show();
							$("#listDiv").show();
							$("#detailDiv").hide();
							search(1);
						}else if (data.indexOf("fail") > -1) {
							layui.use('layer', function() {
		            			var layer = layui.layer;
		            			layer.alert("保存失败！", {icon:0,title:'提示'});
		               		});
						}else if (data.indexOf("exist") > -1) {
							layui.use('layer', function() {
		            			var layer = layui.layer;
		            			layer.alert("来访机器IP地址已存在，不能新增。请查找原来设置并修改！", {icon:0,title:'提示'});
		               		});
						}
					}
				});

			}

			function view(){
				var id = $(this).attr("data-id");
				var pageIndex = $("#currentPage").val();
				$.loadHtmlByUrl({
					url : "/wsMonitor/clientInfo/register/add",
					insertDiv :"detailDiv",
					param : {
						pageIndex : pageIndex,
						id : id
					}
				});
				$("#clientInfoAddBut").hide();
				$("#clientInfoSaveBut").hide();
				$("#clientInfoBackBut").show();
				$("#searchDiv").hide();
				$("#listDiv").hide();
				$("#detailDiv").show();
			}

			function back() {
				$("#clientInfoAddBut").show();
				$("#clientInfoSaveBut").hide();
				$("#clientInfoBackBut").hide();
				$("#searchDiv").show();
				$("#listDiv").show();
				$("#detailDiv").hide();
				search(1);
			}

			function changeOff() {
				var id = $(this).attr("data-id");
				var isOff = $(this).attr("data-flag");

				var title  = "禁用"
				if(isOff == 1) {
					title = "解除禁用";
				}
				layui.use('layer', function() {
					var layer = layui.layer;
					layer.confirm("你确认要" + title + "此客户端吗?", {icon:1, title:'确认提示'}, function(index) {
						$("#clientInfoAddForm").submitFormGetJson({
							url: "/wsMonitor/clientInfo/register/changeOff",
							param: {
								id: id,
								isOff: isOff
							},
							callback: function (data) {
								if (data.indexOf("success") > -1) {
			            			layer.alert(title + "成功！", {icon:0,title:'提示'});
									back();
								} else if (data.indexOf("fail") > -1) {
			            			layer.alert(title + "失败！", {icon:0,title:'提示'});
								}
							}
						});
	
						layer.close(index);
					});
				});
			}

			function deleteClient() {
				var id = $(this).attr("data-id");
				layui.use('layer', function() {
        			var layer = layui.layer;
					layer.confirm("你确认要删除此客户端吗?", {icon:2, title:'确认提示'}, function(index) {
						$("#clientInfoAddForm").submitFormGetJson({
							url: "/wsMonitor/clientInfo/delete",
							param: {
								id: id
							},
							callback: function (data) {
								if (data.indexOf("success") > -1) {
				            		layer.alert("删除成功！", {icon:0,title:'提示'});
									back();
								} else{
				            		layer.alert("删除失败！", {icon:0,title:'提示'});
								}
							}
						});
	
						layer.close(index);
					});
				});
			}

			function search(indexPage) {
				indexPage = ($.isEmpty(indexPage)?1:indexPage);
				var searchObj = {
					url : "/wsMonitor/clientInfo/register/list",
					insertDiv : "listDiv",
					param : {
						indexPage : indexPage
					}
				};
				$("#clientInfoForm").submitFormLoadHtml(searchObj);
			};

			function toggle(obj,tableId) {
				$(obj).toggleClass("ico-top");
				$(obj).toggleClass("ico-bottom");
				$("#" + tableId).toggle();
			};

			return {
				load : load,
				add : add,
				save : save,
				view : view,
				search : search,
				changeOff : changeOff,
				toggle : toggle,
				deleteClient: deleteClient
			};
});