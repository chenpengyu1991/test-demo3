<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:5%;"/>		
	        <col style="width:15%;"/>
	        <col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:15%;"/>
			<col style="width:15%;"/>
			<col style="width:20%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th class="centerth">选择</th>
				<th class="centerth">姓名</th>
				<th class="centerth">性别</th>
				<th class="centerth">年龄</th>
				<th class="centerth">联系电话</th>
				<th class="centerth">血检结果</th>
				<th class="centerth">地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="standard" items="${statusInfo}" varStatus="status">
				<tr id="${standard.malariaQueryDto.idmId}" onclick = 'choosepatient.rowclick(this)'>
					<td><input type="radio" name="selectPatient" value="${standard.malariaQueryDto.idmId}" style="width: 20px;" reg='{"required":"true"}'/></td>
					<td title="${standard.malariaQueryDto.name}">
       					${standard.malariaQueryDto.name}
					</td>
					<td title="<ehr:dic dicmeta="GBT226112003" code="${standard.malariaQueryDto.gender}" />"><ehr:dic dicmeta="GBT226112003" code="${standard.malariaQueryDto.gender}" /></td>
					<td title="${standard.malariaQueryDto.age}">${standard.malariaQueryDto.age}</td>
					<td title="${standard.malariaQueryDto.phoneNumber}">${standard.malariaQueryDto.phoneNumber}</td>
					<td title="<ehr:dic dicmeta="IDM00258" code="${standard.malariaQueryDto.testResult}" />"><ehr:dic dicmeta="IDM00258" code="${standard.malariaQueryDto.testResult}" /></td>
					<td title="<ehr:dic dicmeta="FS990001" code="${standard.malariaQueryDto.patownShip}"></ehr:dic><ehr:dic dicmeta="FS990001" code="${standard.malariaQueryDto.pastreet}"></ehr:dic><c:out value="${standard.malariaQueryDto.pahouseNumber}"></c:out>">
						<ehr:dic dicmeta="FS990001" code="${standard.malariaQueryDto.patownShip}"></ehr:dic><ehr:dic dicmeta="FS990001" code="${standard.malariaQueryDto.pastreet}"></ehr:dic><c:out value="${standard.malariaQueryDto.pahouseNumber}"></c:out>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="choosepatient.search" />
		</tr>
	</table>
</div>