<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="healthEducationStatisticsTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 100px;" />
			<col style="width: 55px;" />
			<col style="width: 70px;" />
			<col style="width: 55px;" />
			<col style="width: 70px;" />
			<col style="width: 70px;" />
			<col style="width: 30px;" />
			<col style="width: 70px;" />
			<col style="width: 30px;" />
			<col style="width: 70px;" />
			<col style="width: 30px;" />
			<col style="width: 70px;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">机构</th>
				<th colspan="2">设置健康教育宣传栏</th>
				<th colspan="3">提供健康教育资料</th>
				<th colspan="2">开展公众健康咨询服务</th>
				<th colspan="2">举办健康知识讲座</th>
				<th colspan="2">其他健康教育活动</th>
			</tr>
			<tr>
				<th>设置宣传栏数</th>
				<th>宣传栏内容更新数</th>
				<th>发放印刷资料</th>
				<th>播放影像资料次数</th>
				<th>接受影像教育人数</th>
				<th>次数</th>
				<th>接受健康教育人数</th>
				<th>次数</th>
				<th>接受健康教育人数</th>
				<th>次数</th>
				<th>接受健康教育人数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}">
				<tr>
					<td>
						<c:choose>
							<c:when test="${genreCodeFlag == '0'}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>			
							<c:when test="${report.orgCode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:when>			
							<c:when test="${genreCodeFlag != '0'}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
					</td>
					<td>${report.bulletinBoardQuantity}</td>
					<td>${report.bulletinBoardUseFrequency}</td>
					<td>${report.issueMaterialQuantity}</td>
					<td>${report.playVideoQuantity}</td>
					<td>${report.playVideoPersonQuantity}</td>
					<td>${report.healthConsultQuantity}</td>
					<td>${report.healthConsultPersonQuantity}</td>
					<td>${report.healthLectureQuantity}</td>
					<td>${report.healthLecturePersonQuantity}</td>
					<td>${report.otherActiveQuantity}</td>
					<td>${report.otherActivePersonQuantity}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><strong>合计</strong></td>
				<td>${reportSummary.bulletinBoardQuantity}</td>
				<td>${reportSummary.bulletinBoardUseFrequency}</td>
				<td>${reportSummary.issueMaterialQuantity}</td>
				<td>${reportSummary.playVideoQuantity}</td>
				<td>${reportSummary.playVideoPersonQuantity}</td>
				<td>${reportSummary.healthConsultQuantity}</td>
				<td>${reportSummary.healthConsultPersonQuantity}</td>
				<td>${reportSummary.healthLectureQuantity}</td>
				<td>${reportSummary.healthLecturePersonQuantity}</td>
				<td>${reportSummary.otherActiveQuantity}</td>
				<td>${reportSummary.otherActivePersonQuantity}</td>
			</tr>
		</tbody>
	</table>
</div>