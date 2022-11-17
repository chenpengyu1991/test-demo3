define(function() {
	
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDivDoctor",searchDoctor);
			searchDoctor(1);
			$("#doctorFormId").onEnter(searchDoctor, 1);
			$("#doctorSearchBut").click(function() {
				searchDoctor(1);
			});
			
			$("#doctorAddButId").click(function(){
				add(0, false);
			});
			$("#doctorSearchSpanId").click(function(){
				toggle(this,'doctorSearchTableId');
			});
		});
	}
	
    function searchDoctor(indexPage) {
		var url = contextPath + "/outDoctor/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDivDoctor",
				 param : {indexPage : indexPage},
				callback: function() {
					/*为listDiv中a的添加click事件*/
					initLinkClick('seeDoctor',view, {doctorId:"data-outDoctorId", see:"data-see"});
					initLinkClick('modifyDoctor',add, {doctorId:"data-outDoctorId", see:"data-see"});
					initLinkClick('deleteDoctor',delDoctor, {doctorId:"data-outDoctorId"});
					initLinkClick('publishDoctor',publishDoctor, {doctorId:"data-outDoctorId",doctorStatus:"data-status"});
				}
			 };
		$("#doctorFormId").formPost(searchObj);
	
	}
	
    function add(doctorId, ifSee) {
		$.loadHtmlByUrl({
			url : "/outDoctor/detail",
			insertDiv :"detailDivDoctor",
            wait : true,
			param : {
				id: doctorId,
				ifSee: ifSee
			}
		});
		$("#detailDivDoctor").show();
		$("#top_allDoctor").hide();
	};
	
	function view(doctorId, ifSee) {
		$.loadHtmlByUrl({
			url : "/outDoctor/view",
			insertDiv :"detailDivDoctor",
            wait : true,
			param : {
				id: doctorId,
				ifSee: ifSee
			}
		});
		$("#detailDivDoctor").show();
		$("#top_allDoctor").hide();
	};

	function publishDoctor(doctorId, doctorStatus) {
		var configTile = "";
		var resultTile = "";

		if(doctorStatus == '0') {
			configTile = "您确认撤销该专家信息？";
			resultTile = "撤销";
		} else {
			configTile = "您确认该专家信息通过审核？";
			resultTile = "审核";
		}

		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm(configTile, {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/outDoctor/status",
					param : {
						id : doctorId,
						status: doctorStatus
					},
					wait : true,
					callback : function(data) {
						if (data == "1") {
							layer.alert(resultTile + "成功！", {icon:0,title:'提示'}, function(index2) {
								searchDoctor($("#currentPage").val());
								layer.close(index2);
							});
							return;
						} else {
							layer.alert(resultTile + "失败！", {icon:0,title:'提示'}, function(index2) {
								searchDoctor($("#currentPage").val());
								layer.close(index2);
							});
						}

					}
				});
				layer.close(index);
			});
		});
	}

	function delDoctor(doctorId) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('您确认要删除吗?', {icon:2, title:'确认提示'}, function(index){
				deleteDo(doctorId);
				layer.close(index);
			});
		});
		
	}
	
	function deleteDo(doctorId){
		$.getJsonByUrl({
	    	url : contextPath + "/outDoctor/delete",
            callback:function(data){
    			if (data.indexOf("success") != -1) {
    				searchDoctor($("#currentPage").val());
    				layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert("删除成功！", {icon:0,title:'提示'});
					});
    			} else if (data.indexOf("exits") != -1) {
    				layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert("此医生已经有今天以后排班资源，暂不可删除！", {icon:0,title:'提示'});
					});
    			}else {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert("删除失败！", {icon:0,title:'提示'});
					});
    			}
    		},
			wait : true,
	    	param:{
				id: doctorId
	    	}
	     });
	}
	function closeFunc(){
		$("#orgCreate").get(0).selectedIndex = 0;
		$("#msgError").hide();
	}
    return{
    	load: load,
    	searchDoctor: searchDoctor
    };
});
