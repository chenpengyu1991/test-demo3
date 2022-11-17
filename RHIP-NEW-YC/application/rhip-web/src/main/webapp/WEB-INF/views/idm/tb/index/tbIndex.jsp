<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="YYJHB" value="<%=RoleType.YYJHB.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>
<c:set var="ZXJHB" value="<%=RoleType.ZXJHB.getValue()%>"/>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb.js" type="text/javascript"></script>

<div id="con" class="sectionnoborder">
   <%--  <ul id="tags">
    	<ehr:authorize ifNotGranted="${DDCRBYY}">
        	<li class=selectTag><a id="tag0" onclick="selectTag('tagContent0',this)" href="javascript:void(0)">疑似与检查</a></li>
       </ehr:authorize>
        <li <ehr:authorize ifAnyGranted="${DDCRBYY}">class=selectTag</ehr:authorize>><a id="tag1" onclick="selectTag('tagContent1',this)" href="javascript:void(0)">确诊与方案</a></li>
        <ehr:authorize ifNotGranted="${DDCRBYY}">
        <li><a id="tag2" onclick="selectTag('tagContent2',this)" href="javascript:void(0)">规范化管理</a></li>
        </ehr:authorize>
        <li><a id="tag4" onclick="selectTag('tagContent4',this)" href="javascript:void(0)">耐多药管理</a></li>
        <ehr:authorize ifAnyGranted="${JKJHB},${ZXJHB},${YYJHB},${DDCRBYY}">
            <li><a id="tag3" onclick="selectTag('tagContent3',this)" href="javascript:void(0)">统计报表</a></li>
        </ehr:authorize>
    </ul>
    <div id="tagContent">
    	<ehr:authorize ifNotGranted="${DDCRBYY}">
	        <div id=tagContent0 class="selectTag">
	            <jsp:include page="beforeConfirmed.jsp"/>
	        </div>
       </ehr:authorize>
        <div id="tagContent1" <ehr:authorize ifNotGranted="${DDCRBYY}">style="display:none" </ehr:authorize> >
            <jsp:include page="confirmed.jsp"/>
        </div>
        <div id="tagContent2" style="display:none" >
            <jsp:include page="standardizedManagement.jsp"/>
        </div>
        <div id="tagContent3" style="display:none" >
            <jsp:include page="statistics.jsp"/>
        </div>
        <div id="tagContent4" style="display:none" >
            <jsp:include page="ndyManagement.jsp"/>
        </div>
    </div> --%>
    
    <div class="toolbar">
            <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">肺结核健康管理</a>
		        <a>
		          <cite>肺结核健康管理</cite></a>
		      </span>
		</div>

    </div>
	<div class="layui-tab layui-tab-brief" lay-filter="tbManageTab" style="width: 98%;margin-left: 8px;">
	  <ul class="layui-tab-title">
	  <ehr:authorize ifNotGranted="${DDCRBYY}">
	    <li class="layui-this" id="tag0">疑似与检查</li>
	  </ehr:authorize>
	    <li id="tag1">确诊与方案</li>
	    <li id="tag2">规范化管理</li>
	    <li id="tag3">耐多药管理</li>
	    <ehr:authorize ifAnyGranted="${JKJHB},${ZXJHB},${YYJHB},${DDCRBYY}">
	    <li id="tag4">统计报表</li>
	    </ehr:authorize>
	  </ul>
	  <div class="layui-tab-content">
	  <ehr:authorize ifNotGranted="${DDCRBYY}">
	  	<div class="layui-tab-item layui-show" id="tagContent0">
	  		<jsp:include page="beforeConfirmed.jsp"/>
	  	</div>
	  </ehr:authorize>
	    <div <ehr:authorize ifAnyGranted="${DDCRBYY}">class="layui-tab-item layui-show"</ehr:authorize> <ehr:authorize ifNotGranted="${DDCRBYY}">class="layui-tab-item"</ehr:authorize>  id="tagContent1">
	       <jsp:include page="confirmed.jsp"/>
	    </div>
	    <div class="layui-tab-item" id="tagContent2">
	    	<jsp:include page="standardizedManagement.jsp"/>
	    </div>
	    <div class="layui-tab-item" id="tagContent3">
	    	<jsp:include page="ndyManagement.jsp"/>
	    </div>
	    <ehr:authorize ifAnyGranted="${JKJHB},${ZXJHB},${YYJHB},${DDCRBYY}">
	    <div class="layui-tab-item" id="tagContent4">
	    	<jsp:include page="statistics.jsp"/>
	    </div>
	    </ehr:authorize>
	  </div>
	</div>
</div>
