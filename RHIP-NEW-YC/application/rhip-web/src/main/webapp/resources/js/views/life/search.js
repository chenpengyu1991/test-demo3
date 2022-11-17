var lifeEventSearch = (function() {
	$(function(){
		$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e){
			e.preventDefault();
			search(1);
		});
		search(1);
		$('input[name="personType"]:eq(0)').attr("checked",'checked');
	});


    //查看详情的方法

    function view(id){
       /* var dialog = {
            url : "/life/view",
            param : {id:id},
            height : 550,
            width : 750,
            title : "死亡医学证明",
            id :"dialog"
        };
        $.dialog(dialog);*/
    	$.post(contextPath+"/life/view", {id:id}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'deathCertificate',
        			  area: ['750px', '610px'],
        			  title:"死亡医学证明",
        			  content: ret
        		  });
        		});
        	});
    }

    function search(indexPage) {
		var url = "/life/query";
		var searchObj = {
			 url : url,
			 insertDiv : "resultDiv",
			 param : {indexPage : indexPage},
			callback: function() {
				//注销
				initLinkClick('personOff',personOff, {recordId:"data-id"});
				//激活
				initLinkClick('personOffActive',personOffActive, {recordId:"data-id",filingFlag:'data-filing-flag'});

                //查看详情
                initLinkClick('view',view, {recordId:"data-id",filingFlag:'data-filing-flag'});

			}
		 };
		$("#searchForm").formPost(searchObj);
	}
    
	function importExcel() {
/*		var excelDialog = {
            url : "/life/importExcel",
            height : 150,
            width : 500,
            title : "导入数据",
            param : {
			}
        };
        $.dialog(excelDialog);*/
		$.post(contextPath+"/life/importExcel", function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'ehrStopImport',
        			  area: ['530px', '150px'],
        			  title:"导入数据",
        			  content: ret
        		  });
        		});
        	});
	}
	
	function cancel(){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('提示：注销时会连带所有业务系统内容注销。是否确认注销？', {icon:2, title:'确认提示'}, function(index){
				var option = {
						url : contextPath + "/life/cancel",
						wait: true,
						callback : function(result) {
							layer.alert(result, {icon:0,title:'提示'}, function() {
								search($("#pageIndex").val());
								layer.closeAll();
							});
						}
					};
					$.getJsonByUrl(option);
			});
		});
    	/*layer.confirm("提示：注销时会连带所有业务系统内容注销。是否确认注销？", (function(index) {
			var option = {
				url : contextPath + "/life/cancel",
				wait: true,
				callback : function(result) {
					layer.alert(result);
					search($("#pageIndex").val());
				}
			};
			$.getJsonByUrl(option);
			layer.close(index);
		}));*/
    }

	/**
	 * 注销
	 * @param recordId
	 */
	function personOff(recordId){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('提示：注销时会连带所有业务系统内容注销。是否确认注销？', {icon:2, title:'确认提示'}, function(index){
				layer.close(index);
			});
		});
	}

	/**
	 * 激活
	 * @param recordId
	 */
	function personOffActive(recordId,filingFlag){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('提示：是否确认激活？', {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : contextPath + "/life/personOffActive",
					param : {
						recordId : recordId,
						filingFlag:filingFlag
					},
					callback : function(data) {
						if (data == 1)
						{
							layer.alert("激活成功！", {icon:0,title:'提示'}, function() {
								search($("#pageIndex").val());
								layer.closeAll();
							});
						} else
						{
							layer.alert("激活失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
		/*layer.confirm("提示：是否确认激活？", (function(index) {
			$.getJsonByUrl({
				url : contextPath + "/life/personOffActive",
				param : {
					recordId : recordId,
					filingFlag:filingFlag
				},
				callback : function(data) {
					if (data == 1)
					{
						layer.alert("激活成功！");
						search($("#pageIndex").val());
					} else
					{
						layer.alert("激活失败！");
					}
				}
			});
			layer.close(index);
		}));*/
	}

	return {
		search :search,
		importExcel : importExcel,
		cancel : cancel
	};
})();