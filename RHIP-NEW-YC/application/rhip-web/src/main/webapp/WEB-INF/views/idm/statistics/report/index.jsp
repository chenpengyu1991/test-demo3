<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/statisticsCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/index.js" type="text/javascript"></script>
<div  class="sectionnoborder">
    <ul id=tags>
<%--    
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">传染病管理及督导</a>
	    </li>
--%>
	    <li class=selectTag>
	        <a id="tag2" href="javascript:void(0)">执行情况自查</a>
	    </li>
	    <li>
	        <a id="tag3" href="javascript:void(0)">手足口病采样</a>
	    </li>
	    <li>
	        <a id="tag4" href="javascript:void(0)">传染病管理月报表</a>
	    </li>
	    <li>
	        <a id="tag5" href="javascript:void(0)">急性传染病防治</a>
	    </li>	    	    	    
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<%-- <div id=tagContent1 class="selectTag"></div>--%>
	 	<div id="tagContent2" class="selectTag" ></div>
	 	<div id="tagContent3" style='display:none' ></div>
	 	<div id="tagContent4" style='display:none' ></div>
	 	<div id="tagContent5" style='display:none' ></div>
	</div>
</div>