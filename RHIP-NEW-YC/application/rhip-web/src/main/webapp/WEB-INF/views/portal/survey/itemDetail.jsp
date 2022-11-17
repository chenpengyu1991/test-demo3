<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="${pageContext.request.contextPath}/js/views/portal/survey/item_detail.js" type="text/javascript"></script>

<fieldset style="margin-top: 10px">
	<legend>调查项信息</legend>
	<form id="itemFormId">
		<input type="hidden" id="surveyId" name="surveyId" value="${surveyId}">
		<input type="hidden" id="surveyStatusId" name="surveyStatus" value="${surveyStatus}">
		<input type="hidden" id="itemId" name="id" value="${surveyItem.id}">
		<input type="hidden" id="optionListJson" name="optionListJson">
		<div id="itemDivId">
			<table class="posttable">
				<colgroup>
					<col style="min-width: 140px; width: 30%;" />
					<col style="min-width: 80px; width: 70%;" />
				</colgroup>
				<tr>
					<th><label class="required">调查项序号</label></th>
					<td>
						<tag:numberInput id="orderNum" name="orderNum" value="${surveyItem.orderNum}" cssClass="width30" reg='{"required":"true"}'/>
					</td>
				</tr>
				<tr>
					<th><label class="required">调查描述</label></th>
					<td>
						<input type="text" id="description" name="description" value="${surveyItem.description}" reg='{"required":"true","maxlength":"100"}'/>
					</td>
				</tr>
				<tr>
					<th><label class="required">标签类型</label></th>
					<td>
						<ehr:dic-radio id="labelTypeCodeId" name="labelTypeCode" dicmeta="LH00005" value="${surveyItem.labelTypeCode}" reg='{"required":"true"}' onchange="itemDetail.isShowOption()"/>
					</td>
				</tr>
			</table>
		</div>
		<div id="optionDivId">
			<div class="toolbarsublist">
				选项：<a href="javascript:void(0)" id="addOpintList" onclick="items.popup('','')"><b class="xinz">添加</b> </a>
			</div>
			<div class="repeattable">
				<table id="optionTable">
					<colgroup>
						<col style="width: 10%" />
						<col style="width: 40%" />
						<col style="width: 15%" />
						<col style="width: 25%" />
					</colgroup>
					<thead>
						<tr>
							<th class="centerth" style="width: 5%">选项值</th>
							<th class="centerth" style="width: 10%">选项描述</th>
							<th class="centerth" style="width: 5%">是否默认选中</th>
							<th class="centerth" style="width: 5%">操作</th>
						  </tr>
					</thead>
					<c:forEach var="option" items="${surveyItem.surveyOptions}" varStatus="status">
						<tr>
							<td field="value">${option.value}</td>
							<td field="item">${option.item}</td>
							<td field="isDefaultValue"><ehr:dic code="${option.isDefault}" dicmeta="FS10009"/></td>
							<td field="isDefault" style="display: none;">${option.isDefault}</td>
							<td field="id" style="display: none;">${option.id}</td>
							<td field="itemId" style="display: none;">${option.itemId}</td>
							<td class="btnsublist" field="btn">
								<a href="javascript:void(0)" onclick="items.popup(this, 'edit')">修改</a>
								<c:choose>
									<c:when test="${option.id != null}">
										<a href="javascript:void(0)" onclick="items.optionDelete(${option.id})">删除</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</form>
</fieldset>