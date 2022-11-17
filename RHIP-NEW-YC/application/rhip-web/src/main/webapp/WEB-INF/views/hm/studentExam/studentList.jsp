<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/studentExam/list.js"/>

<div class="repeattable">
	<table id="studentExamList">
		<colgroup>
			<col style="width: 80px;" />
			<col style="width: 50px;" />
			<col style="width: 50px;" />
			<col style="width: 150px;" />
			<col style="width: 150px;" />
			<col style="width: 90px;" />
			<col style="width: 30px;" />
			<col style="width: 80px;" />
			<col style="width: 50px;" />
			<col style="width: 100px;" />
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>身份证号</th>
				<th>学校</th>
				<th>年级</th>
				<th>班级</th>
				<th>体检日期</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="studentExam" items="${studentExams}">
				<tr id="${studentExam.studentExamId}">
				    <c:if test="${empty studentExam.examDate}">
				    	<td>${studentExam.name}</td>
				    </c:if>
				    <c:if test="${not empty studentExam.examDate}">
				    	<td><a href="#" onclick="hmStudentExamList.viewExam('${studentExam.studentExamId}')">${studentExam.name}</a></td>
				    </c:if>
					<td><ehr:dic dicmeta="GBT226112003" code="${studentExam.gender}" /></td>
					<td>${studentExam.age}</td>
					<td>${studentExam.idcard}</td>
					<td>${studentExam.schoolName}</td>
					<td><ehr:dic dicmeta="FS10258" code="${studentExam.gradeCode}" /></td>
					<td><ehr:tip value="${studentExam.classCode}" /></td>
					<td><fmt:formatDate value="${studentExam.examDate}" pattern="yyyy/MM/dd"/></td>
					<td>
					    <c:if test="${empty studentExam.examDate}">未录入</c:if>
					    <c:if test="${not empty studentExam.examDate}">已录入</c:if>
					</td>
					<td style="text-align: center">
						<a href="javascript:void(0)" onclick="hmStudentExamList.deleteStudentInfo('${studentExam.examId}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="hmStudentSearch.search"  />
		</tr>
	</table>
	<input type="hidden" id="_indexPage" value="${indexPage}" />
</div>
<div id="printPage" style="display: none"></div>