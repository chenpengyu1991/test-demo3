<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/statistics/adminMain.js" type="text/javascript"></script>
<div class="section">
<%-- <ul id="tags">
	<li class=selectTag><a id="star_statistics_btn" href="javascript:void(0)">星级统计</a></li>
	<li><a id="record_statistics_btn" href="javascript:void(0)">档案统计</a></li>
</ul>

<div id="tagContent">
	<div id="tagContent0" class="selectTag" >

		<jsp:include page="starSearchForm.jsp"></jsp:include>
		<div id="star_statistics_con" style="display: none ;height: 450px;overflow: auto" >
		</div>
			<div id="star_statistics_chart" style="height: 450px;overflow: auto;" >
		</div>
		
	</div>
	<div id="tagContent1" style="display: none;">
		<jsp:include page="recordSearchForm.jsp"></jsp:include>
		<div id="record_statistics_con" style="display: none;height: 450px;overflow: auto" ></div>
		<div id="record_statistics_chart" style="height: 450px;overflow: auto;" >
		</div>
	</div>
</div> --%>
<div class="toolbar">
	 	<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">居民健康档案</a>
	        <a>
          <cite>星级统计</cite></a>
      	</span>
    	</div>
	  </div>
<div class="layui-tab layui-tab-brief" lay-filter="ehrStarStatistics" style="width: 98%;margin-left: 8px;">
  <ul class="layui-tab-title">
    <li class="layui-this">星级统计</li>
    <li id="record_statistics_btn">档案统计</li>
  </ul>
  <div class="layui-tab-content" id="tagContent">
    <div class="layui-tab-item layui-show">
		   	<jsp:include page="starSearchForm.jsp"></jsp:include>
		<div id="star_statistics_con" style="display: none ;height: 450px;overflow: auto" >
		</div>
			<div id="star_statistics_chart" style="height: 450px;overflow: auto;" >
		</div>
    </div>
    <div class="layui-tab-item">
	 	<jsp:include page="recordSearchForm.jsp"></jsp:include>
		<div id="record_statistics_con" style="display: none;height: 450px;overflow: auto" ></div>
		<div id="record_statistics_chart" style="height: 450px;overflow: auto;" >
		</div>
    </div>
  </div>
</div>
</div>


<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(ehrStarStatistics)', function(data){
      if (data.index == 1) {
    	  if (!$("#record_statistics_btn").hasClass("loaded"))
			{
    		  statisticsMain.getRecordResult();
    		  statisticsMain.initTown("record_twon_se", "record_org_se");
			}
      }  
  });
});

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#cancelBeginDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    //执行一个laydate实例
    laydate.render({
      elem: '#cancelEndDate'
       ,format: 'yyyy/MM/dd'
    	   ,max:0
    });
    
  //执行一个laydate实例
    laydate.render({
      elem: '#deathBeginDate'
    	  ,format: 'yyyy/MM/dd'
    		  ,max:0
    });
  
  //执行一个laydate实例
    laydate.render({
      elem: '#deathEndDate'
    	  ,format: 'yyyy/MM/dd'
    		  ,max:0
    });
  
    
    //执行一个laydate实例
      laydate.render({
        elem: '#moveBeginDate'
      	  ,format: 'yyyy/MM/dd'
      		  ,max:0
      });
    
    //执行一个laydate实例
      laydate.render({
        elem: '#moveEndDate'
      	  ,format: 'yyyy/MM/dd'
      		  ,max:0
      });
    
  });
  
  

layui.use('form', function() {
	  var form = layui.form;
	/*   form.render(); */
	});
</script>