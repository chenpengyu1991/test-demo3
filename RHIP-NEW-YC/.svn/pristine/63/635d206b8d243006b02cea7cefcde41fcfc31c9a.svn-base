<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/base.js" type="text/javascript"></script>

<div id="side" class="ehrbrw-left">
	<table>
		<tr>
			<td>
			<c:if test="${personInfo.personInfoAdditionalFlag eq true}">
				<img src="${pageContext.request.contextPath}/ehrbrowser/showPhoto/${personInfo.idcard}" width="102" height="126"/>
			</c:if>
			<c:if test="${personInfo.personInfoAdditionalFlag ne true}">
				<img src="${pageContext.request.contextPath}/images/128.gif" width="102" height="126"/>
			</c:if>
			</td>
			<td valign="top">姓名：${personInfo.name }<br />性别：<ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}"/><br />出生日期：<br />
			 <fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/>
			</td>
		</tr>
	</table>
	<c:if test="${not empty mainPersonInfo || not empty personMerges}">
		<fieldset id="personMerge">
			<legend>关联档案</legend>
			<c:if test="${empty mainPersonInfo}">
				<c:forEach items="${personMerges}" var="personMerge">
					<a href="javascript:void(0)" data-person-id="${personMerge.id}"   class="person-merge-link-btn">${personMerge.name}</a>
				</c:forEach>
			</c:if>
			<c:if test="${not empty mainPersonInfo}">
				<a href="javascript:void(0)"  data-person-id="${mainPersonInfo.id}"   class="person-merge-link-btn">${mainPersonInfo.name}</a>
			</c:if>
		</fieldset>
	</c:if>
	<c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '1')}">
		<%-- <fieldset style="padding-bottom: 15px;padding-top: 15px;">
			<legend>近期体征</legend>
				<i class="jqtz">
				<li> <button class="layui-btn layui-btn-sm" id="ehrbrw-hbp-chart-btn" style="height: 25px;line-height: 25px;padding: 0px;width: 60px;"> 血压</button></li>
				<li> <button class="layui-btn layui-btn-sm" id="ehrbrw-di-chart-btn" style="height: 25px;line-height: 25px;padding: 0px;width: 60px;">血糖</button></li>
	                <li> <button class="layui-btn layui-btn-sm" id="lifeEvent" style="height: 25px;line-height: 25px;padding: 0px;width: 60px;">生命周期</button></li>
	
	               <ehr:authorize ifAnyGranted="01">
	                    <c:set var="enableIdCardCheck" value="false"></c:set>
	                </ehr:authorize>
	
	                <c:choose>
	                    <c:when test="${enableIdCardCheck==false}">
	                        <li> <a id="lifeEvent" href="javascript:void(0)"><span>生命周期</span></a></li>
	                    </c:when>
	                    <c:otherwise>
	                        <li> <a id="lifeEvent" data-ehr-type="brwservice"   href="javascript:void(0)"><span>生命周期</span></a></li>
	                    </c:otherwise>
	                </c:choose>
	
			</i>
		</fieldset> --%>
		<fieldset style="padding-bottom: 15px;padding-top: 15px;" class="layui-elem-field">
			<legend>近期体征</legend>
				<i class="jqtz">
				<li> <button class="layui-btn layui-btn-sm" id="ehrbrw-hbp-chart-btn" style="height: 25px;line-height: 25px;padding: 0px;width: 60px;"> 血压</button></li>
				<li> <button class="layui-btn layui-btn-sm" id="ehrbrw-di-chart-btn" style="height: 25px;line-height: 25px;padding: 0px;width: 60px;">血糖</button></li>
	                <li> <button class="layui-btn layui-btn-sm" id="lifeEvent" style="height: 25px;line-height: 25px;padding: 0px;width: 60px;">生命周期</button></li>
	
	      <%--          <ehr:authorize ifAnyGranted="01">
	                    <c:set var="enableIdCardCheck" value="false"></c:set>
	                </ehr:authorize>
	
	                <c:choose>
	                    <c:when test="${enableIdCardCheck==false}">
	                        <li> <a id="lifeEvent" href="javascript:void(0)"><span>生命周期</span></a></li>
	                    </c:when>
	                    <c:otherwise>
	                        <li> <a id="lifeEvent" data-ehr-type="brwservice"   href="javascript:void(0)"><span>生命周期</span></a></li>
	                    </c:otherwise>
	                </c:choose>--%>
	
			</i>
		</fieldset>
	</c:if>
	<c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '1')}">
        <fieldset style="height: 350px;" class="layui-elem-field">
        <legend>相关内容</legend>
			<%--<div id="healthHistoryContent"></div>--%>
			<tiles:insertAttribute name="left"></tiles:insertAttribute>
		</fieldset>
	</c:if>
</div>

<div id="content" >
	<div>
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
</div>
