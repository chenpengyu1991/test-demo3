<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/index/main.css"/>
<script src="${pageContext.request.contextPath}/js/views/ihm/prescriptionTarget/prescriptionSearch.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:prescriptionSearch.returnCost()"><b class="fanhui">返回</b></a>
</div>
<div class="section">
	<div class="searchBox">
		<input type="hidden" id="pageIndex" value="${pageIndex}">

		<form id="prescriptionSearchForm">
			<input type="hidden" name = "beginDate" value ="${beginDt}">
			<input type="hidden" name = "endDate" value ="${endDt}">
			<input type="hidden" name = "gbCode" value ="${gbCode}">
			<input type="hidden" name = "organCode" value ="${organCode}">
			<table id="prescriptionSearch">
				<colgroup>
                	<col style="width: 8%; min-width: 80px;"/>
                    <col style="width: 25%; min-width: 200px;"/>
                    <col style="width: 8%; min-width: 80px;"/>
					<col style="width: 20%; min-width: 150px;"/>
					<col style="width: 7%; min-width: 70px;"/>
					<col style="width: 18%; min-width: 100px;"/>
                    <col/>
				</colgroup>
				<tbody>
					<tr>
						<td class="col-text">姓名</td>
						<td class="col-input">
							<input type="text" name="name" width="120px;"/>
						</td>
						<td class="col-text">身份证号</td>
						<td class="col-input">
							<input type="text" name="idcard" style="width:180px;"/>
						</td>
						<td class="col-text">门诊号</td>
						<td class="col-input">
							<input type="text" name="outpatientNo" style="width:140px"/>
						</td>
						<td style="text-align: right" >
							<input type="button" id="detailBtnSearch" value="查询" onclick="" class="search_btn" />
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom">
						<span onclick="util.toggle(this,'prescriptionSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<div id="prescriptionListDiv">
		<jsp:include page="prescriptionList.jsp"></jsp:include>
	</div>
</div>