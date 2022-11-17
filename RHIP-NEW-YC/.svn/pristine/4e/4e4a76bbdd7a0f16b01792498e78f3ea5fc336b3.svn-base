<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="tuberculosisTable" class="layui-table x-admin-sm-table-list-middle">
		<thead>
			<tr>
				<th rowspan="2">区县</th>
				<th rowspan="2">机构</th>
				<th colspan="6">0-6岁儿童健康管理统计报表</th>
			</tr>
			<tr>
				<th>辖区内活产数</th>
				<th>辖区内按照规范要求接受1次及以上访视的新生儿人数</th>
				<th>新生儿访视率</th>
				<th>辖区内0-6岁儿童数</th>
				<th>辖区内接受1次及以上随访的0-6岁儿童数</th>
				<th>儿童健康管理率</th>
			</tr>
		</thead>
		<tbody id="displayBody">
			 <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
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
					<td title="${report.deliveryNum}">${report.deliveryNum}</td>
					<td title="${report.familyVisitNum}">${report.familyVisitNum}</td>
					<c:if test="${report.familyVisitNum eq 0 &&report.deliveryNum eq 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.familyVisitNum == 0 && report.deliveryNum != 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.familyVisitNum != 0 && report.deliveryNum == 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.familyVisitNum !=0 && report.deliveryNum != 0}">
					<td>
						<fmt:formatNumber value="${(report.familyVisitNum/report.deliveryNum)*100}" pattern="#,##0.0"/>%
					</td>
					</c:if>
					<td title="${report.womenChildNum}">${report.womenChildNum}</td>
					<td title="${report.childExaminationNum}">${report.childExaminationNum}</td>					
					<c:if test="${report.childExaminationNum eq 0 &&report.womenChildNum eq 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.childExaminationNum == 0 && report.womenChildNum != 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.childExaminationNum != 0 && report.womenChildNum == 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.childExaminationNum != 0 && report.womenChildNum != 0}">
					<td><fmt:formatNumber value="${(report.childExaminationNum/report.womenChildNum)*100}" pattern="#,##0.0"/>%</td>
					
					</c:if>
					
				</tr>
			</c:forEach>
			<c:if test="${childStatisticalServiceDto!=null}">
				<tr>
					<td colspan="2"><strong>合计</strong></td>
					<td title="${childStatisticalServiceDto.deliveryNum}">${childStatisticalServiceDto.deliveryNum}</td>
					<td title="${childStatisticalServiceDto.familyVisitNum}">${childStatisticalServiceDto.familyVisitNum}</td>
					<c:if test="${childStatisticalServiceDto.familyVisitNum eq 0 && childStatisticalServiceDto.deliveryNum eq 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${childStatisticalServiceDto.familyVisitNum == 0 && childStatisticalServiceDto.deliveryNum != 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${childStatisticalServiceDto.familyVisitNum != 0 && childStatisticalServiceDto.deliveryNum == 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${childStatisticalServiceDto.familyVisitNum !=0 && childStatisticalServiceDto.deliveryNum != 0}">
					<td>
						<fmt:formatNumber value="${(childStatisticalServiceDto.familyVisitNum/childStatisticalServiceDto.deliveryNum)*100}" pattern="#,##0.0"/>%
					</td>
					</c:if>
					
					
					<td title="${childStatisticalServiceDto.womenChildNum}">${childStatisticalServiceDto.womenChildNum}</td>
					<td title="${childStatisticalServiceDto.childExaminationNum}">${childStatisticalServiceDto.childExaminationNum}</td>
					<c:if test="${childStatisticalServiceDto.childExaminationNum eq 0 && childStatisticalServiceDto.womenChildNum eq 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${childStatisticalServiceDto.childExaminationNum == 0 && childStatisticalServiceDto.womenChildNum != 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${childStatisticalServiceDto.childExaminationNum != 0 && childStatisticalServiceDto.womenChildNum == 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${childStatisticalServiceDto.childExaminationNum != 0 && childStatisticalServiceDto.womenChildNum != 0}">
					<td><fmt:formatNumber value="${(childStatisticalServiceDto.childExaminationNum/childStatisticalServiceDto.womenChildNum)*100}" pattern="#,##0.0"/>%</td>
					
					</c:if>
				</tr>
			</c:if>
		</tbody>
		
		<%-- <tbody id="editBody" style="display: none">
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
    </tbody>  --%>
	</table>
</div>