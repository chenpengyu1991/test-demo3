<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div>	
<form id="inoculationForm">
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="width: 15%;"/>
			<col style="width: 35%;"/>
			<col style="width: 15%;"/>
			<col style="width: 35%;"/>
		</colgroup>
		<tbody>
			<tr>
				<th>姓名</th>
				<td>${inoculationAppointment.personName}</td>
				<th>性別</th>
				<td><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${inoculationAppointment.personGender}"/></ehr:tip></td>
			</tr>
			<tr>
				<th>身份证</th>
				<td>${inoculationAppointment.personIdcard}</td>
				<th>电话</th>
				<td>${inoculationAppointment.phoneNumber}</td>
				
			</tr>
			<tr>
				<th>住址</th>
				<td>${inoculationAppointment.personAddress}</td>
				<th>预约机构</th>
				<td><ehr:org code="${inoculationAppointment.organCode}"></ehr:org></td>
				
			</tr>
			<tr>
				<th>预约时间</th>
				<td>
					<fmt:formatDate value="${inoculationAppointment.createDate}" pattern="yyyy/MM/dd HH:mm:ss"/>
				</td>
				<th>疫苗类型</th>
				<td> 
					<c:choose>
					<c:when test="${inoculationAppointment.vaccineType eq '1'}">老年人23价疫苗预约</c:when>
					<c:when test="${inoculationAppointment.vaccineType eq '3'}">3价流感疫苗预约</c:when>
					<c:when test="${inoculationAppointment.vaccineType eq '4'}">4价流感疫苗预约</c:when>
					<c:when test="${inoculationAppointment.vaccineType eq '5'}">4价HPV疫苗预约</c:when>
					<c:when test="${inoculationAppointment.vaccineType eq '6'}">9价HPV疫苗预约</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">
					${inoculationAppointment.diseaseHistory}
				</td>
			</tr>
		</tbody>
	</table>
	</div>
	</form>
</div>

