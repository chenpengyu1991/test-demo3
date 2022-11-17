<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<div style="width: 210px;height: 120px;position: absolute;padding-left: 10px;z-index: 100;">
	<div class="doctorInfoDiv" onmouseover="reserveschedule.showDoctor(this,2030)" onmouseout="reserveschedule.hideDoctor(this,2030)">
		<table class="doctorInfoTable">
			<tr>
				<th>姓名：</th>
				<td>${outDoctor.name}</td>
			</tr>
			<tr>
				<th>职称：</th>
				<td>${outDoctor.empTitName}</td>
			</tr>
			<tr>
				<th>专长：</th>
				<td>${outDoctor.specializes}</td>
			</tr>
		</table>
	</div>
	<%-- <img class="imgDiv" src="${pageContext.request.contextPath}/images/reserve/arrow.png"> --%>
</div>

