var enterpriseAdd = (function() {
	var validate=null;
	$(function() { 
		validate = $("#enterpriseInfoForm").easyValidate();
		/*重点企业卫生服务档案查询*/

		//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function(){
			var element = layui.element;
		//一些事件监听
			element.on('tab(ohEnterpriseTab)', function(data){
				if (data.index == 0) {/*企业基本信息*/
					var selfObj = this;
					if(contentChanged){
						layui.use('layer', function() {
							var layer = layui.layer;
							var index = layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function(index) {
								layer.close(index);
								disableChangeConfirm();
								tabInfoLoad("/oh/enterpriseDoc/enterpriseInfo","tagContent0");
								return;
							});
						});
					}else{
						tabInfoLoad("/oh/enterpriseDoc/enterpriseInfo","tagContent0");
					}
				} else if(data.index == 1) {/*职业卫生情况*/
					tabInfoLoad("/oh/enterpriseDoc/condition","tagContent1");
				} else if(data.index == 2) {/*使用化学物质*/
					tabInfoLoad("/oh/enterpriseDoc/chemicalsUsed","tagContent2");
				} else if(data.index == 3) {/*职业危害接触因素*/
					tabInfoLoad("/oh/enterpriseDoc/contactSituation","tagContent3");
				} else if(data.index == 4) {/*主要生产设备*/
					tabInfoLoad("/oh/enterpriseDoc/equipment","tagContent4");
				} else if(data.index == 5) {/*监测点示意图*/
					tabInfoLoad("/oh/enterpriseDoc/testItems","tagContent5");
				}

			});
		});
	});

	/*tab信息页面载入*/
	function tabInfoLoad(url,tagId,indexPage) {
		if(indexPage==undefined)
			indexPage=1;
		var enterpriseId=$('#enterpriseId').val();
		if(enterpriseId==''&& tagId!='tagContent0'){

			layui.use('layer', function() {
				var layer = layui.layer;
				var index = layer.confirm('请先保存企业基本信息!', {icon:1, title:'确认提示'}, function(index){
					$("#enterprise_info_btn").click();
					layer.close(index);
				});
			});
			return;
		}

		url=url+"/"+enterpriseId;
		var length = $('#'+tagId).has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : url,
				param : {
					indexPage : indexPage,
					type:$("#type").val()
				},
				insertDiv : tagId
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};
	
	/*保存企业基本信息*/
	function saveEnterpriseInfo() {
		var rs =validate.validateForm();
		if(!rs)
			return;
		var enterpriseId=$('#enterpriseId').val();
			//参数
			var saveObj = {
				url : "/oh/enterpriseDoc/saveEnterpriseInfo",
				insertDiv : "tagContent0",
				param : {
					enterpriseId : enterpriseId,
					type:$("#enterpriseInfoForm #type").val()
				}
			};
			$("#enterpriseInfoForm").submitFormLoadHtml(saveObj);
	}
	
	function returnSearch(){
        debugger;
        if(contentChanged){
			layui.use('layer', function() {
				var layer = layui.layer;
				var index = layer.confirm('确认离开？', {icon:2, title:'确认提示'}, function(index) {
					var pageIndex = $("#pageIndex").val();
					enterpriseSearch.search(1);
					$("#mainSearchDiv").show();
					$("#operationDiv").empty();
					disableChangeConfirm();
					layer.close(index);
					return;
				});
			});
        }else{
            var pageIndex = $("#pageIndex").val();
            enterpriseSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }

    }
	return {
		returnSearch:returnSearch,
		saveEnterpriseInfo:saveEnterpriseInfo,
		tabInfoLoad:tabInfoLoad
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
//	$("#enterpriseBtnSearch").hover( 
//		function () { 
//		$(this).removeClass("search_btn").addClass("search_btn_h"); 
//		}, 
//		function () { 
//		$(this).removeClass("search_btn_h").addClass("search_btn"); 
//		} 
//	); 

});
