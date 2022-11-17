<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/prescription/init.js" type="text/javascript"></script>

<!-- 健康指导 -->
<div class="navRight">
  <div class="location">
    当前位置：<a id="jkzd1" class="space">健康指导</a>
  </div>
  <div id="title" class="detailTitle">
    ${healthPrescription.title}
  </div>
  <div class="publishTime">
    <span>处方名称：${healthPrescription.name}</span>
    <span>创建时间：<fmt:formatDate value="${healthPrescription.createTime}" pattern="yyyy/MM/dd"/></span>
  </div>
  <div class="detailContent">
    ${healthPrescription.content}
  </div>
</div>

