<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>
     <div id="ndyMgn" class="thirdMenu">
        <span class="active"> <a id="ndyQz" href="javascript:void(0)">耐多药确诊</a></span>
         <a>|</a>
         <span > <a id="ndyFy" href="javascript:void(0)">耐多药服药卡</a></span>
     </div>
     <div id="ndyQzPage">
       <jsp:include page="../ndy/confirm/search.jsp"/>
    </div>
    <div id="ndyFyPage" style="display: none;">
        <jsp:include page="../ndy/fuyao/search.jsp"/>
    </div>
</div>
