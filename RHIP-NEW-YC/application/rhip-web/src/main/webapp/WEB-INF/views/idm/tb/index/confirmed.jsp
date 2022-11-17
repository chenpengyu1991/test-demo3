<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>

<div>
     <div id="confirmedId" name="thirdMenu" class="thirdMenu">
     	<ehr:authorize ifAnyGranted="${DDCRBYY}">
	     	 <span class="active"><a id="diagnosisId" href="javascript:void(0)">确诊</a></span>
         </ehr:authorize>
          <%--<ehr:authorize ifNotGranted="${DDCRBYY}">--%>
         |<span <ehr:authorize ifNotGranted="${DDCRBYY}">class="active"</ehr:authorize>>
	         	<a id="dcmrId" href="javascript:void(0)">专用病历</a>
	         </span>
         	<a>|</a>
         	<span><a id="treatmentId" href="javascript:void(0)">治疗卡</a></span>
         <%--</ehr:authorize>--%>
     </div>

	<div id="diagnosisPage">
		<ehr:authorize ifAnyGranted="${DDCRBYY}">
        	<jsp:include page="../diagnosis/search.jsp"/>
        </ehr:authorize>
    </div>
    
    <div id="dcmrPage">
    	<ehr:authorize ifNotGranted="${DDCRBYY}">
        	<jsp:include page="../dcmr/search.jsp"/>
        </ehr:authorize>
    </div>
    <div id="treatmentPage" style="display: none;">
       <jsp:include page="../treatment/search.jsp"/>
    </div>
</div>