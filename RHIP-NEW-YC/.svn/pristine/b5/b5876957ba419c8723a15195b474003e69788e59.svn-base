<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table id="cdm-season-report-cd-result" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
        <c:if test="${isGbcode==true}"><col style="width: 62px" /></c:if>
		<col style="width: 162px" />
		<col span="18" style="width:5%" />
	</colgroup>
		<caption><span style="font-size: 25px;font-weight:bold;">永城市${currentYear}年第${currentSeason}季度慢病发病季报表</span></caption>
		<jsp:include page="../cdMonthSeason/datagrid.jsp"></jsp:include>
</table>
<p></p>