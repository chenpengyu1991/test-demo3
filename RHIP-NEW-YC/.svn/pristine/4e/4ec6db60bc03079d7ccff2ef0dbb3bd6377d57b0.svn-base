<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;margin: 5px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">会诊信息</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
			</colgroup>
			<tr>
				<th width="15%">姓名</th>
				<td>${consultationInfo.name}</td>
				<th width="15%">性别</th>
				<td><ehr:dic dicmeta="GBT226112003" code="${consultationInfo.gender}"></ehr:dic></td>
			</tr>
			<tr>
				<th width="15%">身份证号</th>
				<td>${consultationInfo.idCard}</td>
				<th width="15%">年龄</th>
				<td>${consultationInfo.age}</td>
			</tr>
			<tr>
				<th width="15%">婚姻状态</th>
				<td><ehr:dic dicmeta="GBT226122003" code="${consultationInfo.marriage}"></ehr:dic></td>
				<th width="15%">健康档案编号</th>
				<td>${consultationInfo.healthFileNo}</td>
			</tr>
			<tr>
				<th width="15%">会诊编号</th>
				<td>${consultationInfo.consultationRecordCode}</td>
				<th width="15%">会诊日期</th>
				<td><fmt:formatDate value="${consultationInfo.consultationDae}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>会诊原因</th>
				<td colspan="3">${consultationInfo.consultationCourse}</td>
			</tr>
			<tr>
				<th>会诊意见</th>
				<td colspan="3">${consultationInfo.consultationSuggestion}</td>
			</tr>
			<tr>
				<th>会诊医师姓名</th>
				<td>
					${consultationInfo.consultationDoctorName}
				</td>
				<th>会诊机构名称</th>
				<td>
					${consultationInfo.consultationOrgName}
				</td>
			</tr>
			<tr>
				<th>责任医师姓名</th>
				<td>${consultationInfo.manaDoctorName}
				<th>建档人姓名</th>
				<td>
					${consultationInfo.inputName}
				</td>
			</tr>
		</table>
	</div>
</div>