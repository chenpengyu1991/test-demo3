<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/selfcheck/index.js" type="text/javascript"></script>
<div>
	<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
	<div id="selfCheckId" class="thirdMenu">
		<c:if test="${RoleType !='FYK'}">
			<span id="spanSelfFill1Id" class="active">
				<a id="selfFill1Id" href="javascript:void(0)" >法定传染病报告填写</a>
			</span>
	        <a>|</a>
			<span id="spanSelfFill2Id">
				<a id="selfFill2Id" href="javascript:void(0)" >新生儿产房接种填写</a>
			</span>
	        <a>|</a>	        
        </c:if>	
		<span id="spanSelfListId">
			<a id="selfListId" href="javascript:void(0)" >查看</a>
		</span>
        <a>|</a>
        <span>
			<a id="selfSummaryId" href="javascript:void(0)">汇总</a>
		</span>
    </div>
    <div id="selfcheck_top_all">
		<div id="selfcheckSearchDiv"></div>
		<div id="selfcheck_ResultDiv"></div>
    </div>
    <div id="selfcheck_detailDiv" ></div>
</div>