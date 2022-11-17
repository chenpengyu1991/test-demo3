<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<div class="repeattable">
	<table id="fdmStatisticsTable">
		<colgroup>			
			<col style="width: 120px;" />
			<%--<col style="width: 80px;" />--%>
		</colgroup>
		<thead>
			<tr>
	            <th rowspan="2">监测医院</th>
	            <%--<th rowspan="2">医院级别</th>--%>
	            <th colspan="4">年龄组腹泻病报告数</th>
	            <th rowspan="2">细菌样本数</th>
	            <th colspan="7">致病菌检测阳性数</th>
	            <th rowspan="2">病毒样本数</th>
	            <th colspan="5">病毒检测阳性数</th>
	            <th rowspan="2">细菌合计</th>
	            <th rowspan="2">病毒合计</th>
	            <th rowspan="2">总合计</th>  
			</tr>
			<tr>
				<th>0~</th>
	            <th>5~</th>
	            <th>15~</th>
	            <th>60~</th>
	            <th>沙门氏菌</th>
	            <th>副溶血性弧菌</th>
	            <th>志贺氏菌</th>
	            <th>金黄色葡萄球菌</th>
	            <th>变形杆菌</th>
	            <th>致病性大肠杆菌</th>
	            <th>小肠结肠炎耶尔森氏菌</th>
	            <th>轮状病毒</th>
	            <th>诺如病毒</th>
	            <th>札如病毒</th>
	            <th>星状病毒</th>
	            <th>腺病毒</th>
			</tr>
		</thead>
		<tbody>
        <c:forEach var="summary" items="${summary}" varStatus="status">
		    <tr>
				<td>
                    <c:if test="${summary.FILL_ORGAN_CODE !='合计'}">
                        <ehr:tip><ehr:org code="${summary.FILL_ORGAN_CODE}"></ehr:org> </ehr:tip>
                    </c:if>
                    <c:if test="${summary.FILL_ORGAN_CODE =='合计'}">
                        合计
                    </c:if>
                </td>
				<%--<td>${summary.hospitalClass}</td>--%>
				<td><tags:numberLabel value="${summary.B5C}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.B15C}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.B60C}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.U60C}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.PATESTCOUNT}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.SALMONELLACOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.VPACOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.SHIGELLACOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.STACOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.PROMCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.PECCOUN}" defaultValue="0"/></td>
                <td><tags:numberLabel value="${summary.EJPCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.VIRTESTCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.ROTAVIRUSCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.NOROVIRUSCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.ASTROVIRUSCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.SAPOVIRUSCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.ADENOVIRUSCOUN}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.PATYXTOTAL}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.VIRTOTAL}" defaultValue="0"/></td>
				<td><tags:numberLabel value="${summary.TOTAL}" defaultValue="0"/></td>
		   </tr>
        </c:forEach>
		</tbody>
	</table>
</div>