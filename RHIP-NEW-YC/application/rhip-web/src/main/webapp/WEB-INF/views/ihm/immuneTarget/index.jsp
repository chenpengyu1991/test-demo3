<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/immuneTarget/index.js" type="text/javascript"></script>
<div  class="sectionnoborder">
    <ul id=tagsl>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">接种信息</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">儿童禁忌</a>
	    </li>
        <li>
            <a id="tag3" href="javascript:void(0)">接种副反应</a>
        </li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent1 class="selectTag"></div>
	</div>
</div>