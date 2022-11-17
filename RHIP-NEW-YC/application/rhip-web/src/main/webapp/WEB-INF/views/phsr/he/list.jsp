<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="healthEducationStatisticsTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 18%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<%-- <col style="width: 50px;" /> --%>
		</colgroup>
		<thead>
		<tr>
			<th rowspan="2">机构</th>
			<th colspan="2">印刷资料</th>
			<th>影像资料</th>
			<th colspan="2">设置健康教育宣传栏</th>
			<th colspan="2">开展公众健康咨询服务</th>
			<th colspan="2">举办健康知识讲座</th>
			<%-- <th>健康教育处方</th>--%>
		</tr>
		<tr>
			<th>健康教育处方种类数(种)</th>
			<th>健康教育处方发放数(份)</th>
			<th>种类数(种)</th>
			<th>宣传栏内容更新次数(次)</th>
			<th>健康教育宣传栏设置个数(次)</th>
			<th>开展公众健康咨询服务活动次数(次)</th>
			<th>接受咨询的人数(人)</th>
			<th>举办健康知识讲座次数(次)</th>
			<th>听讲人数(人次)</th>
			<%-- <th>健康教育处方种类(数)</th>--%>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="report" items="${reports}">
			<tr>
				<td>
					<c:choose>
						<c:when test="${report.orgCode == '合计'}"><b>合计</b></c:when>
						<c:otherwise><ehr:org code="${report.orgCode}"/></c:otherwise>
					</c:choose>
				</td>
				<td>${report.speciesMaterialQuantity}</td>
				<td>${report.issueMaterialQuantity}</td>
				<td>${report.speciesVideoQuantity}</td>
				<td>${report.bulletinBoardUseFrequency}</td>
				<td>${report.healthEducationQuantity}</td>
				<td>${report.healthConsultQuantity}</td>
				<td>${report.healthConsultPersonQuantity}</td>
				<td>${report.healthLectureQuantity}</td>
				<td>${report.healthLecturePersonQuantity}</td>
				<%-- <td>${report.traditionalChineseQuantity}</td>--%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>