<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table id="studentExamList">
		<colgroup>
			<col style="width: 50px;" />
			<col style="width: 30px;" />
			<col style="width: 150px;" />
			<col style="width: 50px;" />
			<col style="width: 150px;" />
			<col style="width: 80px;" />
			<col style="width: 80px;" />
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证号</th>
				<th>本地学生</th>
				<th>学校</th>
				<th>封闭日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fs" items="${fissureSealants}">
				<tr>
					<td><a href="#" onclick="hmFissureSealantQuerySearch.view('${fs.fissureSealantId}')"><ehr:tip value="${fs.name}" /></a></td>
					<td><ehr:dic dicmeta="GBT226112003" code="${fs.gender}" /></td>
					<td><ehr:tip value="${fs.idcard}" /></td>
					<td><ehr:dic dicmeta="PH00001" code="${fs.nativeStudent}" /></td>
					<td>${fs.schoolName}</td>
					<td><fmt:formatDate value="${fs.closeDate}" pattern="yyyy/MM/dd"/></td>
					<td style="text-align: center">
							<a href="javascript:void(0)" onclick="hmFissureSealantQuerySearch.edit('${fs.fissureSealantId}')">修改</a>
							<a href="javascript:void(0)" onclick="hmFissureSealantQuerySearch.remove('${fs.fissureSealantId}')">删除</a>
							<a href="javascript:void(0)" onclick="hmFissureSealantQuerySearch.printFs('${fs.fissureSealantId}')">打印</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="hmFissureSealantQuerySearch.search"  />
		</tr>
	</table>
	<input type="hidden" id="_indexPage" value="${indexPage}" />
</div>