<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/malariaIndex.js" type="text/javascript"></script>
<input type="hidden" id="registerFlagId" name="registerFlag" value="${registerFlag}"/>
<input type="hidden" id="manageFlagId" name="manageFlag" value="${manageFlag}"/>
<div class="sectionnoborder">
    <ul id=tags>
		<c:if test="${registerFlag =='1'}">    	
		    <li class=selectTag>
	        	<a id="tag1" href="javascript:void(0)">血检登记</a>
		    </li>
		</c:if>	   
	    <c:if test="${manageFlag =='1'}">
		    <li>
		        <a id="tag2" href="javascript:void(0)">个案调查</a>
		    </li>
		    <li>
		        <a id="tag3" href="javascript:void(0)">规范管理</a>
		    </li>
		</c:if>    
	</ul>
	<div id="tagContent" style="width: 99.5%">
		<c:if test="${registerFlag =='1'}">	
		   	<div id=tagContent0 class="selectTag">
	   			<jsp:include page="./register/search.jsp"></jsp:include>
			</div>
		</c:if>
		<c:if test="${manageFlag =='1'}">
		 	<div id="tagContent1" style='<c:if test="${registerFlag =='1'}">display:none</c:if>' >
	        	<jsp:include page="./case/search.jsp"></jsp:include>
			</div>
			<div id="tagContent2" style="display:none" ></div>	 
		 </c:if>
	</div>
</div>