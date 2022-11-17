<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<%@ page import="com.founder.rhip.portal.common.InteractionStatus" %>
<c:set var="REPLY" value="<%=InteractionStatus.REPLY.getValue()%>"/>
<c:set var="RETURN" value="<%=InteractionStatus.RETURN.getValue()%>"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<script src="${pageContext.request.contextPath}/js/views/interaction/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/interaction/search.js" type="text/javascript"></script>

<div class="navRight">
  <div class="contentlist">
    <div class="location">
      当前位置：<a id="zxzx" class="space">在线咨询</a>
      <c:if test="${not empty eventType}">
        <c:if test="${eventType == '01'}">&gt;&gt;<a id="zx">咨询</a></c:if>
        <c:if test="${eventType == '02'}">&gt;&gt;<a id="jy">建议</a></c:if>
        <c:if test="${eventType == '03'}">&gt;&gt;<a id="ts">投诉</a></c:if>
      </c:if>
      <div class="location_right">
      	<a id="toZx"><i class="zx"></i>我要咨询</a>
      </div>
    </div>
    <div class="messageForm" id="messageForm">
    	<jsp:include page="add.jsp"/>
    </div>
    <div class="searchInteraction" id="searchInteractionDivId" style="width:100%;">
      <form method="post" id="interactionSearch">
      <input type="hidden" id="eventType" name="eventType" value="${eventType}"/>
        <table>
          <tr>
          	<td class="coltd">标题:</td>
            <td style="width:220px;"><input type="text" name="title"/></td>
            <%-- <td class="coltd">咨询类型:</td>
            <td style="width:110px;"><ehr:dic-list name="eventType" dicmeta="LH00002" defaultval="N" value="${eventType}"/></td> --%>
            <td class="coltd">状态:</td>
            <td style="width:180px;">
                <select name="status">
                  <option value="">请选择</option>
                  <option value="99">未回复</option>
                  <option value="${REPLY}">已回复</option>
                  <option value="${RETURN}">已退回</option>
                </select>
            </td>
            <td style="width:80px;"><input id="searchIneractionId" type="button" value="查询" class="search_btn"/></td>
          </tr>
        </table>
      </form>
    </div>
    <div id="listInteractionDivId">
    </div>
  </div>
</div>