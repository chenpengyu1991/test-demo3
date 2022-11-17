var statisticsSearch = (function() {
	var validate = null;
	$(function() { 
		validate = $("#statisticsSearchForm").easyValidate();
        /*体检进度查询*/
        $("#statisticsBtnSearch").onEnter(search, 1);
        $("#statisticsBtnSearch").click(function() {
            search(1);
        });
        search(1);        
	});

	function search(indexPage) { 
		var result = validate.validateForm();
		if (!result) {
			return;
		}		

		var searchObj = {
			url : "/idm/report/diseasesStatistics/list",
			insertDiv : "statisticsResultDiv",
			param : {
				indexPage : indexPage
			}/*,
            callback : function(data) {
                scrollYFun();
            }*/
		};
		$("#statisticsSearchForm").submitFormLoadHtml(searchObj);
	};

    /**
     * 是否出现滚动条对列表宽度影响
     */
    function scrollYFun() {
        var obj=document.getElementById("statisticsDiv");
        if(obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight){
            document.getElementById("statisticsTopDiv").setAttribute("class","paddingright17");
        }else{
            document.getElementById("statisticsTopDiv").removeAttribute("class");
        }
    }

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
        topHide(tableId);
	};

    /**
     * 是否收起查询条件对固定滚动的影响
     */
    function topHide(tableId){
        document.getElementById("statisticsDiv").removeAttribute("class");
        if($("#" + tableId).css("display")=="none"){
            document.getElementById("statisticsDiv").setAttribute("class","contentfixed83");
        }else{
            document.getElementById("statisticsDiv").setAttribute("class","contentfixed119");
        }
    }

	return {
        search : search,
        toggle:toggle
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#statisticsBtnSearch").hover( 
	function () { 
	$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
	$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});