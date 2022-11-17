<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table id="studentExamList">
		<colgroup>
			<col style="width: 80px;" />
			<col style="width: 120px;" />
			<col style="width: 80px;" />
			<col style="width: 50px;" />
			<col style="width: 200px;" />
			<col style="width: 100px;" />
			<col style="width: 80px;" />
		</colgroup>
		<thead>
			<tr>
				<th>学校编码</th>
				<th>学校名称</th>
				<th>学校类型</th>
				<th>地区类型</th>
				<th>学校地址</th>
				<th>体检机构</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="school" items="${schoolList}">
				<tr>
					<td><a href="#" onclick="hmStudentExamSchoolSearch.viewSchool('${school.schoolId}')">${school.schoolCode}</a></td>
					<td>${school.name}</td>
					<td><ehr:dic dicmeta="FS10255" code="${school.type}" /></td>
					<td><ehr:dic dicmeta="FS10256" code="${school.areaType}" /></td>
					<td>${school.address}</td>
					<td><ehr:org code="${school.examOrgan}"/></td>
					<td style="text-align: center">
						<a href="javascript:void(0)" onclick="hmStudentExamSchoolSearch.editSchool('${school.schoolId}')">修改</a>
						&nbsp;&nbsp;
						<a href="javascript:void(0)" onclick="hmStudentExamSchoolSearch.deleteSchool('${school.schoolId}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="hmStudentExamSchoolSearch.search"  />
		</tr>
	</table>
</div>