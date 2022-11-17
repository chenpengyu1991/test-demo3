define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("hospitalInfo_records", hospitalInfoSearch);
			hospitalInfoSearch(1);
			$("#hospitalInfoSearchBtn").click(function() {
				hospitalInfoSearch(1);
			});
			
			$("#form_search").onEnter(function() {
				hospitalInfoSearch(1);
			});
			
			$("#hospitalInfoSearchSpanId").click(function(){
				toggle(this,'hospitalInfoSearchTableId');
			});

	        $("#addHos").click(function(){
	        	addHos();
	        });
	        
		});
	}
	
	function hospitalInfoSearch(indexPage) {
		var submitDateBegin = new Date($("#beginTime").val());
		var submitDateEnd = new Date($("#endTime").val());
		
		if(!checkDate(submitDateBegin,submitDateEnd,"创建")){
			return;
		}
		indexPage = ($.isEmpty(indexPage)?$("#pageIndex").val():indexPage);
		var searchObj = {
			url : "/lhhospitalInfo/list",
			insertDiv : "hospitalInfo_records",
			param : {
				indexPage : indexPage
			},
            callback : function() {
//            	为hospitalInfo_records中a的添加click事件
            	initLinkClick('viewHospitalInfo',viewHospitalInfo, {id:"data-recordId"});
            	initLinkClick('modifyHospitalInfo',modifyHospitalInfo, {id:"data-recordId"});
            	initLinkClick('unpublishHospitalInfo',unpublishHospitalInfo, {id:"data-recordId"});
            	initLinkClick('publishHospitalInfo',publishHospitalInfo, {id:"data-recordId"});
            	initLinkClick('deleteHospitalInfo',deleteHospitalInfo, {id:"data-recordId"});
            }
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	
	// 设置不发布记录
	function unpublishHospitalInfo(id) {
		if (id) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认撤销该记录？', {icon:2, title:'确认提示'}, function(index){
					var deleteDetail = {
						url : "/lhhospitalInfo/status",
						param : {
							id : id,
							operation : "unpublish"
						},
						callback : function(data) {
							if (data == "1") {
								layer.alert("撤销成功！", {icon:0,title:'提示'}, function(index2) {
									hospitalInfoSearch($("#currentPage").val());
									layer.close(index2);
								});
								return;
							}
							layer.alert("撤销失败！", {icon:0,title:'提示'}, function(index2) {
								hospitalInfoSearch($("#currentPage").val());
								layer.close(index2);
							});
						}
					};
					$.getJsonByUrl(deleteDetail);
					layer.close(index);
				});
			});
		}
	}
	
	// 设置发布记录
	function publishHospitalInfo(id) {
		if (id) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认该记录通过审核？', {icon:1, title:'确认提示'}, function(index){
					var deleteDetail = {
						url : "/lhhospitalInfo/status",
						param : {
							id : id,
							operation : "publish"
						},
						callback : function(data) {
							if (data == "1") {
								layer.alert("审核成功！", {icon:0,title:'提示'}, function(index2) {
									hospitalInfoSearch($("#currentPage").val());
									layer.close(index2);
								});
								return;
							}
							layer.alert("审核失败！", {icon:0,title:'提示'}, function(index2) {
								hospitalInfoSearch($("#currentPage").val());
								layer.close(index2);
							});
						}
					};
					$.getJsonByUrl(deleteDetail);
					layer.close(index);
				});
			});
		}
	}
	
	function viewHospitalInfo(id){
		$("#searchDiv").hide();
		var option = {
				url : "/lhhospitalInfo/edit",
				insertDiv : "hospitalInfoDiv",
				param :{
					id : id,
					operation:'1'
				}
		};
		$.loadHtmlByUrl(option);
	}

	function modifyHospitalInfo(id){
		$("#searchDiv").hide();
		var option = {
				url : "/lhhospitalInfo/edit",
				insertDiv : "hospitalInfoDiv",
				param :{
					id : id,
					operation:'2'
				}
		};
		$.loadHtmlByUrl(option);
	}
	
	function deleteHospitalInfo(id){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('是否彻底删除此项？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/lhhospitalInfo/delete",
					param : {
						id : id
					},
					callback : function(){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
							hospitalInfoSearch($("#currentPage").val())
							layer.close(index2);
						});
					}
				});
				layer.close(index);
			});
		});
	}
	
	function addHos(){
    	popuOrgSelect();
    }

    function popuOrgSelect() {
	    var popuOrgDialog = {
	            url : "/lhhospitalInfo/organizationSearch",
	            height : 500,
	            width : 800,
	            title : "机构选择" ,
	            id :"popuOrgDialog",
            	param:{}	            
	        };
		$.dialog(popuOrgDialog);		
    };
    
    function checkDate(startDate,endDate,desp){
		if(startDate && endDate && new Date(startDate) > new Date(endDate)){
			layer.alert(desp + "开始时间不能大于" + desp + "结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
    
	return {
		load : load,
		search : hospitalInfoSearch,
	};
	
});

