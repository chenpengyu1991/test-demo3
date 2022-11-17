<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/supervisor/index.js" type="text/javascript"></script>
<div>
	<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
	<div id="supervisorId" class="thirdMenu">
		<c:if test="${RoleType !='FYK'}">
			<span id="spanSupervisorFillId" class="active">
				<a id="supervisorFillId" href="javascript:void(0)" >填写</a>
			</span>
	        <a>|</a>
        </c:if>
		<span id="spanSupervisorListId">
			<a id="supervisorListId" href="javascript:void(0)" >查看</a>
		</span>	
		<a>|</a>        
        <span>
			<a id="supervisorSummaryId" href="javascript:void(0)">汇总</a>
		</span>
    </div>
    <div id="supervisor_top_all">
    	<div id="supervisorFillDiv"></div>
		<div id="supervisorSearchDiv"></div>
		<div id="supervisor_ResultDiv"></div>
    </div>
    <div id="supervisor_detailDiv" ></div>
</div>