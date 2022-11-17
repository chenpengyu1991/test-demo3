<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/leprosy.js" type="text/javascript"></script>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXAK" value="<%=RoleType.JKXAK.getValue()%>"/>
<c:set var="SJYYFBK" value="<%=RoleType.SJYYFBK.getValue()%>"/>
<c:set var="SQZX" value="<%=RoleType.SQZX.getValue()%>"/>

<div id="con" class="sectionnoborder">
    <ul id="tags">
    	<ehr:authorize ifNotGranted="${JKXAK }">
       	 <li class=selectTag><a id="tag0" onclick="selectTag('tagContent0',this)" href="javascript:void(0)">疑似</a></li>
       	 <li><a id="tag2" onclick="selectTag('tagContent2',this)" href="javascript:void(0)">管理</a></li>
        </ehr:authorize>
        <ehr:authorize ifAnyGranted="${JKXAK }">
        	<li class=selectTag><a id="tag0" onclick="selectTag('tagContent0',this)" href="javascript:void(0)">确诊</a></li>
        	<li><a id="tag2" onclick="selectTag('tagContent2',this)" href="javascript:void(0)">管理</a></li>
        	<li><a id="tag3" onclick="selectTag('tagContent3',this)" href="javascript:void(0)">统计</a></li>
        </ehr:authorize>
    </ul>
    <div id="tagContent">
        <div id="tagContent0" class="selectTag">
           	<jsp:include page="../suspected/search.jsp"/>
        </div>
        <div id="tagContent2" style="display:none">
             <jsp:include page="manager.jsp"/>
        </div>
         <div id="tagContent3" style="display:none">
             <jsp:include page="statistics.jsp"/>
        </div>
    </div>
</div>
