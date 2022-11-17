<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>
     <div id="standardizedId" class="thirdMenu">
        <span class="active"> <a id="medicineId" href="javascript:void(0)">督导服药</a></span>
         <%--<a>|</a>
         <span > <a id="ndy_medicineId" href="javascript:void(0)">耐多药服药卡</a></span>--%>
         <a>|</a>
         <span><a id="sputumId" href="javascript:void(0)">预约查痰</a></span>
         <a>|</a>
         <span><a id="interviewId" href="javascript:void(0)">访视记录</a></span>
         <a>|</a>
         <span><a id="sf_recordId" href="javascript:void(0)">随访记录</a></span>
         <a>|</a>
         <span><a id="delayId" href="javascript:void(0)">用药延误记录</a></span>
         <a>|</a>
         <span><a id="contactId" href="javascript:void(0)">密切接触者随访</a></span>
     </div>
     <div id="standardizationPage">
       <jsp:include page="../standardization/search.jsp"/>
    </div>
</div>
