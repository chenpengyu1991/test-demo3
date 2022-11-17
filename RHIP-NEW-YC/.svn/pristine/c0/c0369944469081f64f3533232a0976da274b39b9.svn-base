<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width: 40px;width:40px;" />
			<col style="min-width: 60px;width:60px;" />
			<col style="min-width: 120px;width:120px;" />
			<col style="min-width: 60px;width:60px;" />
			<col style="min-width: 80px;width:80px;" />
			<col style="min-width: 80px;width:80px;" />
		</colgroup>
		<thead>
			<tr>
				<th>抽样点序号</th>
				<th>抽样点类型</th>
				<th>抽样点名称</th>
				<th>抽样年份</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sampling" items="${samplingList}">
				<tr>
					<td>${sampling.samplingNo}</td>
					<td><ehr:dic dicmeta="FS10272" code="${sampling.type}" /></td>
					<td>${sampling.name}</td>
					<td>${sampling.samplingYear}</td>
					<td>${sampling.remark}</td>
					<td style="text-align: center">
						<a href="javascript:void(0)" onclick="epIodineNutritionSamplingSearch.edit('${sampling.id}')">修改</a>
						<a href="javascript:void(0)" onclick="epIodineNutritionSamplingSearch.remove('${sampling.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="epIodineNutritionSamplingSearch.search"  />
		</tr>
	</table>
	<input type="hidden" id="_indexPage" value="${indexPage}" />
</div>