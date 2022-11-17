var statisticsSearch = (function() {
	var validate = null;
	$(function() { 
		validate = $("#statisticsSearchForm").easyValidate();
			$("#healthManageStatisticsYear").val(new Date().getFullYear());
            /*体检进度查询*/
            $("#statisticsBtnSearch").onEnter(search, 1);
            $("#statisticsBtnSearch").click(function(event) {
            	event.preventDefault();
                search(1);
            });
            search(1);
            //util.checkBoxAll("reportChk","reportChkRef");
            initForm();
            
            $("#statistics-export-btn").on("click", function(event) {
            	event.preventDefault();
                $("#statisticsResultDiv").exportExcel("老年人健康管理统计分析");
            });
	});

	function initForm(){
		$('#centre1').on("change",function(){
		$('#superOrganCode').val(this.value);
		});
		$('#town1').on("change",function(){
		$('#gbCode').val(this.value);
		});
		$('#centre2').on("change",function(){
		$('#superOrganCode').val(this.value);
		});
		$('#town2').on("change",function(){
		$('#gbCode').val(this.value);
		});
		$('#station2').on("change",function(){
		$('#organCode').val(this.value);
		});
		$('#genreCode').on("change",function(){
			changeOrgType();
		});
		$('#rangeType').on("change",function(){
				changeRangeType();
			});
	    changeOrgType();
	    changeRangeType();
	}
	
	function changeRangeType(){
		var yearType = $('input[name="yearType"]:checked').val();
		if($.isEmpty(yearType)){
			$('input[name="yearType"]:eq(0)').attr("checked",'checked'); 
		}
		var rangeType = $('#rangeType').val();
		if(rangeType == '1'){
			$('#byMonth').show();
			$('#byQuarter').hide();
			$('#byYear').hide();
			$('#byRange').hide();
			$('#beginTime').val('');
			$('#endTime').val('');
		}else if(rangeType == '2'){
			$('#byMonth').hide();
			$('#byQuarter').show();
			$('#byYear').hide();
			$('#byRange').hide();
			$('#beginTime').val('');
			$('#endTime').val('');
		}else if(rangeType == '3'){
			$('#byMonth').hide();
			$('#byQuarter').hide();
			$('#byYear').show();
			$('#byRange').hide();
			$('#beginTime').val('');
			$('#endTime').val('');
		}else if(rangeType == '4'){
			$('#byMonth').hide();
			$('#byQuarter').hide();
			$('#byYear').hide();
			$('#byRange').show();
			$('#beginTime').val($('#beginDate4').val());
			$('#endTime').val($('#endDate4').val());
		}
	} 
	function changeOrgType(){
		var genreCode = $('#genreCode').val();
		if(genreCode == '1'){
			$('.org_td').show();
			$('.add_td').hide();
		}else if(genreCode == '2'){
			$('.org_td').hide();
			$('.add_td').show();
		}
	}
	
	function search(indexPage) {
		var result = validate.validateForm();
		if (!result) {
			return;
		}	
		changeOrgType();
	    changeRangeType();
	    
	    var rangeType = $('#rangeType').val();
	    if(rangeType == '4'){
	    	var sDate = new Date(Date.parse($('#beginTime').val()));
	        var eDate = new Date(Date.parse($('#endTime').val()));
	        
	        if (isEmpty($("#beginDate4").val()) || isEmpty($("#endDate4").val())) {
	        	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请选择完整的时间段！", {icon:0,title:'提示'});
        		});
	        	return;
	        }
	        
	        if(sDate.getFullYear() != eDate.getFullYear()){
	        	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("不允许跨年查询！", {icon:0,title:'提示'});
        		});
	        	 return;
	        }
	        
	        
	        if (sDate > eDate) {
	        	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
        		});
	        	return;
	        }
	        
	       /* if(sDate.getFullYear() != eDate.getFullYear()){
	        	msgUtil.alert("不允许跨年查询");
	        	 return;
	        }*/
	    }
		var searchObj = {
			url : "/hm/statistics/list",
			insertDiv : "statisticsResultDiv",
			param : {
				indexPage : indexPage
			},
            callback : function(data) {
//                scrollYFun();
            }
		};
		$("#statisticsSearchForm").submitFormLoadHtml(searchObj);
	};

    /**
     * 是否出现滚动条对列表宽度影响
     */
    function scrollYFun() {
        var obj=document.getElementById("hmStatisticsDiv");
        if(obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight){
            document.getElementById("hmStatisticsTopDiv").setAttribute("class","paddingright17");
        }else{
            document.getElementById("hmStatisticsTopDiv").removeAttribute("class");
        }
    }

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
        /*topHide(tableId);*/
	};

    /**
     * 是否收起查询条件对固定滚动的影响
     */
    function topHide(tableId){
        document.getElementById("hmStatisticsDiv").removeAttribute("class");
        if($("#" + tableId).css("display")=="none"){
            document.getElementById("hmStatisticsDiv").setAttribute("class","contentfixed83");
        }else{
            document.getElementById("hmStatisticsDiv").setAttribute("class","contentfixed119");
        }
    }

	return {
        search : search,
        toggle:toggle
	};
})();

/*$(document).ready(function () { 
	//按钮样式切换 
	$("#statisticsBtnSearch").hover( 
	function () { 
	$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
	$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});*/