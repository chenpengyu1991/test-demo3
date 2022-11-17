<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/statistics/statisticsIndex.js" type="text/javascript"></script>
<div>
    <input type="hidden" id="selectedTagST"/>
    <input type="hidden" id="isSqzx" value="${isSqzx}"/>
     <div id="Istatisticsd" class="thirdMenu">
         <span class="active"><a onclick="statistics.selectTag('suspect')" href="javascript:void(0)">筛查登记</a></span>
         <a>|</a>
         <span><a onclick="statistics.selectTag('transfer')" href="javascript:void(0)">转诊</a></span>
         <a>|</a>
         <span><a onclick="statistics.selectTag('mgnt')" href="javascript:void(0)">管理登记</a></span>
         <a>|</a>
         <span><a onclick="statistics.selectTag('cc')" href="javascript:void(0)">密切接触者</a></span>
     </div>
     <div id="standardizationPage">
       <jsp:include page="../statistics/search.jsp"/>
    </div>
</div>
