<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/index.js" type="text/javascript"></script>
<div  class="sectionnoborder">
    <input type="hidden" id="statusId" value="${statusId}">
    <input type="hidden" id="logoffId" value="${logoff}">
    <input type="hidden" id="pixId" value="${pixId}">
    <input type="hidden" id="bringIntoMode" value="${bringIntoMode}">

    <!-- <ul id=tagsl>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">基本档案</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">出院信息</a>
	    </li>
	    <li>
	        <a id="tag3" href="javascript:void(0)">随访记录</a>
	    </li>
	    <li>
	        <a id="tag4" href="javascript:void(0)">失访信息</a>
	    </li>
	    <li>
	        <a id="tag5" href="javascript:void(0)">个案管理计划</a>
	    </li>
	    <li>
	        <a id="tag6" href="javascript:void(0)">效果评估</a>
	    </li>	
	    <li>
	        <a id="tag7" href="javascript:void(0)">应急处置</a>
	    </li>	
	    <li>
	        <a id="tag8" href="javascript:void(0)">门诊信息</a>
	    </li>	
	    <li>
	        <a id="tag9" href="javascript:void(0)">转诊信息</a>
	    </li>
        <li>
            <a id="tag10" href="javascript:void(0)">健康体检</a>
        </li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent1 class="selectTag"></div>
	 	<div id="tagContent2" style='display:none' ></div>
	 	<div id="tagContent3" style='display:none' ></div>
	 	<div id="tagContent4" style='display:none' ></div>
	 	<div id="tagContent5" style='display:none' ></div>
	 	<div id="tagContent6" style='display:none' ></div>
		<div id="tagContent7" style='display:none' ></div>
		<div id="tagContent8" style='display:none' ></div>
		<div id="tagContent9" style='display:none' ></div>
		<div id="tagContent10" style='display:none' ></div>
	</div> -->
	
	<div class="layui-tab layui-tab-brief" lay-filter="mhmManageTab">
	   <ul class="layui-tab-title">
	    <li class="layui-this" id="tag1" lay-id="tag1">基本档案</li>
	    <li id="tag2" lay-id="tag2">出院信息</li>
	    <li id="tag3" lay-id="tag3">随访记录</li>
	    <li id="tag4" lay-id="tag4">失访信息</li>
	    <li id="tag5" lay-id="tag5">个案管理计划</li>
	    <li id="tag6" lay-id="tag6">效果评估</li>
	    <li id="tag7" lay-id="tag7">应急处置</li>
	    <li id="tag8" lay-id="tag8">门诊信息</li>
	    <li id="tag9" lay-id="tag9">转诊信息</li>
	    <li id="tag10" lay-id="tag10">健康体检</li>
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
          <div class="layui-tab-item" id="tagContent5">
          </div>
          <div class="layui-tab-item" id="tagContent6">
          </div>
          <div class="layui-tab-item" id="tagContent7">
          </div>
          <div class="layui-tab-item" id="tagContent8">
          </div>
          <div class="layui-tab-item" id="tagContent9">
          </div>
          <div class="layui-tab-item" id="tagContent10">
          </div>
	 </div>
  </div>
</div>

<script type="text/javascript">

var _index = 0;

