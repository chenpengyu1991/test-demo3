<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>
<c:set var="ZJHB" value="<%=RoleType.ZJHB.getValue()%>"/>

<div>
     <div id="beforeConfirmedId" class="thirdMenu">
     	 <ehr:authorize ifAnyGranted="${JKJHB},${ZJHB}">
	         <span class="active" data->
	         	<a id="recommendationId" href="javascript:void(0)">疑似推荐</a>
	         </span>
         </ehr:authorize>
         <ehr:authorize ifNotGranted="${JKJHB},${ZJHB}">
	         <span class="active">
	         	<a id="registerId" href="javascript:void(0)">筛查登记</a>
	         </span>
	         <a>|</a>
	         <span><a id="transfertreatId" href="javascript:void(0)">转诊</a></span>
         </ehr:authorize>
     </div>
     
    <div id="recommendationPage">
    	 <ehr:authorize ifAnyGranted="${JKJHB},${ZJHB}">
    	 	 <jsp:include page="../recommendation/search.jsp"/>
    	 </ehr:authorize>
    </div>
    <div id="registerPage" <ehr:authorize ifAnyGranted="${JKJHB},${ZJHB}">style="display: none;"</ehr:authorize>>
      <jsp:include page="../register/search.jsp"/>
    </div>
    <div id="transfertreatPage" style="display: none;">
      <%-- <jsp:include page="../transfertreat/search.jsp"/> --%>
    </div>
</div>