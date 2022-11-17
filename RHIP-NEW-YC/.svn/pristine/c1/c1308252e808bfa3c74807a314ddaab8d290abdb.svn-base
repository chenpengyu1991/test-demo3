var inspectionSearch = (function() {
	$(function() { 
            /*报卡查询*/
            $("#inspectionBtnSearch").click(function() {
                search(1);
            });
            search(1);
            $("#inspectionSearch").onEnter(search, 1);
            $("#btnResourceExport").on("click", function(event) {
    	    	$("#exportTable").exportExcel("检查检验报表统计");
    	    });	
            $('#townOrgCode').on("change",function(){
            	getDeptOption($('#townOrgCode').val());
            });
            $('#centerOrgCode').on("change",function(){
            	getDeptOption($('#centerOrgCode').val());
            });
            $('#orgCode').on("change",function(){
            	getDeptOption($('#orgCode').val());
            });
            $('#clinicOrganCode').on("change",function(){
            	getDeptOption($('#clinicOrganCode').val());
            }); 
            
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/idm/inspection/list",
			insertDiv : "inspectionResultDiv",
//			wait:true,
			param : {
				indexPage : indexPage
			}
		};
		$("#inspectionSearchForm").submitFormLoadHtml(searchObj);
	};

  /*  function detail(id) {
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : '/idm/report/detail/'+ id  ,
            insertDiv :"detailDiv"
        });
        $("#detailDiv").show();
    };*/

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	
	
	
	/**
	 * 很据机构代码更新科室选择下拉框
	 * organCode : 机构代码
	 * deptId : 科室下拉框ID
	 */
	function getDeptOption(organCode)
	{
		var option = {
			url : "/idm/inspection/getDeptList",
			param : {
				organCode : organCode
			},
			callback : (function(list) {
				var select = $("#detectionRoomCode");
				select.empty();
				var html = '<option value="">请选择</option>';
				for (var i in list) {
					html += '<option value="' + list[i].deptCode+ '">' + list[i].deptName + '</option>';
				}
				select.append(html);
			})
		};
		$.getJsonByUrl(option);
	}

	return {
        search : search,
       /* detail:detail,*/
        toggle:toggle
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#inspectionBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 
});
