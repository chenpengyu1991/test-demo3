<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="tuberculosisTable">
		<colgroup>
			<%-- <col style="width: 30%;" />
			<col style="width: 40%;" />
			<col style="width: 40%;" /> --%>
			<%-- <col style="width: 50px;" />
			<col style="width: 70px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" /> --%>
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">单位</th>
				<th colspan="2">结核病患者健康管理</th>
			</tr>
			<tr>
				<th>推介转诊结核病患者人数</th>
				<th>随访管理结核病患者人数</th>
			</tr>
		</thead>
		<tbody id="displayBody">
			 <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<c:choose>
							<c:when test="${not empty all}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
							<c:when test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
					</td>
					<td title="${report.referralTbNum}">${report.referralTbNum}</td>
					<td title="${report.followUpTuberculosis}">${report.followUpTuberculosis}</td>
				</tr>
			</c:forEach>
			<tr>
			<td><strong>合计</strong></td>
					<td title="${tuberculosisServiceDto.referralTbNum}">${tuberculosisServiceDto.referralTbNum}</td>
					<td title="${tuberculosisServiceDto.followUpTuberculosis}">${tuberculosisServiceDto.followUpTuberculosis}</td>
		</tr>
		</tbody>
		
		<tbody id="editBody" style="display: none">
    <c:forEach items="${reportList}" var="report" varStatus="status">
        <tr>
            <td title=<ehr:org code="${report.orgCode}"></ehr:org>>
                <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].id" value="${report.id }">
                <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].orgCode" value="${report.orgCode }">
                <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].year" value="${report.year }">
                <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].orgName" readonly="readonly" value="${report.orgName }"/>
            
            
            <c:choose>
							<c:when test="${not empty all}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
							<c:when test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
            </td>
            <td>
                <input type="text" name="TuberculosisDto.TuberculosisDtoList[${status.index }].referralTbNum" size="3" value="${report.referralTbNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="TuberculosisDto.TuberculosisDtoList[${status.index }].followUpTuberculosis" size="3" value="${report.followUpTuberculosis}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
        </tr>
    </c:forEach>
    </tbody> 
	</table>
</div>