<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<script data-main="${pageContext.request.contextPath}/js/util/main_report_fdm" src="${pageContext.request.contextPath}/js/require/require.js"></script>

<div class="toolbar">
    <input type="hidden" id="from" value="${from}">
    <c:if test="${from ne 'csws'}">
        <button style="display: block" class="btn" name="report-input-save-btn" id="report-input-save-btn">
            <b class="tijiao">提交</b>
        </button>
    </c:if>
    <c:if test="${from eq 'csws'}">
        <a href="javascript:void(0)" id="report-input-save-btn"><b class="tijiao">提交</b></a>
    </c:if>
</div>
<div class="hide"   id="fdm-report-card-message">
	无需报卡，请关闭报卡界面！
</div>

<div class="hide"  id="fdm-report-card-main">
	<jsp:include page="input_require.jsp"></jsp:include>
</div>