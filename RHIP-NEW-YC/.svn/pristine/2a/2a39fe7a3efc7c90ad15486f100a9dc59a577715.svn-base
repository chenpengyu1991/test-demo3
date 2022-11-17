var susOccDi = (function() {
	$(function() { 
		$("#hsa-sodp-search-btn").click(function(){
			searchSusOccDi(1);
		});
		$("#hsa-susOccDi-add-btn").click(function(){
			addSusOccDiInfo();
		});
		$("#sus-occ-detailed-view").on("click","#save-sus-occ-di-button",function(){
			saveSusOccDisInfo();
		});
		$("#sus-occ-detailed-view").on("click","#return-sus-occ-di-button",function(){
			$("#hsa-sodp-list-box").show();
			$("#sus-occ-detailed-view").hide();
		}); 
		$("#sus_occ_di_form_search").keypress(function(e){
			var key = e.which;
			if (key == 13){
				searchSusOccDi(1);
			}
		});
		//更新可疑职业病信息
		$("#hsa-sodp-result-box").on("click", ".update-sus-occ-dis-info",function(event){
			event.preventDefault();
			$("#hsa-sodp-list-box").hide();
			$("#sus-occ-detailed-view").show();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/sodp/updateOrSearchSusOccDisInfo",
				insertDiv : "sus-occ-detailed-view",
				param:{
						id:$(this).data("id"),
						flag:"update"
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
		//查看可疑职业病信息
		$("#hsa-sodp-result-box").on("click", ".search-sus-occ-dis-info",function(event){
			event.preventDefault();
			$("#hsa-sodp-list-box").hide();
			$("#sus-occ-detailed-view").show();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/sodp/updateOrSearchSusOccDisInfo",
				insertDiv : "sus-occ-detailed-view",
				param:{
						id:$(this).data("id"),
						flag:"search"
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
		searchSusOccDi(1);
	});
	//保存可疑职业病信息
	function saveSusOccDisInfo(){
		 var validate = $("#sus-occ-dis-form").easyValidate();
		 var result = validate.validateForm();
		 if (!result){
		 	return;
		 }
		$("#sus-occ-dis-form").submitFormGetJson({			
	        url : "/hsa/inspRecord/sodp/saveSusOccDisInfo", 
	    	callback : function(data){
	    		if("failure" == data){
	    			layer.alert("保存失败！", {icon:0,title:'提示'});
	    		}
	    		if("success" == data){
	    			layer.alert("保存成功！", {icon:0,title:'提示'}, function(index){
	    				$("#hsa-sodp-list-box").show();
	    				$("#sus-occ-detailed-view").hide();
	    				searchSusOccDi(1);
	    				layer.close(index);
	    			});
	    		}
	    	}
		});
	}
	function addSusOccDiInfo(){
		$("#hsa-sodp-list-box").hide();
		$("#sus-occ-detailed-view").show();
		var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/sodp/susOccDiDetailedInfo",
				insertDiv : "sus-occ-detailed-view",
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	function searchSusOccDi(indexPage) {
		var searchObj = {
			url : "/hsa/inspRecord/sodp/susOccDiSearch",
			insertDiv : "hsa-sodp-result-box",
			param : {			
				indexPage : indexPage,
			}
		};
		$("#sus_occ_di_form_search").submitFormLoadHtml(searchObj);
	}
	function searchDetailedInfo(id){
		$("#hsa-sodp-list-box").hide();
		$("#sus-occ-detailed-view").show();
		var loadHtmlByUrlOption = {
			url : "/hsa/inspRecord/sodp/susOccDiDetailedInfo",
			insertDiv : "sus-occ-detailed-view",
			param:{
				id:id
			}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	 function toggle(obj,tableId) {
			$(obj).toggleClass("ico-top");
			$(obj).toggleClass("ico-bottom");
			$("#" + tableId).toggle();
		}
	return {
		searchDetailedInfo:searchDetailedInfo,
		searchSusOccDi:searchSusOccDi,
		toggle:toggle
	};
})();