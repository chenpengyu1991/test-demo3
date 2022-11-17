<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/monitorList.js"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:40px;" />
			<col style="width:40px;" />
			<col style="width:40px;" />
			<col style="width:30px;" />
			<col style="width:30px;" />
			<col style="width:30px;" />
			<col style="width:30px;" />
			<col style="width:80px;" />
		</colgroup>
		<thead>
			<tr>
				<th>抽样点名称</th>
				<th>抽样点类别</th>
				<th>调查日期</th>
				<th>调查人数</th>
				<th>应答题目数</th>
				<th>正确答题数</th>
				<th>知晓率(%)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="knowledge" items="${knowledgeList}">
				<tr>
					<td>${knowledge.samplingLocationName}</td>
					<td><ehr:dic dicmeta="FS10272" code="${knowledge.samplingLocationType}" /></td>
					<td><fmt:formatDate value="${knowledge.investigateTime}" pattern="yyyy/MM/dd"/></td>
					<td>${knowledge.totalPersonNo}</td>
					<td>${knowledge.questionsForEach}</td>
					<td>${knowledge.totalCorrectAnswers}</td>
					<td><fmt:formatNumber pattern="#0.00" value="${knowledge.awarenessRate}" /></td>
					<td style="text-align: center">
						<a href="javascript:void(0)" onclick="epIodineNutritionKnowledgeSearch.edit('${knowledge.id}')">修改</a>
						<a href="javascript:void(0)" onclick="epIodineNutritionKnowledgeSearch.remove('${knowledge.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="epIodineNutritionKnowledgeSearch.search"  />
		</tr>
	</table>
	<input type="hidden" id="_indexPage" value="${indexPage}" />
</div>