<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">体弱儿童管理随访</li>
	</ul>
	<br />
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>${frailChildFollowup.name}</td>
				<th>性别</th>
				<td><ehr:dic code="${frailChildFollowup.gender}" dicmeta="GBT226112003"></ehr:dic></td>
			</tr>
			<tr>
				<th>出生日期</th>
				<td><fmt:formatDate value="${frailChildFollowup.birthday}" pattern="yyyy/MM/dd" /></td>
				<th>身份证件号码</th>
				<td>${frailChildFollowup.idCard}</td>
			</tr>
			<tr>
				<th>母亲姓名</th>
				<td>${frailChildFollowup.motherName}</td>
				<th>父亲姓名</th>
				<td>${frailChildFollowup.fatherName}</td>
			</tr>
			<tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3"><c:out value="${frailChildFollowup.hrprovince}"></c:out>
					<c:out value="${frailChildFollowup.hrcity}"></c:out> 
					<c:out value="${frailChildFollowup.hrcounty}"></c:out> 
					<c:out value="${frailChildFollowup.hrtownShip}"></c:out> 
					<c:out value="${frailChildFollowup.hrstreet}"></c:out> 
					<c:out value="${frailChildFollowup.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3"><c:out value="${frailChildFollowup.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>居住住址</th>
				<td colspan="3"><c:out value="${frailChildFollowup.paprovince}"></c:out>
					<c:out value="${frailChildFollowup.pacity}"></c:out> 
					<c:out value="${frailChildFollowup.pacounty}"></c:out> 
					<c:out value="${frailChildFollowup.patownShip}"></c:out> 
					<c:out value="${frailChildFollowup.pastreet}"></c:out> 
					<c:out value="${frailChildFollowup.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3"><c:out value="${frailChildFollowup.papostCode}"></c:out></td>
			</tr>
			<tr>
				<th>联系电话类别</th>
				<td>
					<ehr:dic code="${frailChildFollowup.telType}" dicmeta="CV040001"></ehr:dic>
				</td>
				<th>联系电话号码</th>
				<td>${frailChildFollowup.telNumber}</td>
			</tr>
			<tr>

				<th>喂养方式</th>
				<td>
					<ehr:dic code="${frailChildFollowup.feedingType}" dicmeta="FS10026"></ehr:dic>
				</td>
				<th>随诊月龄</th>
				<td>${frailChildFollowup.followUpMonth}</td>
			</tr>
			<tr>
				<th>儿童体弱原因</th>
				<td colspan="3">
					<ehr:dic code="${frailChildFollowup.childrenDebilityType}" dicmeta="CV0510007"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>症状</th>
				<td colspan="3">${frailChildFollowup.symptom}</td>
			</tr>
			<tr>
				<th>体征</th>
				<td colspan="3">${frailChildFollowup.signs}</td>
			</tr>
			<tr>
				<th>处理及指导意见</th>
				<td colspan="3">${frailChildFollowup.mgOpinion}</td>
			</tr>
			<tr>
				<th>预约日期</th>
				<td>
					<fmt:formatDate value="${frailChildFollowup.reserveDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>体弱儿童转归</th>
				<td><ehr:dic code="${frailChildFollowup.childrenPrognosisCode}" dicmeta="CV550102"></ehr:dic></td>
			</tr>
			<tr>
				<th>结案日期</th>
				<td>
					<fmt:formatDate value="${frailChildFollowup.closedDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>结案医师姓名</th>
				<td>${frailChildFollowup.closedDoctorName}</td>
			</tr>
			<tr>
				<th>结案单位名称</th>
				<td>${frailChildFollowup.closedUnitName}</td>
				<th>建档日期</th>
				<td>
					<fmt:formatDate value="${frailChildFollowup.inputDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>辅助检查项目名称</th>
				<td colspan="3">${frailChildFollowup.aeItemName}</td>
			</tr>
			<tr>
				<th>辅助检查结果</th>
				<td colspan="3">${frailChildFollowup.aeResult}</td>
			</tr>
			<tr>
				<th>检查(测)日期</th>
				<td>
					<fmt:formatDate value="${frailChildFollowup.checkDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>检查(测)人员姓名</th>
				<td>${frailChildFollowup.checkName}</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
                <%--2014-07-08 修改 刘洋 臻鼎只有建档机构（即监测机构）--%>
				<td colspan="3">${frailChildFollowup.createOrganName}</td>
			</tr>
		</table>
	</div>
</div>