var enterpriseSearch = (function() {
	$(function() { 
            /*重点企业卫生服务档案查询*/
            $("#enterpriseBtnSearch").click(function(e) {
				e.preventDefault();//防止整个页面刷新
                search(1);
            });
            $("#initAdd").click(function() {
            	initAdd();
            });
            
            search(1);
            $("#enterpriseBtnSearch").onEnter(search, 1);
            document.onkeydown = function (e) { 
            	var theEvent = window.event || e; 
            	var code = theEvent.keyCode || theEvent.which; 
            	if (code == 13) { 
            		search(1); 
            	}
            };   
            
            //$("#context").change(selContextChanged);
            //util.checkBoxAll("reportChk","reportChkRef");
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/oh/enterpriseDoc/enterpriselist",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#enterpriseSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAdd(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/oh/enterpriseDoc/initAddView",
				insertDiv : "operationDiv"//,
//				param :{
//					operatorType:'3'
//				}
		};
		$.loadHtmlByUrl(option);
	}
	
	function view(id){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/serviceInfo/edit",
				insertDiv : "operationDiv",
				param :{
					id : id,
					operatorType:'1'
				}
		};
		$.loadHtmlByUrl(option);
	}
	
	function modify(id){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/serviceInfo/edit",
				insertDiv : "operationDiv",
				param :{
					id : id,
					operatorType:'2'
				}
		};
		$.loadHtmlByUrl(option);
	}

	function deleteServiceInfo(dUrl,id){
		if (!id) {
			return;
		}
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('是否彻底删除此项?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : dUrl,
					param : {
						id : id
					},
					callback : function() {
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(){search(1);});
					}
				});
			});
		});
	}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	return {
        search : search,
      //  add:add,
       // caseAdd:caseAdd,
       // caseEdit:caseEdit,
      //  print:print,
       // edit:edit,
        toggle:toggle
	};
})();

// $(document).ready(function () {
// 	//按钮样式切换
// 	$("#enterpriseBtnSearch").hover(
// 		function () {
// 		$(this).removeClass("search_btn").addClass("search_btn_h");
// 		},
// 		function () {
// 		$(this).removeClass("search_btn_h").addClass("search_btn");
// 		}
// 	);
//
// });
