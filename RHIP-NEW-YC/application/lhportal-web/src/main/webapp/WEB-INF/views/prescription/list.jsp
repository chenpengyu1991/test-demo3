<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/prescription/init.js" type="text/javascript"></script>

<input type="hidden" id="type" value="${type}"/>
<div class="navRight">
  <div class="contentlist">
    <div class="location">
      当前位置：<a id="jkzd1" class="space">健康指导</a>
    </div>
    <c:choose>
      <c:when test="${fn:length(healthPrescriptions)== ''}">
        <div class="contents">
          暂无健康指导！
        </div>
      </c:when>
      <c:otherwise>
        <div class="contents">
          <ul>
            <c:forEach items="${healthPrescriptions}" var="prescription">
              <li>
                <a id="prescriptionDetail${promorion.id}" data-id="${prescription.id}" style="float:left" >${prescription.title}</a>
                <span style="float:right"><fmt:formatDate value='${prescription.createTime}' pattern='yyyy/MM/dd'/></span>
              </li>
            </c:forEach>
          </ul>
        </div>
        <ehr:pagination action="contentPage.prescriptionSearch"/>
      </c:otherwise>
    </c:choose>
  </div>
</div>