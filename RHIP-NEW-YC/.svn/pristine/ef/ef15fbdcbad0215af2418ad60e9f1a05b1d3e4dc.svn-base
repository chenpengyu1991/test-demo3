<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<script
	src="${pageContext.request.contextPath}/js/views/ehr/person/modifyTrace.js"
	type="text/javascript"></script>

<div id="dialog-search">
	<div id="inquiry" style="width: 100%;text-align:left">
		<b>查询</b>
		<form method="post" id="form_search">
			<input type="hidden" value="${personId}" id="id_personId">
			<table class="table-01">
				<tr>
					<td width="30%">修改时间： <input type="text" readonly="readonly"
						id="inputBeginDate" style="width: 80px"
						onfocus="WdatePicker({skin:&#39;whyGreen&#39;,dateFmt:&#39;yyyy/MM/dd&#39;})"
						name="inputBeginDate" /> ~ <input type="text" readonly="readonly"
						id="inputEndDate"
						onfocus="WdatePicker({skin:&#39;whyGreen&#39;,dateFmt:&#39;yyyy/MM/dd&#39;})"
						name="inputEndDate" style="width: 80px" />
					</td>
					<td width="40%">业务类型： <input type="radio" name="regionType"
						value="-1" checked="checked" /> 全部 <input type="radio"
						name="regionType" value="A00000002" /> 个人基本信息表 <input
						type="radio" name="regionType" value="A00000003" /> 个人健康体检表
					</td>
					<td><input class="btn" type="button" name="search"
						id="search_btn" value="查询" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="readRecord-result-content"></div>
	<table id="result_table" class="repeattable">
		<thead>
			<tr>
				<th style="width: 60px;">修改时间</th>
				<th style="width: 80px;">修改人</th>
				<th style="width: 100px;">修改机构</th>
				<th style="width: 100px;">业务类型</th>
				<th style="width: 120px;">项目</th>
				<th>内容</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${pageList}" var="fi">
				<tr>
					<td class="centerText"><fmt:formatDate value="${fi.inputDate}"
							pattern="yyyy/MM/dd" /></td>
					<td class="centerText">${fi.inputUserId}</td>
					<td class="centerText">${fi.inputUserId}</td>
					<td class="centerText">${fi.regionName}</td>
					<td><tags:textWithTip value="${fi.itemName}"/></td>
					<c:if test="${fi.itemCode != null }">
						<td>
							<c:if test="${fi.oldValue==null||fi.oldValue==''}">
								未填
							</c:if>
							<c:if test="${fi.oldValue!=null}">
								<ehr:dic dicmeta="${fi.itemCode}" code="${fi.oldValue}" />
							</c:if>
							 -->
							<ehr:dic dicmeta="${fi.itemCode}" code="${fi.newValue}"></ehr:dic>
						</td>
					</c:if>
					<c:if test="${fi.itemCode == null }">
						<td>
							<c:if test="${fi.oldValue==null||fi.oldValue==''}">
								<tags:textWithTip value="未填" />
							</c:if>
							<c:if test="${fi.oldValue!=null}">
								<tags:textWithTip value="${fi.oldValue}"/>
							</c:if>
							-->${fi.newValue}
						</td>
					</c:if>
				<tr>
			</c:forEach>
		</tbody>
		<ehr:pagination action="modifyTracePagination.pagination" colspan="9" />
	</table>
</div>