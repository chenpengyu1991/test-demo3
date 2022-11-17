<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/promorion/init.js" type="text/javascript"></script>

<!-- 健康宣传 -->
<div class="navRight">
  <div class="location">
    当前位置：<a id="jkxc1" class="space">健康宣传</a>
  </div>
  <div id="title" class="detailTitle">
    ${healthPromorion.promorionTitle }
  </div>
  <div class="publishTime">
    <span>发布人：${healthPromorion.userName}</span>
    <span>创建时间：<fmt:formatDate value="${healthPromorion.createDate}" pattern="yyyy/MM/dd"/></span>
    <span>发布时间：<fmt:formatDate value="${healthPromorion.promorionDate}" pattern="yyyy/MM/dd"/></span>
  </div>
  <div class="detailContent">
    <p> ${healthPromorion.promorionContent}</p>
  </div>
</div>

