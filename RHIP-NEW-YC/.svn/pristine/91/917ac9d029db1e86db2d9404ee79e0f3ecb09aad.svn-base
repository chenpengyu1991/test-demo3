<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="malignantsSize" value="${fn:length(malignants)}"></c:set>
<c:set var="nonMalignantsSize" value="${fn:length(nonMalignants)}"></c:set>
<table style="min-width: ${(malignantsSize+ nonMalignantsSize+21)*40}px" id="cdm-ms-report-tumor-result" class="layui-table x-admin-sm-table-list-middle">
		<caption><span style="font-size: 25px;font-weight:bold;">永城市${currentYear}年${currentMonth}月肿瘤发病月报表</span></caption>
		<jsp:include page="datagrid.jsp"></jsp:include>
</table>
<p></p>