<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grjlda/grjlhjkjhda/fsgzryngzlList.js" type="text/javascript"></script>
<div>
	<div class="repeattable">
		<table id="workload_record_table">
			<colgroup>
				<col style="width:4%;"/>
				<col style="width:20%;"/>
				<col style="width:16%;"/>
				<col style="width:10%;"/>
				<col style="width:10%;"/>
				<col style="width:10%;"/>
				<col style="width:10%;"/>
				<col style="width:10%;"/>
				<col style="width:10%;"/>
			</colgroup>
			<thead>
				<tr>
					<th style="text-align: center;">序号</th>
					<th style="text-align: center;">年份</th>
					<th style="text-align: center;">透视</th>
					<th style="text-align: center;">胃肠</th>
					<th style="text-align: center;">拍片</th>
					<th style="text-align: center;">介入</th>
					<th style="text-align: center;">骨科复位</th>
					<th style="text-align: center;">镊取异物</th>
					<th style="text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach items="${infoRecords}" var="record" varStatus="status">
					<tr>
						<td style="text-align: center"><ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number></td>
						<td title="${record.year }" style="text-align: center;">${record.year }</td>
						<td title="${record.perspective }" style="text-align: center">${record.perspective }</td>
						<td title="${record.stomachIntestine }" style="text-align: center">${record.stomachIntestine }</td>
						<td title="${record.xRay }" style="text-align: center">${record.xRay }</td>
						<td title="${record.intervene }" style="text-align: center">${record.intervene }</td>
						<td title="${record.orthopedicsRepst }" style="text-align: center">${record.orthopedicsRepst }</td>
						<td title="${record.foreignForceps }" style="text-align: center">${record.foreignForceps }</td>
						<td style="text-align: center">
						    <a class="fsgzryngzlListModify" href="#this" onclick="fsgzryngzlList.updateWorkloadRecord('${record.id}')">修改</a> 
						    <a class="fsgzryngzlListDelete" href="#this" onclick="fsgzryngzlList.deleteWorkloadRecord('${record.id}')">删除</a>
						</td>
					<tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="grjlhjkjhda.searchWorkload" colspan="9" />
		</table>
	</div>
</div>
