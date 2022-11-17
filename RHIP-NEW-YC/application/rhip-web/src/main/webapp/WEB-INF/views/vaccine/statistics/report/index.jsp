<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/vaccine/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/statisticsCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/report/index.js" type="text/javascript"></script>
<div  class="sectionnoborder">
    <ul id=tags>

	    <li>
	        <a id="tag4" href="javascript:void(0)">犬伤防治</a>
	    </li>
	    <li>
	        <a id="tag5" href="javascript:void(0)">犬伤处置</a>
	    </li>	    	    	    
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<%-- <div id=tagContent1 class="selectTag"></div>--%>
<!-- 	 	<div id="tagContent2" class="selectTag" ></div>
	 	<div id="tagContent3" style='display:none' ></div> -->
	 	<div id="tagContent4" class="selectTag" ></div>
	 	<div id="tagContent5" style='display:none' ></div>
	</div>
</div>