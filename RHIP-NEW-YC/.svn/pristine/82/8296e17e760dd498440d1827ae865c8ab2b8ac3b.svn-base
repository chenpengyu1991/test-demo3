<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXSCB" value="<%=RoleType.ZXSCB.getValue()%>"/>
<div>
	<div class="thirdMenu" id="standardizationIndexId">
        <span id="drugRegId" class="active"><a class="tabbtn" onclick="filStandard.searchFollowup(1)">随访</a></span>
        <ehr:authorize ifNotGranted="${ZXSCB}">
            <a>|</a>
            <span id="interview"><a class="tabbtn" onclick="filStandard.searchSc(1)">工作督导</a></span>
        </ehr:authorize>
    </div>

    <jsp:include page="followup/search.jsp"></jsp:include>
</div>