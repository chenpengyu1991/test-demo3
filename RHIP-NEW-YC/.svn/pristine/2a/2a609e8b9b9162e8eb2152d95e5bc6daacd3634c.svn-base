<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/schCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/schIndex.js" type="text/javascript"></script>
<div  class="sectionnoborder">
    <%-- <ul id=tags>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">监测登记</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">个案调查</a>
	    </li>
	    <li>
	        <a id="tag3" href="javascript:void(0)">晚血管理</a>
	    </li>
		<li>
			<a id="tag4" href="javascript:void(0)">统计报表</a>
		</li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent1 class="selectTag"></div>
	 	<div id="tagContent2" style='display:none' ></div>
		<div id="tagContent3" style="display:none" ></div>
		<div id="tagContent4" style="display:none" ></div>
	</div> --%>
	<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">传染病及突发事件</a>
		        <a href="javascript:void(0)">专项</a>
		        <a>
		          <cite>血吸虫</cite></a>
		      </span>
		</div>
        </div>
	<div class="layui-tab layui-tab-brief" lay-filter="idmschistosomeTab" style="width: 98%;margin-left: 8px;">
	  <ul class="layui-tab-title">
	    <li class="layui-this" id="tag1" lay-id="tag1">监测登记</li>
	    <li id="tag2" lay-id="tag2">个案调查</li>
	    <li id="tag3" lay-id="tag3">晚血管理</li>
	    <li id="tag4" lay-id="tag4">统计报表</li>
	  </ul>
	  <div class="layui-tab-content">
	    <div class="layui-tab-item layui-show" id="tagContent1">
	    </div>
	    <div class="layui-tab-item" id="tagContent2">
	    </div>
	    <div class="layui-tab-item" id="tagContent3">
	    </div>
	    <div class="layui-tab-item" id="tagContent4">
	    </div>
	  </div>
	</div>
</div>

<script>
var tabContent = 0;
layui.use('element', function() {
  var element = layui.element;
  
  $("#tag1").click(function() {
   	if($("#tag1").hasClass("layui-this")) {
   		tabContent = 0;
    } else if ($("#tag2").hasClass("layui-this")) {
    	tabContent = 1;
    } else if ($("#tag3").hasClass("layui-this")) {
    	tabContent = 2;
    } else if ($("#tag4").hasClass("layui-this")) {
    	tabContent = 3;
    }
  });
  
  
  $("#tag2").click(function() {
   	if($("#tag1").hasClass("layui-this")) {
   		tabContent = 0;
    } else if ($("#tag2").hasClass("layui-this")) {
    	tabContent = 1;
    } else if ($("#tag3").hasClass("layui-this")) {
    	tabContent = 2;
    } else if ($("#tag4").hasClass("layui-this")) {
    	tabContent = 3;
    }
  });
  
  
  $("#tag3").click(function() {
   	if($("#tag1").hasClass("layui-this")) {
   		tabContent = 0;
    } else if ($("#tag2").hasClass("layui-this")) {
    	tabContent = 1;
    } else if ($("#tag3").hasClass("layui-this")) {
    	tabContent = 2;
    } else if ($("#tag4").hasClass("layui-this")) {
    	tabContent = 3;
    }
  });
  
  
  $("#tag4").click(function() {
   	if($("#tag1").hasClass("layui-this")) {
   		tabContent = 0;
    } else if ($("#tag2").hasClass("layui-this")) {
    	tabContent = 1;
    } else if ($("#tag3").hasClass("layui-this")) {
    	tabContent = 2;
    } else if ($("#tag4").hasClass("layui-this")) {
    	tabContent = 3;
    }
  });
  
  

// 事件监听
  element.on('tab(idmschistosomeTab)', function(data) {
      if (data.index == 0) {
    	  if(contentChanged) {
    		  layui.use('layer', function() {
					var layer = layui.layer;
					var index = layer.confirm('确认离开？', {icon:0, title:'确认提示'}, function(index) {
						layer.close(index);
						disableChangeConfirm();
						schIndex.registerIndex();
						return;
					});
				});
    		  if (tabContent == 0) {
    		  	element.tabChange('idmschistosomeTab','tag1');
    		  } else if (tabContent == 1) {
    			element.tabChange('idmschistosomeTab','tag2');
    		  } else if (tabContent == 2) {
    			element.tabChange('idmschistosomeTab','tag3');
    		  } else if (tabContent == 3) {
    			element.tabChange('idmschistosomeTab','tag4');
    		  }
    		  
	      } else {
	    	  schIndex.registerIndex();
	     }
    	  
      } else if(data.index == 1) {
    	  if(contentChanged) {
    		  layui.use('layer', function() {
					var layer = layui.layer;
					var index = layer.confirm('确认离开？', {icon:0, title:'确认提示'}, function(index) {
						layer.close(index);
						disableChangeConfirm();
						schIndex.caseIndex();
						return;
					});
				});
    		  if (tabContent == 0) {
    		  	element.tabChange('idmschistosomeTab','tagContent1');
    		  } else if (tabContent == 1) {
    			element.tabChange('idmschistosomeTab','tagContent2');
    		  } else if (tabContent == 2) {
    			element.tabChange('idmschistosomeTab','tagContent3');
    		  } else if (tabContent == 3) {
    			element.tabChange('idmschistosomeTab','tagContent4');
    		  }
    		  
	      } else {
	    	  schIndex.caseIndex();
	     }
    	 
      }   else if(data.index == 2) {
    	  if(contentChanged) {
    		  layui.use('layer', function() {
					var layer = layui.layer;
					var index = layer.confirm('确认离开？', {icon:0, title:'确认提示'}, function(index) {
						layer.close(index);
						disableChangeConfirm();
						schIndex.advancedIndex();
						return;
					});
				});
    		  if (tabContent == 0) {
    		  	element.tabChange('idmschistosomeTab','tagContent1');
    		  } else if (tabContent == 1) {
    			element.tabChange('idmschistosomeTab','tagContent2');
    		  } else if (tabContent == 2) {
    			element.tabChange('idmschistosomeTab','tagContent3');
    		  } else if (tabContent == 3) {
    			element.tabChange('idmschistosomeTab','tagContent4');
    		  }
    		  
	      } else {
	    	  schIndex.advancedIndex();
	     }
    	 
      }  else if(data.index == 3) {
    	  if(contentChanged) {
    		  layui.use('layer', function() {
					var layer = layui.layer;
					var index = layer.confirm('确认离开？', {icon:0, title:'确认提示'}, function(index) {
						layer.close(index);
						disableChangeConfirm();
						schIndex.reportIndex();
						return;
					});
				});
    		  if (tabContent == 0) {
    		  	element.tabChange('idmschistosomeTab','tagContent1');
    		  } else if (tabContent == 1) {
    			element.tabChange('idmschistosomeTab','tagContent2');
    		  } else if (tabContent == 2) {
    			element.tabChange('idmschistosomeTab','tagContent3');
    		  } else if (tabContent == 3) {
    			element.tabChange('idmschistosomeTab','tagContent4');
    		  }
    		  
	      } else {
	    	  schIndex.reportIndex();
	     }
    	 
      }  
  });
});
</script>