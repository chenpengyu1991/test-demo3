var logSearch = (function() {
	$(function() { 
            /*报卡查询*/
            $("#logBtnSearch").click(function() {
                search(1);
            });
            search(1);
            $("#logSearch").onEnter(search, 1);
            $("#btnResourceExport").on("click", function(event) {
    	    	$("#exportTable").exportExcel("出入院登记报表");
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
			url : "/idm/log/register/list",
			insertDiv : "logResultDiv",
//			wait:true,
			param : {
				indexPage : indexPage
			}
		};
		$("#logSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function getDeptOption(organCode)
	{
		var option = {
			url : "/idm/inspection/getDeptList",
			param : {
				organCode : organCode
			},
			callback : (function(list) {
				var select = $("#medicalRoomCode");
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

	return {
        search : search,
       /* detail:detail,*/
        toggle:toggle
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#logBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 
});
