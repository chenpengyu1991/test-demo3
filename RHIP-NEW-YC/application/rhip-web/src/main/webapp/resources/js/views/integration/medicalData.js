define(function(){
	function load() {
		$(function () {
		
		$.ajaxSetup ({
			cache: false
		});
		
		$("#projectNames").multiselect({
			 header:false,
			 noneSelectedText: '请选择项目类型',
			 selectedList: 2//最多可选中几个
		});
		
		$("#medical_data_search_btn").click(function() {
            search();
        });
		//search();
        $("#integrationLogSearch").onEnter(search, 1);
		});
		
		$("#medical_data_search_bottom").click(function() {
        	toggle(this,'medicalDataSearch');
        });
	}

 	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
        topHide(tableId);
    };
	
	function search() {
		$("#medical_data_from").submitFormLoadHtml({
			url : "/im/medicalData/list",
			insertDiv : "medical_data_content",
            callback : function(data) {
                scrollYFun();
            }
		});
	}

    /**
     * 是否出现滚动条对列表宽度影响
     */
    function scrollYFun() {
        var obj=document.getElementById("medicalDataDiv");
        if(obj == null){
            return;
        }
        if(obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight){
            document.getElementById("medicalDataTopDiv").setAttribute("class","paddingright17");
        }else{
            document.getElementById("medicalDataTopDiv").removeAttribute("class");
        }
    }

    /**
     * 是否收起查询条件对固定滚动的影响
     */
    function topHide(tableId){
        document.getElementById("medicalDataDiv").removeAttribute("class");
        if($("#" + tableId).css("display")=="none"){
             document.getElementById("medicalDataDiv").setAttribute("class","contentfixed90");
        }else{
            document.getElementById("medicalDataDiv").setAttribute("class","contentfixed126");
        }
    }
			
	return {
		load: load
	};
})