<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="repeattable">
	<table id="statistics_record_table">
		<colgroup>
			<col style="width:19%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
			<col style="width:9%;"/>
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2" colspan="1">单位</th>
				<th rowspan="1" colspan="3">重点人群建档数</th>
				<th rowspan="1" colspan="2">健康档案使用情况</th>
				<th rowspan="1" colspan="2">高血压患者健康管理</th>
				<th rowspan="1" colspan="2">2 型糖尿病患者健康管理</th>
			</tr>
			<tr>
				<th class="zimu">65岁以上老人</th>
				<th class="zimu">高血压患者</th>
				<th class="zimu">2 型糖尿病患者</th>
				<th class="zimu">近一年来有动态记录数</th>
				<th class="zimu">近一年来无动态记录数</th>
				<th class="zimu">新发现高血压患者人数</th>
				<th class="zimu">最近一次随访血压达标患者人数</th>
				<th class="zimu">新发现 2 型糖尿病患者人数</th>
				<th class="zimu">最近一次随访血糖达标患者人数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${statisticsByMonths}" var="statis">
				<tr>
					<td title="${statis.organName}">${statis.organName}</td>
					<td>${statis.sixtyFiveElder}</td>
					<td>${statis.hypertension}</td>
					<td>${statis.typeTwoDiabetes}</td>
					<td>${statis.changedRecord}</td>
					<td>${statis.unchangedRecord}</td>
					<td>${statis.newHypertension}</td>
					<td>${statis.curedHypertension}</td>
					<td>${statis.newTypeTwoDiabetes}</td>
					<td>${statis.curedTypeTwoDiabetes}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>