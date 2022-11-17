<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/promorion/init.js" type="text/javascript"></script>

<div class="navRight">
  <div class="contentlist">
    <div class="location">
      当前位置：<a id="jkxc1" class="space">健康宣传</a>
    </div>
    <c:choose>
      <c:when test="${fn:length(healthPromorions)== ''}">
        <div class="contents">
          暂无健康宣传！
        </div>
      </c:when>
      <c:otherwise>
        <div class="contents">
          <ul>
            <c:forEach items="${healthPromorions}" var="promorion">
              <li>
                <a id="promorionDetail${promorion.id}" data-id="${promorion.id}" style="float:left" >${promorion.promorionTitle}</a>
                <span style="float:right"><fmt:formatDate value='${promorion.promorionDate}' pattern='yyyy/MM/dd'/></span>
              </li>
            </c:forEach>
          </ul>
        </div>
        <ehr:pagination action="contentPage.promorionSearch"/>
      </c:otherwise>
    </c:choose>
  </div>
</div>