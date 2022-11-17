<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXAK" value="<%=RoleType.JKXAK.getValue()%>"/>
<c:set var="SJYYFBK" value="<%=RoleType.SJYYFBK.getValue()%>"/>
<c:set var="SQZX" value="<%=RoleType.SQZX.getValue()%>"/>

<div>
	<div id="confirmedId" class="thirdMenu">
	<ehr:authorize ifAnyGranted="${JKXAK }">
		<span class="active">
			<a id="caseId" href="javascript:void(0)" >个案</a>
		</span>
		 <a>|</a>
	</ehr:authorize>
        <span <ehr:authorize ifNotGranted="${JKXAK }">class="active"</ehr:authorize>>
			<a id="contactId" href="javascript:void(0)">密切接触者</a>
		</span>
		<a>|</a>
        <span>
			<a id="followupId" href="javascript:void(0)">随访观察</a>
		</span>
    </div>

	<div id="casePage">
		<ehr:authorize ifAnyGranted="${JKXAK }">
        <jsp:include page="../case/search.jsp"></jsp:include>
        </ehr:authorize>
    </div>
    
    <div id="contactPage" <ehr:authorize ifAnyGranted="${JKXAK }">style="display: none;"</ehr:authorize>>
        <jsp:include page="../contact/search.jsp"/>
    </div>
    <div id="followupPage" style="display: none;">
       <jsp:include page="../followup/search.jsp"/>
    </div>
</div>