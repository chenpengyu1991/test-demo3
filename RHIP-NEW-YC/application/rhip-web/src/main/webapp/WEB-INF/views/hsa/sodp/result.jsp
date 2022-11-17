<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<table id="manageCardList" style="">
	<colgroup>
			<col style="min-width:70px; width: 10%;"/>
			<col style="min-width:70px; width: 10%;"/>
            <col style="min-width:70px; width: 20%;"/>
			<col style="min-width:70px; width: 10%;"/>
            <col style="min-width:70px; width: 10%;"/>
			<col style="min-width:70px; width: 10%;"/>
			<col style="min-width:70px; width: 10%;"/>
            <col style="min-width:70px; width: 10%;"/>
			<col style="min-width:70px; width: 10%;"/>
	</colgroup>
	<thead>
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>年龄</th>
			<th>工种</th>
			<th>接诊单位名称</th>
			<th>接诊部门名称</th>
			<th>接诊人姓名</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody style="text-align: center">
			 <c:forEach var="susOccDisInfoList" items="${susOccDisInfoList}">
			 	<tr>
			 		<td ><ehr:tip>${susOccDisInfoList.name}</ehr:tip></td>
			 		<td ><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${susOccDisInfoList.gender}"/></ehr:tip></td>
			 		<td ><ehr:tip>${susOccDisInfoList.idcard}</ehr:tip></td>
			 		<td ><ehr:tip>${susOccDisInfoList.age}</ehr:tip></td>
			 		<td ><ehr:tip>${susOccDisInfoList.occupation}</ehr:tip></td>
			 		<td ><ehr:tip>${susOccDisInfoList.admissionOrganName}</ehr:tip></td>
			 		<td ><ehr:tip>${susOccDisInfoList.admissionDeptName}</ehr:tip></td>
			 		<td ><ehr:tip>${susOccDisInfoList.admissionDoctorName}</ehr:tip></td>
			 		<td><a href="javascript:void(0)" class="search-sus-occ-dis-info"  data-id="${susOccDisInfoList.id}">查看</a>
			 			<ehr:authorize ifAnyGranted="01,0422,0222,0122"><a href="javascript:void(0)" class="update-sus-occ-dis-info"  data-id="${susOccDisInfoList.id}">修改</a></ehr:authorize>
			 		</td>
			 	</tr>
			 </c:forEach>
	</tbody>
	<ehr:pagination action="susOccDi.searchSusOccDi" colspan="9" />
</table>