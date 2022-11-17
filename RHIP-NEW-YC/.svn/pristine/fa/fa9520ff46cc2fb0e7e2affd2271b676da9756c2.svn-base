<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="malignantsSize" value="${fn:length(malignants)}"></c:set>
<c:set var="nonMalignantsSize" value="${fn:length(nonMalignants)}"></c:set>
<colgroup>
    <c:if test="${isGbcode==true}"><col style="width: 62px" /></c:if>
	<col style="width: 162px" />
	<col span="${malignantsSize+21+nonMalignantsSize}" />
</colgroup>
<thead>
	<tr>
		<th rowspan="2" colspan="${isGbcode==true?'2':'1'}">报告单位</th>
		<th colspan="${malignantsSize+17}">恶性肿瘤</th>
		<th rowspan="1" colspan="${nonMalignantsSize+2}">非恶性肿瘤</th>
		<th rowspan="2">合计</th>
		<th rowspan="2">累计</th>
	</tr>
	<tr height="18">
		<th>鼻咽癌</th>
		<th>食管癌</th>
		<th>胃癌</th>
		<th>结肠癌</th>
		<th>直肠癌</th>
		<th>肝和肝内胆管癌</th>
		<th>胆囊和肝外胆管癌</th>
		<th>胰腺癌</th>
		<th>气管,支气管和肺癌</th>
		<th>乳腺癌</th>
		<th>宫颈癌</th>
		<th>前列腺癌</th>
		<th>膀胱癌</th>
		<th>脑/神经系统恶性肿瘤</th>
		<th>恶性淋巴瘤</th>
		<th>白血病</th>
		<c:forEach items="${malignants}" var="malignant">
			<th><ehr:disease icd="${malignant}"></ehr:disease></th>
		</c:forEach>
		<th>小计</th>
		<th colspan="1">神经系统良性肿瘤</th>
		<c:forEach items="${nonMalignants}" var="nonmalignant">
			<th><ehr:disease icd="${nonmalignant}"></ehr:disease></th>
		</c:forEach>
		<th>小计</th>
	</tr>
</thead>
<tbody>
	<c:set var="size" value="${fn:length(cdMonthReport)}"></c:set>
	<c:if test="${size>0}">
		<c:forEach items="${cdMonthReport}" var="report">
            <c:choose>
                <c:when test="${report.organCode=='-1' and isGbcode ==true  and report.gbCode=='-1'}">
                    <c:set var="total" scope="request" value="${report}"></c:set>
                </c:when>
                <c:when test="${report.organCode=='-1' and isGbcode==false}">
                    <c:set var="total" scope="request" value="${report}"></c:set>
                </c:when>
                <c:when test="${report.organCode=='-2'}">
                    <c:set var="other" scope="request" value="${report}"></c:set>
                </c:when>
                <c:otherwise>
					<tr>
                        <c:if test="${isGbcode==true}">
                            <td data-code="${report.gbCode}">
                                <ehr:tip trim="true">
                                    <ehr:dic code="${report.gbCode}" dicmeta="FS990001"></ehr:dic>
                                </ehr:tip></td>
                            <td>
                                <c:if test="${report.organCode=='-1'}">
                                    合计
                                </c:if>
                                <c:if test="${report.organCode!='-1'}">
                                    <ehr:tip trim="true">
                                        <ehr:org code="${report.organCode}"></ehr:org>
                                    </ehr:tip>
                                </c:if>
                            </td>
                        </c:if>
                        <c:if test="${isGbcode==false}">
                            <td>
                                <c:if test="${report.organCode=='-1'}">
                                    合计
                                </c:if>
                                <c:if test="${report.organCode!='-1'}">
                                    <ehr:tip trim="true">
                                        <ehr:org code="${report.organCode}"></ehr:org>
                                    </ehr:tip>
                                </c:if>
                            </td>
                        </c:if>

						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c11}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c15}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c16}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c18}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c19}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c22}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c23}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c25}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c33}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c50}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c53}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c61}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c67}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c70}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c81}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c91}" type="number" /></td>
						<c:forEach items="${malignants}" var="malignant">
							<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report[malignant]}" type="number" /></td>
						</c:forEach>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.maTotal}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.d33}" type="number" /></td>
						<c:forEach items="${nonMalignants}" var="nonmalignant">
							<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report[nonmalignant]}" type="number" /></td>
						</c:forEach>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.nonmaTotal}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.total}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.upTotal}" type="number" /></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${not empty other }">
			<tr>
				<td>外地诊断</td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c11}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c15}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c16}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c18}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c19}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c22}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c23}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c25}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c33}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c50}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c53}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c61}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c67}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c70}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c81}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c91}" type="number" /></td>
				<c:forEach items="${malignants}" var="malignant">
					<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other[malignant]}" type="number" /></td>
				</c:forEach>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.maTotal}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.d33}" type="number" /></td>
				<c:forEach items="${nonMalignants}" var="nonmalignant">
					<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other[nonmalignant]}" type="number" /></td>
				</c:forEach>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.nonmaTotal}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.total}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.upTotal}" type="number" /></td>
			</tr>
		</c:if>
		<tr>
			<td colspan="${isGbcode==true?2:1}">合计</td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c11}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c15}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c16}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c18}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c19}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c22}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c23}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c25}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c33}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c50}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c53}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c61}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c67}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c70}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c81}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c91}" type="number" /></td>
			<c:forEach items="${malignants}" var="malignant">
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total[malignant]}" type="number" /></td>
			</c:forEach>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.maTotal}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.d33}" type="number" /></td>
			<c:forEach items="${nonMalignants}" var="nonmalignant">
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total[nonmalignant]}" type="number" /></td>
			</c:forEach>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.nonmaTotal}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.total}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upTotal}" type="number" /></td>
		</tr>
		<tr>
			<td colspan="${isGbcode==true?2:1}">累计</td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC11}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC15}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC16}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC18}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC19}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC22}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC23}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC25}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC33}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC50}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC53}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC61}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC67}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC70}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC81}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upC91}" type="number" /></td>
			<c:forEach items="${malignants}" var="malignant">
				<c:set var="key">up${fn:toUpperCase(malignant)}</c:set>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total[key]}" type="number" /></td>
			</c:forEach>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upMaTotal}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upD33}" type="number" /></td>
			<c:forEach items="${nonMalignants}" var="nonmalignant">
				<c:set var="key">up${fn:toUpperCase(nonmalignant)}</c:set>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total[key]}" type="number" /></td>
			</c:forEach>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upNonmaTotal}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upTotal}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.upTotal}" type="number" /></td>
	</c:if>
</tbody>
<tfoot>
	<tr  style="font-weight:bold;">
        <c:set var="addColumnCount" value="${isGbcode==true?'1':'0'}"></c:set>
		<td  colspan="${malignantsSize+22+nonMalignantsSize+addColumnCount}">报告单位（盖章）:${currentOrgName } 报告人:${currentUserName} 报告日期:<fmt:formatDate
				pattern="yyyy/MM/dd" value="${currentDate}"
			/></td>
	</tr>
</tfoot>
