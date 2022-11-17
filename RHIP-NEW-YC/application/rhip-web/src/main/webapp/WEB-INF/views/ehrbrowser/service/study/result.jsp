<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/study/result.js" type="text/javascript"></script>
<jsp:include page="datagrid.jsp"></jsp:include>
<%-- <table>
				<tr>
                	<ehr:pagination action="studySearch.search"/>
                </tr>
             </table> --%>

