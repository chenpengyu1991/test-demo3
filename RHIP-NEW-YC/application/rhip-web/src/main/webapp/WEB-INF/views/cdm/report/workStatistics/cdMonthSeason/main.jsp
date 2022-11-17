<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="toolbar">
	<%-- <a href="javascript:void(0)" id="cdm-ms-report-cd-export"><b class="export">导出</b></a> --%>
	<a href="javascript:void(0)" id="cdm-ms-report-cd-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
</div>
<div class="searchbox searchSection x-admin-sm" style="width: 100%">
	<form id="cdm-ms-report-cd-form">
		<table id="cdm-ms-report-cd-form-table">
			<jsp:include page="form.jsp"></jsp:include>
		</table>
		<table class="toggle-table">
			<tbody>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="cdmWorkStatistics.toggle(this,'cdm-ms-report-cd-form-table')"
						class="ico-bottom"
					>&nbsp;</span></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<div class="repeattable" id="cdm-ms-report-cd-content"></div>