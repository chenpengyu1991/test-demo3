define(function() {

	function load() {
		$(function () {
			$("#montiorSearch").click(function () {
				search(1);
			});
			$("#clientSearchForm").onEnter(search, 1);
			search(1);
			initOrg();
		});

	}
	function initOrg(){
		init('orgCode','A1,B1,B2,G2',['0']);
	}

	/**
	 * 初始化机构控件
	 * orgId:控件ID
	 * orgType:机构类型
	 * unSelectType:不能选择的机构类型
	 */
	function init(orgId,orgType,unSelectType){
		//机构下拉树设置
		var option={
			url:"/mdmOrganization/organationTree",
			unSelecteType:unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
			param:{organType:orgType}  //查询机构类型,逗号分割
		};
		//机构自动检索设置
		var opb = {
			url:"/mdmOrganization/organationSelect",
			feild: {
				value: "organCode",
				lable: "organName"
			},
			param:{organType:orgType}  //查询机构类型,逗号分割
		};

		var hospitalCode=$("#" + orgId);
		if(hospitalCode.length>0){
			//初始化自动检索
			hospitalCode.selectBox(opb);
			//初始化下拉树
			hospitalCode.initTreeSelect(option);
		}
	}

	function search(indexPage) {
		indexPage = ($.isEmpty(indexPage)?1:indexPage);
		var searchObj = {
			url : "/wsMonitor/clientInfo/monitor/list",
			insertDiv : "clientResultDiv",
			param : {
				indexPage : indexPage
			},
			callback: function(data) {
				$("#pageIndex").val(indexPage);
			}
		};
		$("#clientSearchForm").submitFormLoadHtml(searchObj);
	};

	function changeOff(orgCode,isOff) {
		var msg = isOff==0?'启用':'禁用';
		layui.use('layer', function() {
			var layer = layui.layer;
			layer.confirm("你确定要" + msg + "吗？", {icon:1, title:'确认提示'}, function(index) {
				$.getJsonByUrl({
					url: "/wsMonitor/clientInfo/changeOff",
					param: {
						orgCode: orgCode,
						isOff:isOff
					},
					callback: function (data) {
						if (data.wsStatus > 0) {
		            		layer.alert(msg + "成功！", {icon:0,title:'提示'});
							search();
						} else {
		            		layer.alert(msg + "失败！", {icon:0,title:'提示'});
						}
					}
				});
	
				layer.close(index);
			});
		});
	}
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	return {
		load : load,
        search : search,
		changeOff:changeOff,
		toggle:toggle
	};
});

$(document).ready(function () { 
	//按钮样式切换 
	$("#montiorSearch").hover(
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
