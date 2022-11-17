<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%--报告登记页面--%>
<fieldset>
<legend>报告登记</legend>
	<div class="postcontent">	
		<div class="postdiv">
			<input type="hidden" name = "updateId" id = "updateId" value = "">
			<input type="hidden" name="infoTypeCode" value="${inspRecord.reportRecord.infoTypeCode}">
			<input type="hidden" name="reportRecord.id" value="${inspRecord.reportRecord.id}">
			<table class="posttable">
				<colgroup>
					<col style="width: 12%; min-width: 50px;" />
					<col style="width: 38%; min-width: 300px;" />
					<col style="width: 12%; min-width: 50px;" />
					<col style="width: 38%; min-width: 300px;" />
				</colgroup>
				<tr>
					<c:choose>
						<c:when test="${flag !='view'}">
							<th><label class="required" for="discoveryDate">发现时间</label></th>
							<td><tag:dateInput reg="{'required':'true'}" name="reportRecord.discoveryDate" id="discoveryDate" style="width:178px;" onlypast="true" date="${inspRecord.reportRecord.discoveryDate}"/></td>
						</c:when>
						<c:otherwise>
							<th><label class="required" for="createDate">发现时间</label></th>
							<td><input type="text" readonly="readonly" name="reportRecord.discoveryDate"  id="discoveryDate" value="<fmt:formatDate value="${inspRecord.reportRecord.discoveryDate}" pattern="yyyy/MM/dd"/>"></td>
						</c:otherwise>
			    	</c:choose>
				</tr>
				
				<tr>
					<c:choose>
						<c:when test="${flag !='view'}">
							<th><label class="required" for="infoTypeCode">信息类别</label></th>
							<td><ehr:dic-list reg="{'required':'true'}" dicmeta="HSA00004" width="178px;" name="reportRecord.infoTypeCode" id="infoTypeCode" value="${inspRecord.reportRecord.infoTypeCode}" uninclude="4"/></td>
						</c:when>
						<c:otherwise>
							<th><label class="required" for="infoTypeCode">信息类别</label></th>
							<td><input type="text"  readonly="readonly" name="reportRecord.infoTypeCode"  id="reportRecord.infoTypeCode" value="<ehr:dic dicmeta="HSA00004" code = "${inspRecord.reportRecord.infoTypeCode}"/>" ></td>
							<input type="hidden" id="infoTypeCode" value="${inspRecord.reportRecord.infoTypeCode}">
						</c:otherwise>
			    	</c:choose>
						
				</tr>
				<tr id="hideSusOccDisease" class="hide">
					<th>可疑职业病人</th>
					<td colspan="3"><jsp:include page="../../sodp/add/main.jsp"></jsp:include></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th><label class="required" for="infoContent">信息内容</label></th>
					<td><textarea style="min-width: 500px; height: 120px" class="disabledInfoContent" id="infoContent" name="reportRecord.infoContent" reg="{'required':'true','maxlength':300}">${inspRecord.reportRecord.infoContent}</textarea></td>
				</tr>
				<tr>
					<th><label class="required" for="reportDate">报告时间</label></th>
					<td><tag:dateInput reg="{'required':'true'}" name="reportRecord.reportDate"  id="reportDate" onlypast="true" date="${inspRecord.reportRecord.reportDate}"/></td>
					<th><label class="required" for="reporterName">报告人姓名</label></th>
					<td><input reg="{'required':'true'}" name="reportRecord.reporterName" id="reporterName" type="text" readonly="readonly" value="${inspRecord.reportRecord.reporterName}" />
				</tr>
			</table>
		</div>
	</div>
</fieldset>