layui.use('element', function() {
  var element = layui.element;
  
  /* $("#tag1").click(function() {
	   	if($("#tag1").hasClass("layui-this")) {
	   		tabContent = 0;
	    } else if ($("#tag2").hasClass("layui-this")) {
	    	tabContent = 1;
	    } else if ($("#tag3").hasClass("layui-this")) {
	    	tabContent = 2;
	    } else if ($("#tag4").hasClass("layui-this")) {
	    	tabContent = 3;
	    } else if ($("#tag5").hasClass("layui-this")) {
	    	tabContent = 4;
	    } else if ($("#tag6").hasClass("layui-this")) {
	    	tabContent = 5;
	    } else if ($("#tag7").hasClass("layui-this")) {
	    	tabContent = 6;
	    } else if ($("#tag8").hasClass("layui-this")) {
	    	tabContent = 7;
	    } else if ($("#tag9").hasClass("layui-this")) {
	    	tabContent = 8;
	    } else if ($("#tag10").hasClass("layui-this")) {
	    	tabContent = 9;
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
	  }); */
	  
  element.on('tab(mhmManageTab)', function(data) {
	  
	 /*  if(contentChanged) {
		  alert(contentChanged);
		  changeTag(element, _index);
		  layui.use('layer', function() {
				var layer = layui.layer;
				 var index = layer.confirm('确认离开？',function() {
					layer.close(index);
					disableChangeConfirm();
					changeTabCascadeContent(element, data.index);
					return;
				}); 
				 
			});
		  
	  } else {
		  loadContent(data.index);
	  }
	   */
	  loadContent(data.index);
	     
  });
  
	  
});

 /*  function changeTag(element, index) {
	      if (index == 0) {
		  	element.tabChange('mhmManageTab','tag1');
		  } else if (index == 1) {
			element.tabChange('mhmManageTab','tag2');
		  } else if (index == 2) {
			element.tabChange('mhmManageTab','tag3');
		  } else if (index == 3) {
			element.tabChange('mhmManageTab','tag4');
		  }  else if (index == 4) {
			element.tabChange('mhmManageTab','tag5');
		  }  else if (index == 5) {
			element.tabChange('mhmManageTab','tag6');
		  }  else if (index == 6) {
			element.tabChange('mhmManageTab','tag7');
		  }  else if (index == 7) {
			element.tabChange('mhmManageTab','tag8');
		  }  else if (index == 8) {
			element.tabChange('mhmManageTab','tag9');
		  }  else if (index == 9) {
			element.tabChange('mhmManageTab','tag10');
		  }
  } */
  
	 /*  function changeTabCascadeContent(element, index) {
		  if (index == 0) {
				changeTag(element, 0);
				managementIndex.baseinfo();
		  } else if (index == 1) {
			  changeTag(element, 1);
			  managementIndex.outInfo();
		  }  else if (index == 2) {
			  changeTag(element, 1);
			  managementIndex.followUp();
		  } else if (index == 3) {
			  changeTag(element, 1);
			  managementIndex.lostFollowUpIndex();
		  } else if (index == 4) {
			  changeTag(element, 1);
			  managementIndex.casePlan();
		  } else if (index == 5) {
			  changeTag(element, 1);
			  managementIndex.evaluation();
		  } else if (index == 6) {
			  changeTag(element, 1);
			  managementIndex.emergency();
		  } else if (index == 7) {
			  changeTag(element, 1);
			  managementIndex.advancedIndex();
		  } else if (index == 8) {
			  changeTag(element, 1);
			  managementIndex.referral();
		  } else if (index == 9) {
			  changeTag(element, 1);
			  managementIndex.healthCheck();
		  } 
	  } */
	  
	  function loadContent(index) {
		  if (index == 0) {
				managementIndex.baseinfo();
		  } else if (index == 1) {
			  managementIndex.outInfo();
		  }  else if (index == 2) {
			  managementIndex.followUp();
		  } else if (index == 3) {
			  managementIndex.lostFollowUpIndex();
		  } else if (index == 4) {
			  managementIndex.casePlan();
		  } else if (index == 5) {
			  managementIndex.evaluation();
		  } else if (index == 6) {
			  managementIndex.emergency();
		  } else if (index == 7) {
			  managementIndex.advancedIndex();
		  } else if (index == 8) {
			  managementIndex.referral();
		  } else if (index == 9) {
			  managementIndex.healthCheck();
		  } 
	  }
	  
/* $(function() {
	$("li[id^='tag']").each(function () {
		$(this).click(function() {
		   	if($("#tag1").hasClass("layui-this")) {
		   		_index = 0;
		    } else if ($("#tag2").hasClass("layui-this")) {
		    	_index = 1;
		    } else if ($("#tag3").hasClass("layui-this")) {
		    	_index = 2;
		    } else if ($("#tag4").hasClass("layui-this")) {
		    	_index = 3;
		    } else if ($("#tag5").hasClass("layui-this")) {
		    	_index = 4;
		    } else if ($("#tag6").hasClass("layui-this")) {
		    	_index = 5;
		    } else if ($("#tag7").hasClass("layui-this")) {
		    	_index = 6;
		    } else if ($("#tag8").hasClass("layui-this")) {
		    	_index = 7;
		    } else if ($("#tag9").hasClass("layui-this")) {
		    	_index = 8;
		    } else if ($("#tag10").hasClass("layui-this")) {
		    	_index = 9;
		    } 
		   	
		  });
	});
}) */
</script>

